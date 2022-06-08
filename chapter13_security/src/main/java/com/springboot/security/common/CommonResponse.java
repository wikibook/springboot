package com.springboot.security.common;

// 예제 13.27
public enum CommonResponse {

    SUCCESS(0, "Success"), FAIL(-1, "Fail");

    int code;
    String msg;

    CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
