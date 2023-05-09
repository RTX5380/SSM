package com.ssm.controller;

import com.ssm.exception.BusinessException;
import com.ssm.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doException(SystemException se){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发给开发人员
        return new Result(se.getCode(),null,se.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doException(BusinessException be){
        return new Result(be.getCode(),null,be.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception be){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发给开发人员
        return new Result(Code.SYSTEM_UNKONW_ERR,null,"系统繁忙，请稍后再试");
    }
}