package com.helper.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.service.BaseContentService;
import com.helper.service.impl.BaseContentServiceImpl;
import com.helper.tools.JxlExcelUtils;

public class ExportExcelServlet extends HttpServlet {
	private BaseContentService bcService = new BaseContentServiceImpl();
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
		
		String code = request.getParameter("code");
		String codeName = request.getParameter("codeName");
		String categorycode = request.getParameter("categorycode");
		HashMap<String, String> map = new HashMap<String, String>();
		if(categorycode==null||categorycode==""){
			categorycode = "";
		}
		if(code==null||code==""){
			code = "";
		}
		if(codeName==null||codeName==""){
			codeName = "";
		}
		map.put("categorycode", categorycode);
		map.put("code", code);
		map.put("codeName", codeName);
		List<Map<String,Object>> listData = bcService.findAllBaseContent(map);
		List<String> columns = new ArrayList<String>();
		columns.add("所属类别");
		columns.add("字典编号");
		columns.add("字典内容");
		columns.add("公司名称");
		columns.add("排序编号");
		columns.add("备注");
		columns.add("操作员");
		columns.add("显示状态");
		JxlExcelUtils.exportexcle(response, "zidian", listData, "sheetName", columns);  
		
	}

}
