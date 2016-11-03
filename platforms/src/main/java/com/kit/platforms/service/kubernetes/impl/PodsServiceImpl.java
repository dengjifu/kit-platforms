package com.kit.platforms.service.kubernetes.impl;

import com.kit.platforms.service.kubernetes.PodsService;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by hadoop on 2016/10/12.
 */
public class PodsServiceImpl implements PodsService {

    private static final Logger logger = LoggerFactory.getLogger(NameSpacesServiceImpl.class);
    private String master = "http://172.16.18.133:8080/";
    private Config config = new ConfigBuilder().withMasterUrl(master).build();

    public void CreatePod(String statementId, Map paramMap)throws Exception {


        KubernetesClient client = new DefaultKubernetesClient(config);

        Pod pod =new PodBuilder()
                .withNewMetadata()
                .withName("testpod")
                .addToLabels("server", "nginx")
                .endMetadata()
                .withNewSpec()
                .addNewContainer().withName("nginx").withImage("nginx")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec().build();

         client.pods().create(pod);

    }

    public  boolean DeletePod(String statementId, Map paramMap) throws Exception {

        KubernetesClient client = new DefaultKubernetesClient(config) ;
        boolean falg = client.pods().inNamespace("aa").withName("thisisatest").delete();
        return falg;

    }

    public PodList findPodList(String statementId, Map paramMap) throws Exception{

        PodList list=null;
        KubernetesClient client = new DefaultKubernetesClient(config);
        list= client.pods().list();
        return list;

    }

    public void updatePod(String statementId, Map paramMap) throws Exception{
        KubernetesClient client = new DefaultKubernetesClient(config);
        client.pods().inNamespace("thisisatest").withName("nginx-controller").edit().editSpec()
                .addNewContainer().withName("nginx").withImage("httpd")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec()
                .done();
    }

}
