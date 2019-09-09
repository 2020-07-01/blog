package com.example.blog.errorCode;

/**
 * @author :qiang
 * @date :2019/9/8 下午9:19
 * @description :错误信息处理
 * @other :
 */
public class ErrorCode {

    //错误代码
    String code1;
    //错误信息
    String errorMessage;

    public ErrorCode(String code, String errorMessage) {
        this.code1 = code;
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return code1;
    }

    public void setCode(String code) {
        this.code1 = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
