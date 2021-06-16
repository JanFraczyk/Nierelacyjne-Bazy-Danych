
db.people.mapReduce(
  function () { emit( this.job, {workerQty:1}); },
  function (key, values) {
    var x = {workerQty: 0};

    values.forEach(function (value) {
      x.workerQty += value.workerQty;
    });

    return x;
  }, {
    out: "unique_jobs"
  }
);
  
db.unique_jobs.find({})