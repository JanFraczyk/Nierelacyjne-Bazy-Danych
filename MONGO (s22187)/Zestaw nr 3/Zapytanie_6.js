db.people.insert({"sex": "Male", "first_name": "Jan", "last_name": "Fraczyk", "job": "Logistic assistant", 
	"email": "janfraczyk97@gmail.com", "location": {"city": "Warsaw", "address": {".streetname": "Stoklosy", 
	"streetnumber": "7"}}, 
	"description": "ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar", 
	"height": "179.00", "weight": 75.00, "birth_date": "1997-01-28T14:25:36Z", "nationality": "Poland", "credit": {"type": "abc", 
	"number": "12345678910112", "currency": "PLN", "balance": "2950.56"}})
//Sprawdzenie
printjson(db.people.find({first_name: "Jan"}).toArray())