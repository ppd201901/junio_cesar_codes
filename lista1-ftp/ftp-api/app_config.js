var express = require('express');

var app = module.exports = express();

var bodyParser = require('body-parser');

var allowCors = function(req,res,next) {
    res.header('Access-Control-Allow-Origin','*');
    res.header('Access-Control-Allow-Methods','GET,POST,PUT,DELETE');
    res.header('Access-Control-Allow-Headers','Content-Type');
    res.header('Access-Control-Allow-Credentials','true');
    res.header('Content-Type','application/json');
    next();

};

app.use(allowCors);

app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.urlencoded({limit: '50mb'}));
app.use(bodyParser.json({limit: '50mb'}));
app.listen(54321);