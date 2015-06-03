package com.helper.dao;

import java.util.List;

import com.helper.entity.Parts;

public interface PartsDao {
	/**
	 * 查询配件信息
	 * @return
	 */
	List<Parts> findPartsMessage(String s1,String s2,String s3);
	/**
	 * 添加配件信息
	 * @param parts
	 * @return
	 */
	int insertPartMessage(Parts parts);
	/**
	 * 删除配件信息
	 * @param id
	 * @return
	 */
	int deletePartMessage(String id);
	/**
	 * 统一的价格调整
	 * @param list
	 * @return
	 */
	int updatePartMessage(String s1,String s2,String s3,String price);
	/**
	 * 修改产品信息
	 * @param id
	 * @return
	 */
	int updatePartMessage(Parts part);
	
}
