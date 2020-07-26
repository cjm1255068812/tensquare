package com.jermine.base.exception;

public enum BaseBizStatusCode {
    SUCCESS("000000", "处理成功", "处理成功"),
    FAIL("999999", "处理失败", "处理失败"),
    UNAUTHORIZED("444444", "未认证", "未认证"),
    PARAM_ERROR("000001", "参数校验错误", "参数校验错误"),
    LOGIN_USERNAME_ERROR("000002", "用户名不存在", "用户名不存在"),
    LOGIN_PASSWORD_ERROR("000003", "密码错误", "密码错误"),
    LABEL_NOT_FOUND("000004", "标签信息不存在", "标签信息不存在"),
    LABEL_DELETE_ERROR("000004", "标签删除失败", "标签删除失败"),
    LABEL_PARAM_NAME_ERROR("000005", "标签名称输入不合法", "标签名称输入不合法"),
    ;

    private String code;
    private String errorMessage;
    private String returnMessage;

    BaseBizStatusCode(String code, String errorMessage, String returnMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.returnMessage = returnMessage;
    }

    BaseBizStatusCode(String code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;

    }

    public String getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getReturnMessage() {
        return returnMessage;
    }
}
