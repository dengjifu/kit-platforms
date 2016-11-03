package com.kit.platforms.service.kubernetes;

import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hadoop on 2016/10/12.
 */
@Service
public interface ReplicationControllerService {

    public void CreateReplicationController(String statementId, Map paramMap)throws Exception;

    public  boolean DeleteReplicationController(String statementId, Map paramMap) throws Exception;

    public ReplicationControllerList findReplicationControllerList(String statementId, Map paramMap) throws Exception;

    public void updateReplicationController(String statementId, Map paramMap) throws Exception;
}
