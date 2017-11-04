package com.github.iloveulhj.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.iloveulhj.common.ApiResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
public class AjaxResponse {
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

    public static AjaxResponse getSuccessResponse() {
        AjaxResponse apiResponse = new AjaxResponse();
        apiResponse.setHeader(new Header(ApiResult.SUCCESS));
        return apiResponse;
    }

    public static AjaxResponse getFailResponse() {
        AjaxResponse apiResponse = new AjaxResponse();
        apiResponse.setHeader(new Header(ApiResult.INTERNAL_ERROR));
        return apiResponse;
    }
}