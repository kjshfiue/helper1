package com.helper.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.entity.BaseContent;
import com.helper.service.BaseContentService;
import com.helper.service.impl.BaseContentServiceImpl;

public class AddBaseContentServlet extends HttpServlet {

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

		response.setContentType("text/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		BaseContent bc = new BaseContent();
		bc.setCode(request.getParameter("code"));
		bc.setCodeName(request.getParameter("codeName"));
		bc.setCategorycode(request.getParameter("categorycode"));
		bc.setOrderNo(request.getParameter("orderNo"));
		bc.setIsShow(request.getParameter("isShow"));
		bc.setRemarks(request.getParameter("remarks"));
		bc.setAddUser(request.getParameter("addUser"));
		bc.setAddUserName(request.getParameter("addUserName"));
		bc.setAddIp(request.getParameter("addIp"));
		bc.setCompCode(request.getParameter("compCode"));
		BaseContentService bcService = new BaseContentServiceImpl();
		int ret = bcService.addBaseContent(bc);
		JSONObject json = new JSONObject();
		if(ret==1){
			json.put("message", "×ÖµäÌí¼Ó³É¹¦£¡");
		}else{
			json.put("message", "×ÖµäÌí¼ÓÊ§°Ü£¡");
		}
		System.out.println("message: "+json.toString());
		response.getWriter().println(json.toString());
		
	}

}
