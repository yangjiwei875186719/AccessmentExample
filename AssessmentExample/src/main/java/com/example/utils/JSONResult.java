package com.example.utils;

/**
 * 2020/5/7 14:06
 * root
 * 包装JSON数据返回到前台
 */
public class JSONResult<T> {
    private Integer code;//0正常，1请求数据不存在，2服务器异常错误
    private String msg;
    private T data;

    /**
     * 请求成功的构造函数
     *
     * @param data
     */
    private JSONResult(T data) {
        this.code = 0;//默认0是成功
        this.msg = "SUCCESS";
        this.data = data;
    }

    /**
     * 请求失败时的构造方法
     *
     * @param code
     * @param msg
     */
    private JSONResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }


    /**
     * 成功时调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> JSONResult<T> success(T data) {
        return new JSONResult<T>(data);
    }


    /**
     * 失败时调用
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> JSONResult<T> error(Integer code, String msg) {
        return new JSONResult<T>(code, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
