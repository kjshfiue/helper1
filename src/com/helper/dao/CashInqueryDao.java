package com.helper.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.write.WriteException;

import com.helper.entity.CashInquery;
import com.helper.entity.DBCashInquery;
import com.helper.entity.PageBean;
import com.helper.entity.Parts;

public interface CashInqueryDao {
	//	��ָ����������ѯ�۵�����Ϣ��///
	PageBean  searchPartBySth(int pageNo,int pageSize,HashMap<String, String> map);
    //���ӡ��޸ġ�ɾ��ѯ�۵��ݣ�
	int addCashInqueryList(CashInquery cashInquery);
	//ɾ��ѯ�۵���
	int delCashInqueryList(String code);
	//�޸�ѯ�۵��ݣ�
	int updateCashInqueryList(CashInquery cashInquery);
	//���ȫ����Ϣ---��ʱ�滻��һ������
	PageBean getAllPartInfo(int pageNo,int pageSize);
	//����JDBC�������������ִ��ɾ��
	//int delBatch(String []object);
	//�����ݵ���ΪEXCEL��ʽ
	void outputExecle(CashInquery cashInquery) ;
	//����������������������ȫ������Ϊexcel
     List<Map<String,Object>> findAllBCashInquery(HashMap<String, String> map);
     //���BasePart���л�������
     PageBean getBasePart(int pageNo,int pageSize,String code);
     //��ù�Ӧ������
     PageBean getPrividerName(int pageNo,int pageSize,HashMap<String, String> map);
	//
}
