//express
const express = require('express');

//model
const usuario = require('../model/Usuario');

//rotas
const router = express.Router();

router.post('/usuario/cadastrarUsuario', (req, res)=>{

    const {nome, sobrenome, email, senha, celular} = req.body;

    usuario.create({
        nome, 
        sobrenome,
        email,
        senha,
        celular
    }).then(
        ()=>{
            res.status(200).json({"MSG": "USUÁRIO CADASTRADO COM SUCESSO!"});
        }
    );

});

module.exports = router;