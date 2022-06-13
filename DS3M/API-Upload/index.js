const express = require('express');
const fs = require('fs');
const Livro = require('./model/Livro');
const modelLivro = require('./model/Livro')

const app = express();

//config do express pra trabalhar com json e via form
app.use(express.json());
app.use(express.urlencoded({extended:true, limit:'5MB'}));

//rota com arrow function
app.post('/testeUpload', (req, res)=>{

    let buffer = new Buffer.from(req.body.file, 'base64');

    let imageName = './uploads/' + Date.now().toString() + '.jpg';
    let titulo = req.body.titulo;

    //console.log(buffer);

    fs.writeFileSync(imageName, buffer, 'base64', (error)=>{
        if (error) console.log(error);
    });

    Livro.create({
        titulo: titulo,
        imagem: imageName
    }).then(()=>{

        res.status(200);

    });

});

app.listen(3000, ()=>{
    console.log('SERVIDOR RODANDO EM http://localhost:3000');
});