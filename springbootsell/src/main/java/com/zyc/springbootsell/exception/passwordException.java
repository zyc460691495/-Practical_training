package com.zyc.springbootsell.exception;

import com.zyc.springbootsell.enums.ResultEnum;

public class passwordException extends Exception {

    private Integer code;

    public passwordException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public passwordException(String message, Integer code) {
        super(message);
        this.code = code;
    }

}
