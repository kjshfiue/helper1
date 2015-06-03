package com.helper.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.service.BaseContentService;
import com.helper.service.impl.BaseContentServiceImpl;

public class DeleteBaseContentServlet extends HttpServlet {
	private BaseContentService  bcService = new BaseContentServiceImpl(); 
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

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		String categorycode = request.getParameter("categorycode");
		//categorycode = new String(categorycode.getBytes("iso8859-1"),"utf-8");
		
		String code = request.getParameter("code");
		//code = new String(code.getBytes("iso8859-1"),"utf-8");
		//System.out.println("delete½ÓÊÕ+"+categorycode+","+code);
		int ret = bcService.deleteByCode(categorycode, code);
		JSONObject json = new JSONObject();
		json.put("ret", ret);
		//System.out.println("É¾³ý×´Ì¬£º"+ret+","+categorycode+","+code+json.toString());
		response.getWriter().println(json.toString());
		
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

		this.doGet(request, response);
	}

}
