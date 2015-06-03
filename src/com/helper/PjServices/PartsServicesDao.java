package com.helper.PjServices;

import java.util.List;

import com.helper.entity.Parts;

public interface PartsServicesDao {
	/**
	 * 指定條件搜索詳細信息
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	List<Parts> searchParts(String s1,String s2,String s3);
	/**
	 * 添加詳細信息
	 * @param part
	 * @return
	 */
	int addParts(Parts parts);
	/**
	 * 修改詳細信息
	 * @param parts
	 * @return
	 */
	int updateParts(Parts parts);
	/**
	 * 單個刪除信息
	 * @param id
	 * @return
	 */
	int deleteParts(String id);
	/**
	 * 批量刪除信息
	 * @param list
	 * @return
	 */
	int deleteAllPart(List<Integer> list);
	/**
	 * 批量價格調整
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param price
	 * @return
	 */
	int updateParts(String s1,String s2,String s3,String price);
}
