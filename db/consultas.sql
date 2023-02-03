
use comex;
SELECT categoria.id AS 'CATEGORIA ID', categoria.nome AS 'CATEGORIA NOME',
       produtos.id AS 'ID PRODUTO', produtos.nome AS 'NOME PRODUTO',
       produtos.preco AS 'PREÇO PRODUTO'
FROM categoria
INNER JOIN produtos ON categoria.id = produtos.categoria_id;


use comex;
SELECT clientes.nome AS 'CLIENTES',
 categoria.nome AS 'CATEGORIA',
 produtos.nome AS 'PRODUTOS', 
 itens_pedidos.preco_unitario AS 'UNITARIO', itens_pedidos.quantidade AS 'QUANTIDADE', 
 pedidos.data AS 'DATA'
FROM clientes
INNER JOIN pedidos ON clientes.id = pedidos.clientes_id
INNER JOIN itens_pedidos ON pedidos.id = itens_pedidos.pedidos_id
INNER JOIN produtos ON itens_pedidos.produtos_id = produtos.id
INNER JOIN categoria ON produtos.categoria_id = categoria.id
ORDER BY clientes.nome, categoria.nome ASC;


use comex;
SELECT categoria.nome AS 'CATEGORIA', 
SUM(itens_pedidos.preco_unitario * itens_pedidos.quantidade) AS 'TOTAL DE VENDAS'
FROM categoria
JOIN produtos ON categoria.id = produtos.categoria_id
JOIN itens_pedidos ON produtos.id = itens_pedidos.produtos_id
GROUP BY categoria.nome;


SELECT COUNT(DISTINCT pedidos.id) AS 'PEDIDOS',
SUM(itens_pedidos.quantidade) AS 'QUANTIDADE PEDIDA',
MIN(itens_pedidos.preco_unitario * itens_pedidos.quantidade) AS 'PEDIDO MAIS BARATO',
MAX(itens_pedidos.preco_unitario * itens_pedidos.quantidade) AS 'PEDIDO MAIS CARO',
SUM(itens_pedidos.preco_unitario * itens_pedidos.quantidade) AS 'TOTAL DE VENDAS'
FROM pedidoS LEFT JOIN itens_pedidos ON pedidos.id = itens_pedidos.pedidos_id;
 
 
use comex;
SELECT clientes.nome, COUNT(pedidos.id) AS quantidade_pedidos
FROM clientes
JOIN pedidos ON clientes.id = pedidos.clientes_id
GROUP BY clientes.nome
ORDER BY quantidade_pedidos DESC
LIMIT 2;