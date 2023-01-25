//Criando o banco
Create schema comex;

//Criando a tabela pedido
USE comex;

create table pedido
( id BIGINT (20) NOT NULL PRIMARY KEY, produto VARCHAR(255), preco DECIMAl (10,2), quantidade INTEGER, data_pedido DATE,
cliente VARCHAR(60));

//Criando coluna categoria
ALTER TABLE pedido ADD COLUMN categoria VARCHAR(100);
 
//Inserindo dados na tabela pedido
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (1,'INFO','Notebook Samsung',3523.00,1,date_format(str_to_date('01/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ANA');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (2,'MÓVEIS','Sofá 3 lugares',2500.00,1,date_format(str_to_date('05/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ANA');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (3,'LIVROS','Clean Architecture',102.90,2,date_format(str_to_date('08/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ANA');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (4,'MÓVEIS','Mesa de jantar 6 lugares',3678.98,1,date_format(str_to_date('06/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ELI');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (5,'CELULARES','iPhone 13 Pro',9176.00,6,date_format(str_to_date('13/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'ANA');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (6,'INFO','Monitor Dell 27',1889.00,3,date_format(str_to_date('04/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'DANI');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (7,'LIVROS','Implementing Domain-Driven Design',144.07,3,date_format(str_to_date('10/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'GABI');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (8,'AUTOMOTIVA','Jogo de pneus',1276.79,1,date_format(str_to_date('15/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'BIA');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (9,'LIVROS','Clean Code',95.17,1,date_format(str_to_date('09/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'BIA');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (10,'CELULARES','Galaxy S22 Ultra',8549.10,5,date_format(str_to_date('05/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'DANI');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (11,'INFO','Macbook Pro 16',31752.00,1,date_format(str_to_date('03/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'CAIO');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (12,'LIVROS','Refactoring Improving the Design of Existing Code',173.90,1,date_format(str_to_date('12/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'DANI');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (13,'MÓVEIS','Cama queen size',3100.00,2,date_format(str_to_date('07/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'DANI');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (14,'AUTOMOTIVA','Central multimidia',711.18,1,date_format(str_to_date('16/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'CAIO');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (15,'LIVROS','Building Microservices',300.28,2,date_format(str_to_date('11/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'CAIO');
INSERT INTO pedido(id,categoria,produto,preco,quantidade,data_pedido,cliente) VALUES (16,'INFO','Galaxy Tab S8',5939.10,4,date_format(str_to_date('02/01/2022', '%d/%m/%Y'), '%Y-%m-%d'),'BIA');

//Dando update na tabela pedido trocando info por informática
update pedido set categoria = 'INFORMÁTICA'
where categoria = 'INFO';

//Fazendo select de todos os pedidos
select produto from pedido;

//Fazendo select de todos que estão na categoria CELULARES
select * from pedido where categoria = 'CELULARES';

//Fazendo select de todos os pedidos que custam entre R$3000.00 e R$10000.00
select * from pedido where preco between 3000.00 and 10000.00;

//Fazendo select dos clientes que fizeram mais pedidos
select * from pedido where cliente = 'ANA' OR cliente = 'DANI';

//Fazendo select de todos os livros que a quantidade seja maior que 1 e aparelhos de informática maior que 5000.00
select * from pedido where (categoria = 'LIVROS' and quantidade > 1) OR (categoria = 'INFORMÁTICA' and preco > 5000.00);

//Removendo pedidos da Bia que tenha quantidade = 1
delete from pedido where cliente = 'BIA' and quantidade = 1;
