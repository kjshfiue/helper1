package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.helper.entity.Company;
import com.helper.service.CompanyService;
import com.helper.service.impl.CompanyServiceImpl;
import com.helper.util.JSONDateProcessor;
public class SearchCompanyJsonServlet extends HttpServlet {

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
	private  CompanyService companyService=new CompanyServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/json;charset=utf-8");
		
		/*JsonConfig  config=new JsonConfig();
		  config.setExcludes(new String[]{"cShow","cDate","cLogo","cUser","cUserName","cIp"});//设置把哪些实体属性排除
		  config.registerJsonValueProcessor(Date.class,new JSONDateProcessor("yyyy年MM月dd日"));
		*/
		//Company company = new Company();
		//company=companyService.findByIdCompany("GS20150528102723");//给一个固定值
		Company company = companyService.findCompany();//给一个固定值
		//json解析
		JSONObject jsob=JSONObject.fromObject(company);
	    /*Map attrs=new HashMap();
		  attrs.put("rows",company.getcDate());
		  jsonObject.putAll(attrs,config);
		  String data=jsonObject.toString();
		*/
		System.out.println(jsob);
		response.getWriter().println(jsob);
		
	}

}
