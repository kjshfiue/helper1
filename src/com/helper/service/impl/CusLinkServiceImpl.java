package com.helper.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



import com.helper.dao.CusLInkDao;
import com.helper.dao.impl.CusLinkDaoImpl;
import com.helper.dao.impl.PageBean;
import com.helper.entity.CustomerLink;
import com.helper.service.CusLinkService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CusLinkServiceImpl implements CusLinkService {
	private CusLInkDao csd=new CusLinkDaoImpl();

	/*   分页查查全部 
	 * pagenumber:传入页码
	 * pagesize：传入每页大小
	 * 返回客户记录的列表
	 */
	public PageBean findByPage(int pagenumber, int pagesize,String code,String name, String Date) {
		return csd.selectAll( pagenumber, pagesize,code,name,Date);
		
	}
	
/*
 * 根据code删除
 * 返回状态
 */
	public int Deletecus(String code) {
	return csd.delete(code);
	}
	
	public int addCus(CustomerLink c){
		
		return csd.insert(c);
	}

	public int changeCus(CustomerLink rs) {
		// TODO Auto-generated method stub
		return csd.update(rs);
	}

	public int  OutExcel(List<CustomerLink> l) {
		int ret =  0;
		HSSFWorkbook workbook = new HSSFWorkbook();//创建一个Excel文件
		HSSFSheet sheet = workbook.createSheet("企业信息表");//添加一个sheet		
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle = workbook.createCellStyle();//创建单元格，并设置值表头设置表头居中 
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		HSSFCell cell = row.createCell(0); 			
        cell.setCellValue("代码");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(1);  
        cell.setCellValue("名称");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(2);  
        cell.setCellValue("联系人");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(3);  
        cell.setCellValue("电话");     
        cell.setCellStyle(cellStyle); 
        //写入实体数据，实际上这些数据应该从数据库得到
       
    
        for(int i = 0; i <l.size(); i++)  
        {  
        	
        	CustomerLink c = l.get(i);  
            row = sheet.createRow(i+1);  
            row.createCell(0).setCellValue(c.getCode());  
            row.createCell(1).setCellValue(c.getCsName());  
            row.createCell(2).setCellValue(c.getContActor());  
            row.createCell(3).setCellValue(c.getTelPhone());  
          
      
        }
        FileOutputStream fout;
		try {
			fout = new FileOutputStream("F://往来单位10.xls");
			   workbook.write(fout);  
		        fout.close(); 
		        ret =1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return ret = 1;
	}
	
	
	public int getTotal(String code, String name, String cc) {
		// TODO Auto-generated method stub
		return csd.selectTotal(code, name, cc);
	}
	public List<CustomerLink> OutExcel(String code, String name, String cc) {
		return csd.selectAll(code, name, cc);
		
	}
	public void outWord(Map<String,Object> dataMap,String fileName){
		Configuration con=null;
		con = new Configuration();
		con.setDefaultEncoding("utf-8");
		//模板放在temp包下
		con.setClassForTemplateLoading(this.getClass(),"/template");
		Template t=null;
		
		//为 test.ftl装载模板
		try {
			t=con.getTemplate("往来单位信息.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//输出文档路径及名称
		File outFile=new File(fileName);
		Writer out =null;
		FileOutputStream fos=null;
		
		try {
			
			fos=new FileOutputStream(outFile);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");//这个地方对流的编码不可或缺										
			out	=new BufferedWriter(osw);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			//输出文本
			try {
				t.process(dataMap,out);
				out.close();
				fos.close();
				
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
