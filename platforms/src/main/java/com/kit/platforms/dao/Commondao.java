package com.kit.platforms.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @Description: 基础的数据操作
 * @author cs
 * @date 2016-8-3
 *
 */
@Component
public class Commondao {
	 @Autowired
	 private  SqlSessionTemplate sqlSession;;
	/**
	 * 根据条件查询所有数据
	 *
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	public List<Object> findList(String statementId, Object parameter) throws Exception {
		List<Object> list =sqlSession.selectList(statementId,parameter);
		return list;

	}

	/**
	 * 根据条件统计数据总数
	 *
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	public long get(String statementId, Object parameter) throws Exception {
		long count =sqlSession.selectOne(statementId,parameter);
		return count;

	}

	/**
	 * 添加数据
	 *
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	public Object add(String statementId, Object parameter) throws Exception{
		return  sqlSession.insert(statementId,parameter);
	}

	/**
	 * 更新数据
	 *
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	public int update(String statementId, Object parameter) throws Exception{
		return  sqlSession.update(statementId,parameter);
	}

	/**
	 * 根据条件删除数据
	 *
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	public int delete(String statementId, Object parameter) throws Exception{
		return  sqlSession.update(statementId,parameter);
	}


}
