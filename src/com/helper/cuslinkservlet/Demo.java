package com.helper.cuslinkservlet;

import com.helper.dao.CusLInkDao;
import com.helper.dao.impl.CusLinkDaoImpl;

public class Demo {

	public static void main(String[] args) {
		 CusLInkDao cd = new CusLinkDaoImpl();
		 System.out.println("dddddddd"+cd.selectByCode("GCS20150601013321").getCode());
	}

}
