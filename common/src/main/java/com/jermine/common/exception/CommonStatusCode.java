package com.jermine.common.exception;

import lombok.Getter;

@Getter
public enum CommonStatusCode {

    SUCCESS("000000", "处理成功", "处理成功"),
    FAIL("999999", "处理失败", "处理失败"),
    LOGIN_ERROR("444444","登录失败","登录失败"),
    PARAM_ERROR("000001","参数校验失败", "参数校验失败"),
    ;

    private String code;
    private String errorMessage;
    private String returnMessage;

    CommonStatusCode(String code, String errorMessage, String returnMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.returnMessage = returnMessage;
    }

    CommonStatusCode(String code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }
}
