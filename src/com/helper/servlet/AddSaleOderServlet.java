package com.helper.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.entity.SaleOrder;
import com.helper.service.SaleOrderService;
import com.helper.service.impl.SaleOrderServiceImpl;
import com.helper.tools.DateUtil;

public class AddSaleOderServlet extends HttpServlet {
	private SaleOrderService saleOrderService = new SaleOrderServiceImpl();
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

		response.setContentType("text/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String code = request.getParameter("code");
		String orderDateStr = request.getParameter("orderDate");
		String customerCode = request.getParameter("customerCode");
		String trans = request.getParameter("trans");
		String businesser = request.getParameter("businesser");
		String contacter = request.getParameter("contacter");
		String telPhone = request.getParameter("telPhone");
		String remarks = request.getParameter("remarks");
		String deliveryDateStr = request.getParameter("deliveryDate");
		String addUserName = request.getParameter("addUserName");
		String fax = request.getParameter("fax");
		Date orderDate = null;
		Date deliveryDate = null;
		if(orderDateStr!=null&&orderDateStr!=""){
			orderDate = DateUtil.toJavaDate(orderDateStr, "yyyy-MM-dd");
		}
		if(deliveryDateStr!=null&&deliveryDateStr!=""){
			deliveryDate = DateUtil.toJavaDate(deliveryDateStr, "yyyy-MM-dd");
		}
		SaleOrder saleOrder = new SaleOrder();
		saleOrder.setCode(code);
		saleOrder.setOrderDate(orderDate);
		saleOrder.setCustomerCode(customerCode);
		saleOrder.setTrans(trans);
		saleOrder.setBusinesser(businesser);
		saleOrder.setContacter(contacter);
		saleOrder.setTelPhone(telPhone);
		saleOrder.setRemarks(remarks);
		saleOrder.setDeliveryDate(deliveryDate);
		saleOrder.setFax(fax);
		saleOrder.setAddUserName(addUserName);
		int ret = saleOrderService.addSaleOrder(saleOrder);
		JSONObject json = new JSONObject();
		if(ret==1){
			json.put("message", "订单添加成功!");
		}else{
			json.put("message", "订单添加失败!");
		}
		response.getWriter().println(json.toString());
		
		
		
		
	}

}
