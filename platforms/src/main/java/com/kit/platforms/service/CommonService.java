package com.kit.platforms.service;

import com.github.pagehelper.PageHelper;
import com.kit.platforms.dao.Commondao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hadoop on 2016/9/13/013.
 */
@Service
public class CommonService {

    @Autowired
    private Commondao dao;

    public List findList(String statementId, Object parameter)throws Exception {
     return dao.findList(statementId,parameter);
    }

    public List findListpage(String statementId, Object parameter,int page,int rows)throws Exception {
        PageHelper.startPage(page, rows);
        return dao.findList(statementId,parameter);
    }

}
