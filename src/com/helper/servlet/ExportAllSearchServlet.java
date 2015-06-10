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

import com.helper.dao.CashInqueryDao;
import com.helper.dao.impl.CashInqueryDaoImpl;
import com.helper.tools.JxlExcelUtils;

public class ExportAllSearchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ExportAllSearchServlet() {
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
            response.setContentType("text/json;chartset=utf-8");
            request.setCharacterEncoding("utf-8");
            String code=null;
		    String startDate=null;
		    String endDate=null;
		    String privider=null;
		    String code1=request.getParameter("code");
		    if(code1==null||code1==""){
		    	code="'null'";
		    	
		    }else{
		        code="'"+code1+"'";
		    }
		    String startDate1=request.getParameter("startDate");
		    if(startDate1==null||startDate1==""){
		    	startDate="'null'";
		    }
		    else{
		         startDate="'"+startDate1+"'";
		     }
		    String endDate1 =request.getParameter("endDate");
		    if(endDate1==null||endDate1==""){
		    	endDate="'null'";
		    }else{
		      endDate="'"+endDate1+"'";
		    }
		    String privider1=request.getParameter("privider");
		    if(privider1==null||privider1==""){
		    	privider="'null'";
		    }else{
		     privider="'"+privider1+"'";}
		
		    
		    HashMap <String ,String> map=new HashMap<String ,String>();
		    map.put("code", code);
		    map.put("endDate", endDate);
		    map.put("startDate", startDate);
		    map.put("comPCode",privider);
		    CashInqueryDao ciDao=new CashInqueryDaoImpl();
		    List<Map<String,Object>> listData = ciDao.findAllBCashInquery(map);
		    List<String> columns = new ArrayList<String>();
			columns.add("询价编号");
			columns.add("询价日期");
			columns.add("供应商名称");
			columns.add("数量");
			columns.add("金额");
			columns.add("联系人");
			columns.add("联系方式");
			columns.add("审核状态");
			JxlExcelUtils.exportexcle(response, "询价单", listData, "sheetName", columns);  
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
