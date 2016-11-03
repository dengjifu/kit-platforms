package com.kit.platforms.service.kubernetes.impl;

import com.kit.platforms.service.kubernetes.ReplicationControllerService;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
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
public class ReplicationControllerServiceImpl  implements ReplicationControllerService {

    private static final Logger logger = LoggerFactory.getLogger(DeploymentsServiceImpl.class);
    private String master = "http://172.16.18.133:8080/";
    private Config config = new ConfigBuilder().withMasterUrl(master).build();

    public void CreateReplicationController(String statementId, Map paramMap)throws Exception {
        KubernetesClient client = new DefaultKubernetesClient(config);
        ReplicationController replicationController=new ReplicationControllerBuilder()
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
        client.replicationControllers().inNamespace("thisisatest").create(replicationController);

    }

    public  boolean DeleteReplicationController(String statementId, Map paramMap) throws Exception {

        KubernetesClient client = new DefaultKubernetesClient(config) ;
        boolean falg = client.namespaces().withName("thisisatest").delete();
        client.replicationControllers().inNamespace("thisisatest").withLabel("server", "nginx").delete();
        return falg;

    }

    public ReplicationControllerList findReplicationControllerList(String statementId, Map paramMap) throws Exception{

        ReplicationControllerList list=null;
        KubernetesClient client = new DefaultKubernetesClient(config);
        list= client.replicationControllers().list();
        return list;

    }

    public void updateReplicationController(String statementId, Map paramMap) throws Exception{

        KubernetesClient client = new DefaultKubernetesClient(config);

        // Update the Deployment - change the image to apache
        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller").edit().editSpec().editTemplate().withNewSpec()
                .addNewContainer().withName("nginx").withImage("httpd")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec().done();
    }
}
