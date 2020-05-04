package com.ryzezhao.springcloud.payment.common;


import lombok.Data;

import java.io.Serializable;

/**
 * 统一接口返回数据格式
 * @author: HeHaoZhao
 * @date: 2020/5/4 18:01
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "操作成功！";

    /**
     * 返回代码
     */
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    private T result;

    public Result() {
        this.code = HttpStatusConstant.SC_OK_200;
    }

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public void error500(String message) {
        this.message = message;
        this.code = HttpStatusConstant.SC_INTERNAL_SERVER_ERROR_500;
        this.success = false;
    }

    public void success(String message) {
        this.message = message;
        this.code = HttpStatusConstant.SC_OK_200;
        this.success = true;
    }

    public static Result<Object> error(String msg) {
        return error(HttpStatusConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
    }

    public static Result<Object> error(int code, String msg) {
        Result<Object> r = new Result<Object>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public static Result<Object> ok() {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(HttpStatusConstant.SC_OK_200);
        r.setMessage("成功");
        return r;
    }

    public static Result<Object> ok(String msg) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(HttpStatusConstant.SC_OK_200);
        r.setMessage(msg);
        return r;
    }

    public static Result<Object> ok(Object data) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(HttpStatusConstant.SC_OK_200);
        r.setResult(data);
        return r;
    }

    public static Result<Object> ok(String msg, Object data) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(HttpStatusConstant.SC_OK_200);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }
}