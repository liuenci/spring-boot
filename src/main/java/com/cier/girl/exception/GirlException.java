package com.cier.girl.exception;

import com.cier.girl.enums.ResultEnum;

public class GirlException extends RuntimeException{
    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.MIDDLE_SCHOOL.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
