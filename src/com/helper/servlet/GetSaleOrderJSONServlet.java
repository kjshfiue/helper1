package com.helper.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.helper.entity.PageBean;
import com.helper.service.SaleOrderService;
import com.helper.service.impl.SaleOrderServiceImpl;
import com.helper.tools.DateUtil;
import com.helper.util.JSONDateProcessor;

public class GetSaleOrderJSONServlet extends HttpServlet {
	private SaleOrderService saleOrderService = new SaleOrderServiceImpl();
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
		String code = request.getParameter("code");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");	
		String customerCode = request.getParameter("customerCode");
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		if(pageNo==null||pageNo==""){
			pageNo = "1";
		}
		if(pageSize==null||pageSize==""){
			pageSize = "10";
		}
		if(startDate!=null&&startDate!=""){
			startDate = DateUtil.toSqlDateString(startDate);
		}
		if(endDate!=null&&endDate!=""){
			endDate = DateUtil.toSqlDateString(endDate);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("code", code);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("customerCode", customerCode);
		PageBean pageBean = saleOrderService.findSaleOrder(Integer.parseInt(pageNo),Integer.parseInt(pageSize),map);

		Map<String,Object> map22 = new HashMap<String,Object>();
		map22.put("rows", pageBean.getData());
		map22.put("total", pageBean.getTotal());
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JSONDateProcessor("yyyy-MM-dd"));
		////
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll( map22, jsonConfig);
		response.getWriter().println(jsonObject.toString());
		
	}

}
