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

import com.helper.entity.CustomerLink;
import com.helper.service.CusLinkService;
import com.helper.service.impl.CusLinkServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class OutExcel extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	private CusLinkService cs=new CusLinkServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String name = null;
			String cc   = null;
			String code = null;
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
					System.out.println("FFFFFF"+cc);
					}catch (ParseException e) {
						e.printStackTrace();
				}
			}	
			cs.OutExcel(cs.OutExcel(code,name,cc));
			JSONObject jo = new JSONObject();
			jo.put("result",1);
			System.out.println(jo.toString());
			response.getWriter().print(jo.toString());	
	}

}
