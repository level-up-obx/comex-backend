CREATE TABLE pedido(
id BIGINT,
produto VARCHAR(255),
preco DECIMAL(10,2),
quantidade INTEGER,
data DATE,
cliente VARCHAR(60));

ALTER TABLE pedido ADD PRIMARY KEY (id);