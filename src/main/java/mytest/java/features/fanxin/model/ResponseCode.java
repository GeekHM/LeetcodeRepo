package mytest.java.features.fanxin.model;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-20 15:50
 * @version：
 **/

import java.util.Arrays;

/**
 * 统一返回编码枚举
 */
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(1000, "操作成功"),
    /**
     * 服务内部错误（未处理的异常默认返回）
     */
    SERVICE_ERROR(9998, "业务异常"),
    /**
     * 服务内部错误（未处理的异常默认返回）
     */
    BUSINESS_ERROR(9999, "服务内部错误");


    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResponseCode getByCode(int code) {
        return Arrays.stream(ResponseCode.values()).filter(r -> r.getCode() == code).findFirst().orElse(null);
    }
}

