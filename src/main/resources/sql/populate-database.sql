INSERT INTO SHIFT6_CATEGORIA (ID_CATEGORIA, NOME_CATEGORIA, ATIVO) VALUES (CATEGORIA_SEQ.NEXTVAL, 'Notebook', 1);
INSERT INTO SHIFT6_CATEGORIA (ID_CATEGORIA, NOME_CATEGORIA, ATIVO) VALUES (CATEGORIA_SEQ.NEXTVAL, 'Smartphone', 1);
INSERT INTO SHIFT6_CATEGORIA (ID_CATEGORIA, NOME_CATEGORIA, ATIVO) VALUES (CATEGORIA_SEQ.NEXTVAL, 'TV', 1);
INSERT INTO SHIFT6_CATEGORIA (ID_CATEGORIA, NOME_CATEGORIA, ATIVO) VALUES (CATEGORIA_SEQ.NEXTVAL, 'Tablet', 0);

INSERT INTO SHIFT6_MARCA (ID_MARCA, NOME_MARCA) VALUES (MARCA_SEQ.NEXTVAL, 'LG');
INSERT INTO SHIFT6_MARCA (ID_MARCA, NOME_MARCA) VALUES (MARCA_SEQ.NEXTVAL, 'Apple');
INSERT INTO SHIFT6_MARCA (ID_MARCA, NOME_MARCA) VALUES (MARCA_SEQ.NEXTVAL, 'Samsumg');
INSERT INTO SHIFT6_MARCA (ID_MARCA, NOME_MARCA) VALUES (MARCA_SEQ.NEXTVAL, 'Sony');

INSERT INTO SHIFT6_PRODUTO (ID_PRODUTO, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA, FOTO) VALUES (PRODUTO_SEQ.NEXTVAL, 'LG Nome do produto 1', 'sku-0001', 'Descrição do Produto 1', 'Características do produto 1', 1.99, TO_DATE('2003/05/03', 'yyyy/mm/dd') , 1, 1 , 'https://via.placeholder.com/400x400/FF5733/000000');
INSERT INTO SHIFT6_PRODUTO (ID_PRODUTO, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA, FOTO) VALUES (PRODUTO_SEQ.NEXTVAL, 'APPLE Nome do produto 2', 'sku-0002', 'Descrição do Produto 2', 'Características do produto 2', 2.99, TO_DATE('2003/06/03', 'yyyy/mm/dd') , 2, 2 , 'https://via.placeholder.com/400x400/FFE033/000000');
INSERT INTO SHIFT6_PRODUTO (ID_PRODUTO, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA, FOTO) VALUES (PRODUTO_SEQ.NEXTVAL, 'FIAP Nome do produto 3', 'sku-0002', 'Descrição do Produto 3', 'Características do produto 3', 3.99, TO_DATE('2003/07/03', 'yyyy/mm/dd') , 3, 3 , 'https://via.placeholder.com/400x400/FF3380/000000');
INSERT INTO SHIFT6_PRODUTO (ID_PRODUTO, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA, FOTO) VALUES (PRODUTO_SEQ.NEXTVAL, 'FIAP Nome do produto 4', 'sku-0002', 'Descrição do Produto 4', 'Características do produto 4', 4.99, TO_DATE('2003/08/03', 'yyyy/mm/dd') , 4, 4 , 'https://via.placeholder.com/400x400/9433FF/000000');
INSERT INTO SHIFT6_PRODUTO (ID_PRODUTO, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA, FOTO) VALUES (PRODUTO_SEQ.NEXTVAL, 'APPLE Nome do produto 5', 'sku-0005', 'Descrição do Produto 5', 'Características do produto 5', 5.99, TO_DATE('2003/09/03', 'yyyy/mm/dd') , 4, 4 , 'https://via.placeholder.com/400x400/33FDFF/000000');
INSERT INTO SHIFT6_PRODUTO (ID_PRODUTO, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA, FOTO) VALUES (PRODUTO_SEQ.NEXTVAL, 'LG Nome do produto 6', 'sku-0006', 'Descrição do Produto 6', 'Características do produto 6', 4.99, TO_DATE('2003/10/03', 'yyyy/mm/dd') , 4, 4 , 'https://via.placeholder.com/400x400/78FF33/000000');