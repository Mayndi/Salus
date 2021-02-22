package com.platform.salus.registryUser.address.converter.output;

import com.platform.salus.common.utils.CommonFields;

public class AddressCountOutput extends CommonFields {

    private Long count;

    public Long getCount() {
        return count;
    }

    public AddressCountOutput setCount(Long count) {
        this.count = count;
        return this;
    }
}
