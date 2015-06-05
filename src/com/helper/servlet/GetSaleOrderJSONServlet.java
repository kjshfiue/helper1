package com.helper.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.entity.PageBean;
import com.helper.service.SaleOrderService;
import com.helper.service.impl.SaleOrderServiceImpl;

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
		Map<String,String> map = new HashMap<String,String>();
		map.put("code", code);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("customerCode", customerCode);
		PageBean pageBean = saleOrderService.findSaleOrder(Integer.parseInt(pageNo),Integer.parseInt(pageSize),map);
		JSONObject json = new JSONObject();
		json.put("rows", pageBean.getData());
		json.put("total", pageBean.getTotal());
		response.getWriter().println(json.toString());
		
	}

}
