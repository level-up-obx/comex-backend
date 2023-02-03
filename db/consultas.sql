
use comex;
SELECT categoria.id AS 'CATEGORIA ID', categoria.nome AS 'CATEGORIA NOME',
       produtos.id AS 'ID PRODUTO', produtos.nome AS 'NOME PRODUTO',
       produtos.preco AS 'PREÇO PRODUTO'
FROM categoria
INNER JOIN produtos ON categoria.id = produtos.categoria_id;