package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.entity.SaleOrderDetail;
import com.helper.entity.StockIn;
import com.helper.entity.StockInDetail;
import com.helper.service.StockInDetailService;
import com.helper.service.StockInService;
import com.helper.service.impl.StockInDetailServiceImpl;
import com.helper.service.impl.StockInServiceImpl;

public class DescriptionStockInServlet extends HttpServlet {

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
	private StockInDetailService skInDS=new StockInDetailServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String inCode=request.getParameter("inCode");
		List<StockInDetail> list = null;
		if(inCode!=null&&inCode!=""){
			list = skInDS.findDatailByInCode(inCode);
		}
		JSONObject json = new JSONObject();
		json.put("rows", list);
		response.getWriter().println(json.toString());
	}

}
