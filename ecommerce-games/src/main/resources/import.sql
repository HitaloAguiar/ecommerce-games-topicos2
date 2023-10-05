-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO estado (nome, sigla) VALUES ('Acre', 'AC');
INSERT INTO estado (nome, sigla) VALUES ('Amazonas', 'AM');
INSERT INTO estado (nome, sigla) VALUES ('Goiás', 'GO');
INSERT INTO estado (nome, sigla) VALUES ('Pará', 'PA');
INSERT INTO estado (nome, sigla) VALUES ('Tocantins', 'TO');

INSERT INTO cidade (nome, id_estado) VALUES ('Manaus', 2);
INSERT INTO cidade (nome, id_estado) VALUES ('Palmas', 5);
INSERT INTO cidade (nome, id_estado) VALUES ('Guaraí', 5);
INSERT INTO cidade (nome, id_estado) VALUES ('Belém', 4);
INSERT INTO cidade (nome, id_estado) VALUES ('Goiânia', 3);

INSERT INTO genero (nome) VALUES ('Terror');
INSERT INTO genero (nome) VALUES ('Action RPG');
INSERT INTO genero (nome) VALUES ('Luta');
INSERT INTO genero (nome) VALUES ('Puzzle');
INSERT INTO genero (nome) VALUES ('RPG de turno');

INSERT INTO developer (nome, anoFundacao) VALUES ('Konami', '1970-10-22');
INSERT INTO developer (nome, anoFundacao) VALUES ('Capcom', '1980-01-12');
INSERT INTO developer (nome, anoFundacao) VALUES ('Rare', '1987-05-30');
INSERT INTO developer (nome, anoFundacao) VALUES ('Ubisoft', '1998-08-04');
INSERT INTO developer (nome, anoFundacao) VALUES ('Activision', '1990-11-15');

INSERT INTO fabricante (nome, anoFundacao) VALUES ('Nintendo', '1888-01-28');
INSERT INTO fabricante (nome, anoFundacao) VALUES ('Sony', '1977-11-09');
INSERT INTO fabricante (nome, anoFundacao) VALUES ('Microsoft', '1975-05-10');
INSERT INTO fabricante (nome, anoFundacao) VALUES ('SEGA', '1979-09-29');
INSERT INTO fabricante (nome, anoFundacao) VALUES ('Atari', '1978-02-11');

INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante) 
       VALUES ('PlayStation 5', '', '2021-05-30', 2);
INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante) 
       VALUES ('Nintendo Switch', '', '2017-01-22', 1);
INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante) 
       VALUES ('XBox Series X', '', '2021-11-18', 3);
INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante) 
       VALUES ('SEGA Dreamcast', '', '1998-04-17', 4);
INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante) 
       VALUES ('Xbox One', '', '2013-01-05', 3);

INSERT INTO noticia (titulo, conteudo, dataPublicacao, autor, topicoPrincipal)
       VALUES ('Nostalgia total: 7 games que eram sucesso em lan houses',
'Os jogadores mais antigos vão se lembrar do King of Dragon Pass, lançado para PC e Mac em 1999 (posteriormente para iOS em 2011 e para Android em 2014). Ele acabou tendo uma sequência em 2018, chamada Six Ages. E agora, uma terceira obra está surpreendendo a indústria: Six Ages 2.

O ano de 2023 viu o surgimento de apenas três jogos, que conseguiram obter a média quase perfeita de 96/100 no Metacritic, site agregador de classificação de jogos. Entre estes três títulos, dois nomes conhecidos estão no topo: Baldurs Gate III e The Legend of Zelda: Tears of the Kingdom. Porém, o desconhecido Six Ages 2: Lights Going Out, game desenvolvido pela A Sharp e publicado pela Kitfox Games, se meteu no meio.', '2023-09-30', 'Danilo da Silva', 'CURIOSIDADES');
INSERT INTO noticia (titulo, dataPublicacao, autor, topicoPrincipal)
       VALUES ('Lançamentos: Games que você precisa jogar em outubro', '2023-10-03', 'Erick Santos', 'LANCAMENTO');
INSERT INTO noticia (titulo, dataPublicacao, autor, topicoPrincipal)
       VALUES ('NÃO ESQUEÇA NESTA TERÇA: Epic Games Store solta 2 jogos de graça', '2023-10-03', 'Luís Felipe', 'EVENTO');
INSERT INTO noticia (titulo, dataPublicacao, autor, topicoPrincipal)
       VALUES ('Total War: Pharaoh tem lançamento adiado na loja da Epic Games', '2023-09-30', 'Emannuel Oliveira', 'ATUALIZACAO');