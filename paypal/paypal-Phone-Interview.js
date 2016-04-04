//Date: 3/30/16 Paypal Phone interview
// 
// Questti
json 
API: 

route :

GET: 
POST:

Post:  /127.0.0.1:9443/reviews/
 {
     reviewer: "hua zhang"
     date: " 2016-03-30"
     message: {
     
     } 
     comment: {
     }
     level: "monthly plan"
     registerDate: "2015-12-06"
 
 }
 
 ## comments
 Async, series
 
 // Promise , Q
 
 List: /127.0.0.1:9443/reviews/:reviewId/comments
 
 
 List : /127.0.0.1:9443/reviews/
 offset
 
 reviewId  ORM 
 GET /127.0.0.1:9443/reviews/:reviewId
 
 
//  read a file 

var myCallback = function(data) {
    console.log('got data: ' + data);
};
 
var usingIt = function(callback) {
    callback('print it');
};

usingIt(myCallback);

 
 closure
 1. read a file
 2. console.log("print something...")
 
 
 
 function readFile(filename, output, callback) {
    async.waterfall([
        myCallback, usingIt], callback);
 }
 
 readFile(input, output, function(err) {
     if(!err) console.log('All is ok!");
 })
 
 // Promise 
 function readFile(input, output) {
     return fs.readFileAysnc( input, 'utf8')
         .then(server.printItAsync)
         .then(fs.writeFileAsync);
 
 }
 
// readFile Async

readFile(inputFile, output).done(function() {
....
});
 
 
 I can't hear you.. sorry
 
 
 
 
 
 