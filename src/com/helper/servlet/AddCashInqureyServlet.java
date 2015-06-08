package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.dao.CashInqueryDao;
import com.helper.dao.impl.CashInqueryDaoImpl;
import com.helper.entity.CashInquery;

public class AddCashInqureyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddCashInqureyServlet() {
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
		//获得前台页面传来数据
		String comPCode=request.getParameter("comPcode_add");
		String nums=request.getParameter("nums_add");
		String numSprice=request.getParameter("numSprice_add");
		String contacter=request.getParameter("contacter_add");
		String telephone=request.getParameter("telephone_add");
		String state=request.getParameter("state_add");
		String remarks=request.getParameter("remarks_add");
		//对数据进行封装
		String code=null;
		Date date=new Date();
		int year =0;
		
		CashInquery cashInquery=new CashInquery();
		cashInquery.setCode(code);
		cashInquery.setComPCode(comPCode);
		cashInquery.setNums(nums);
		cashInquery.setContacter(contacter);
		cashInquery.setNumSprice(numSprice);
		cashInquery.setTelphone(telephone);
		cashInquery.setState(state);
		cashInquery.setRemarks(remarks);
		//写回数据库
		CashInqueryDao ciDao=new CashInqueryDaoImpl();
		int ret=ciDao.addCashInqueryList(cashInquery);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("ret", ret);
		String data=jsonObject.toString();
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
