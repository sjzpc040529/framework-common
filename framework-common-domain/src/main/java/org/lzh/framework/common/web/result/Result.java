package org.lzh.framework.common.web.result;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回結果集
 * Created by Courser on 2015/11/8.
 */
@Data
public class Result<D> implements Serializable {
    private final static  Integer sucCode=1 ;
//    @Getter
//    @Setter
    /**
     * 调用成功失败
     */
    private boolean success;
//    @Getter
//    @Setter
    /**
     * 提示信息，一般用于错误提示信息
     */
    private String msg;
    /**
     * 数据对象
     */
//    @Getter
//    @Setter
    private D data;
//    @Getter
//    @Setter
    /**
     * 错误码
     */
    private Integer resultCode;
    public Result(boolean success){
        this.success = success;

    }
    public Result(){

    }

    public static <T> Result successResult(T data) {
        Result result = new Result();
        result.data = data;
        result.success = true;
        result.resultCode = sucCode ;
        return result;
    }

    public static Result errorResult(Integer errorCode, String message) {
        Result result = new Result(false);
//        result.success = false;
        result.resultCode = errorCode;
        result.msg = message;
        return result;
    }



}
