//express
const express = require('express');

const app = express();

//express -> json
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

//rotas
const usuarioController = require('./controller/UsuarioController');
app.use('/', usuarioController);

app.listen(3000, ()=>{ 
    console.log('SERVIDOR RODANDO NA URL: http://localhost:3000'); 
});