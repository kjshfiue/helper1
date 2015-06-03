package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.helper.PjServices.PartsServicesDao;
import com.helper.PjServices.impl.PartsServicesImpl;
import com.helper.entity.Parts;

public class ForFindMessage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ForFindMessage() {
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
		PrintWriter out = response.getWriter();
		PartsServicesDao psd=new PartsServicesImpl();
		String type=new String(request.getParameter("type1").getBytes("ISO-8859-1"),"utf-8");
	//	System.out.println("liebie:"+type);
		if(!type.equals("-ѡ�����-")){
			type="'"+type+"'";
		}else{
			type=null;
		}
		String name=request.getParameter("name1");
		//System.out.println("name:"+name);
		if(!name.isEmpty()){
			name="'"+name+"'";
		}else{
			name=null;
		}
		String number=request.getParameter("number1");
		//System.out.println("bianhao"+number);
		if(!number.isEmpty()){
			number="'"+number+"'";
		}else{
			number=null;
		}
		
		List<Parts> list=psd.searchParts(number,name,type);
		
		JSONArray jsar=JSONArray.fromObject(list);
		//System.out.println(jsar);
		out.print(jsar);
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
