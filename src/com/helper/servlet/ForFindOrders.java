package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.helper.dao.impl.OrderImpl;
import com.helper.entity.Order;

public class ForFindOrders extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ForFindOrders() {
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
	/*	String code=new String(request.getParameter("code").getBytes("iso-8859"),"utf-8");
		String rq=new String(request.getParameter("rq").getBytes("iso-8859"),"utf-8");
		String gys=new String(request.getParameter("gys").getBytes("iso-8859"),"utf-8");
		String lxr=new String(request.getParameter("lxr").getBytes("iso-8859"),"utf-8");
		String dh=new String(request.getParameter("dh").getBytes("iso-8859"),"utf-8");
		String cz=new String(request.getParameter("cz").getBytes("iso-8859"),"utf-8");
		String ysfs=new String(request.getParameter("ysfs").getBytes("iso-8859"),"utf-8");
		String jhrq=new String(request.getParameter("jhrq").getBytes("iso-8859"),"utf-8");
		String ywry=new String(request.getParameter("ywry").getBytes("iso-8859"),"utf-8");
		String bz=new String(request.getParameter("bz").getBytes("iso-8859"),"utf-8");
		String xsfs=new String(request.getParameter("xsfs").getBytes("iso-8859"),"utf-8");
		String pjsl=new String(request.getParameter("pjsl").getBytes("iso-8859"),"utf-8");
		String cgzj=new String(request.getParameter("cgzj").getBytes("iso-8859"),"utf-8");
		String sh=new String(request.getParameter("sh").getBytes("iso-8859"),"utf-8");
		String czrz=new String(request.getParameter("czrz").getBytes("iso-8859"),"utf-8");
		String czyh=new String(request.getParameter("czyh").getBytes("iso-8859"),"utf-8");
		String fzyhm=new String(request.getParameter("fzyhm").getBytes("iso-8859"),"utf-8");
		String czip=new String(request.getParameter("czip").getBytes("iso-8859"),"utf-8");*/
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		int first=Integer.parseInt(pageNo);
		int second=Integer.parseInt(pageSize);
		OrderImpl oi=new OrderImpl();
		List<Order> list=new ArrayList<Order>();
		list=oi.findOrders(null, null, null, null,first,second);
		JSONArray jsar=JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
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
