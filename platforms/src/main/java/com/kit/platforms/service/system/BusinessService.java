package com.kit.platforms.service.system;

import com.github.pagehelper.PageHelper;
import com.kit.platforms.dao.Commondao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by liujianliang on 2016/8/18.
 */
@Service
public class BusinessService {
    @Autowired
    private Commondao dao;
    public List<Object> findBusinessList(String statementId, Map paramMap,int page,int rows) throws Exception {
        PageHelper.startPage(page, rows);
        return dao.findList(statementId,paramMap);
    }

    public Object addBusiness(String statementId, Map paramMap) throws Exception{
        return dao.add(statementId,paramMap);
    }

    public Object updateBusiness(String statementId, Map paramMap) throws Exception{
        return dao.update(statementId,paramMap);
    }

    public Object deleteBusiness(String statementId, Map paramMap) throws Exception{
        return dao.delete(statementId,paramMap);
    }
}
