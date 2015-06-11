package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.entity.StockIn;
import com.helper.entity.StockOut;
import com.helper.service.StockInService;
import com.helper.service.StockOutService;
import com.helper.service.impl.StockInServiceImpl;
import com.helper.service.impl.StockOutServiceImpl;

public class AddStockOutServlet extends HttpServlet {

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
		StockOut stockOut = new StockOut();
		//System.out.println("ÄãµÄ±³°ü"+request.getParameter("code"));
		stockOut.setCode(request.getParameter("code"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println("ÄãÅ£"+request.getParameter("outDate"));
		try {
			stockOut.setOutDate(sdf.parse(request.getParameter("outDate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stockOut.setCustomerCode(request.getParameter("customerCode"));
		stockOut.setContActer(request.getParameter("contActer"));
		stockOut.setTelphone(request.getParameter("telphone"));
		stockOut.setFax(request.getParameter("fax"));
		stockOut.setOutType(request.getParameter("outType"));
		stockOut.setIsInVoice(request.getParameter("isInVoice"));
		
		stockOut.setRemarks(request.getParameter("remarks"));
		
		//stockOut.setIsRoad(request.getParameter("isRoad"));
		//System.out.println("¶ßÀ²AÃÎ"+request.getParameter("isShow"));
		//stockIn.setIsShow(request.getParameter("isShow"));
//		try {
//			stockOut.setAddDate(sdf.parse(request.getParameter("addDate")));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//stockOut.setNums(Double.parseDouble(request.getParameter("nums")));
		//stockOut.setNumSprice(Double.parseDouble("numSprice"));
		//stockOut.setState(request.getParameter("state"));
		//stockOut.setCompCode(request.getParameter("compCode"));
		//stockOut.setAddUser(request.getParameter("addUser"));
		//stockOut.setAddUserName(request.getParameter("addUserName"));
		//stockOut.setAddIp(request.getParameter("addIp"));
		
		StockOutService stockOutService = new StockOutServiceImpl();
		int ret=stockOutService.insertStockOut(stockOut);
	}
	
}
