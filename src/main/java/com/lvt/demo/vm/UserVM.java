package com.lvt.demo.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lvt.demo.bean.Age;
import com.lvt.demo.bean.DateValid;
import com.lvt.demo.exception.ErrorCode;

import javax.validation.constraints.NotNull;

public class UserVM {

    @NotNull(message = ErrorCode.BIRTH_DAY_NOT_VALID)
    @JsonProperty("birth_day")
    protected String birthDay;

    @NotNull(message = ErrorCode.NAME_NOT_VALID)
    @JsonProperty("name")
    protected String name;

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserVM(@NotNull(message = ErrorCode.BIRTH_DAY_NOT_VALID) String birthDay, @NotNull(message = ErrorCode.NAME_NOT_VALID) String name) {
        this.birthDay = birthDay;
        this.name = name;
    }

    public UserVM() {
    }
}
