create schema comex;

create table categoria (

id bigint auto_increment primary key,
nome varchar(100)
);

create table produto (

id bigint auto_increment primary key,
 nome varchar(255),
 preco decimal(10,2),
 categoria_id bigint,
 foreign key (categoria_id));
 
 create table cliente (

id bigint auto_increment primary key,
 nome varchar(100),
 );

create table pedido (

id bigint auto_increment primary key,
 data datetime,
 cliente_id bigint,
 foreign key (cliente_id)
);

id bigint auto_increment primary key,
 data datetime,
 pedido_id bigint,
 produto_id bigint,
 preco_unitario decimal(10,2)
 quantidade integer
 foreign key (pedido_id, produto_id)