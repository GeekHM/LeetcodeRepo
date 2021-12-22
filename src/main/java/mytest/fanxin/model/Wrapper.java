package mytest.fanxin.model;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-20 15:49
 * @version：
 **/

import java.io.Serializable;
import java.util.List;

/**
 * 统一返回数据模型
 */
public class Wrapper<T> implements Serializable {
    private static final long serialVersionUID = 3184376297284610305L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应时间戳
     */
    private Long time;

    public Wrapper() {
    }

    public static <T> Wrapper<T> success() {
        ResponseCode responseCode = ResponseCode.SUCCESS;
        return new Wrapper<>(responseCode.getCode(), responseCode.getMessage(), null, System.currentTimeMillis());
    }

    public static <T> Wrapper<T> success(T data) {
        ResponseCode responseCode = ResponseCode.SUCCESS;
        return new Wrapper<>(responseCode.getCode(), responseCode.getMessage(), data, System.currentTimeMillis());
    }

    public static <K> Wrapper<PageData<K>> success(List<K> data, Long totalCount) {
        ResponseCode responseCode = ResponseCode.SUCCESS;
        PageData<K> pageData = new PageData<>(totalCount, data);
        return new Wrapper<>(responseCode.getCode(), responseCode.getMessage(), pageData, System.currentTimeMillis());
    }

    public static <T> Wrapper<T> fail(ResponseCode responseCode) {
        return new Wrapper<>(responseCode.getCode(), responseCode.getMessage(), null, System.currentTimeMillis());
    }

    public static <T> Wrapper<T> failService(String errorMessage) {
        return new Wrapper<>(ResponseCode.SERVICE_ERROR.getCode(), errorMessage, null, System.currentTimeMillis());
    }

    public static <T> Wrapper<T> fail(String errorMessage) {
        return new Wrapper<>(ResponseCode.BUSINESS_ERROR.getCode(), errorMessage, null, System.currentTimeMillis());
    }

    public static <T> Wrapper<T> fail(int responseCode, String errorMessage) {
        return new Wrapper<>(responseCode, errorMessage, null, System.currentTimeMillis());
    }

    public static <T> Wrapper<T> fail(int responseCode) {
        return new Wrapper<>(responseCode, null, null, System.currentTimeMillis());
    }

    public static <T> Wrapper<T> fail(Wrapper<?> wrapper) {
        return new Wrapper<>(wrapper.getCode(), wrapper.getMessage(), null, System.currentTimeMillis());
    }

    public static <T> Wrapper<T> fail(ResponseCode responseCode, String errorMessage) {
        return new Wrapper<>(responseCode.getCode(), errorMessage, null, System.currentTimeMillis());
    }

    public static <T> Wrapper<T> fail(ResponseCode responseCode, T data) {
        return new Wrapper<>(responseCode.getCode(), responseCode.getMessage(), data, System.currentTimeMillis());
    }

    private Wrapper(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Wrapper(int code, String message, T data, Long time) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
