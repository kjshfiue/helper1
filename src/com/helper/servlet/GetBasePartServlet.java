package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.dao.CashInqueryDao;
import com.helper.dao.impl.CashInqueryDaoImpl;
import com.helper.entity.DBCashInquery;
import com.helper.entity.PageBean;

public class GetBasePartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetBasePartServlet() {
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
              request.setCharacterEncoding("utf-8");
              response.setContentType("text/json;charset=utf-8");
              String code=request.getParameter("code");
              PageBean pageBean=null;
              String pageNo=request.getParameter("page");
  		      String pageSize=request.getParameter("rows");
  		      if(pageNo==null||pageNo.equals("")){
  		    	pageNo="1";
  		       }
  		       if(pageSize==null||pageSize.equals("")){
  		    	pageSize="10";
  		       }
              /* String code=null;
            
              if(code1==null||code1==""){
  		    	   code="'null'";
  		    	
  		       }else{
  		           code="'"+code1+"'";
  		        }*/
              CashInqueryDao ciDao=new CashInqueryDaoImpl();
              List <DBCashInquery> list=new ArrayList <DBCashInquery>();
              pageBean= ciDao.getBasePart(Integer.parseInt(pageNo), Integer.parseInt(pageSize), code);
              System.out.println(pageBean.getTotal());
              JSONObject jsonObject=new JSONObject();
              jsonObject.put("rows",pageBean.getData());
              jsonObject.put("total",pageBean.getTotal());
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
