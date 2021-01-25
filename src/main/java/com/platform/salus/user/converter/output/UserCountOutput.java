package com.platform.salus.user.converter.output;

public class UserCountOutput extends UserOutputCommonFields{

    private Long count;

    public Long getCount() {
        return count;
    }

    public UserCountOutput setCount(Long count) {
        this.count = count;
        return this;
    }
}
