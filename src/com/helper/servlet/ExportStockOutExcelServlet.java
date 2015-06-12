package com.helper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.helper.service.StockInService;
import com.helper.service.StockOutService;
import com.helper.service.impl.StockInServiceImpl;
import com.helper.service.impl.StockOutServiceImpl;
import com.helper.tools.DateUtil;
import com.helper.tools.JxlExcelUtils;

public class ExportStockOutExcelServlet extends HttpServlet {

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
	private StockOutService stockOutService = new StockOutServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String code = request.getParameter("code");
		String date1= request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String name = request.getParameter("name");
		HashMap<String, String> map = new HashMap<String, String>();
		if(code==null||code==""){
			code = "";
		}
		if(date1!=null&&date1!=""){
			date1 =DateUtil.toSqlDateString(date1);
		}
		if(date2!=null&&date2!=""){
			date2 =DateUtil.toSqlDateString(date2);
		}
		if(name==null||name==""){
			name = "";
		}
		
		map.put("code", code);
		System.out.println("入库时间"+date1);
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("name", name);
		List<Map<String,Object>> listData = stockOutService.findAllStock(map);
		List<String> columns = new ArrayList<String>();
		columns.add("出库单号");
		columns.add("出库日期");
		columns.add("客户名称");
		columns.add("数量");
		columns.add("总货值");
		columns.add("审核状态");
		columns.add("操作员");
	    JsonConfig  config=new JsonConfig();
		config.setExcludes(new String[]{"contacter","telphone","fax","outtype","address","isinvoice",
				"remarks","isshow","adddate","adduser","addip"});//设置把哪些实体属性排除
		
		JSONArray lineitemArray = JSONArray.fromObject( listData ,config);
		List result = JSONArray.fromObject(lineitemArray);
		
		JxlExcelUtils.exportexcle(response, "shuju1", result, "sheetName", columns);  
		
		
		
	}

}
