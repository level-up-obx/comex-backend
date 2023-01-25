Create schema comex;

USE comex;

create table pedido
( id BIGINT (20) NOT NULL PRIMARY KEY, produto VARCHAR(255), preco DECIMAl (10,2), quantidade INTEGER, data_pedido DATE,
cliente VARCHAR(60));
