package com.jermine.common.util;

import com.jermine.common.annotation.FieldExInfo;
import com.jermine.common.entity.Response;
import com.jermine.common.exception.CommonException;
import com.jermine.common.exception.CommonStatusCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.lang.reflect.Field;
import java.util.Objects;


public class ResponseUtils {

    private ResponseUtils() {
        throw new AssertionError("No com.jermine.util.ResponseUtils instances for you!");
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setCode(CommonStatusCode.SUCCESS.getCode());
        response.setFlag(Boolean.TRUE);
        response.setMessage(CommonStatusCode.SUCCESS.getReturnMessage());
        return response;
    }

    public static <T> Response<T> success(T data, String message) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setCode(CommonStatusCode.SUCCESS.getCode());
        response.setFlag(Boolean.TRUE);
        response.setMessage(message);
        return response;
    }

    public static <T> Response<T> fail(CommonException ex) {
        Response<T> response = new Response<>();
        response.setFlag(Boolean.FALSE);

        if (ex != null) {
            response.setCode(ex.getErrorCode());
            if (StringUtils.isBlank(ex.getReturnMsg())) {
                response.setMessage(ex.getErrorMsg());
            } else {
                response.setMessage(ex.getReturnMsg());
            }

            return response;
        }
        response.setCode(CommonStatusCode.FAIL.getCode());
        response.setMessage(CommonStatusCode.FAIL.getReturnMessage());
        return response;
    }

    public static Response<String> failValidate(MethodArgumentNotValidException ex) throws NoSuchFieldException {
        Response<String> response = new Response<>();
        response.setFlag(Boolean.FALSE);
        String defaultMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        Class<?> parameterType = ex.getParameter().getParameterType();
        String fieldName = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getField();
        Field field = parameterType.getDeclaredField(fieldName);
        FieldExInfo annotation = field.getAnnotation(FieldExInfo.class);
        if (annotation != null) {
            response.setCode(annotation.value());
        } else {
            response.setCode(CommonStatusCode.PARAM_ERROR.getCode());
        }
        response.setMessage(defaultMessage);
        return response;
    }
}
