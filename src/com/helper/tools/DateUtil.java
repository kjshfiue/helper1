package com.helper.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 
	 * @param date 日期字符串
	 * @param s 日期格式
	 * @return
	 */
	public static Date toJavaDate(String date,String s){
		SimpleDateFormat sdf2 = new SimpleDateFormat(s);
		Date date2 = null;
		try {
			date2 = sdf2.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
	}
	/**
	 * 
	 * @param date 日期字符串
	 * @param s 日期格式
	 * @return
	 */
	public static Date toSqlDate(String date,String s){
		SimpleDateFormat sdf2 = new SimpleDateFormat(s);
		Date date2 = null;
		
			try {
				date2 = new java.sql.Date(sdf2.parse(date).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return date2;
	}
	
	
private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String toSqlDateString(String str){
		String dateStr = null;
		try {
			Date date = sdf.parse(str);
			Calendar c = Calendar. getInstance();//创建日历类工具
			c.setTime(date); //设置日历日期
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1;
			int day = c.get(Calendar.DAY_OF_MONTH);
			dateStr = day+"-"+month+"月-"+year;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateStr;
	}

	public static String toSqlDateString(Date date){
		String dateStr = null;
		Calendar c = Calendar. getInstance();//创建日历类工具
		c.setTime(date); //设置日历日期
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH+1);
		int day = c.get(Calendar.DAY_OF_MONTH);
		dateStr = day+"-"+month+"月-"+year;
		return dateStr;
	}
	
	public static Date toSqlDate(Date javaDate){
		Date sqlDate = new java.sql.Date(javaDate.getTime());
		return sqlDate;
	}
	
}
