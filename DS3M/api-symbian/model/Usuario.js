//sequelize
const Sequelize = require('sequelize');

//conexão
const connection = require('../database/database');

const Usuario = connection.define(
    'tbl_usuario',
    {
        id_usuario:{
            type: Sequelize.INTEGER(10),
            primaryKey: true,
            autoIncrement: true
        },
        nome:{
            type:Sequelize.STRING(255),
            allowNull: false
        },
        sobrenome:{
            type:Sequelize.STRING(255),
            allowNull: false
        },
        email:{
            type:Sequelize.STRING(255),
            allowNull: false
        },
        senha:{
            type:Sequelize.STRING(255),
            allowNull: false
        },
        celular:{
            type:Sequelize.STRING(255),
            allowNull: false
        }
    }
);

// Usuario.sync({force:true});

module.exports = Usuario;