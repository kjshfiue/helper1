package com.helper.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.helper.service.SaleOrderService;
import com.helper.service.impl.SaleOrderServiceImpl;

public class DelBatchSaleOrderServlet extends HttpServlet {
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
		request.getParameter("utf-8");
		String data = request.getParameter("data");
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<String> codeList = (List<String>)JSONArray.toCollection(jsonArray);
		int ret = saleOrderService.deleteBatchByCode(codeList);
		JSONObject json = new JSONObject();
		if(ret==1){
			json.put("message", "批量删除成功！");
		}else{
			json.put("message", "批量删除失败！");
		}
		response.getWriter().println(json.toString());
		
		
		
		
	}

}
