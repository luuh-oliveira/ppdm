//importa o pacote sequelize 
const sequelize  = require('sequelize');

/* CRIA UMA CONSTANTE NOMEADA COMO connection QUE VAI REPRESENTAR 
A INSTANCIA DE CONEXÃO DO SEQUELIZE

PARÂMETROS DE CONEXÃO:
1- NOME DO BANCO
2- USUÁRIO
3- SENHA
4- OBJETO JSON QUE DETERMINAM O LOCAL ONDE O SERVIÇO DE BD
ESTÁ SENDO EXECUTADO E O TIPO DO BANCO DE DADOS.

*/

const connection = new sequelize(
    'libri',
    'root',
    '12345678',
    {
        'host': 'localhost:3306',
        'dialect': 'mysql'
    }
);

module.exports = connection;