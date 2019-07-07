'use strict'
var pg = require('pg');

var cn = {
    database: 'doutorado',
    port: 5432,
    host: 'localhost',
    user: 'doutorado',
    password: 'ppd-2019'
};

var erro = {
    erro: 'Ocorreu uma inconsistência na base de dados'
}

const pool = new pg.Pool(cn);
exports.list = function(res, sql, callback){
    pool.connect(function(err,client,done) {
        if(err){
            console.log("Não foi possível conectar ao banco: "+ err);
            callback(err);
            return;
        } 
        client.query(sql, function(err,result) {
            done(); // closing the connection;
            if(err){
                console.log(err);
                
                callback(err);
                return;
            }

            callback(result.rows);
        });
        
    });
};

exports.listId = function(sql, campos, callback){
    pool.connect(function(err,client,done) {
        if(err){
            console.log("Não foi possível conectar ao banco: "+ err);
            callback(err);
            return;
        } 
        client.query(sql, campos, function(err,result) {
            done(); // closing the connection;
            if(err){
                console.log(err);
                callback(err);
                return;
            }
            
            callback(result.rows);
        });
        
    });
   
};

exports.save = function(sql, campos, callback){

    pool.connect(function(err,client,done) {
        if(err){
            console.log("Não foi possível conectar ao banco: "+ err);
           callback(err);
           return;
        } 
        client.query(sql, 
                campos,function(err,result) {
            done(); // closing the connection;
            if(err){
                console.log(err);
                callback(err);
                return;
            }

            callback(result.rows);
        });
     });
    
};

exports.update = function(sql, campos,callback){
      pool.connect(function(err,client,done) {
        if(err){
            console.log("Não foi possível conectar ao banco: "+ err);
            callback(err);
            return;
        } 
        client.query(sql, 
               campos,function(err,result) {
            done(); // closing the connection;
            if(err){
                console.log(err);
                callback(err);
                return;
            }

            callback(result.rows);

        });
     });
};

exports.delete = function(sql, campos, callback) {
    pool.connect(function(err,client,done) {
        if(err){
            console.log("Não foi possível conectar ao banco: "+ err);
            callback(err);
            return;
        } 
        client.query(sql, campos, function(err,result) {
            done(); // closing the connection;
            if(err){
                console.log(err);
                callback(err);
                return;
            }
            callback({'msg': 'Dados excluídos com sucesso'});
        });
    });
};