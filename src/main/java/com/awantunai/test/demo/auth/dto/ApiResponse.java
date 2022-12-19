package com.awantunai.test.demo.auth.dto;

public class ApiResponse<T> {
    private int status;
    private T data;
    private String error;

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public ApiResponse(T data) {
        this.status = 200;
        this.data = data;
    }

    public ApiResponse(int status, String error) {
        this.status = status;
        this.data = null;
        this.error = error;
    }
}
