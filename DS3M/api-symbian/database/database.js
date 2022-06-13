// importar sequelize
const Sequelize = require('sequelize');

//criar conexão
const connection = new Sequelize('db_symbian', 'root', '12345678', {
    host: 'localhost',
    dialect: 'mysql',
    timezone: '-03:00'
});

//importar conexão
module.exports = connection;