package com.platform.salus.registryUser.medic.converter.output;

import com.platform.salus.common.utils.CommonFields;

public class MedicCountOutput extends CommonFields {

    private Long count;

    public Long getCount() {
        return count;
    }

    public MedicCountOutput setCount(Long count) {
        this.count = count;
        return this;
    }
}
