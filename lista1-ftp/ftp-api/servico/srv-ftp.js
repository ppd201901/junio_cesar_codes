var controller = require('../controller/db-pg.js');

//F T P
//-----
exports.post = function(req,res){
    
    
    var nome = req.param('nome_arquivo');
    var mimetype = req.param('mimetype');
    var arquivo = req.param('arquivo');
    var data = req.param('data')
    var tamanho = req.param('tamanho')

    var sql = 'INSERT INTO ppd.ftp (nome_arquivo, mimetype, arquivo, data, tamanho) VALUES($1, $2, $3, $4, $5) RETURNING *'
    var campos = [
        nome,
        mimetype,
        arquivo,
        data,
        tamanho
    ]
    
    controller.save(sql, campos, function(resp){
        res.json(resp);

   });
};

exports.get = function(req,res){
    var sql = "SELECT id, nome_arquivo, mimetype, data, tamanho " +
        " FROM ppd.ftp order by nome_arquivo"

    controller.list(res, sql, function(resp){
        res.json(resp);
   });
 };

exports.getId = function(req,res){
    
    var id = req.param('id');
    
    var sql = "SELECT * " +
    " FROM ppd.ftp WHERE ID = $1 "
    controller.listId(sql, [id], function(resp){
        res.json(resp);
    });
 };
 
 exports.delete = function(req,res){
    
    var id = req.param('id');
    var sql = 'DELETE FROM ppd.ftp where id = $1'
    controller.delete(sql, [id], function(resp){
        res.json(resp);
    });
};    

exports.put = function(req,res){
    var nome = req.param('nome_arquivo');
    var mimetype = req.param('mimetype');
    var arquivo = req.param('arquivo');
    var data = req.param('data')
    var tamanho = req.param('tamanho')
    var id = req.param('id');
    var sql = 'UPDATE ppd.ftp SET nome_arquivo = $1, mimetype = $2, arquivo = $3, data = $4, tamanho = $5 WHERE id = $6 RETURNING *'
    var campos = [
        nome,
        mimetype,
        arquivo,
        data, 
        tamanho,
        id
    ]
    
    controller.update(sql, campos, function(resp){
       res.json(resp);
   });
};
