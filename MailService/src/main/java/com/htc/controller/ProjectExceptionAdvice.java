package com.htc.controller;

import com.htc.entity.Response;
import com.htc.exception.BusinessException;
import com.htc.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.htc.entity.Response.Code;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Response doSystemException(SystemException ex){  //系统异常
        return new Response(Code.SYSTEM_ERROR.getNum(),ex.getMessage(),null);
    }

    @ExceptionHandler(BusinessException.class)
    public Response doBusinessException(BusinessException ex){  //业务异常
        return new Response(Code.BUSINESS_ERROR.getNum(),ex.getMessage(),null);
    }

    @ExceptionHandler(Exception.class)
    public Response doException(Exception ex){      //其他异常
        return new Response(Code.UNKNOWN_ERROR.getNum(),"系统繁忙，请稍后再试",null);
    }
}
