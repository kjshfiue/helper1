package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.tools.DocumentHandler;
import com.helper.tools.DocumentHandlerNext;

public class PrintServlet extends HttpServlet {

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

		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code",request.getParameter("code"));
		map.put("inDate",request.getParameter("inDate"));
		map.put("supplierCode",request.getParameter("supplierCode"));
		map.put("contActer",request.getParameter("contActer"));
		map.put("teltphone",request.getParameter("teltphone"));
		map.put("fax",request.getParameter("fax"));
		map.put("inType","1".equals(request.getParameter("inType"))?"œ‘ æ":"“˛≤ÿ");
		map.put("isInVoice","1".equals(request.getParameter("isInVoice"))?"œ‘ æ":"“˛≤ÿ");
		map.put("remarks",request.getParameter("remarks"));
		DocumentHandlerNext doc = new DocumentHandlerNext();    
		doc.createDoc(map, "E:/¥Ú”°.doc");
	}

}
