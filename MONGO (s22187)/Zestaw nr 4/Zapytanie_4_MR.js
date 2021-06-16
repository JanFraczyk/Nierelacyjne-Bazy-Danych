db.people.mapReduce(
function () {
    var bmi = Math.round((+this.weight * 1000000 / (Math.pow(this.height,2))) ) / 100
    
    emit(this.nationality, { qty: 1, minBMI: bmi, maxBMI: bmi, avgBMI: bmi });
}
, 
function (nationality, objVals) {
    x = { qty: 0, minBMI: 0, maxBMI: 0, avgBMI: 0 }
    for (var idx = 0; idx < objVals.length; idx++) {
        x.qty += objVals[idx].qty;
         if (x.minBMI == 0) {
            x.minBMI = objVals[idx].minBMI
        }
        x.minBMI = Math.min(x.minBMI, objVals[idx].minBMI);
        x.maxBMI = Math.max(x.maxBMI, objVals[idx].maxBMI);
        x.avgBMI += objVals[idx].avgBMI;       
    }
    
    x.avgBMI = Math.round((x.avgBMI / x.qty) * 100) / 100;
    
    return x;
}
, 
{ out: "BMI_MR"})
db.BMI_MR.find({})