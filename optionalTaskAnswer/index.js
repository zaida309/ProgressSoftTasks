
function definePrices(){
  document.getElementById("item1price").innerHTML=10;
  document.getElementById("item2price").innerHTML=10;
  document.getElementById("item3price").innerHTML=10;

}

definePrices();



function Transaction(){
let amount=0;

this.add=function(otherAmount){
 if(typeof otherAmount!='number' && otherAmount>0) 
 throw new Error("amount error");
amount+=otherAmount;
}

this.sub=function(otherAmount){
  if(typeof otherAmount!='number'  && otherAmount>0 ) 
  throw new Error("amount error");
 amount-=otherAmount;
}

Object.defineProperty(this, 'getAmount', {
  get: function() {
      return amount;
  }       
});         



};



const transaction=new Transaction();
let selectitem=0;

document.getElementById('QUARTER_DINAR').addEventListener('click',function(){
transaction.add(0.25);
document.getElementById('Moneyintransaction').innerHTML=transaction.getAmount;
});
document.getElementById('HALF_DINAR',).addEventListener('click',function(){
  transaction.add(0.50);
  document.getElementById('Moneyintransaction').innerHTML=transaction.getAmount;

});
document.getElementById('DINAR',).addEventListener('click',function(){
  transaction.add(1.00);
  document.getElementById('Moneyintransaction').innerHTML=transaction.getAmount;

});
document.getElementById('FIVEJODS',).addEventListener('click',function(){
  transaction.add(5.00);
  document.getElementById('Moneyintransaction').innerHTML=transaction.getAmount;

});
document.getElementById('TENJODS',).addEventListener('click',function(){
  transaction.add(10.00);
  document.getElementById('Moneyintransaction').innerHTML=transaction.getAmount;

});

document.getElementById('item1css').addEventListener('click',function(){
  
  if(selectitem==0){
    selectitem= parseFloat(document.getElementById("item1price").innerHTML);

    this.style.boxShadow = "4px 4px 4px black";
    let that = this;
    // setTimeout(function(){
    //   that.style.boxShadow = "";
  
    // }, 250); //1 second delay
  
  
  }else{
    alert("you can not select more than one item , the page will be reloaded after 1 second")
    setTimeout(function(){
      document.location.reload();  
    }, 1000); 
  
  }
  

})
document.getElementById('item2css').addEventListener('click',function(){
  
  if(selectitem==0){
    selectitem=  parseFloat(document.getElementById("item2price").innerHTML);
    this.style.boxShadow = "4px 4px 4px black";
    let that = this;
    // setTimeout(function(){
    //   that.style.boxShadow = "";
  
    // }, 250); 
  
  
  }else{
    alert("you can not select more than one item , the page will be reloaded after 1 second")
    setTimeout(function(){
      document.location.reload();  
    }, 1000); 
  
  }
  
})
document.getElementById('item3css').addEventListener('click',function(){
  
  if(selectitem==0){
    selectitem= parseFloat(document.getElementById("item3price").innerHTML);

    this.style.boxShadow = "4px 4px 4px black";
    let that = this;
    // setTimeout(function(){
    //   that.style.boxShadow = "";
  
    // }, 250); 
  
  
  }else{
    alert("you can not select more than one item , the page will be reloaded after 1 second")
    setTimeout(function(){
      document.location.reload();  
    }, 1000); 
  
  }
  
  

})



document.getElementById('buycss').addEventListener('click',function(){
  if(selectitem==0){
    alert("you shoudl select first an item")
    throw new Error("you should select first")
    
  }
  if(transaction.getAmount>=selectitem){

    transaction.sub(selectitem);
    document.getElementById('Moneyintransaction').innerHTML=transaction.getAmount;
    document.getElementById('Change').innerHTML=transaction.getAmount;
    document.getElementById('MoneyinsideMachine').innerHTML=selectitem;

  }else{

    setTimeout(function(){
      document.location.reload();  
    }, 1000); 
  
      alert("amount problem , the page will be relodede within one second")
  }
})



