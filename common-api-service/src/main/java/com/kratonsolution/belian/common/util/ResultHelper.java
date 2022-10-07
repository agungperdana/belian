package com.kratonsolution.belian.common.util;

import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.1
 * @version 2.0.1
 */
public class ResultHelper {

    public static final String SUCCESS = "success";
    public static final String MESSAGE = "message";

    private Map<String, Object> map = new HashMap<>();

    ResultHelper(){}

    public static ResultHelper success() {

        ResultHelper helper = new ResultHelper();
        helper.map.put(SUCCESS, Boolean.TRUE);

        return helper;
    }

    public static ResultHelper failed() {

        ResultHelper helper = new ResultHelper();
        helper.map.put(SUCCESS, Boolean.FALSE);

        return helper;
    }

    public static ResultHelper failed(@NonNull String message) {

        ResultHelper helper = new ResultHelper();
        helper.map.put(SUCCESS, Boolean.FALSE);
        helper.map.put(MESSAGE, message);

        return helper;
    }

    public ResultHelper put(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public Mono<Map<String, Object>> mono() {
        return Mono.just(map);
    }

    public Map<String, Object> map() {
        return map;
    }
}
