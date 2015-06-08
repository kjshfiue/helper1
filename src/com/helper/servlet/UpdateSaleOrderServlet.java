package com.helper.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.entity.SaleOrder;
import com.helper.service.SaleOrderService;
import com.helper.service.impl.SaleOrderServiceImpl;
import com.helper.tools.DateUtil;

public class UpdateSaleOrderServlet extends HttpServlet {
	private SaleOrderService soService = new SaleOrderServiceImpl();
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/josn; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String code1 = request.getParameter("code1");
		String code = request.getParameter("code");
		String orderDate = request.getParameter("orderDate");
		String customerCode = request.getParameter("customerCode");
		String nums = request.getParameter("nums");
		String numSprice = request.getParameter("numSprice");
		String telPhone = request.getParameter("telPhone");
		String state = request.getParameter("state");
		String addUserName = request.getParameter("addUserName");
		String contacter = request.getParameter("contacter");
		
		SaleOrder s = new SaleOrder();
		s.setCode(code);
		s.setOrderDate(DateUtil.toJavaDate(orderDate,"yyyy-MM-dd"));
		s.setCustomerCode(customerCode);
		s.setNums(nums==""?0:Integer.parseInt(nums));
		s.setNumSprice(numSprice==""?0:Integer.parseInt(numSprice));
		s.setTelPhone(telPhone);
		s.setState("已审核".equals(state)?"1":"0");
		s.setAddUserName(addUserName);
		s.setContacter(contacter);
		int ret = soService.updateByCode(code1, s);
		if(ret==1){
			response.getWriter().println("{'message':'修改成功！'}");
		}else{
			response.getWriter().println("{'message':'修改失败！'}");
		}
		
		
		
	}

}
