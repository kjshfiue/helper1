package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.helper.dao.CashInqueryDao;
import com.helper.dao.impl.CashInqueryDaoImpl;
import com.helper.entity.PageBean;
import com.helper.util.JSONDateProcessor;

public class GetBaseCashInqueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetBaseCashInqueryServlet() {
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
		    response.setContentType("text/json; charset=utf-8");
		    JsonConfig config=new JsonConfig();
		    config.setExcludes(new String[]{});
		    config.registerJsonValueProcessor(Date.class,new JSONDateProcessor("dd-MMÔÂ-yy"));
		    CashInqueryDao ciDao=new CashInqueryDaoImpl();
 		    String pageNo=request.getParameter("page");
		    String pageSize=request.getParameter("rows");
		    if(pageNo==null||pageNo.equals("")){
		    	pageNo="1";
		    }
		    if(pageSize==null||pageSize.equals("")){
		    	pageSize="10";
		    }
		    PageBean pageBean=ciDao.getAllPartInfo(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
             Map attrs=new HashMap();
             JSONObject jsonObject=new JSONObject();
             attrs.put("rows",pageBean.getData());
             attrs.put("total",pageBean.getTotal());
             jsonObject.putAll(attrs,config);
             String data=jsonObject.toString();
             response.getWriter().println(data);
	
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
				this.doGet(request, response);
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
