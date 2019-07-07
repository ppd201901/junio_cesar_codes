var fs = require('fs');

var app = require('./app_config.js');

//var controller = require('./controller/db-pg.js');
//var validator = require('validator');
var srvFtp = require('./servico/srv-ftp.js');

app.get('/', function(req,res){
  
    res.end('Servidor ON'); 

})

//F T P
//-----
app.post('/ftp', function(req,res) {
    srvFtp.post(req,res);
});
app.get('/ftp', function(req,res) {
    srvFtp.get(req,res);
});
app.get('/ftp/:id', function(req,res) {
    srvFtp.getId(req,res);
});
app.delete('/ftp/:id', function(req,res) {
    srvFtp.delete(req,res);
});
app.put('/ftp', function(req,res) {
    srvFtp.put(req,res);
});