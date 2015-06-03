package com.helper.cuslinkservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.dao.CusLInkDao;
import com.helper.dao.impl.CusLinkDaoImpl;
import com.helper.entity.CustomerLink;

public class GetCusByCodeServlet extends HttpServlet {
	private  CusLInkDao cd = new CusLinkDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String code = request.getParameter("code");
		CustomerLink c = cd.selectByCode(code);
		JSONObject json = JSONObject.fromObject(c);
		response.getWriter().print(json.toString());
		System.out.println(json.toString());
	}

}
