package com.helper.cuslinkservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.service.CusLinkService;
import com.helper.service.impl.CusLinkServiceImpl;

public class DeletecusSeverlet extends HttpServlet {

	private CusLinkService cls = new CusLinkServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("77777777"+request.getParameter("code"));
		String code=request.getParameter("code");
		System.out.print(cls.Deletecus(code));
		System.out.println("É¾³ý");
		response.sendRedirect("/helper/base/coslinkmanger.html?page=10");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
