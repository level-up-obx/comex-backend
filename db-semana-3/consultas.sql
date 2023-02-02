#Tarefa 03 - Relatório de produtos e categorias
SELECT categoria.id AS id_categoria, categoria.nome AS categoria, produto.id AS id_produto, produto.nome AS produto, produto.preco AS preco
FROM categoria LEFT JOIN produto ON  categoria.id = produto.categoria_id;