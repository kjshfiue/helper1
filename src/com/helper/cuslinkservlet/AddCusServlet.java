package com.helper.cuslinkservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.entity.CustomerLink;
import com.helper.service.CusLinkService;
import com.helper.service.impl.CusLinkServiceImpl;

public class AddCusServlet extends HttpServlet {
	
	private CusLinkService cul =  new CusLinkServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		//code,CATEGORYCODE,CSNAME,ADDDATE,TELEPHONE,ADDRESS,ADDDATE,REMARKS
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		String type = request.getParameter("type");
		String addDate = request.getParameter("date");
		String telPhone =  request.getParameter("telPhone");
		String csName = request.getParameter("name");
		String contActor = request.getParameter("conActor");
		String remarks = request.getParameter("remarks");
		String address = request.getParameter("address");
		
		CustomerLink c = new CustomerLink();
		
		c.setCode(code);
		c.setCategoryCode(type);
		c.setTelPhone(telPhone);
		c.setCsName(csName);
		c.setContActor(contActor);
		c.setRemarks(remarks);
		c.setAddress(address);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			c.setAddDate(sdf.parse(addDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ìí¼Ó
		if(state.equals("add")){
			int ret = cul.addCus(c);
			response.sendRedirect("/helper/base/addcus.jsp?ret="+ret);
		}
		//ÐÞ¸Ä
		if(state.equals("update")){
			int ret =cul.changeCus(c);
			
			response.sendRedirect("/helper/base/updatecus.jsp?code="+code);
		}
		}
		

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
