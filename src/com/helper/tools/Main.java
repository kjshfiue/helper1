package com.helper.tools;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	/**
	 * @freemarker ����word
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		 Map<String, Object> dataMap = new HashMap<String, Object>();  
		 
		 dataMap.put("code", "��дԱ1");
		 dataMap.put("codeName", "��дԱ2");
		 dataMap.put("categorycode", "��дԱ3");
		 dataMap.put("orderNo", "��дԱ4");
		 dataMap.put("isShow", "��дԱ5");
		 dataMap.put("remarks", "��дԱ5");
		 
		 //����word
		 DocumentHandler doc = new DocumentHandler();    
		 doc.createDoc(dataMap, "E:/�ֵ�.doc");  

	}

}
