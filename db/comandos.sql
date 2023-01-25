//Criando a Tabela

CREATE SCHEMA `Comex` ;


// Criando a tabela pedido com a primary key no ID.

USE COMEX;
CREATE TABLE pedido(
id BIGINT(20) NOT NULL PRIMARY KEY ,
produto VARCHAR(255),
preco DECIMAL(10.2),
quantidade INT(150),
dataPedido DATE,
cliente VARCHAR(60))


