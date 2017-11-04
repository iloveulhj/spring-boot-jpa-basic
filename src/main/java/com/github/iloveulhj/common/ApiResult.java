package com.github.iloveulhj.common;

public enum ApiResult {
    SUCCESS(true, "0000", "Success"),
    INTERNAL_ERROR(false, "0500", "Intnal Error");

    ApiResult(boolean isSuccess, String code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess;
    public String code;
    public String message;
}
