package com.helper.tools;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	/**
	 * @freemarker 导出word
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		 Map<String, Object> dataMap = new HashMap<String, Object>();  
		 
		 dataMap.put("code", "编写员1");
		 dataMap.put("codeName", "编写员2");
		 dataMap.put("categorycode", "编写员3");
		 dataMap.put("orderNo", "编写员4");
		 dataMap.put("isShow", "编写员5");
		 dataMap.put("remarks", "编写员5");
		 
		 //导出word
		 DocumentHandler doc = new DocumentHandler();    
		 doc.createDoc(dataMap, "E:/字典.doc");  

	}

}
