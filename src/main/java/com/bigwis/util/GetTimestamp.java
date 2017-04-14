package com.bigwis.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 将Date格式的时间转换为Timestamp格式的时间
 * Created by GanZiB on 2017/4/12.
 */
public class GetTimestamp {

    /**
     * 将Date格式的时间转换为Timestamp格式的时间
     * @param date 时间
     * @param format 时间格式
     * @return
     */
    public static Timestamp changeTime(Date date,String format,Integer amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if(amount!=0)
        calendar.add(Calendar.DATE,-1);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateSdf = sdf.format(calendar.getTime());
        return Timestamp.valueOf(dateSdf);
    }


}
