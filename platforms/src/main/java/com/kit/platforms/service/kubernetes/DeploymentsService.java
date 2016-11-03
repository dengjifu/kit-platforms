package com.kit.platforms.service.kubernetes;

import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hadoop on 2016/10/12.
 */
@Service
public interface DeploymentsService {
    public void CreateDeployment(String statementId, Map paramMap)throws Exception;

    public  boolean DeleteDeployment(String statementId, Map paramMap) throws Exception;

    public DeploymentList findDeploymentList(String statementId, Map paramMap) throws Exception;

    public void updateDeployment(String statementId, Map paramMap) throws Exception;
}
