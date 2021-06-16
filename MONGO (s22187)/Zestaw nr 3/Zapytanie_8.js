db.people.update({"location": {"city": "Moskwa"}}, {$set: {"location.city":  "Moscow"}}, {multi: true})
