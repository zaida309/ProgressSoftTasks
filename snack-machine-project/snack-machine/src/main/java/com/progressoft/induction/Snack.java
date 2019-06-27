package com.progressoft.induction;

public class Snack {
  private final  SnackType snackType;
  private   int quantity;

    public Snack(SnackType snackType, int quantity) {

        if(quantity==0 || snackType==null){
            throw (new IllegalArgumentException());
        }
        this.snackType = snackType;
        this.quantity= quantity;
    }

    public SnackType getSnackType() {
        return snackType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(){
        quantity--;
    }




}
