package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.tools.DocumentHandler;

public class OutputCahInqueryDocServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OutputCahInqueryDocServlet() {
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
			this.doGet(request, response);
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
			response.setContentType("text/html");
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String code=request.getParameter("code_add");
			String comPCode=request.getParameter("comPcode_add");
			String nums=request.getParameter("nums_add");
			String numSprice=request.getParameter("numSprice_add");
			String contacter=request.getParameter("contacter_add");
			String telephone=request.getParameter("telephone_add");
			String state=request.getParameter("state_add");
			String remarks=request.getParameter("remarks_add");
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("code",code);
			map.put("comPCode",comPCode);
			map.put("nums",nums);
			map.put("numSprice",numSprice);
			map.put("contacter",contacter);
			map.put("telephone",telephone);
			map.put("state",state);
			map.put("remarks",remarks);
			DocumentHandler doc = new DocumentHandler();    
			doc.createDoc(map, "E:/基础管理任务分配.doc");
			
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
