package com.htc.entity;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
    // 枚举类，用来定义状态码
    public enum Code{
        GET_OK(1),GET_ERROR(2),
        SYSTEM_ERROR(10001),
        BUSINESS_ERROR(20001),
        UNKNOWN_ERROR(30001);

        private int num;

        private Code(int num){
            this.num=num;
        }

        public int getNum() {
            return num;
        }
    }

    private int code;
    private String message;
    private T data;

    public Response() {
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}