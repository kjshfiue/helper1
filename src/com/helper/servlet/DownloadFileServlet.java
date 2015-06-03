package com.helper.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFileServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 //��������ļ���  
        String fileName = request.getParameter("fileName");  
        System.out.println(fileName);  
          
        //�����ļ�MIME����  
        response.setContentType(getServletContext().getMimeType(fileName)); 
        
        //����Content-Disposition  
        //�������ͻ��������������ļ�ʱ������������֧�ֵ��ļ����ͣ�һ���Ĭ��ʹ��������򿪣�����txt��jpg�ȣ���ֱ�������������ʾ��
        //�����Ҫ��ʾ�û����棬��Ҫ����Content-Disposition����һ�´����ؼ�����һ��Ҫ����attachment��
        
        response.setHeader("Content-Disposition", "attachment;filename="+fileName);  
       
        //��ȡĿ���ļ���ͨ��response��Ŀ���ļ�д���ͻ���  
        //��ȡĿ���ļ��ľ���·��  	
        String fullFileName = getServletContext().getRealPath("/download/" + fileName);  
        //System.out.println(fullFileName);  
        
        //��ȡ�ļ�  
        
        InputStream in = new FileInputStream(fullFileName);  
        OutputStream out = response.getOutputStream();  
          
        //д�ļ�  
        byte[] buff = new byte[2048];
        int b= 0;
        while(-1!=(b= in.read(buff,0,buff.length)))  //�������������buff.length�������ֽڶ��� byte ���顣
        {
            out.write(buff,0,b);
        }
        
        in.close();  
        out.close();  
	}

}
