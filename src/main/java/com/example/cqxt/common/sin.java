package com.example.cqxt.common;

import lombok.Data;

@Data
public class sin {
    private int Code;
    private String Message;
    private Object Data;
    private boolean Success;
    private String Type;

    public static sin success(String message){
        sin s = new sin();
        s.setCode(200);
        s.setMessage(message);
        s.setType("success");
        s.setSuccess(true);
        s.setData(null);
        return s;
    }

    public static sin error(String message){
        sin s = success(message);
        s.setType("error");
        s.setSuccess(false);
        return s;
    }

    public static sin success(String message, Object data){
        sin s = success(message);
        s.setData(data);
        return s;
    }

    public static sin warning(String message){
        sin s = error(message);
        s.setType("warning");
        return s;
    }

    public static sin fatal(String message){
        sin s = error(message);
        s.setType("fatal");
        s.setCode(500);
        return s;
    }
}
