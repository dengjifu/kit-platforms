package com.kit.platforms.service.kubernetes;

import io.fabric8.kubernetes.api.model.PodList;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hadoop on 2016/10/12.
 */
@Service
public interface PodsService {

    public void CreatePod(String statementId, Map paramMap)throws Exception;

    public  boolean DeletePod(String statementId, Map paramMap) throws Exception;

    public PodList findPodList(String statementId, Map paramMap) throws Exception;

    public void updatePod(String statementId, Map paramMap) throws Exception;
}
