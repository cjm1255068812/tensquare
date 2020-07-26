package com.jermine.base.exception;

import com.jermine.common.entity.Response;
import com.jermine.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.jermine.common.util.ResponseUtils.fail;
import static com.jermine.common.util.ResponseUtils.failValidate;

@ControllerAdvice
@Slf4j
public class BaseBizExceptionHandler {

    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public ResponseEntity<Response<Object>> handleException(CommonException ex) {
        if (StringUtils.isNoneEmpty(ex.getReturnMsg())) {
            log.error(ex.getReturnMsg(), ex);
        } else {
            log.error("CommonException occurred", ex);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fail(ex));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Response<Object>> handleException(Exception ex) {
        log.error("Exception occurred", ex);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fail(null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<String>> handleException(MethodArgumentNotValidException ex) throws NoSuchFieldException {
        log.error("MethodArgumentNotValidException occurred", ex);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(failValidate(ex));
    }
}
