package com.dansmulticorp.controllers.payload.response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class ResourcePayload<T> {
    private int responseCode;
    private int elementNumber;
    private String resposeMessage;
    private T data;
}
