-- 1) Criando database

create database comex char set = 'utf8mb4'
USE comex;

-- 2) Criando Tabela pedidos

create table comex.pedidos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    produto VARCHAR(255),
    categoria VARCHAR(255),
    preco DECIMAL(10,2),
    quantidade INTEGER,
    data DATE,
    cliente VARCHAR(60),
    PRIMARY KEY (id)
);

-- 3) Inserindo dados nas tabelas

insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('INFO','Notebook Samsung',3523.00,1, '2022/01/01/','ANA');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('INFO', 'Notebook Samsung', '3523.00','1','2022-01-01','ANA');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('MÓVEIS', 'Sofá 3 lugares', '2500.00','1','2022-01-05','ANA');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('LIVROS', 'Clean Architecture', '102.90','2','2022-01-08','ANA');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('MÓVEIS', 'Mesa de jantar 6 lugares', '3678.98','1','2022-01-06','ELI');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('CELULARES', 'iPhone 13 Pro', '9176.00','6','2022-01-13','ANA');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('INFO', 'Monitor Dell 27', '1889.00','3','2022-01-04','DANI');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('LIVROS', 'Implementing Domain-Driven Design', '144.07','3','2022-01-10','GABI');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('AUTOMOTIVA', 'Jogo de pneus', '1276.79','1','2022-01-15','BIA');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('LIVROS', 'Clean Code', '95.17','1','2022-01-09','BIA');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('CELULARES', 'Galaxy S22 Ultra', '8549.10','5','2022-01-14','DANI');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('INFO', 'Macbook Pro 16', '31752.00','1','2022-01-03','CAIO');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('LIVROS', 'Refactoring Improving the Design of Existing Code', '173.90','1','2022-01-12','DANI');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('MÓVEIS', 'Cama queen size', '3100.00','2','2022-01-07','DANI');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('AUTOMOTIVA', 'Central multimidia', '711.18', '1', '2022-01-16','CAIO');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('LIVROS', 'Building Microservices', '300.28', '2', '2022-01-11','CAIO');
insert into pedidos (`produto`, `categoria`, `preco`, `quantidade`, `data`, `cliente`) values ('INFO', 'Galaxy Tab S8', '5939.10', '4','2022-01-02', 'BIA');

-- 4) Alterando INFO por INFORMÁTICA

update pedidos set produto = "INFORMÁTICA" where produto = "INFO";

-- 5) Listando todos os pedidos

select * from pedidos;

-- 6) Listando todos os pedidos da categoria CELULARES

select * from pedidos where produto = "CELULARES";

-- 7) Listando todos os pedidos  onde o preço esteja entre R$ 3.000,00 e R$ 10.000,00;

select * from pedidos where preco between "3000.00" and "10000.00";