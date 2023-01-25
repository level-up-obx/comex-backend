#Tarefa 01 - Criar tabela de pedidos (no trello diz "pedido", porém o professor Leonardo pediu para colocarmos "pedidos"
CREATE TABLE tb_pedidos(
id BIGINT NOT NULL,
produto VARCHAR(255),
categoria VARCHAR(255),
preco DECIMAL(10,2),
quantidade INTEGER,
data DATE,
cliente VARCHAR(60));

ALTER TABLE tb_pedidos ADD PRIMARY KEY (id);

#Tarefa 02 - Inserindo os pedidos do arquivo csv disponibilizado na base de dados
INSERT INTO tb_pedidos (produto, categoria, preco, quantidade, data, cliente)
VALUES
("Notebook Samsung","INFO", 3523.00, 1, "2022-01-01", "ANA"),
("Sofá 3 lugares","MÓVEIS", 2500.00, 1, "2022-01-05", "ANA"),
("Clean Architecture","LIVROS", 102.90, 2, "2022-01-08", "ANA"),
("Mesa de jantar 6 lugares","MÓVEIS", 3678.98, 1, "2022-01-06", "ELI"),
("iPhone 13 Pro","CELULARES", 9176.00, 6, "2022-01-13", "ANA"),
("Monitor Dell 27''","INFO", 1889.00, 3, "2022-01-04", "DANI"),
("Implementing Domain-Driven Design","LIVROS", 144.07, 3, "2022-01-10", "GABI"),
("Jogo de pneus","AUTOMOTIVA", 1276.79, 1, "2022-01-15", "BIA"),
("Clean Code","LIVROS", 95.17, 1, "2022-01-09", "BIA"),
("Galaxy S22 Ultra","CELULARES", 8549.10, 5, "2022-01-14", "DANI"),
("Macbook Pro 16","INFO", 31752.00, 1, "2022-01-03", "CAIO"),
("Refactoring Improving the Design of Existing Code","LIVROS", 173.90, 1, "2022-01-12", "DANI"),
("Cama queen size","MÓVEIS", 3100.00, 2, "2022-01-07", "DANI"),
("Central multimidia","AUTOMOTIVA", 711.18, 1, "2022-01-16", "CAIO"),
("Building Microservices","LIVROS", 300.28, 2, "2022-01-11", "CAIO"),
("Galaxy Tab S8","INFO", 5939.10, 4, "2022-01-02", "BIA");

#Tarefa 03 -  Corrigindo a coluna 'INFO' para 'INFORMÁTICA'
UPDATE tb_pedidos SET categoria= 'INFORMÁTICA' WHERE categoria = 'INFO';