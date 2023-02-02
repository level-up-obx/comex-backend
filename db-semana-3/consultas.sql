#Tarefa 03 - Relatório de produtos e categorias
SELECT categoria.id AS id_categoria, categoria.nome AS categoria, produto.id AS id_produto, produto.nome AS produto, produto.preco AS preco
FROM categoria LEFT JOIN produto ON  categoria.id = produto.categoria_id;

#Tarefa 04 - Relatório completo de pedidos
SELECT cliente.nome AS cliente, categoria.nome AS categoria, produto.nome AS produto, item_pedido.preco_unitario, item_pedido.quantidade, pedido.data
FROM cliente
INNER JOIN pedido ON cliente.id = pedido.cliente_id
INNER JOIN item_pedido ON pedido.id = item_pedido.pedido_id
INNER JOIN produto ON item_pedido.produto_id = produto.id
INNER JOIN categoria ON produto.categoria_id = categoria.id;

