package com.helper.dao;

import java.util.HashMap;
import java.util.List;

import com.helper.entity.CashInquery;
import com.helper.entity.PageBean;

public interface CashInqueryDao {
	//	��ָ����������ѯ�۵�����Ϣ��
	PageBean  searchPartBySth(int pageNo,int pageSize,HashMap<String,String> map);
    //���ӡ��޸ġ�ɾ��ѯ�۵��ݣ�
	int addCashInqueryList(CashInquery cashInquery);
	//ɾ��ѯ�۵���
	int delCashInqueryList(String code);
	//�޸�ѯ�۵��ݣ�
	int updateCashInqueryList(CashInquery cashInquery);
	//���ȫ����Ϣ---��ʱ�滻��һ������
	PageBean getAllPartInfo(int pageNo,int pageSize);
	
	
}
