-- Crie uma consulta que liste:
-- ID da categoria;
-- nome da categoria;
-- ID do produto;
-- nome do produto;
-- preço do produto.
select 
    p.categoria_id,
    c.nome as categoria,
    p.id as produto_id,
    p.nome as produto,
    p.preco
from produto p 
left join categoria c on p.categoria_id = c.id
order by c.nome, p.nome asc;

-- Crie uma consulta que liste:
-- nome do cliente;
-- nome da categoria;
-- nome do produto;
-- preço unitário do item;
-- quantidade vendida;
-- data do pedido.

select 
    c.nome as cliente,
    ct.nome as categoria,
	pt.nome as produto,
    ip.preco_unitario as preco_unitario,
    ip.quantidade as quantidade,
    pd.`data` as `data`
from item_pedido ip
left join pedido pd on ip.pedido_id = pd.id
left join produto pt on ip.produto_id = pt.id
left join cliente c on pd.cliente_id = c.id
left join categoria ct on pt.categoria_id = ct.id
order by c.nome, ct.nome asc;


