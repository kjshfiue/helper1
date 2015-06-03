package com.helper.cuslinkservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.helper.dao.impl.PageBean;
import com.helper.entity.CustomerLink;
import com.helper.service.CusLinkService;
import com.helper.service.impl.CusLinkServiceImpl;

public class GetCusList extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}
	
	
	private CusLinkService cs=new CusLinkServiceImpl();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置
		response.setContentType("text/json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取数据
		int pagenumber=1;
		int pagesize=3;
		String name =null;
		String cc  = null;
		String code  = null;
		if(request.getParameter("page")!=null&&request.getParameter("rows")!=null){
			pagenumber= Integer.parseInt(request.getParameter("page"));
		    pagesize = Integer.parseInt(request.getParameter("rows"));
		}
		if(request.getParameter("code")!=null){
			code = request.getParameter("code");
		}
		if(request.getParameter("name")!=null){
			//完美解决乱码问题
			 name=new String(request.getParameter("name").getBytes("iso8859-1"),"utf-8");	
		}
		if(request.getParameter("cc")!=null&&request.getParameter("cc")!=""){
			System.out.println("AAAAAA"+request.getParameter("cc"));
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			cc=request.getParameter("cc");
			try {
				Date date = sdf.parse(cc);
				Calendar cl = Calendar.getInstance();
				cl.setTime(date);
				
				int day  = cl.get(Calendar.DAY_OF_MONTH);
				int month = cl.get(Calendar.MONTH)+1;
				int year = cl.get(Calendar.YEAR);
				cc = day+"-"+month+"月"+"-"+year;
				
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
		}	
		//逻辑处理
		PageBean pb = cs.findByPage(pagenumber, pagesize,code,name,cc);
		List<CustomerLink> cuslist=pb.getDatelist();
		JSONObject cusObject=new JSONObject();
		cusObject.put("total", cs.getTotal(code,name,cc));
		cusObject.put("rows", cuslist);		
		response.getWriter().println(cusObject.toString());
	}

}
