package com.helper.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.helper.entity.PageBean;
import com.helper.service.StockInService;
import com.helper.service.impl.StockInServiceImpl;
import com.helper.tools.DateUtil;
import com.helper.util.JSONDateProcessor;



public class DisplayStockInServlet extends HttpServlet {
	
	
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
	private StockInService stockInService = new StockInServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

  	 	
		response.setContentType("text/json; charset=utf-8");
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		if(pageSize==null||pageSize==""){
			pageSize="5";
		}
		//System.out.println("方象"+pageNo+"--"+pageSize);
		String code = request.getParameter("code");
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String name = request.getParameter("name");
		
		HashMap<String, String> map = new HashMap<String, String>();
		if(code==null||code==""){
			code = "";
		}
		if(date1!=null&&date1!=""){
			date1 = DateUtil.toSqlDateString(date1);
		}
		if(date2!=null&&date2!=""){
			date2 = DateUtil.toSqlDateString(date2);
		}
		map.put("code", code);
		//System.out.println("込込"+date1);
		map.put("date1", date1);
		System.out.println("込込*"+date2);
		map.put("date2", date2);
		map.put("name", name);
		PageBean pageBean = stockInService.searchPageBean
				(Integer.parseInt(pageNo), Integer.parseInt(pageSize), map);
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JSONDateProcessor("yyyy-MM-dd"));

		Map attrs=new HashMap();
        JSONObject jsonObject=new JSONObject();
        attrs.put("rows",pageBean.getData());
        attrs.put("total",pageBean.getTotal());
        
        jsonObject.putAll(attrs,jsonConfig);
        response.getWriter().println(jsonObject.toString());
		
		
	}

}
