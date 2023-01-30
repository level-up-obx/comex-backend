-- 1) Criando database

create database comex char set = 'utf8mb4'
USE comex;

-- 2) Criando Tabela pedidos

create table comex.pedidos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    produto VARCHAR(255),
    categoria VARCHAR(255),
    preco DECIMAL(10,2),
    quantidade INTEGER,
    data DATE,
    cliente VARCHAR(60),
    PRIMARY KEY (id)
);

