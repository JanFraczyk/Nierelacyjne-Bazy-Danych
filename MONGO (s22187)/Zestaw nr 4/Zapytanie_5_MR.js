db.people.mapReduce(
function () {
    for (i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, { qty: 1, balance: +this.credit[i].balance });
    }
}, 
function (key, objVals) {
    x = { qty: 0, balance: 0 };
    
    for (i = 0; i < objVals.length; i++) {
        x.qty += objVals[i].qty;
        x.balance += objVals[i].balance;
    }
    
    x.balance = Math.round(x.balance * 100) / 100;
    x.avarage = Math.round((x.balance / x.qty) * 100) / 100;
    
    return x
}, 
{ query: { sex: "Female", nationality: "Poland" }, 
out: "polfemcurr_credit_MR" })

db.polfemcurr_credit_MR.find({})