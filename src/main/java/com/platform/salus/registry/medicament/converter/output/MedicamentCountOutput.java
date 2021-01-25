package com.platform.salus.registry.medicament.converter.output;

import com.platform.salus.common.utils.CommonFields;

public class MedicamentCountOutput extends CommonFields {

    private Long count;

    public Long getCount() {
        return count;
    }

    public MedicamentCountOutput setCount(Long count) {
        this.count = count;
        return this;
    }
}
