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
//	按指定条件搜索询价单据信息；
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
	//增加询价单据；
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
	//删除询价单据
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
	//修改询价单据；
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
	//将数据导出为EXCEL形式
	public void outputExecle(CashInquery cashInquery) {
		  
		// TODO Auto-generated method stub
		File file=new File("d://info.xls");
		WritableSheet sheet=null;
		WritableWorkbook wk=null;
		try {
			 wk=Workbook.createWorkbook(file);
			sheet=wk.createSheet("成绩表", 0);
			sheet.mergeCells(0, 0, 4, 0);//单元格合并方法，四个参数为主对角线的两个顶点；
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
		//创建WritableCellFormat对象，将该对象应用于单元格从而设置单元格的样式
		WritableCellFormat titleFormat=new WritableCellFormat();
		//创建WritableFont字体对象，参数依次表示黑体、字号12、粗体、非斜体。不带下划线、亮蓝色
		WritableFont titleFont=new WritableFont(
				WritableFont.createFont("黑体"),12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,
				Colour.LIGHT_BLUE);
		titleFormat.setFont(titleFont);//设置字体格式
	    try {
			titleFormat.setAlignment(Alignment.CENTRE);//设置文本水平居中
			titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);//设置文本垂直居中对齐
			titleFormat.setBackground(Colour.GRAY_25);//设置背景颜色
			titleFormat.setWrap(true);//设置自动换行
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    //添加Lable对象，参数依次表示在第一列，第一行，内容，使用格式
	    Label lab_00=new Label(0,0,"单据导出凭证",titleFormat);
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
	    columnTitleFormat.setFont(new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.BOLD,false));
	    try {
			columnTitleFormat.setAlignment(Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Label lab_01 = new Label(0,1,"询价编号",columnTitleFormat);
		Label lab_11 = new Label(1,1,"询价日期",columnTitleFormat);
		Label lab_21 = new Label(2,1,"供应商名称",columnTitleFormat);
		Label lab_31 = new Label(3,1,"数量",columnTitleFormat);
		Label lab_41 = new Label(4,1,"金额",columnTitleFormat);
		Label lab_51 = new Label(5,1,"联系人",columnTitleFormat);
		Label lab_61 = new Label(6,1,"联系方式",columnTitleFormat);
		Label lab_71 = new Label(7,1,"审核状态",columnTitleFormat);
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
	
		//定义导出日期型格式
		DateFormat df=new DateFormat("yyyy-MM-dd");//定义日期格式
		WritableCellFormat datewcf=new WritableCellFormat(df);//创建WritableCellFormat对象
		DateTime dtLab_42=new DateTime(1,2,cashInquery.getAddDate(),datewcf);//类似于lable对象，区别Label表示文本数据，DateTime表示日期型数据
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
			     sheet.addCell(new Label(7,2,"已审核！"));}
			else{
				sheet.addCell(new Label(7,2,"未审核！"));	
			}
		   } catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   } catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	    
		//将定义的工作表输出到之前指定的介质中
		try {
			wk.write();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//操作完成后关闭对象，释放占用的内存空间
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
	//将搜索到的数据全部导出
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
	
	//===================================测试================================
		public static void main(String[] args) {
			//PageBean pageBean=null;
			CashInqueryDao ciDao=new CashInqueryDaoImpl();
			//CashInquery cashInquery=new CashInquery();
		   /* cashInquery.setComPCode("1234");
		    cashInquery.setNums("0012");
		    cashInquery.setNumSprice("0000");
		    cashInquery.setContacter("王五");
		    cashInquery.setTelphone("12345678");
		    cashInquery.setState("0");
		    cashInquery.setRemarks("你大爷1234");
		    cashInquery.setCode("2002");*/
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		     HashMap <String ,String> map=new HashMap<String ,String>();
			    map.put("code", "'2001'");
			    map.put("endDate", "'01-6月-15'");
			    map.put("startDate", "'19-6月-15'");
			    map.put("comPCode","'01'");
			 list=ciDao.findAllBCashInquery(map);
		     System.out.println(list.get(0).get("code"));
			
		  
		}

		@Override
		 //获得BasePart表中基本数据
		public List<Parts> getBasePart(String code) {
			// TODO Auto-generated method stub
			String sql="";
			
			
			return null;
		}

		
}
