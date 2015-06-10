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

import com.helper.dao.CashInqueryDao;
import com.helper.dao.impl.CashInqueryDaoImpl;
import com.helper.entity.CashInquery;

public class ExportCashInqueryExcelServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ExportCashInqueryExcelServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
			response.setContentType("text/json;charset=utf-8 ");
			request.setCharacterEncoding("utf-8");
			CashInquery cashInquery=new CashInquery();
			//获得前台所传数据
			String code=request.getParameter("code");
			String addDate1= request.getParameter("addDate");
			String comPCode=request.getParameter("comPCode");
		    String nums=request.getParameter("nums");
		    String numSprice=request.getParameter("numSprice");
		    String contacter=request.getParameter("contacter");
		    String telphone =request.getParameter("telphone");
		    String state=request.getParameter("state");
		    System.out.println(addDate1);
		    //转化日期型数据
		    SimpleDateFormat sdf= new SimpleDateFormat("dd-MM月-yy");
		    Date addDate=null;
			try {
				addDate = sdf.parse(addDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    //获得数据进行封装
		    cashInquery.setCode(code);
		    cashInquery.setAddDate(addDate);
		    cashInquery.setComPCode(comPCode);
		    cashInquery.setNums(nums);
		    cashInquery.setNumSprice(numSprice);
		    cashInquery.setContacter(contacter);
		    cashInquery.setTelphone(telphone);
		    cashInquery.setState(state);
		   
		    
		    //方法调用
		    CashInqueryDao ciDao=new CashInqueryDaoImpl();
		    ciDao.outputExecle(cashInquery);
	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
