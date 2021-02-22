package com.platform.salus.registryUser.user.converter.output;

import com.platform.salus.common.utils.CommonFields;

public class UserCountOutput extends CommonFields {

    private Long count;

    public Long getCount() {
        return count;
    }

    public UserCountOutput setCount(Long count) {
        this.count = count;
        return this;
    }
}
