//importa o pacote sequelize 
const sequelize  = require('sequelize');

//importa o arquivo de conexão 
const connection = require('../database/database');

/* representa o modelo da tabela de dados de usuário 

CRIA A REPRESENTAÇÃO DA TABELA
Parâmetros: 
1- NOME DA TABELA
2- OBJETO JSON

*/

const Usuario = connection.define(
    'tbl_usuario',
    {
        cod_usuario: {
            type: sequelize.INTEGER(10),
            primaryKey: true,
            autoIncrement: true
        },
        nome: {
            type: sequelize.STRING(500),
            allowNull: false
        },
        sobrenome: {
            type: sequelize.STRING(500),
            allowNull: false
        },
        email: {
            type: sequelize.STRING(500),
            allowNull: false
        },
        foto: {
            type: sequelize.STRING(500),
            allowNull: false
        },
        login: {
            type: sequelize.STRING(50),
            allowNull: false
        },
        senha:{
            type: sequelize.STRING(50),
            allowNull: false
        }

    }
);

Usuario.sync({force:true});

module.exports = Usuario;