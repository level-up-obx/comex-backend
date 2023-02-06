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
 foreign key (categoria_id) references categoria(id) 	);
 

 create table cliente (

id bigint auto_increment primary key,
 nome varchar(100)
 );


create table pedido (

id bigint auto_increment primary key,
 data datetime,
 cliente_id bigint,
foreign key (cliente_id) references categoria(id) );



create table item_pedido(
id bigint auto_increment primary key,
 pedido_id bigint,
 produto_id bigint,
 preco_unitario decimal(10,2),
 quantidade integer,
 foreign key (pedido_id) references categoria(id),
 foreign key (produto_id) references categoria(id));
	
	
	----- INSERINDO ITENS NAS TABELAS-------------
	
	use comex;

insert into categoria (nome) 
value ('AUTOMOTIVA'), ('CELULARES'), ('INFO'), ('LIVROS'), ('MOVEIS');


select * from categoria;

insert into cliente(
nome) value ('ANA'), ('ELI'), ('DANI'),('GABI'),('BIA'), ('CAIO');

select * from cliente;

insert item_pedido (preco_unitario, quantidade)
value (3523.00, 1), (2500.00, 1), (102,90), (3678.98, 1), (9176.00, 6), (1889.00, 3), (144.07, 3), (1276.79, 1), (95.17, 1), (8549.10, 5), 
(31752.00, 1), (173.90, 1), (3100.00, 2), (711.18, 1), (300.28, 2), (5939.10, 4);


select * from item_pedido;

insert into pedido (data)
value ('2022-01-01'), ('2022-01-05'), ('2022-08-01'), ('2022-01-06'), ('2022-01-13'), ('2022-01-04'), ('2022-01-10'), ('2022-01-15'), ('2022-01-06'),
 ('2022-01-14'), ('2022-01-03'), ('2022-01-12'), ('2022-01-07'), ('2022-01-16'), ('2022-01-11'), ('2022-01-02');
  
  
select * from pedido;
  
insert into produto (nome, preco) 
value ('Notebook Samsung',3523.00), ('Sofá 3 lugares', 2500.00), ('Clean Architecture', 102.90), ('Mesa de jantar 6 lugares', 3678.98),
('iPhone 13 Pro', 9176.00), ('Monitor Dell 27"', 1889.00), ('Implementing Domain-Driven Design', 144.07), ('Jogo de pneus', 1276.79), ('Clean Code', 95.17),
('Galaxy S22 Ultra', 8549.10), ('Macbook Pro 16', 31752.00), ('Refactoring Improving the Design of Existing Code', 173.90),
('Cama queen size', 3100.00), ('Central multimidia', 711.18), ('Building Microservices', 300.28),   ('Galaxy Tab S8', 5939.10);


select * from item_pedido;

-- Select dos produtos e preços----

use comex;

select * from categoria;
select * from produto;

select distinct A.id as id_categoria, A.nome, B.id as id_produto, B.nome, B.preco from produto B left join categoria A on A.id = B.id is not null;