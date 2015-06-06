package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.PjServices.impl.PartsServicesImpl;
import com.helper.entity.Parts;

public class UpdateMessage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateMessage() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String code=request.getParameter("partsCode");
		String No=request.getParameter("partsNo");
		String Category=request.getParameter("partsCategory");
		String Name=request.getParameter("partsName");
		String Brand=request.getParameter("partsBrand");
		String Model=request.getParameter("partsModel");
		String ModelOld=request.getParameter("partsModelOld");
		String Price=request.getParameter("salePrice");
		String show=request.getParameter("idShow");
		String UserName=request.getParameter("addUserName");
		String remarks=request.getParameter("remarks");
		
		Parts parts=new Parts();
		
		
		parts.setAddUserName(UserName);
	
		parts.setIdShow(show);
		parts.setPartsBrand(Brand);
		parts.setPartsCategory(Category);
		System.out.println("code:"+code);
		parts.setPartsCode(code);
		
		parts.setPartsModel(Model);
		parts.setPartsModelOld(ModelOld);
		parts.setPartsName(Name);
		parts.setPartsNo(No);
		System.out.println("No"+No);
		parts.setRemarks(remarks);
		parts.setSalePrice(Double.parseDouble(Price));
		
		
		
		PartsServicesImpl psi=new PartsServicesImpl();
		int flag=psi.updateParts(parts);
		PrintWriter out = response.getWriter();
		System.out.println("flag:"+flag);
		out.print(flag);
		out.flush();
		out.close();
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
