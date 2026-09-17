package com.areeb.foodDeliveryApp.Response;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response <T>{
    private int statusCode;
    private String message;
    private T data;
    private Map<String, Serializable> meta;
}
