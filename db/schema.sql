/*Criando Database e Tabelas */

DROP DATABASE comex;
CREATE DATABASE comex;
USE comex;


CREATE TABLE categoria (
  id bigint AUTO_INCREMENT PRIMARY KEY,
  nome varchar(100)
);

CREATE TABLE produto (
  id bigint AUTO_INCREMENT PRIMARY KEY,
  nome varchar(255),
  preco decimal(10,2),
  categoria_id bigint,
  FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE clientes (
id bigint AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR (255)
);

CREATE TABLE pedidos (
  id bigint AUTO_INCREMENT PRIMARY KEY,
  data datetime,
  clientes_id bigint,
  FOREIGN KEY (clientes_id) REFERENCES clientes(id) 
);

CREATE TABLE itens_pedidos (
  id bigint AUTO_INCREMENT PRIMARY KEY,
  pedidos_id bigint,
  produtos_id bigint,
  preco_unitario decimal(10, 2),
  quantidade integer,
  FOREIGN KEY (pedidos_id) REFERENCES pedidos(id),
  FOREIGN KEY (produtos_id) REFERENCES produtos(id)
);
