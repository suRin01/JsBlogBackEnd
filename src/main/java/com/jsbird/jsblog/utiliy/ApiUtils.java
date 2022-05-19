package com.jsbird.jsblog.utiliy;

import com.jsbird.jsblog.model.response.ApiError;
import com.jsbird.jsblog.model.response.Response;

public class ApiUtils {
    public static <T>Response<T> success(T response){
        return new Response<>(Boolean.TRUE, response, null);
    }

    public static Response<String> success(){
        return new Response<>(Boolean.TRUE, "", null);
    }
    public static Response<?> error(String message, Integer status){
        return new Response<>(Boolean.FALSE, null, new ApiError(message, status));
    }
}
