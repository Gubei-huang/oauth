package com.hwj.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回类（封装json数据）
 *
 * @author Huang
 */
@Data
public class JsonUtils {
    // 状态码 200-成功 400-失败
    private int code;
    // 提示信息
    private String msg;

    // 用户要返回给浏览器的数据
    private Map<String, Object> data = new HashMap();
    /**
     * 处理成功
     *
     * @return
     */
    public static JsonUtils success() {
        JsonUtils result = new JsonUtils();
        result.setCode(200);
        result.setMsg("处理成功！");
        return result;
    }

    /**
     * 处理失败
     *
     * @return
     */
    public static JsonUtils fail() {
        JsonUtils result = new JsonUtils();
        result.setCode(400);
        result.setMsg("处理失败！");
        return result;
    }

    public static JsonUtils failPs() {
        JsonUtils result = new JsonUtils();
        result.setCode(300);
        result.setMsg("处理失败！");
        return result;
    }
    public static JsonUtils failEx() {
        JsonUtils result = new JsonUtils();
        result.setCode(400);
        result.setMsg("处理失败！");
        return result;
    }
    public static JsonUtils failNu() {
        JsonUtils result = new JsonUtils();
        result.setCode(500);
        result.setMsg("处理失败！");
        return result;
    }

    /**
     * 添加要返回的json数据
     *
     * @param key
     * @param value
     * @return
     */
    public JsonUtils add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }
    public JsonUtils msg(String msg){
        this.setMsg(msg);
        return this;
    }
}
