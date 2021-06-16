db.people.update({"first_name": "Antonio"}, {$set: {"hobby": "pingpong"}}, {upsert: true, multi: true})
