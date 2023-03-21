-- Crie um novo database chamado comex (caso já exista, faça drop do antigo)
drop database comex ;
create database comex;
USE comex;

-- Crie a tabela categoria com os campos:
create table categoria(
    id bigint auto_increment,
    nome varchar(100),

    PRIMARY KEY (id)
);

-- Crie a tabela produto com os campos:
create table produto(
    id bigint auto_increment,
    nome varchar(255),
    preco decimal(10,2),
    categoria_id bigint,

    PRIMARY KEY (id),
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

-- Crie a tabela cliente com os campos:
create table cliente(
    id bigint auto_increment,
    nome varchar(255),

    PRIMARY KEY (id)
);

-- Crie a tabela pedido com os campos:
create table pedido(
    id bigint auto_increment,
    data datetime,
    cliente_id bigint,

    PRIMARY KEY (id),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Crie a tabela item_pedido com os campos:
create table item_pedido(
	id bigint auto_increment,
	pedido_id bigint,
	produto_id bigint,
	preco_unitario decimal(10,2),
	quantidade integer,

    PRIMARY KEY (id),
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

