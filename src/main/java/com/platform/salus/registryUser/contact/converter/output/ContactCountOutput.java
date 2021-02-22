package com.platform.salus.registryUser.contact.converter.output;

import com.platform.salus.common.utils.CommonFields;

public class ContactCountOutput extends CommonFields {

    private Long count;

    public Long getCount() {
        return count;
    }

    public ContactCountOutput setCount(Long count) {
        this.count = count;
        return this;
    }
}
