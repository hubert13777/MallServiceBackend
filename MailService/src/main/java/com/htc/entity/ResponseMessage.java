package com.htc.entity;

public class ResponseMessage<T> {
    // 枚举类，用来定义状态码
    public enum Code{
        GET_OK(1),GET_ERROR(0);

        private int num;

        private Code(int num){
            this.num=num;
        }
    }

    private int code;
    private String message;
    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}