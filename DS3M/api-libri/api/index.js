// Importa o pacote express para a aplicação
const express = require('express');

//cria uma instãncia do pacote para ser utilizada na aplicação
const app = express();

//instancia do servidor
app.listen(3000, ()=>{
    console.log('SERVIDOR RODANDO EM http://localhost:3000');
    console.log('teste');
});