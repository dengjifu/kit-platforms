package com.kit.platforms.service.kubernetes.impl;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hadoop on 2016/10/12.
 */
@Service
public class NameSpacesServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(NameSpacesServiceImpl.class);
    private String master = "http://172.16.18.133:8080/";


    public void CreateNameSpace(String statementId, Map paramMap)throws Exception {

        Config config = new ConfigBuilder().withMasterUrl(master).build();
        try (final KubernetesClient client = new DefaultKubernetesClient(config)) {

            Namespace ns = new NamespaceBuilder()
                    .withNewMetadata()
                    .withName("thisisatest")
                    .addToLabels("this", "rocks")
                    .endMetadata().build();

             Namespace aa=   client.namespaces().create(ns);
        } catch (KubernetesClientException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public  void DeleteNameSpace(String statementId, Map paramMap) throws Exception {
        Config config = new ConfigBuilder().withMasterUrl(master).build();
        try (final KubernetesClient client = new DefaultKubernetesClient(config)) {

            client.namespaces().withName("thisisatest").delete();

        } catch (KubernetesClientException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public NamespaceList findUserList(String statementId, Map paramMap) throws Exception{
        Config config = new ConfigBuilder().withMasterUrl(master).build();
        NamespaceList list=null;
        try (final KubernetesClient client = new DefaultKubernetesClient(config)) {

            list= client.namespaces().list();
           return list;
        } catch (KubernetesClientException e) {
            logger.error(e.getMessage(), e);
        }
        return  null;
    }

    public void updateNameSpace(String statementId, Map paramMap) throws Exception{
        Config config = new ConfigBuilder().withMasterUrl(master).build();
        try (final KubernetesClient client = new DefaultKubernetesClient(config)) {

            client.namespaces().withName("thisisatest").edit().editMetadata()
                    .addToLabels("aa","dsss2")
                    .removeFromLabels("this")
                    .endMetadata()
                    .done();

        } catch (KubernetesClientException e) {
            logger.error(e.getMessage(), e);
        }
    }


//    public static void main(String[] args) throws InterruptedException {
//        String master = "http://172.16.18.133:8080/";
////        Config config = new ConfigBuilder().withMasterUrl(master).build();
////        try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
////
////            Namespace ns = new NamespaceBuilder().withNewMetadata().withName("thisisatest").addToLabels("this", "rocks").endMetadata().build();
////            System.out.println( client.namespaces().create(ns));
////
////        } catch (KubernetesClientException e) {
////            logger.error(e.getMessage(), e);
////        }
//
////        Config config = new ConfigBuilder().withMasterUrl(master).build();
////        try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
////
////            client.namespaces().withName("thisisatest").edit().editMetadata()
////                    .addToLabels("aa","dsss2")
////                    .removeFromLabels("this")
////                    .endMetadata()
////                    .done();
////
////        } catch (KubernetesClientException e) {
////            logger.error(e.getMessage(), e);
////        }
//
//        Config config = new ConfigBuilder().withMasterUrl(master).build();
//        try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
//
//            NamespaceList list= client.namespaces().list();
//            System.out.println(list.getItems().size());
//        } catch (KubernetesClientException e) {
//            logger.error(e.getMessage(), e);
//        }
//    }
}
