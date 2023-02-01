﻿/* RELATÓRIO DE PRODUTOS E CATEGORIAS */
SELECT C.ID, C.NOME AS CATEGORIA, P.ID, P.NOME AS PRODUTO, P.PRECO FROM CATEGORIAS C INNER JOIN PRODUTOS P ON C.ID = P.CATEGORIA_ID ORDER BY CATEGORIA, PRODUTO ASC;

/* RELATÓRIO COMPLETO DE PEDIDOS */
SELECT CL.NOME AS CLIENTE, CA.NOME AS CATEGORIA, PR.NOME AS PRODUTO, I.PRECO_UNITARIO, I.QUANTIDADE, PE.DATA FROM CATEGORIAS CA INNER JOIN PRODUTOS PR ON CA.ID = PR.CATEGORIA_ID INNER JOIN ITEM_PEDIDO I ON PR.ID = I.PRODUTO_ID INNER JOIN PEDIDOS PE ON I.PEDIDO_ID = PE.ID INNER JOIN CLIENTES CL ON PE.CLIENTE_ID = CL.ID ORDER BY CL.NOME, CA.NOME ASC;