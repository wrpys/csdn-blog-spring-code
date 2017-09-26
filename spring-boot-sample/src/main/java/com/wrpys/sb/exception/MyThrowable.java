package com.wrpys.sb.exception;

public interface MyThrowable {

    /**
     * 获取错误码信息
     *
     * @return
     */
    public String getCode();

    /**
     * 获取错误信息
     *
     * @return
     */
    public String getMsg();

    /**
     * 获取异常类型
     *
     * @return
     */
    public String getType();

    /**
     * 获取异常堆栈信息
     *
     * @return
     */
    public String getStackTraceMsg();

    /**
     * 获取异常源
     *
     * @return
     */
    public Throwable getThrowable();
}
