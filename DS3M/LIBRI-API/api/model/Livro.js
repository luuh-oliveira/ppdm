/* IMPORTA O MÓDULO DO sequelize */
const Sequelize = require('sequelize');

/* IMPORTA O ARQUIVO DE CONEXÃO COM BANCO DE DADOS */
const connection = require('../database/database');

const Usuario =  require('./Usuario');

const Livro  = connection.define(
    'tbl_livro',
    {
        cod_livro:{
            type: Sequelize.INTEGER(10),
            primaryKey: true,
            autoIncrement: true
        },
        titulo:{
            type: Sequelize.STRING(200),
            allowNull: true
        },
        descricao:{
            type: Sequelize.TEXT,
            allowNull: true
        },
        imagem:{
            type: Sequelize.STRING(500),
            allowNull: true
        }
    }
);

// no sequelize, a tabela com a chave estrangeira é que representa a relação

/*Implementação da  CHAVE ESTRANGEIRA - LADO N*/
Usuario.hasMany(Livro);


/*Representação da CHAVE PRIMÁRIA - LADO 1*/
Livro.belongsTo(Usuario);

// Livro.sync({force:true});

module.exports = Livro;