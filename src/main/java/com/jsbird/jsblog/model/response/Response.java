package com.jsbird.jsblog.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response<T>{
    private final Boolean statusCode;
    private final T body;
    private final ApiError apiError;
}
