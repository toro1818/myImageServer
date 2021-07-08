package com.example.imageServer.util;

public enum ApiCode {

    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 非法访问
     */
    UNAUTHORIZED(401, "非法访问"),

    /**
     * 没有权限
     */
    NOT_PERMISSION(403, "没有权限"),

    /**
     * 资源不存在
     */
    NOT_FOUND(404, "你请求的资源不存在"),

    /**
     * 操作失败
     */
    FAIL(500, "操作失败"),


    /**
     * 登录失败
     */
    LOGIN_EXCEPTION(4000, "登陆失败"),


    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(5000, "系统异常!"),

    /**
     * 请求参数校验异常
     */
    PARAMETER_EXCEPTION(5001, "请求参数校验异常"),

    /**
     * 请求参数解析异常
     */
    PARAMETER_PARSE_EXCEPTION(5002, "请求参数解析异常"),

    /**
     * HTTP Media 类型异常
     */
    HTTP_MEDIA_TYPE_EXCEPTION(5003, "HTTP Media 类型异常"),

    /**
     * 系统处理异常
     */
    SPRING_BOOT_PLUS_EXCEPTION(5100, "系统处理异常"),

    /**
     * 业务处理异常
     */
    BUSINESS_EXCEPTION(5101, "业务处理异常"),

    /**
     * 数据库处理异常
     */
    DAO_EXCEPTION(5102, "数据库处理异常"),

    /**
     * 验证码校验异常
     */
    VERIFICATION_CODE_EXCEPTION(5103, "验证码校验异常"),

    /**
     * 登陆授权异常
     */
    AUTHENTICATION_EXCEPTION(5104, "登陆授权异常"),

    /**
     * 没有访问权限
     */
    UNAUTHENTICATED_EXCEPTION(5105, "没有访问权限"),

    /**
     * 没有访问权限
     */
    UNAUTHORIZED_EXCEPTION(5106, "没有访问权限"),


    ;

    private final int code;
    private final String msg;

    ApiCode(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiCode getApiCode(int code) {
        ApiCode[] ecs = ApiCode.values();
        for (ApiCode ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}