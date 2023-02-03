-- cliente
insert into cliente (nome) 
values  ('ANA'),
        ('ELI'),
        ('DANI'),
        ('GABI'),
        ('BIA'),
        ('CAIO');

-- categoria
insert into categoria (nome)
values  ('INFO'),
        ('MÓVEIS'),
        ('LIVROS'),
        ('CELULARES'),
        ('AUTOMOTIVA');

-- produto
select * from categoria;
insert into produto (nome, preco, categoria_id)
values  ("Notebook Samsung",3523,1),
        ("Sofá 3 lugares",2500,2),
        ("Clean Architecture",102.9,3),
        ("Mesa de jantar 6 lugares",3678.98,2),
        ("iPhone 13 Pro",9176,4),
        ("Monitor Dell 27",1889,1),
        ("Implementing Domain-Driven Design",144.07,3),
        ("Jogo de pneus",1276.79,5),
        ("Clean Code",95.17,3),
        ("Galaxy S22 Ultra",8549.1,4),
        ("Macbook Pro 16",31752,1),
        ("Refactoring Improving the Design of Existing Code",173.9,3),
        ("Cama queen size",3100,2),
        ("Central multimidia",711.18,5),
        ("Building Microservices",300.28,3),
        ("Galaxy Tab S8",5939.1,1);

-- pedido
select * from cliente;
insert into pedido (data, cliente_id) 
values  ( STR_TO_DATE("01/01/2022","%d/%m/%Y"), 1),
        ( STR_TO_DATE("05/01/2022","%d/%m/%Y"), 1),
        ( STR_TO_DATE("08/01/2022","%d/%m/%Y"), 1),
        ( STR_TO_DATE("06/01/2022","%d/%m/%Y"), 2),
        ( STR_TO_DATE("13/01/2022","%d/%m/%Y"), 1),
        ( STR_TO_DATE("04/01/2022","%d/%m/%Y"), 3),
        ( STR_TO_DATE("10/01/2022","%d/%m/%Y"), 4),
        ( STR_TO_DATE("15/01/2022","%d/%m/%Y"), 5),
        ( STR_TO_DATE("09/01/2022","%d/%m/%Y"), 5),
        ( STR_TO_DATE("14/01/2022","%d/%m/%Y"), 3),
        ( STR_TO_DATE("03/01/2022","%d/%m/%Y"), 6),
        ( STR_TO_DATE("12/01/2022","%d/%m/%Y"), 3),
        ( STR_TO_DATE("07/01/2022","%d/%m/%Y"), 3),
        ( STR_TO_DATE("16/01/2022","%d/%m/%Y"), 6),
        ( STR_TO_DATE("11/01/2022","%d/%m/%Y"), 6),
        ( STR_TO_DATE("02/01/2022","%d/%m/%Y"), 5);

-- item_pedido
select * from pedido;
select * from produto;
insert into item_pedido (pedido_id, produto_id, preco_unitario, quantidade)
values  (1,1,3523,1),
        (2,2,2500,1),
        (3,3,102.9,2),
        (4,4,3678.98,1),
        (5,5,9176,6),
        (6,6,1889,3),
        (7,7,144.07,3),
        (8,8,1276.79,1),
        (9,9,95.17,1),
        (10,10,8549.1,5),
        (11,11,31752,1),
        (12,12,173.9,1),
        (13,13,3100,2),
        (14,14,711.18,1),
        (15,15,300.28,2),
        (16,16,5939.1,4);
