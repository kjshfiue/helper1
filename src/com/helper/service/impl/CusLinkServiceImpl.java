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

	/*   ��ҳ���ȫ�� 
	 * pagenumber:����ҳ��
	 * pagesize������ÿҳ��С
	 * ���ؿͻ���¼���б�
	 */
	public PageBean findByPage(int pagenumber, int pagesize,String code,String name, String Date) {
		return csd.selectAll( pagenumber, pagesize,code,name,Date);
		
	}
	
/*
 * ����codeɾ��
 * ����״̬
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
		HSSFWorkbook workbook = new HSSFWorkbook();//����һ��Excel�ļ�
		HSSFSheet sheet = workbook.createSheet("��ҵ��Ϣ��");//���һ��sheet		
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle = workbook.createCellStyle();//������Ԫ�񣬲�����ֵ��ͷ���ñ�ͷ���� 
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//ˮƽ����
		HSSFCell cell = row.createCell(0); 			
        cell.setCellValue("����");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(1);  
        cell.setCellValue("����");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(2);  
        cell.setCellValue("��ϵ��");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(3);  
        cell.setCellValue("�绰");     
        cell.setCellStyle(cellStyle); 
        //д��ʵ�����ݣ�ʵ������Щ����Ӧ�ô����ݿ�õ�
       
    
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
			fout = new FileOutputStream("F://������λ10.xls");
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
		//ģ�����temp����
		con.setClassForTemplateLoading(this.getClass(),"/template");
		Template t=null;
		
		//Ϊ test.ftlװ��ģ��
		try {
			t=con.getTemplate("������λ��Ϣ.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����ĵ�·��������
		File outFile=new File(fileName);
		Writer out =null;
		FileOutputStream fos=null;
		
		try {
			
			fos=new FileOutputStream(outFile);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");//����ط������ı��벻�ɻ�ȱ										
			out	=new BufferedWriter(osw);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			//����ı�
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
