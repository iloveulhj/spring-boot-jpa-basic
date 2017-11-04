package com.github.iloveulhj.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.iloveulhj.common.ApiResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
public class ApiResponse {
    private Header header;
    private Map<String, Object> body = new HashMap<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header {
        @JsonIgnore
        public ApiResult apiResult;

        public Boolean getIsSuccess() {
            return apiResult.isSuccess;
        }

        public String getResultCode() {
            return apiResult.code;
        }

        public String getResultMessage() {
            return apiResult.message;
        }
    }

    public static ApiResponse getSuccessResponse() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHeader(new Header(ApiResult.SUCCESS));
        return apiResponse;
    }

    public static ApiResponse getFailResponse() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHeader(new Header(ApiResult.INTERNAL_ERROR));
        return apiResponse;
    }
}