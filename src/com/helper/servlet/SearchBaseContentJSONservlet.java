package com.helper.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.entity.BaseContent;
import com.helper.entity.PageBean;
import com.helper.service.BaseContentService;
import com.helper.service.impl.BaseContentServiceImpl;

public class SearchBaseContentJSONservlet extends HttpServlet {
	private BaseContentService bcService = new BaseContentServiceImpl();
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
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		if(pageSize==null||pageSize==""){
			pageSize="10";
		}
		String categorycode = request.getParameter("categorycode");
		String code = request.getParameter("code");
		String codeName = request.getParameter("codeName");
		HashMap<String, String> map = new HashMap<String, String>();
		if(categorycode==null||categorycode==""){
			categorycode = "";
		}
		if(code==null||code==""){
			code = "";
		}
		if(codeName==null||codeName==""){
			codeName = "";
		}
		map.put("categorycode", categorycode);
		map.put("code", code);
		map.put("codeName", codeName);
		
		PageBean pageBean = bcService.searchPageBean(Integer.parseInt(pageNo), Integer.parseInt(pageSize), map);
		JSONObject json = new JSONObject();
		json.put("rows", pageBean.getData());
		json.put("total", pageBean.getTotal());
		response.getWriter().println(json.toString());
	}

}
