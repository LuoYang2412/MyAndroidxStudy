package com.luoyang.myandroidxstudy.api;

import java.io.Serializable;

/**
 * 数据包装类
 *
 * @param <T>
 * @author LuoYang
 */
public class ResponseData<T> implements Serializable {
    private boolean success;
    private int code;
    private String message;
    private T data;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
