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
import com.helper.service.StockOutService;
import com.helper.service.impl.StockOutServiceImpl;

public class updateStockOutDanJuServlet extends HttpServlet {

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
	private StockOutService stockOutService = new StockOutServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json;charset=utf-8");
		String code=request.getParameter("code");
		StockOut stockOut=new StockOut();
		stockOut.setCode(request.getParameter("code"));
					
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//System.out.println(request.getParameter("outDate"));
			if(request.getParameter("outDate")!=null){
				stockOut.setOutDate(sdf.parse(request.getParameter("outDate")));
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stockOut.setCustomerCode(request.getParameter("customerCode"));
		//System.out.println(request.getParameter("ustomerCode"));
		stockOut.setNums(Double.parseDouble(request.getParameter("nums")));
		stockOut.setNumSprice(Double.parseDouble(request.getParameter("numSprice")));
		stockOut.setState(request.getParameter("state"));
		stockOut.setAddUserName(request.getParameter("addUserName"));
		
		int ret=stockOutService.updateStockOut(code,stockOut);
		response.getWriter().println("{\"ret\":"+ret+"}");
	}

}
