package com.progressoft.induction;

import java.math.BigDecimal;

public enum SnackType {


    CHEWING_GUM(BigDecimal.valueOf(0.5)),CHIPS(BigDecimal.valueOf(1)),CHOCOLATE(BigDecimal.valueOf(2));

    private  final  BigDecimal VALUE;

    SnackType(BigDecimal otherValue) {

        this.VALUE = otherValue;

    }

    public BigDecimal getValue() {
        return VALUE;
    }


}
