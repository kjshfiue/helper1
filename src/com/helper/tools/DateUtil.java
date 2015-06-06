package com.helper.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String toSqlDateString(String str){
		String dateStr = null;
		try {
			Date date = sdf.parse(str);
			Calendar c = Calendar. getInstance();//���������๤��
			c.setTime(date); //������������
			c.add(Calendar. DAY_OF_MONTH,40); //��������40��40���
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			dateStr = day+"-"+month+"��"+year;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String toSqlDateString(Date date){
		
		return null;
	}
}
