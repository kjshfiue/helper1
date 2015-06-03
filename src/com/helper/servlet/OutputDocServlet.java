package com.helper.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.tools.DocumentHandler;

public class OutputDocServlet extends HttpServlet {

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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code",request.getParameter("code"));
		map.put("codeName",request.getParameter("codeName"));
		map.put("categorycode",request.getParameter("categorycode"));
		map.put("orderNo",request.getParameter("orderNo"));
		map.put("isShow","1".equals(request.getParameter("isShow"))?"ÏÔÊ¾":"Òþ²Ø");
		map.put("remarks",request.getParameter("remarks"));
		DocumentHandler doc = new DocumentHandler();    
		doc.createDoc(map, "E:/xin×Öµä.doc");
	}

}
