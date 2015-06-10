package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.dao.CashInqueryDao;
import com.helper.dao.impl.CashInqueryDaoImpl;
import com.helper.entity.CashInquery;

public class UpdateCashInqueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateCashInqueryServlet() {
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

		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		CashInquery cashInquery=new CashInquery();
		//获得前台所传数据
		String code=request.getParameter("code_update");
		String comPCode=request.getParameter("comPcode_update");
	    String nums=request.getParameter("nums_update");
	    String numSprice=request.getParameter("numSprice_update");
	    String contacter=request.getParameter("contacter_update");
	    String telephone =request.getParameter("telephone_update");
	    String state=request.getParameter("state_update");
	 
	   
	    //获得数据进行封装
	    cashInquery.setCode(code);
	    cashInquery.setComPCode(comPCode);
	    cashInquery.setNums(nums);
	    cashInquery.setNumSprice(numSprice);
	    cashInquery.setContacter(contacter);
	    cashInquery.setTelphone(telephone);
	    cashInquery.setState(state);
	    
	    //将数据写回数据库
	    CashInqueryDao ciDao=new CashInqueryDaoImpl();
	    int ret=0;
	     ret=ciDao.updateCashInqueryList(cashInquery);
	     System.out.println(ret);
	    JSONObject jsonObject=new JSONObject();
	    jsonObject.put("ret",ret);
	    String data=jsonObject.toString();
	    System.out.println(data); 
	    response.getWriter().println(data);
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
