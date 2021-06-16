//Konwersja height na dane numeryczne
db.people.find().forEach(function(data) {
    db.people.update({
        "_id": data._id,
        "height": data.height
    }, {
        "$set": {
            "height": parseFloat(data.height)
        }
    });
})
//Wywołanie zapytania
db.people.remove({"height": {$gt: 190}})