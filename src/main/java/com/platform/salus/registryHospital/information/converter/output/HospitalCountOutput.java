package com.platform.salus.registryHospital.information.converter.output;

import com.platform.salus.common.utils.CommonFields;

public class HospitalCountOutput extends CommonFields {

    private Long count;

    public Long getCount() {
        return count;
    }

    public HospitalCountOutput setCount(Long count) {
        this.count = count;
        return this;
    }
}
