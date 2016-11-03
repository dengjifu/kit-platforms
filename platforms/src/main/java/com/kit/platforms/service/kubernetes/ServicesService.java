package com.kit.platforms.service.kubernetes;

import io.fabric8.kubernetes.api.model.ServiceList;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hadoop on 2016/10/12.
 */
@Service
public interface ServicesService {
    public void CreateService(String statementId, Map paramMap)throws Exception;

    public  boolean DeleteService(String statementId, Map paramMap) throws Exception;

    public ServiceList findServiceList(String statementId, Map paramMap) throws Exception;

    public void updateService(String statementId, Map paramMap) throws Exception;
}
