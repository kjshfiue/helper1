package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.dao.impl.OrderImpl;
import com.helper.entity.Order;

public class ForUpDateXjMessage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ForUpDateXjMessage() {
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
		String code=new String(request.getParameter("code").getBytes("ISO-8859-1"), "utf-8");
		String orddate=new String(request.getParameter("ddrq").getBytes("ISO-8859-1"), "utf-8");
		String supplycode=new String(request.getParameter("gys").getBytes("ISO-8859-1"), "utf-8");
		String contacter=new String(request.getParameter("lxr").getBytes("ISO-8859-1"), "utf-8");
		String telphone=new String(request.getParameter("dh").getBytes("ISO-8859-1"), "utf-8");
		String fax=new String(request.getParameter("cz").getBytes("ISO-8859-1"), "utf-8");
		String trans=new String(request.getParameter("ysfs").getBytes("ISO-8859-1"), "utf-8");
		String deliverydate=new String(request.getParameter("jhrq").getBytes("ISO-8859-1"), "utf-8");
		String busineerer=new String(request.getParameter("ywry").getBytes("ISO-8859-1"), "utf-8");
		String remarks=new String(request.getParameter("bz").getBytes("ISO-8859-1"), "utf-8");
		String isshow=new String(request.getParameter("xsfs").getBytes("ISO-8859-1"), "utf-8");
		String nums=new String(request.getParameter("pjsl").getBytes("ISO-8859-1"), "utf-8");
		String numsprice=new String(request.getParameter("cgzj").getBytes("ISO-8859-1"), "utf-8");
		String state=new String(request.getParameter("sh").getBytes("ISO-8859-1"), "utf-8");
		String addDate=new String(request.getParameter("czrq").getBytes("ISO-8859-1"), "utf-8");
		String addUser=new String(request.getParameter("czyh").getBytes("ISO-8859-1"), "utf-8");
		String AddUsername=new String(request.getParameter("czyhm").getBytes("ISO-8859-1"), "utf-8");
		String Addip=new String(request.getParameter("czip").getBytes("ISO-8859-1"), "utf-8");

		PrintWriter out = response.getWriter();
		Order ord=new Order();
		ord.setCode(code);
		ord.setOrderDate(orddate);
		ord.setSuppliercode(supplycode);
		ord.setContacter(contacter);
		ord.setTelphone(telphone);
		ord.setFax(fax);
		ord.setTrans(trans);
		ord.setDeliverydate(deliverydate);
		ord.setBusinesser(busineerer);
		ord.setRemarks(remarks);
		ord.setIsshow(isshow);
		ord.setNums(nums);
		ord.setNumsprice(numsprice);
		ord.setState(state);
		ord.setAddDate(addDate);
		ord.setAdduser(addUser);
		ord.setAddUserName(AddUsername);
		ord.setAddIp(Addip);
		
		OrderImpl oi=new OrderImpl();
		int flag=oi.updateMessage(ord);
		//System.out.println(flag);
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
