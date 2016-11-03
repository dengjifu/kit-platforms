package com.kit.platforms.service.kubernetes.impl;

import com.kit.platforms.service.kubernetes.DeploymentsService;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
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
public class DeploymentsServiceImpl implements DeploymentsService {

    private static final Logger logger = LoggerFactory.getLogger(DeploymentsServiceImpl.class);
    private String master = "http://172.16.18.133:8080/";
    private Config config = new ConfigBuilder().withMasterUrl(master).build();

    public void CreateDeployment(String statementId, Map paramMap)throws Exception {
        KubernetesClient client = new DefaultKubernetesClient(config);
        Deployment deployment=new DeploymentBuilder()
                .withNewMetadata().withName("nginx-controller").addToLabels("server", "nginx").endMetadata()
                .withNewSpec().withReplicas(3)
                .withNewTemplate()
                .withNewMetadata().addToLabels("server", "nginx").endMetadata()
                .withNewSpec()
                .addNewContainer().withName("nginx").withImage("nginx")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec().build();
       client.extensions().deployments().inNamespace("thisisatest").create(deployment);

    }

    public  boolean DeleteDeployment(String statementId, Map paramMap) throws Exception {

        KubernetesClient client = new DefaultKubernetesClient(config) ;
        boolean falg = client.namespaces().withName("thisisatest").delete();
        client.extensions().deployments().inNamespace("thisisatest").withLabel("server", "nginx").delete();
        return falg;

    }

    public DeploymentList findDeploymentList(String statementId, Map paramMap) throws Exception{

        DeploymentList list=null;
        KubernetesClient client = new DefaultKubernetesClient(config);
        list= client.extensions().deployments().list();
        return list;

    }

    public void updateDeployment(String statementId, Map paramMap) throws Exception{

        KubernetesClient client = new DefaultKubernetesClient(config);

        // Update the Deployment - change the image to apache
        client.extensions().deployments().inNamespace("thisisatest").withName("nginx-controller").edit().editSpec().editTemplate().withNewSpec()
                .addNewContainer().withName("nginx").withImage("httpd")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec().done();
    }
}
