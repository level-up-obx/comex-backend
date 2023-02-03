//Criando consulta que lista categoria, produtos e preço
SELECT c.id AS 'CATEGORIA ID', c.nome AS 'CATEGORIA NOME',
p.id AS 'ID PRODUTO', p.nome AS 'NOME PRODUTO',
p.preco AS 'PREÇO PRODUTO'
FROM categoria c INNER JOIN produtos p ON c.id = p.categoria_id;

//Criando consulta que trás um relatório completo de pedidos

SELECT clientes.nome AS 'NOME DO CLIENTE', 
categoria.nome AS 'CATEGORIA', 
produtos.nome AS 'NOME DO PRODUTO',
itens_pedidos.preco_unitario AS 'PREÇO', 
itens_pedidos.quantidade AS 'QUANTIDADE', 
pedidos.`data`as 'DATA DO PEDIDO'
from clientes
INNER join pedidos on clientes.id = pedidos.cliente_id
INNER join itens_pedidos on itens_pedidos.pedido_id = pedidos.id
INNER join produtos on produtos.id = itens_pedidos.produto_id
INNER join categoria on produtos.categoria_id = clientes.id
order by clientes.nome, categoria.nome ASC;