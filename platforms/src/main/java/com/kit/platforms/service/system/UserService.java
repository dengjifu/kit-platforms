package com.kit.platforms.service.system;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by liujianliang on 2016/9/22.
 */
@Service
public interface UserService {

    public List<Object> getUser(String statementId, Map paramMap) throws Exception;

    public long getUserListCount(String statementId, Map paramMap) throws Exception;

    public List<Object> findUserList(String statementId, Map paramMap) throws Exception;

    public Object updateUser(String statementId, Map paramMap) throws Exception;

    public Object deleteUser(String statementId, Object paramList) throws Exception;
}
