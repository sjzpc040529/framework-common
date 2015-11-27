package org.lzh.framework.common.util;


import com.google.gson.Gson;

/**
 * @Description:打印对象
 * @author: lizhaohua
 * @date: 15/11/3 上午11:43
 * @version: V1.0
 */
public class Printer {
    /**
     * 调用gson的api转json
     * @param o 对象
     * @return json字符串
     */
    public  static void println(Object o){
        System.out.println( new Gson().toJson(o));
    }
}
