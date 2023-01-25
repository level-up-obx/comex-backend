//Criando a Tabela

CREATE SCHEMA `Comex` ;


// Criando a tabela pedido com a primary key no ID.

USE COMEX;
CREATE TABLE pedido(
id BIGINT(20) NOT NULL PRIMARY KEY ,
produto VARCHAR(255),
preco DECIMAL(10.2),
quantidade INT(150),
dataPedido DATE,
cliente VARCHAR(60))

//Inserindo dados na tabela pedidos

USE comex;

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES ( 1,'INFO','Notebook Samsung',3523.00,1,  date_format(str_to_date('01/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ANA');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES ( 2,'MÓVEIS','Sofá 3 lugares',2500.00,1,  date_format(str_to_date('05/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ANA');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES ( 3,'LIVROS','Clean Architecture',102.90,2,  date_format(str_to_date('08/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ANA');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES ( 4,'MÓVEIS','Mesa de jantar 6 lugares',3678.98,1,   date_format(str_to_date('06/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ELI');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES ( 5,'CELULARES','iPhone 13 Pro',9176.00,6,   date_format(str_to_date('13/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ANA');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES ( 6,'INFO','Monitor Dell 27',1889.00,3,   date_format(str_to_date('04/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'DANIi');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES ( 7,'LIVROS','Implementing Domain-Driven Design',144.07,3,  date_format(str_to_date('10/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'GABI');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES ( 8,'AUTOMOTIVA','Jogo de pneus',1276.79,1,  date_format(str_to_date('15/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'BIA');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES ( 9,'LIVROS','Clean Code',95.17,1,   date_format(str_to_date('09/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'BIA');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES (10,'CELULARES','Galaxy S22 Ultra',8549.10,5,   date_format(str_to_date('14/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'DANI');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES (11,'INFO','Macbook Pro 16',31752.00,1,  date_format(str_to_date('03/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'CAIO');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES (12,'LIVROS','Refactoring Improving the Design of Existing Code',173.90,1,  date_format(str_to_date('12/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'DANI');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES (13,'MÓVEIS','Cama queen size',3100.00,2,  date_format(str_to_date('07/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ANA');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES (14,'AUTOMOTIVA','Central multimidia',711.18,1,  date_format(str_to_date('16/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'CAIO');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES (15,'LIVROS','Building Microservices',300.28,2,  date_format(str_to_date('11/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'CAIO');

INSERT INTO pedido(ID,CATEGORIA,PRODUTO,PRECO,QUANTIDADE,DATAPEDIDO,CLIENTE) VALUES (16,'INFO','Galaxy Tab S8',5939.10,4,  date_format(str_to_date('02/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'BIA');


//Corrigindo categoria Informatica

UPDATE pedido SET categoria = 'INFORMATICA' WHERE categoria = 'INFO'; 


//Selecionando todos os pedidos da tabela pedido

SELECT produto FROM pedido;


//Selecionando todos os pedidos da categoria CELULARES

SELECT * FROM pedido WHERE categoria = 'CELULARES';


//Listando preços entre 3000.00 e 10000.00

SELECT * FROM pedido WHERE preco BETWEEN 3000.00 AND 10000.00;


