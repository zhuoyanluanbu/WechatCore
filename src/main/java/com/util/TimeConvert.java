package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thinkpad on 2015/8/12.
 */
public class TimeConvert {

    public static String convertTimeStamp(String strFormat){
        String timeStr="";
        try {
            Date date = new Date();
            SimpleDateFormat sdf=new SimpleDateFormat(strFormat);
            timeStr=sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeStr;
    }

}
