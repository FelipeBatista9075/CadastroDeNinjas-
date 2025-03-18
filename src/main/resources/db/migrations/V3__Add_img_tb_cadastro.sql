-- V3: Migrations para adicionar a coluna de imagem na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN img VARCHAR(255);