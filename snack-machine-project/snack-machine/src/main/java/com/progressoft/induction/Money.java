package com.progressoft.induction;

import java.math.BigDecimal;
import java.util.Objects;

public class Money implements Comparable<Money> {

    private BigDecimal amount;


    final public static Money ZERO = new Money(BigDecimal.valueOf(0));
    final public static Money QUARTER_DINAR =new Money( BigDecimal.valueOf(0.25));
    final public static Money HALF_DINAR =new Money(BigDecimal.valueOf(0.5));
    final public static Money DINAR = new Money(BigDecimal.valueOf(1));
    final public static Money FIVEJODS = new Money(BigDecimal.valueOf(5));
    final public static Money TENJODS = new Money(BigDecimal.valueOf(10));


    public Money(BigDecimal amount) {


        setAmount(amount);

    }


    public void setAmount(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }

        this.amount = amount.stripTrailingZeros();
    }

    public Money() {

        this.amount =BigDecimal.valueOf(0);
    }


    public Money add(Money otherMoney) {


        return add(otherMoney.getAmount());

    }


    public Money add(BigDecimal otherAmount) {


        if (checkOtherMoneyIsNull(otherAmount))
            throw (new IllegalArgumentException());

        if (otherAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw (new IllegalArgumentException());
        }

        setAmount(this.getAmount().add(otherAmount));
        return this;


    }

    public Money subtract(Money otherMoney) {

        return subtract(otherMoney.getAmount());

    }


    public Money subtract(BigDecimal otherAmount) {

        if (checkOtherMoneyIsNull(otherAmount))
            throw (new IllegalArgumentException());


        if (this.getAmount().compareTo(otherAmount) < 0) {
            throw (new IllegalArgumentException("you can not subtract"));
        }


        setAmount(this.getAmount().subtract(otherAmount));
        return this;

    }


    private boolean checkOtherMoneyIsNull(Object otherMoney) {
        if (otherMoney == null)
            return true;

        return false;
    }


    public boolean isLessThan(Money otherMoney) {

        if (checkOtherMoneyIsNull(otherMoney))
            return false;

        if (this.getAmount().compareTo(otherMoney.getAmount()) < 0)
            return true;


        return false;

    }

    public boolean isGreaterThanOrEqual(Money otherMoney) {

        if (checkOtherMoneyIsNull(otherMoney))
            return false;

        if (this.getAmount().compareTo(otherMoney.getAmount()) >= 0)
            return true;


        return false;

    }


    public boolean isGreaterThanOrEqual(BigDecimal otherAmount) {

        return isGreaterThanOrEqual(new Money(otherAmount));

    }


    public boolean isLessThanOrEqual(Money otherMoney) {

        if (checkOtherMoneyIsNull(otherMoney))
            return false;

        if (this.getAmount().compareTo(otherMoney.getAmount()) <= 0)
            return true;


        return false;

    }


    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }


    public boolean isEmpty() {
        return getAmount().compareTo(BigDecimal.valueOf(0d)) == 0d;
    }

    @Override
    public int compareTo(Money o) {
        if(this.getAmount().compareTo(o.getAmount())<0)
            return -1;

        if(this.getAmount().compareTo(o.getAmount())>0)
            return 1;

        return 0;
    }





}


