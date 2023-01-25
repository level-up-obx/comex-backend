CREATE TABLE tb_pedidos(
id BIGINT NOT NULL,
produto VARCHAR(255),
categoria VARCHAR(255),
preco DECIMAL(10,2),
quantidade INTEGER,
data DATE,
cliente VARCHAR(60));

ALTER TABLE tb_pedidos ADD PRIMARY KEY (id);