package com.kit.platforms.service.kubernetes;

import io.fabric8.kubernetes.api.model.NamespaceList;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hadoop on 2016/10/12.
 */
@Service
public interface NameSpacesService {

    public void CreateNameSpace(String statementId, Map paramMap)throws Exception;

    public  void DeleteNameSpace(String statementId, Map paramMap) throws Exception;

    public NamespaceList findNamespaceList(String statementId, Map paramMap) throws Exception;

    public void updateNameSpace(String statementId, Map paramMap) throws Exception;
}
