create database comex;

use comex;

create table pedido
(id bigint auto_increment primary key,
produto varchar(255),
preco decimal(10,2),
quantidade integer,
`data` date,
cliente varchar(60))
