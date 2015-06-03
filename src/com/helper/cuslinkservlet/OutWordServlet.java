package com.helper.cuslinkservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.helper.dao.CusLInkDao;
import com.helper.dao.impl.CusLinkDaoImpl;
import com.helper.entity.CustomerLink;
import com.helper.service.CusLinkService;
import com.helper.service.impl.CusLinkServiceImpl;
public class OutWordServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	private CusLinkService cs = new CusLinkServiceImpl();
	private CusLInkDao cld =new CusLinkDaoImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code2");
			 CustomerLink c =cld.selectByCode(code);
			 Map<String, Object> dataMap = new HashMap<String, Object>();  
			 dataMap.put("code", c.getCode());
			 dataMap.put("csname", c.getCsName());
			 dataMap.put("name", c.getCsName());
			 dataMap.put("contactor", "455");
			 dataMap.put("telphone", c.getTelPhone());
			 dataMap.put("type", c.getCategoryCode());
			 dataMap.put("remarks", c.getRemarks());
			 //导出word	   
			cs.outWord(dataMap, "E:/基础管理任务分配111.doc"); 
			JSONObject josn =  new JSONObject();
			josn.put("ret","1");
			response.getWriter().print(josn.toString());
	}

}
