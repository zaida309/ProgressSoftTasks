package com.progressoft.induction;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SnackMachine {


     public static final int  DEFAULT_QUANTITY = 1;
     private Money inboxMoney;
     private Money transactionMoney;
     List<Snack> snackList;
     SnackType selectedSnack;

    public SnackMachine() {
        inboxMoney =new Money(BigDecimal.valueOf(0));
        transactionMoney=new Money();
        snackList=new ArrayList<>();
        SnackType[] snakcsChoices=SnackType.values();
        selectedSnack=null;
        for( SnackType snackChoice : snakcsChoices){
            snackList.add(new Snack(snackChoice,DEFAULT_QUANTITY));
        }

    }

    public Money moneyInside(){
        return inboxMoney;
    }


    public void insertMoney(BigDecimal otherAmount){

        if(checkIfNull(otherAmount)){
            throw (new IllegalArgumentException());
        }


        transactionMoney.add(otherAmount);
    }


  public SnackMachine  chewingGums(){

      this.selectedSnack=SnackType.CHEWING_GUM;
      return this;

  }

  public SnackMachine chocolates(){
      this.selectedSnack=SnackType.CHOCOLATE;
      return this;

  }


  public SnackMachine chips(){

    this.selectedSnack=SnackType.CHIPS;
    return this;
  }

  public int quantity(){

        if(checkIfNull(selectedSnack))
            throw (new IllegalStateException());

         return snackList.get(selectedSnack.ordinal()).getQuantity();
  }


  public Money  buySnack(SnackType snackType){
        if(transactionMoney.isEmpty())
            throw new IllegalStateException();

        if(snackList.get(snackType.ordinal()).getQuantity()==0)
            throw new IllegalStateException("the quantity is empty of  "+snackType);

        if(transactionMoney.isGreaterThanOrEqual(snackType.getValue())){
            transactionMoney.subtract(snackType.getValue());
            inboxMoney.add(snackType.getValue());
            snackList.get(snackType.ordinal()).reduceQuantity();
            return transactionMoney;
        }

        throw (new IllegalStateException("the price is more than tranaction money "));


  }


    public void insertMoney(Money otherMoney){

        if(checkIfNull(otherMoney)){
            throw (new IllegalArgumentException());
        }


        AllowedMoney allowedMoney=new AllowedMoney();
        if(allowedMoney.isAllowed(otherMoney)){
            transactionMoney.add(otherMoney);
            return;
        }

        throw (new IllegalArgumentException());
    }

    public boolean checkIfNull(Object item){

        if(item==null){
            return true;
        }

        return false;

    }



    public Money moneyInTransaction(){
        return transactionMoney;
    }




    static private  class AllowedMoney{

        final BigDecimal[] allowedMoneyList={
                Money.DINAR.getAmount(),Money.QUARTER_DINAR.getAmount(),Money.HALF_DINAR.getAmount(),
                Money.FIVEJODS.getAmount(),Money.FIVEJODS.getAmount() , Money.TENJODS.getAmount()};


      public boolean isAllowed(BigDecimal otherAmount){


            if(checkIfNull(otherAmount)){
                return false;
            }

            boolean flag=false;
            for(BigDecimal value:allowedMoneyList){
                if(value.compareTo(otherAmount)==0) {
                    flag=true;
                }
            }

            return flag;
        }


        public boolean isAllowed(Money otherMoney){

          return isAllowed(otherMoney.getAmount());
        }



        public boolean checkIfNull(Object item){

            if(item==null){
                return true;
            }

            return false;

        }


    }



}
