/* Inserindo data nas tabelas */

INSERT INTO categoria (nome) 
VALUES ('INFO'), ('MÓVEIS'), ('LIVROS'), ('CELULARES'), ('AUTOMOTIVA');

INSERT INTO produtos (nome, preco, categoria_id)
VALUES 
  ('Notebook Samsung', 3523.00, 1),
  ('Sofá 3 lugares', 2500.00, 2),
  ('Clean Architecture', 102.90, 3),
  ('Mesa de jantar 6 lugares', 3678.98, 2),
  ('iPhone 13 Pro', 9176.00, 4),
  ('Monitor Dell 27"', 1889.00, 1),
  ('Implementing Domain-Driven Design', 144.07, 3),
  ('Jogo de pneus', 1276.79, 5),
  ('Clean Code', 95.17, 3),
  ('Galaxy S22 Ultra', 8549.10, 4),
  ('Macbook Pro 16', 31752.00, 1),
  ('Refactoring Improving the Design of Existing Code', 173.90, 3),
  ('Cama queen size', 3100.00, 2),
  ('Central multimidia', 711.18, 5),
  ('Building Microservices', 300.28, 3),
  ('Galaxy Tab S8', 5939.10, 1);


INSERT INTO clientes (nome) VALUES ('ANA'), ('ELI'), ('DANI'), ('GABI'), ('BIA'), ('CAIO');

INSERT INTO pedidos (data, clientes_id)
VALUES
  ('2022-01-01', 1),
  ('2022-01-05', 1),
  ('2022-01-08', 1),
  ('2022-01-06', 2),
  ('2022-01-13', 1),
  ('2022-01-04', 3),
  ('2022-01-10', 4),
  ('2022-01-15', 5),
  ('2022-01-09', 5),
  ('2022-01-14', 3),
  ('2022-01-03', 6),
  ('2022-01-12', 3),
  ('2022-01-07', 3),
  ('2022-01-16', 6),
  ('2022-01-11', 6),
  ('2022-01-02', 5);


INSERT INTO itens_pedidos (pedidos_id, produtos_id, preco_unitario, quantidade)
VALUES  (1,49,3523,1),
        (2,50,2500,1),
        (3,51,102.9,2),
        (4,52,3678.98,1),
        (5,53,9176,6),
        (6,54,1889,3),
        (7,55,144.07,3),
        (8,56,1276.79,1),
        (9,57,95.17,1),
        (10,58,8549.1,5),
        (11,59,31752,1),
        (12,60,173.9,1),
        (13,61,3100,2),
        (14,62,711.18,1),
        (15,63,300.28,2),
        (16,64,5939.1,4);