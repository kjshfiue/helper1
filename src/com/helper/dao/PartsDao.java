package com.helper.dao;

import java.util.List;

import com.helper.entity.Parts;

public interface PartsDao {
	/**
	 * ��ѯ�����Ϣ
	 * @return
	 */
	List<Parts> findPartsMessage(String s1,String s2,String s3);
	/**
	 * ��������Ϣ
	 * @param parts
	 * @return
	 */
	int insertPartMessage(Parts parts);
	/**
	 * ɾ�������Ϣ
	 * @param id
	 * @return
	 */
	int deletePartMessage(String id);
	/**
	 * ͳһ�ļ۸����
	 * @param list
	 * @return
	 */
	int updatePartMessage(String s1,String s2,String s3,String price);
	/**
	 * �޸Ĳ�Ʒ��Ϣ
	 * @param id
	 * @return
	 */
	int updatePartMessage(Parts part);
	
}
