CREATE TABLE tb_pedidos(
id BIGINT NOT NULL,
produto varchar(255),
categoria varchar(255),
preco decimal(10,2),
quantidade integer,
data date,
cliente varchar(60));

ALTER TABLE tb_pedidos ADD PRIMARY KEY (id);