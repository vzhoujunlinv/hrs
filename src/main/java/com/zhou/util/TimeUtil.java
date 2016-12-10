package com.zhou.util;
import java.math.BigDecimal;  
import java.text.DecimalFormat;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  

public class TimeUtil {
	
	public static Date formatDate(String dateStr){  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date result=null;  
        try {  
            result = sdf.parse(dateStr);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }
}
