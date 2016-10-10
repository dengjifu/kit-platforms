package com.kit.platforms.domain.result;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 
 * @author carwen
 *
 */
public class TableResult {

	private Long total;

	private List<?> rows;

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public static TableResult create(List<?> rows) {
		TableResult tableResult = new TableResult();
		tableResult.setRows(rows);
		PageInfo<?> page = new PageInfo(rows);
		Long count=page.getTotal();
		tableResult.setTotal(count);
		return tableResult;
	}

}
