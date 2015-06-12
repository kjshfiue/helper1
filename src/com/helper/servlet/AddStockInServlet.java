package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.entity.StockIn;
import com.helper.service.StockInService;
import com.helper.service.impl.StockInServiceImpl;
import com.helper.tools.DateUtil;

public class AddStockInServlet extends HttpServlet {

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
		StockIn stockIn = new StockIn();
		//System.out.println("ÄãµÄ±³°ü"+request.getParameter("code"));
		stockIn.setCode(request.getParameter("code"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println("ÄãÅ£"+request.getParameter("inDate"));
		try {
			stockIn.setInDate(sdf.parse(request.getParameter("inDate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stockIn.setSupplierCode(request.getParameter("supplierCode"));
		stockIn.setContActer(request.getParameter("contActer"));
		stockIn.setTeltphone(request.getParameter("teltphone"));
		stockIn.setFax(request.getParameter("fax"));
		stockIn.setInType(request.getParameter("inType"));
		stockIn.setIsInVoice(request.getParameter("isInVoice"));
		stockIn.setRemarks(request.getParameter("remarks"));
		
		//stockIn.setIsRoad(request.getParameter("isRoad"));
		//System.out.println("¶ßÀ²AÃÎ"+request.getParameter("isShow"));
		//stockIn.setIsShow(request.getParameter("isShow"));
		
//		try {
//			stockIn.setAddDate(sdf.parse(request.getParameter("addDate")));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//stockIn.setNums(Double.parseDouble(request.getParameter("nums")));
		//stockIn.setNumSprice(Double.parseDouble("numSprice"));
		//stockIn.setState(request.getParameter("state"));
		//stockIn.setCompCode(request.getParameter("compCode"));
		//stockIn.setAddUser(request.getParameter("addUser"));
		//stockIn.setAddUserName(request.getParameter("addUserName"));
		//stockIn.setAddIp(request.getParameter("addIp"));
		
		StockInService stockInService = new StockInServiceImpl();
		int ret=stockInService.insertStockIn(stockIn);
	}
	

}
