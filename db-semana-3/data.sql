#Tarefa 02 - Popular tabelas
INSERT INTO categoria (nome)
VALUES
("informática"),
("móveis"),
("livros"),
("celulares"),
("automotiva");

INSERT INTO produto (nome, preco, categoria_id)
VALUES
("Notebook Samsung", 3523.00, 1),
("Sofá 3 lugares", 2500.00, 2),
("Clean Architecture", 102.90, 3),
("Mesa de jantar 6 lugares", 3678.98, 2),
("iPhone 13 Pro", 9176.00, 4),
("Monitor Dell 27", 1889.00, 1),
("Implementing Domain-Driven Design", 144.07, 3),
("Jogo de pneus", 1276.79, 5),
("Clean Code", 95.17, 3),
("Galaxy S22 Ultra", 8549.10, 4),
("Macbook Pro 16", 31752.00, 1),
("Refactoring Improving the Design of Existing Code", 173.90, 3),
("Cama queen size", 3100.00, 2),
("Central multimidia", 711.18, 5),
("Building Microservices", 300.28, 3),
("Galaxy Tab S8", 5939.10, 1);

INSERT INTO cliente (nome)
VALUES
("ANA"),
("ELI"),
("DANI"),
("GABI"),
("BIA"),
("CAIO");

INSERT INTO pedido (data, cliente_id)
VALUES
("2022-01-01", 1),
("2022-01-05", 1),
("2022-01-08", 1),
("2022-01-06", 2),
("2022-01-13", 1),
("2022-01-04", 3),
("2022-01-10", 4),
("2022-01-15", 5),
("2022-01-09", 5),
("2022-01-14", 3),
("2022-01-03", 6),
("2022-01-12", 3),
("2022-01-07", 3),
("2022-01-16", 6),
("2022-01-11", 6),
("2022-01-02", 5);

INSERT INTO item_pedido (pedido_id, produto_id, preco_unitario, quantidade)
VALUES
(1, 16, 3523.00, 1),
(2, 17, 2500.00, 1),
(3, 18, 102.90, 2),
(4, 19, 3678.98, 1),
(5, 20, 9176.00, 6),
(6, 21, 1889.00, 3),
(7, 22, 144.07, 3),
(8, 23, 1276.79, 1),
(9, 24, 95.17, 1),
(10, 25, 8549.10, 5),
(11, 26, 31752.00, 1),
(12, 27, 173.90, 1),
(13, 28, 3100.00, 2),
(14, 29, 711.18, 1),
(15, 30, 300.28, 2),
(16, 31, 5939.10, 4);


SELECT * FROM produto;
SELECT * FROM categoria;
SELECT * FROM cliente;
SELECT * FROM pedido;
SELECT * FROM item_pedido;