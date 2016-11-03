package com.kit.platforms.service.kubernetes.impl;

import com.kit.platforms.service.kubernetes.ServicesService;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceList;
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
public class ServicesServiceImpl implements ServicesService {


    private static final Logger logger = LoggerFactory.getLogger(NameSpacesServiceImpl.class);
    private String master = "http://172.16.18.133:8080/";
    private Config config = new ConfigBuilder().withMasterUrl(master).build();

    public void CreateService(String statementId, Map paramMap)throws Exception {


        KubernetesClient client = new DefaultKubernetesClient(config);

        Service service=new ServiceBuilder()
                .withNewMetadata().withNamespace("aa").withName("testservice").endMetadata()
                .withNewSpec()
                .addNewPort().withPort(80).withNewTargetPort().withIntVal(80).endTargetPort().endPort()
                .endSpec()
                .build();

        client.services().create(service);

    }

    public  boolean DeleteService(String statementId, Map paramMap) throws Exception {

        KubernetesClient client = new DefaultKubernetesClient(config) ;
        boolean falg = client.services().inNamespace("aa").withName("thisisatest").delete();
        return falg;

    }

    public ServiceList findServiceList(String statementId, Map paramMap) throws Exception{

        ServiceList list=null;
        KubernetesClient client = new DefaultKubernetesClient(config);
        list= client.services().list();
        return list;

    }

    public void updateService(String statementId, Map paramMap) throws Exception{

        KubernetesClient client = new DefaultKubernetesClient(config);

        client.services().withName("thisisatest").edit().editMetadata()
                .addToLabels("aa","dsss2")
                .removeFromLabels("this")
                .endMetadata()
                .done();

    }
}
