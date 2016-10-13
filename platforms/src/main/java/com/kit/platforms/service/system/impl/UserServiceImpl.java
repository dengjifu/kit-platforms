package com.kit.platforms.service.system.impl;

import com.kit.platforms.dao.Commondao;
import com.kit.platforms.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by liujianliang on 2016/9/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Commondao dao;

    @Transactional(value="txManager")
    public List<Object> getUser(String statementId, Map paramMap) throws Exception{
        if(paramMap.get("start")==null) {
            paramMap.put("start", 0);
            paramMap.put("end", 1);
        }
        List<Object> list =  dao.findList(statementId,paramMap);
        return list;
    }

    @Transactional(value="txManager")
    public long getUserListCount(String statementId, Map paramMap) throws Exception{

        return dao.get(statementId,paramMap);
    }

    @Transactional(value="txManager")
    public List<Object> findUserList(String statementId, Map paramMap) throws Exception{
        List<Object> list =  dao.findList(statementId,paramMap);
        return list;
    }

    @Transactional(value="txManager")
    public Object updateUser(String statementId, Map paramMap) throws Exception{
        return dao.update(statementId,paramMap);
    }

    @Transactional(value="txManager")
    public Object deleteUser(String statementId, Object paramList) throws Exception{
        return dao.update(statementId,paramList);
    }
}
