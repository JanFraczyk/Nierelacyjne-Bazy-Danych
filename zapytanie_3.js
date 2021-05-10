//Zad. 1.:
db.people.findOne()
//Zad. 2.:
db.people.findOne({"sex": "Female", "nationality": "China"})
//Zad. 3.:
db.people.find({"sex": "Male", "nationality": "Germany"})
//Zad. 4.:
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
db.people.find({$and: [{"weight": {$gte: 68}}, {"weight": {$lt: 71.5}}]})
//Zad. 5.:
db.people.find({"birth_date" : {$gte: "2000-01-01T00:00:00Z"}}, {"_id": 0, "first_name": 1, "last_name": 1, "location": "$location.city"})
//Zad. 6.
db.people.insert({"sex": "Male", "first_name": "Jan", "last_name": "Fraczyk", "job": "Logistic assistant", 
	"email": "janfraczyk97@gmail.com", "location.city": "Warsaw", "location.address.streetname": "Stoklosy", 
	"location.address.streetnumber": "7", 
	"description": "ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar", 
	"height": "179.00", "weight": 75.00, "birth_date": "1997-01-28T14:25:36Z", "nationality": "Poland", "credit.type": "abc", 
	"credit.number": "12345678910112", "currency": "PLN", "balance": "2950.56"})
//Sprawdzenie
db.people.find({first_name: "Jan"})
//Zad. 7.
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
//Zad. 8.
db.people.update({"location.city": "Moscow"}, {$set: {"location.city": "Moskwa"}}, {multi: true})
//Zad. 9.
db.people.update({"first_name": "Antonio"}, {$set: {"hobby": "pingpong"}}, {upsert: true, multi: true})
//Zad. 10.
db.people.update({"job": "Editor"}, {$unset: {"email": 1}}, {multi:  true})

printjson(db.people.find())