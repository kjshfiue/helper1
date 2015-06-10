package com.helper.dao.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.helper.entity.PageBean;
import com.helper.entity.Parts;
import com.helper.dao.BaseDao;
import com.helper.dao.CashInqueryDao;
import com.helper.entity.CashInquery;

public class CashInqueryDaoImpl extends BaseDao implements CashInqueryDao{
	
	

	@Override
//	��ָ����������ѯ�۵�����Ϣ��
	public PageBean searchPartBySth(int pageNo,int pageSize,HashMap<String,String> map) {
		// TODO Auto-generated method stub
		PageBean pageBean=null;
		List <CashInquery> list =new ArrayList<CashInquery>();
		List<Object> pstm=new ArrayList<Object>();
		CashInquery cashInquery=null;
		ResultSet rs=null;
		
		String sql="select * from PURCHASEINQUERY where 1=1";
		if(map.get("code").equals("'null'")!=true){
			sql+=" and code="+map.get("code");
		}
		if(map.get("endDate").equals("'null'")!=true){
			sql+=" and addDate<"+map.get("endDate");
		}
		if(map.get("startDate").equals("'null'")!=true){
			sql+=" and addDate>"+map.get("startDate");
		}
		if(map.get("comPCode").equals("'null'")!=true){
			sql+=" and comPCode="+map.get("comPCode");
		}
		  Object[] object1=pstm.toArray();
		  pstm.add(pageNo*pageSize);
		  pstm.add((pageNo-1)*pageSize);
		  Object[] object2=pstm.toArray();

		   rs=super.executeQueryForPage(sql, object2);
		
		   try {
			while(rs.next()){
				cashInquery=new CashInquery();
				cashInquery.setCode(rs.getString("code"));
			    cashInquery.setAddDate(new java.util.Date(rs.getDate("addDate").getTime()));
			    cashInquery.setSupplierCode(rs.getString("supplierCode"));
				cashInquery.setContacter(rs.getString("contacter"));
				cashInquery.setTelphone(rs.getString("telphone"));
				cashInquery.setFax(rs.getString("fax"));
				cashInquery.setNums(rs.getString("nums"));
				cashInquery.setNumSprice(rs.getString("numSprice"));
				cashInquery.setIsShow(rs.getString("isShow"));
				cashInquery.setState(rs.getString("state"));
				cashInquery.setRemarks(rs.getString("remarks"));
				cashInquery.setAddUser(rs.getString("addUser"));
				cashInquery.setAddUserName(rs.getString("addUserName"));
				cashInquery.setAddIP(rs.getString("addIp"));
				cashInquery.setComPCode(rs.getString("comPCode"));
				list.add(cashInquery);
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   if(list!=null){
			   String sql2 ="select count (*) count from ("+sql+")";
			   int total=super.executeTotalCount(sql2, object1);
			   pageBean=new PageBean();
			   pageBean.setTotal(total);
			   pageBean.setData(list);
		   }
		   
		return pageBean;
	}

	@Override
	//����ѯ�۵��ݣ�
	public int addCashInqueryList(CashInquery cashInquery) {
		// TODO Auto-generated method stub
		String sql="insert into PURCHASEINQUERY (code,addDate,comPcode,nums,numSprice,contacter,"
				+ "telphone,state,remarks) values(?,sysDate,?,?,?,?,?,?,?) ";
		Object params[]=new Object[]{cashInquery.getCode(),cashInquery.getComPCode(),cashInquery.getNums()
				,cashInquery.getNumSprice(),cashInquery.getContacter(),cashInquery.getTelphone(),cashInquery.getState(),
				cashInquery.getRemarks()};
		int ret=super.executeUpdate(sql, params);
		return ret;
	}

	@Override
	//ɾ��ѯ�۵���
	public int delCashInqueryList(String code) {
		// TODO Auto-generated method stub
		String sql="delete from PURCHASEINQUERY where code=?";
		Object []params=new Object[]{code};
		int ret=0;
		ret=super.executeUpdate(sql, params);
		return ret;
	}
	@Override
	public PageBean getAllPartInfo(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean=null;
		List<CashInquery> list=new ArrayList <CashInquery>();
		CashInquery cashInquery=null;
		String sql="select * from PURCHASEINQUERY where 1=1";
		ResultSet rs=super.executeQueryForPage(sql, pageNo, pageSize);
		   try {
				while(rs.next()){
					cashInquery=new CashInquery();
					cashInquery.setCode(rs.getString("code"));
				    cashInquery.setAddDate(new java.util.Date(rs.getDate("addDate").getTime()));
				    cashInquery.setSupplierCode(rs.getString("supplierCode"));
					cashInquery.setContacter(rs.getString("contacter"));
					cashInquery.setTelphone(rs.getString("telphone"));
					cashInquery.setFax(rs.getString("fax"));
					cashInquery.setNums(rs.getString("nums"));
					cashInquery.setNumSprice(rs.getString("numSprice"));
					cashInquery.setIsShow(rs.getString("isShow"));
					cashInquery.setState(rs.getString("state"));
					cashInquery.setRemarks(rs.getString("remarks"));
					cashInquery.setAddUser(rs.getString("addUser"));
					cashInquery.setAddUserName(rs.getString("addUserName"));
					cashInquery.setAddIP(rs.getString("addIp"));
					cashInquery.setComPCode(rs.getString("comPCode"));
					list.add(cashInquery);
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   if(list!=null){
				   String sql2 ="select count (*) count from PURCHASEINQUERY";
				   int total=super.executeTotalCount(sql2);
				   pageBean=new PageBean();
				   pageBean.setTotal(total);
				   pageBean.setData(list);
			   }
		return pageBean;
	}
	//�޸�ѯ�۵��ݣ�
	public int updateCashInqueryList(CashInquery cashInquery) {
		String sql=" update PURCHASEINQUERY set addDate=sysDate ,comPCode =?,nums=? ,numSprice=? , contacter=? ,telphone=? ,state=?  where code=?" ;
		Object [] params=new Object[]{
				cashInquery.getComPCode(),cashInquery.getNums(),
				cashInquery.getNumSprice(),cashInquery.getContacter(),cashInquery.getTelphone(),
				cashInquery.getState(),cashInquery.getCode()};
	
		int ret=super.executeUpdate(sql, params);
		/*System.out.println("DAO"+ret);*/
		return ret;
	}
	

	@Override
	//�����ݵ���ΪEXCEL��ʽ
	public void outputExecle(CashInquery cashInquery) {
		  
		// TODO Auto-generated method stub
		File file=new File("d://info.xls");
		WritableSheet sheet=null;
		WritableWorkbook wk=null;
		try {
			 wk=Workbook.createWorkbook(file);
			sheet=wk.createSheet("�ɼ���", 0);
			sheet.mergeCells(0, 0, 4, 0);//��Ԫ��ϲ��������ĸ�����Ϊ���Խ��ߵ��������㣻
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����WritableCellFormat���󣬽��ö���Ӧ���ڵ�Ԫ��Ӷ����õ�Ԫ�����ʽ
		WritableCellFormat titleFormat=new WritableCellFormat();
		//����WritableFont������󣬲������α�ʾ���塢�ֺ�12�����塢��б�塣�����»��ߡ�����ɫ
		WritableFont titleFont=new WritableFont(
				WritableFont.createFont("����"),12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,
				Colour.LIGHT_BLUE);
		titleFormat.setFont(titleFont);//���������ʽ
	    try {
			titleFormat.setAlignment(Alignment.CENTRE);//�����ı�ˮƽ����
			titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);//�����ı���ֱ���ж���
			titleFormat.setBackground(Colour.GRAY_25);//���ñ�����ɫ
			titleFormat.setWrap(true);//�����Զ�����
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    //���Lable���󣬲������α�ʾ�ڵ�һ�У���һ�У����ݣ�ʹ�ø�ʽ
	    Label lab_00=new Label(0,0,"���ݵ���ƾ֤",titleFormat);
	    try {
			sheet.addCell(lab_00);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    WritableCellFormat columnTitleFormat=new WritableCellFormat();
	    columnTitleFormat.setFont(new WritableFont(WritableFont.createFont("����"),10,WritableFont.BOLD,false));
	    try {
			columnTitleFormat.setAlignment(Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Label lab_01 = new Label(0,1,"ѯ�۱��",columnTitleFormat);
		Label lab_11 = new Label(1,1,"ѯ������",columnTitleFormat);
		Label lab_21 = new Label(2,1,"��Ӧ������",columnTitleFormat);
		Label lab_31 = new Label(3,1,"����",columnTitleFormat);
		Label lab_41 = new Label(4,1,"���",columnTitleFormat);
		Label lab_51 = new Label(5,1,"��ϵ��",columnTitleFormat);
		Label lab_61 = new Label(6,1,"��ϵ��ʽ",columnTitleFormat);
		Label lab_71 = new Label(7,1,"���״̬",columnTitleFormat);
		try {
			sheet.addCell(lab_01);
			sheet.addCell(lab_11);
		    sheet.addCell(lab_21);
		    sheet.addCell(lab_31);
		    sheet.addCell(lab_41);
		    sheet.addCell(lab_51);
		    sheet.addCell(lab_61);
		    sheet.addCell(lab_71);
		    
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//���嵼�������͸�ʽ
		DateFormat df=new DateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		WritableCellFormat datewcf=new WritableCellFormat(df);//����WritableCellFormat����
		DateTime dtLab_42=new DateTime(1,2,cashInquery.getAddDate(),datewcf);//������lable��������Label��ʾ�ı����ݣ�DateTime��ʾ����������
		try {
			sheet.addCell(dtLab_42);
		} catch (RowsExceededException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			sheet.addCell(new Label(0,2,cashInquery.getCode()));
			//sheet.addCell(new Label(1,2,dtLab_42));
			sheet.addCell(new Label(2,2,cashInquery.getComPCode()));
			sheet.addCell(new Label(3,2,cashInquery.getNums()));
			sheet.addCell(new Label(4,2,cashInquery.getNumSprice()));
			sheet.addCell(new Label(5,2,cashInquery.getContacter()));
			sheet.addCell(new Label(6,2,cashInquery.getTelphone()));
			if(cashInquery.getState().equals("1")){
			     sheet.addCell(new Label(7,2,"����ˣ�"));}
			else{
				sheet.addCell(new Label(7,2,"δ��ˣ�"));	
			}
		   } catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   } catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	    
		//������Ĺ����������֮ǰָ���Ľ�����
		try {
			wk.write();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//������ɺ�رն����ͷ�ռ�õ��ڴ�ռ�
	    try {
			wk.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	@Override
	//��������������ȫ������
	public List<Map<String, Object>> findAllBCashInquery(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		//CashInquery cashInquery=new CashInquery();
		String sql="select *from PURCHASEINQUERY where 1=1";
		//List <Object> pstm=new ArrayList<Object>();
		if(map.size()>0){
			if(map.get("code").equals("'null'")!=true){
				sql+=" and code="+map.get("code");
			}
			if(map.get("endDate").equals("'null'")!=true){
				sql+=" and addDate< "+map.get("endDate");
			}
			if(map.get("startDate").equals("'null'")!=true){
				sql+=" and addDate> "+map.get("startDate");
			}
			if(map.get("comPCode").equals("'null'")!=true){
				sql+=" and comPCode= "+map.get("comPCode");
			}
		}
		//Object [] object=pstm.toArray();
		ResultSet rs = super.executeQuery(sql);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> baseMap = null;
		 try {
				while(rs.next()){
					baseMap = new HashMap<String,Object>();
					baseMap.put("code",rs.getString("code"));
					baseMap.put("comPCode",rs.getString("comPCode"));
					baseMap.put("nums",rs.getString("nums"));
					baseMap.put("numSprice",rs.getString("numSprice"));
					baseMap.put("contacter",rs.getString("contacter"));
					baseMap.put("addDate",new java.util.Date(rs.getTimestamp("addDate").getTime()));
					baseMap.put("telphone",rs.getString("telphone"));
					list.add(baseMap);
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
	
	//===================================����================================
		public static void main(String[] args) {
			//PageBean pageBean=null;
			CashInqueryDao ciDao=new CashInqueryDaoImpl();
			//CashInquery cashInquery=new CashInquery();
		   /* cashInquery.setComPCode("1234");
		    cashInquery.setNums("0012");
		    cashInquery.setNumSprice("0000");
		    cashInquery.setContacter("����");
		    cashInquery.setTelphone("12345678");
		    cashInquery.setState("0");
		    cashInquery.setRemarks("���ү1234");
		    cashInquery.setCode("2002");*/
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		     HashMap <String ,String> map=new HashMap<String ,String>();
			    map.put("code", "'2001'");
			    map.put("endDate", "'01-6��-15'");
			    map.put("startDate", "'19-6��-15'");
			    map.put("comPCode","'01'");
			 list=ciDao.findAllBCashInquery(map);
		     System.out.println(list.get(0).get("code"));
			
		  
		}

		@Override
		 //���BasePart���л�������
		public List<Parts> getBasePart(String code) {
			// TODO Auto-generated method stub
			String sql="";
			
			
			return null;
		}

		
}
