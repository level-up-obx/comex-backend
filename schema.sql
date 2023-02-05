create schema comex;

create table categoria (
id bigint auto_increment primary key,
nome varchar(100)
);


create table produto (
id bigint auto_increment primary key,
 nome varchar(255),
 preco decimal(10,2),
 categoria_id bigint
  	);
alter table produto 
	add constraint fk_produto foreign key(categoria_id) references produto (id);
 

 create table cliente (

id bigint auto_increment primary key,
 nome varchar(100)
 );


create table pedido (

id bigint auto_increment primary key,
 data datetime,
 cliente_id bigint
 );
alter table pedido 
	add constraint fk_pedido foreign key(cliente_id) references produto (id);


create table item_pedido(
id bigint auto_increment primary key,
 pedido_id bigint,
 produto_id bigint,
 preco_unitario decimal(10,2),
 quantidade integer
);
alter table item_pedido 
	add constraint fk_item_pedido foreign key(pedido_id) references produto (id);
    alter table item_pedido 
	add constraint fk_item_pedido_produto foreign key(produto_id) references produto (id);