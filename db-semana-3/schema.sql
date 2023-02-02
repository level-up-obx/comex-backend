#Tarefa 01 - Criar banco de dados Comex
CREATE DATABASE comex_db;

CREATE TABLE categoria(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100)
);

CREATE TABLE produto(
id bigint AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255),
preco DECIMAL(10,2),
categoria_id BIGINT,
FOREIGN KEY (categoria_id)
REFERENCES categoria (id)
);

CREATE TABLE cliente(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255)
);

CREATE TABLE pedido(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
data DATETIME,
cliente_id BIGINT,
FOREIGN KEY (cliente_id)
REFERENCES cliente (id)
);

CREATE TABLE item_pedido(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
pedido_id BIGINT,
FOREIGN KEY (pedido_id)
REFERENCES pedido (id),
produto_id BIGINT,
FOREIGN KEY (produto_id)
REFERENCES produto (id),
preco_unitario DECIMAL(10,2),
quantidade INTEGER
);