package com.jermine.common.exception;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description TODO
 * @Author Jermine
 * @Date 2019/1/29 11:37
 **/
@Data
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 8349733024973824658L;

    private String errorCode;
    private String errorMsg;
    private String returnMsg;
    private Integer printLog;

    public CommonException() {
        this.printLog = 1;
    }

    public CommonException(String errorCode, String errorMsg) {
        this.printLog = 1;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonException(String errorCode, String errorMsg, Integer printLog) {
        this(errorCode, errorMsg);
        this.printLog = printLog;
    }

    public CommonException(String errorCode, String errorMsg, Throwable t) {
        super(t);
        this.printLog = 1;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonException(String errorCode, String errorMsg, Integer printLog, Throwable t) {
        this(errorCode, errorMsg, t);
        this.printLog = printLog;
    }

    public CommonException(String errorCode, String errorMsg, String returnMsg) {
        this.printLog = 1;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.returnMsg = returnMsg;
    }

    public CommonException(String errorCode, String errorMsg, String returnMsg, Integer printLog) {
        this(errorCode, errorMsg, returnMsg);
        this.printLog = printLog;
    }

    public CommonException(String errorCode, String errorMsg, String returnMsg, Throwable t) {
        super(t);
        this.printLog = 1;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.returnMsg = returnMsg;
    }

    public CommonException(String errorCode, String errorMsg, String returnMsg, Integer printLog, Throwable t) {
        this(errorCode, errorMsg, returnMsg, printLog);
        this.printLog = printLog;
    }

    public String toString() {
        return super.toString() + " [errorCode = " + this.errorCode + "，errorMsg=" + this.errorMsg + "]";
    }

}
