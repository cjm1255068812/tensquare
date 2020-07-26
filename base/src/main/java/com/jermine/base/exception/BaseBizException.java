package com.jermine.base.exception;

import com.jermine.common.exception.CommonException;

public class BaseBizException extends CommonException {

    private BaseBizStatusCode statusCode;

    public BaseBizException(BaseBizStatusCode statusCode) {
        super(statusCode.getCode(), statusCode.getErrorMessage(), statusCode.getReturnMessage());
    }

    public BaseBizException(BaseBizStatusCode statusCode, Exception e) {
        super(statusCode.getCode(), statusCode.getErrorMessage(), statusCode.getReturnMessage(), e);
    }

    public BaseBizException(String code, String realMessage, String showMessage) {
        super(code, realMessage, showMessage);
    }

    public BaseBizException(String code, String realMessage, String showMessage, Exception e) {
        super(code, realMessage, showMessage, e);
    }

}
