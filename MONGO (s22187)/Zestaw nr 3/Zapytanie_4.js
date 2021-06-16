//Konwersja "weight" ze string na Decimal
db.people.find().forEach(function(data) {
    db.people.update({
        "_id": data._id,
        "weight": data.weight
    }, {
        "$set": {
            "weight": parseFloat(data.weight)
        }
    });
})
//Wywołanie zapytania
printjson(db.people.find({"weight" : {$gte: 68, $lt: 71.5}}))