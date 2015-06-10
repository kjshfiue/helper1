package com.helper.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JSONDateProcessor implements JsonValueProcessor {

	private String format = null;
	public JSONDateProcessor(){
		this.format = "yyyy-MM-dd HH:mm:ss";
	}
	public JSONDateProcessor(String fmt){
		this.format = fmt;
	}

	public Object processObjectValue(String key, Object val, JsonConfig conf) {
		// TODO Auto-generated method stub
		return process(val);
	}
	
	public Object processArrayValue(Object val, JsonConfig conf) {
		// TODO Auto-generated method stub
		return process(val);
	}
	
    private Object process(Object value){   
        if(value instanceof Date){   
            SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.UK);   
            return sdf.format((Date)value);   
        }   
        return value == null ? "" : value.toString();   
    }

}
