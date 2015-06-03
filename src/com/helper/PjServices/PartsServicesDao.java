package com.helper.PjServices;

import java.util.List;

import com.helper.entity.Parts;

public interface PartsServicesDao {
	/**
	 * ָ���l������Ԕ����Ϣ
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	List<Parts> searchParts(String s1,String s2,String s3);
	/**
	 * ���Ԕ����Ϣ
	 * @param part
	 * @return
	 */
	int addParts(Parts parts);
	/**
	 * �޸�Ԕ����Ϣ
	 * @param parts
	 * @return
	 */
	int updateParts(Parts parts);
	/**
	 * �΂��h����Ϣ
	 * @param id
	 * @return
	 */
	int deleteParts(String id);
	/**
	 * �����h����Ϣ
	 * @param list
	 * @return
	 */
	int deleteAllPart(List<Integer> list);
	/**
	 * �����r���{��
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param price
	 * @return
	 */
	int updateParts(String s1,String s2,String s3,String price);
}
