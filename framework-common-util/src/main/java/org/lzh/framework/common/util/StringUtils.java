package org.lzh.framework.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 字符串工具处理类
 * @author: lizhaohua
 * @date: 15/11/16 下午5:14
 * @version: V1.0
 */
public class StringUtils {

    /**
     * 日期格式化
     * @param date 日期
     * @param format 格式化
     * @return 返回格式化字符串
     */
    public static String dateFormat(Date date,String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);

        return sdf.format(date);
    }

    /**
     * 日期默认格式化 yyyy-MM-dd
     * @param date
     * @return
     */
    public static String dateFormat(Date date){
        return dateFormat(date, "yyyy-MM-dd");
    }

    /**
     * 日期默认格式化 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String timeFormat(Date date){
        return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取昨天的日期格式化字符串 yyyy-MM-dd
     * @return
     */
    public static String yesterdayFormate(){
        Date  date = new Date();
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(date);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间
        return dateFormat(dBefore);
    }
}
