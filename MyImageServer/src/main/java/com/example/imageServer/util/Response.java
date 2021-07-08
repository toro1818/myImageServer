package com.example.imageServer.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class Response<T> implements Serializable {


    /**
     * 响应码
     */
    private int state;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应时间
     */
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time = new Date();

    public Response() {

    }

    public static Response result(boolean flag) {
        if (flag) {
            return ok();
        }
        return fail();
    }

    public static Response result(ApiCode apiCode) {
        return result(apiCode, null);
    }

    public static Response result(ApiCode apiCode, Object data) {
        return result(apiCode, null, data);
    }

    public static Response result(ApiCode apiCode, String msg, Object data) {
        boolean success = false;
        if (apiCode.getCode() == ApiCode.SUCCESS.getCode()) {
            success = true;
        }
        String message = apiCode.getMsg();
        //自改
        if (msg != null && !msg.trim().equals("")) {
            message = msg;
        }
//        if (StringUtils.isNotBlank(msg)) {
//            message = msg;
//        }
        return Response.builder()
                .state(apiCode.getCode())
                .msg(message)
                .data(data)
                .success(success)
                .time(new Date())
                .build();
    }

    public static Response ok() {
        return ok(null);
    }

    public static Response ok(Object data) {
        return result(ApiCode.SUCCESS, data);
    }

    public static Response ok(Object data, String msg) {
        return result(ApiCode.SUCCESS, msg, data);
    }

    public static Response okMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return ok(map);
    }

    public static Response fail(ApiCode apiCode) {
        return result(apiCode, null);
    }

    public static Response fail(String msg) {
        return result(ApiCode.FAIL, msg, null);

    }

    public static Response fail(ApiCode apiCode, Object data) {
        if (ApiCode.SUCCESS == apiCode) {
            throw new RuntimeException("失败结果状态码不能为" + ApiCode.SUCCESS.getCode());
        }
        return result(apiCode, data);

    }

    public static Response fail(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return result(ApiCode.FAIL, map);
    }

    public static Response fail() {
        return fail(ApiCode.FAIL);
    }
}