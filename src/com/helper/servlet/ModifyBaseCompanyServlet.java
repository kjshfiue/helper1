package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONObject;

import com.helper.entity.Company;
import com.helper.service.CompanyService;
import com.helper.service.impl.CompanyServiceImpl;

public class ModifyBaseCompanyServlet extends HttpServlet {

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
	private CompanyService companyService = new CompanyServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String hide = request.getParameter("hide");
		Company company = new Company();
		company.setCid(request.getParameter("code"));
		company.setcName(request.getParameter("compName"));
		company.setcAddress(request.getParameter("compAddress"));
		company.setcPostCode(request.getParameter("compPostCode"));
		company.setcPhone(request.getParameter("compPhone"));
		company.setcFax(request.getParameter("compFax"));
		company.setcUrl(request.getParameter("compUrl"));
		company.setcEmail(request.getParameter("compEmail"));
		company.setcLegaler(request.getParameter("compLegaler"));
		company.setcAgent(request.getParameter("compAgent"));
		company.setcAccount(request.getParameter("compAccount"));
		company.setcBank(request.getParameter("compBank"));
		company.setcTax(request.getParameter("compTax"));
		company.setcMark(request.getParameter("remarks"));
		String flag = null;
		if(hide==null||hide==""){
			System.out.println("执行插入操作"+hide);
			flag=companyService.insertCompany(company)==1?"公司添加成功!":"公司添加失败!";
		}else{
			System.out.println("执行修改操作");
			flag=companyService.updateCompany(company)==1?"公司修改成功!":"公司修改失败!";
		}
		JSONObject j = new JSONObject();
		j.put("flag", flag);
		response.getWriter().println(j.toString());
		
	}
}
