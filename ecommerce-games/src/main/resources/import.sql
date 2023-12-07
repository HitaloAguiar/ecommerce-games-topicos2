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

INSERT INTO genero (nome) VALUES ('Terror'); --1
INSERT INTO genero (nome) VALUES ('Action RPG');--2
INSERT INTO genero (nome) VALUES ('Plataforma');--3
INSERT INTO genero (nome) VALUES ('Puzzle');--4
INSERT INTO genero (nome) VALUES ('RPG de turno');--5
INSERT INTO genero (nome) VALUES ('Ação e Aventura');--6
INSERT INTO genero (nome) VALUES ('Hack and Slash');--7
INSERT INTO genero (nome) VALUES ('FPS');--8
INSERT INTO genero (nome) VALUES ('Estratégia');--9
INSERT INTO genero (nome) VALUES ('Simulação');--10
INSERT INTO genero (nome) VALUES ('Luta');--11
INSERT INTO genero (nome) VALUES ('Sobrevivência');--12
INSERT INTO genero (nome) VALUES ('Horror');--13
INSERT INTO genero (nome) VALUES ('Mundo Aberto');--14
INSERT INTO genero (nome) VALUES ('Música');--15
INSERT INTO genero (nome) VALUES ('Soulslike');--16
INSERT INTO genero (nome) VALUES ('Exploração');--17
INSERT INTO genero (nome) VALUES ('Mistério');--18
INSERT INTO genero (nome) VALUES ('Metroidvania');--19
INSERT INTO genero (nome) VALUES ('Roguelike');--20
INSERT INTO genero (nome) VALUES ('Tiro');--21

INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Konami', '1970-10-22', 'SECOND_PARTY');--1
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Santa Monica Studio', '2002-01-12', 'FIRST_PARTY');--2
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Nintendo EPD', '1980-08-30', 'FIRST_PARTY');--3
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Naughty Dog', '1996-08-04', 'SECOND_PARTY');--4
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Bethesda', '1990-11-15', 'THIRD_PARTY');--5
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Studio MDHR', '2015-12-05', 'INDIE');--6
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('From Software', '1986-11-01', 'FIRST_PARTY');--7
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Nomada Studio', '2015-07-20', 'INDIE');--8
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Annapurna Interactive', '2016-12-06', 'INDIE');--9
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Team Cherry', '2014-06-06', 'INDIE');--10
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Larian Studios', '1996-08-13', 'INDIE');--11
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Remedy Entertainment', '1996-08-13', 'THIRD_PARTY');--12
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Respawn Entertainment', '2010-04-12', 'THIRD_PARTY');--13
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Capcom', '1979-05-30', 'THIRD_PARTY');--14
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Avalanche Software', '1995-10-10', 'THIRD_PARTY');--15
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('CD Projekt RED', '2002-03-06', 'THIRD_PARTY');--16
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Kojima Productions', '2015-12-16', 'THIRD_PARTY');--17
INSERT INTO developer (nome, anoFundacao, classificacao) VALUES ('Askiisoft ', '2008-08-02', 'INDIE');--18

INSERT INTO fabricante (nome, anoFundacao) VALUES ('Nintendo', '1888-01-28');
INSERT INTO fabricante (nome, anoFundacao) VALUES ('Sony', '1977-11-09');
INSERT INTO fabricante (nome, anoFundacao) VALUES ('Microsoft', '1975-05-10');
INSERT INTO fabricante (nome, anoFundacao) VALUES ('SEGA', '1979-09-29');
INSERT INTO fabricante (nome, anoFundacao) VALUES ('Atari', '1978-02-11');

INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante) 
       VALUES ('PlayStation 5', '', '2021-05-30', 2); --1
INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante) 
       VALUES ('Nintendo Switch', '', '2017-01-22', 1);--2
INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante) 
       VALUES ('XBox Series X', '', '2021-11-18', 3);--3
INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante) 
       VALUES ('SEGA Dreamcast', '', '1998-04-17', 4);--4
INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante)
       VALUES ('Windows', '', '2013-01-05', 3);--5
INSERT INTO plataforma (nome, descricao, anoLancamento, id_fabricante)
       VALUES ('PlayStation 4', '', '2016-06-09', 2);--6

INSERT INTO produto (nome, descricao, preco) VALUES ('Super Mario Odyssey', 'descricao exemplo', 289.90);--1
INSERT INTO produto (nome, descricao, preco) VALUES ('God of War Ragnarok', 'descricao exemplo', 193.51);--2
INSERT INTO produto (nome, descricao, preco) VALUES ('Zelda: Tears of the Kingdom', 'descricao exemplo', 306.90);--3
INSERT INTO produto (nome, descricao, preco) VALUES ('The Last Of Us 2', 'descricao exemplo', 150.15);--4
INSERT INTO produto (nome, descricao, preco) VALUES ('Doom Eternal', 'descricao exemplo', 160.90);--5
INSERT INTO produto (nome, descricao, preco) VALUES ('Elden Ring', 'descricao exemplo', 229.90);--6
INSERT INTO produto (nome, descricao, preco) VALUES ('GRIS', 'descricao exemplo', 46.99);--7
INSERT INTO produto (nome, descricao, preco) VALUES ('Outer Wilds', 'descricao exemplo', 59.99);--8
INSERT INTO produto (nome, descricao, preco) VALUES ('Hollow Knight', 'descricao exemplo', 62.50);--9
INSERT INTO produto (nome, descricao, preco) VALUES ('Baldur''s Gate 3', 'descricao exemplo', 199.90);--10
INSERT INTO produto (nome, descricao, preco) VALUES ('Sekiro: Shadows Die Twice', 'descricao exemplo', 274.00);--11
INSERT INTO produto (nome, descricao, preco) VALUES ('Alan Wake 2', 'descricao exemplo', 225.00);--12
INSERT INTO produto (nome, descricao, preco) VALUES ('Star Wars Jedi: Survivor', 'descricao exemplo', 299.00);--13
INSERT INTO produto (nome, descricao, preco) VALUES ('Mega Man X Legacy Collection', 'descricao exemplo', 66.90);--14
INSERT INTO produto (nome, descricao, preco) VALUES ('Hogwarts Legacy', 'descricao exemplo', 249.99);--15
INSERT INTO produto (nome, descricao, preco) VALUES ('Cyberpunk 2077', 'descricao exemplo', 199.90);--16
INSERT INTO produto (nome, descricao, preco) VALUES ('Death Stranding', 'descricao exemplo', 159.00);--17
INSERT INTO produto (nome, descricao, preco) VALUES ('Katana ZERO', 'descricao exemplo', 46.99);--18
INSERT INTO produto (nome, descricao, preco) VALUES ('Devil May Cry 5', 'descricao exemplo', 99.90);--19
INSERT INTO produto (nome, descricao, preco) VALUES ('Dark Souls 3', 'descricao exemplo', 229.90);--20


INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2017-10-27', 3, 'super-mario-odyssey-cover.png', 1);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2022-11-09', 2, 'gow-cover.jpg', 2);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2023-05-17', 3, 'zelda-totk-cover.jpg', 3);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2020-06-19', 4, 'tlou-2-cover.jpg', 4);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2020-03-20', 5, 'doom-eternal-cover.png', 5);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2022-02-25', 7, 'elden-ring-cover.jpg', 6);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2018-12-13', 8, 'gris-cover.jpg', 7);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2019-05-28', 9, 'outer-wilds-cover.jpg', 8);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2017-02-24', 10, 'hollow-knight-cover.jpg', 9);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2023-08-03', 11, 'bg3-cover.png', 10);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2019-03-22', 7, 'sekiro-cover.jpg', 11);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2023-10-17', 12, 'alan-wake-2-cover.png', 12);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2023-04-28', 13, 'star-wars-jedi-survivor-cover.jpg', 13);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2018-07-24', 14, 'mega-man-x-cover.jpg', 14);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2023-02-10', 15, 'hogwarts-legacy-cover.jpg', 15);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2020-12-10', 16, 'cyberpunk-cover.jpg', 16);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2020-07-14', 17, 'death-stranding-cover.jpg', 17);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2019-04-18', 18, 'katana-zero-cover.jpg', 18);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2019-04-08', 14, 'dmc5-cover.jpg', 19);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, id) VALUES ('2016-04-16', 7, 'dark-souls-3-cover.png', 20);

INSERT INTO generos_game (id_game, id_genero) VALUES (1, 3);
INSERT INTO generos_game (id_game, id_genero) VALUES (1, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (2, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (2, 7);
INSERT INTO generos_game (id_game, id_genero) VALUES (3, 4);
INSERT INTO generos_game (id_game, id_genero) VALUES (3, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (3, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (4, 1);
INSERT INTO generos_game (id_game, id_genero) VALUES (5, 8);
INSERT INTO generos_game (id_game, id_genero) VALUES (5, 1);
INSERT INTO generos_game (id_game, id_genero) VALUES (5, 3);
INSERT INTO generos_game (id_game, id_genero) VALUES (5, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 11);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 16);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (7, 3);
INSERT INTO generos_game (id_game, id_genero) VALUES (7, 4);
INSERT INTO generos_game (id_game, id_genero) VALUES (7, 15);
INSERT INTO generos_game (id_game, id_genero) VALUES (7, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (8, 4);
INSERT INTO generos_game (id_game, id_genero) VALUES (8, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (8, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (8, 18);
INSERT INTO generos_game (id_game, id_genero) VALUES (9, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (9, 11);
INSERT INTO generos_game (id_game, id_genero) VALUES (9, 18);
INSERT INTO generos_game (id_game, id_genero) VALUES (9, 19);
INSERT INTO generos_game (id_game, id_genero) VALUES (10, 5);
INSERT INTO generos_game (id_game, id_genero) VALUES (10, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (10, 9);
INSERT INTO generos_game (id_game, id_genero) VALUES (10, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (10, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (11, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (11, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (11, 11);
INSERT INTO generos_game (id_game, id_genero) VALUES (11, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (11, 16);
INSERT INTO generos_game (id_game, id_genero) VALUES (12, 1);
INSERT INTO generos_game (id_game, id_genero) VALUES (12, 4);
INSERT INTO generos_game (id_game, id_genero) VALUES (12, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (12, 8);
INSERT INTO generos_game (id_game, id_genero) VALUES (12, 12);
INSERT INTO generos_game (id_game, id_genero) VALUES (12, 13);
INSERT INTO generos_game (id_game, id_genero) VALUES (13, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (13, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (13, 11);
INSERT INTO generos_game (id_game, id_genero) VALUES (13, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (13, 16);
INSERT INTO generos_game (id_game, id_genero) VALUES (14, 3);
INSERT INTO generos_game (id_game, id_genero) VALUES (14, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (15, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (15, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (15, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (15, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (15, 21);
INSERT INTO generos_game (id_game, id_genero) VALUES (16, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (16, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (16, 8);
INSERT INTO generos_game (id_game, id_genero) VALUES (16, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (17, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (17, 10);
INSERT INTO generos_game (id_game, id_genero) VALUES (17, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (17, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (17, 21);
INSERT INTO generos_game (id_game, id_genero) VALUES (18, 3);
INSERT INTO generos_game (id_game, id_genero) VALUES (18, 19);
INSERT INTO generos_game (id_game, id_genero) VALUES (19, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (19, 7);
INSERT INTO generos_game (id_game, id_genero) VALUES (19, 11);
INSERT INTO generos_game (id_game, id_genero) VALUES (19, 21);
INSERT INTO generos_game (id_game, id_genero) VALUES (20, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (20, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (20, 11);
INSERT INTO generos_game (id_game, id_genero) VALUES (20, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (20, 16);

INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (1, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (2, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (2, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (2, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (3, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (4, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (4, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (4, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (5, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (5, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (5, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (5, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (5, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (6, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (6, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (6, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (6, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (7, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (7, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (7, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (7, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (7, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (8, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (8, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (8, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (8, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (9, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (9, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (9, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (9, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (9, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (10, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (10, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (10, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (11, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (11, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (11, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (11, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (12, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (12, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (12, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (13, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (13, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (13, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (14, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (14, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (15, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (15, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (15, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (15, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (15, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (16, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (16, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (16, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (16, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (17, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (17, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (17, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (18, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (18, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (19, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (19, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (19, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (19, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (20, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (20, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (20, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (20, 6);

INSERT INTO usuario (nome, cpf, email, login, senha, perfil) VALUES ('José Alencar', '09112332145', 'jose_alencar@hotmail.com', 'JoseAlen', '1234', 'USER');
INSERT INTO usuario (nome, cpf, email, login, senha, perfil) VALUES ('João Aguiar', '89114182345', 'joao_aguia@gmail.com', 'Joao123', 'senha', 'ADMIN');
INSERT INTO usuario (nome, cpf, email, login, senha, perfil) VALUES ('Luísa Soares', '19429301284', 'luisa1263@hotmail.com', 'B1az3', '0r2p6DyRONqvuvLf1bkpivfs0sFL87+3MvcjeUkQcDWwfYDjODq7QvsIWNucXXBD+2ElXwsg2qxOQoz/XVORVg==', 'USER');
INSERT INTO usuario (nome, cpf, email, login, senha, perfil) VALUES ('Julia Ramos', '92874291092', 'julia.ra@gmail.com', 'Juh', 'Juh276', 'USER');
INSERT INTO usuario (nome, cpf, email, login, senha, perfil) VALUES ('hitalo', '1111111111', 'hitalo@gmail.com','hitalo','TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 'ADMIN');

INSERT INTO telefone (numero, id_usuario) VALUES ('(011) 98456-7812', 1);
INSERT INTO telefone (numero, id_usuario) VALUES ('(061) 99901-5842', 1);
INSERT INTO telefone (numero, id_usuario) VALUES ('(061) 99933-0572', 1);
INSERT INTO telefone (numero, id_usuario) VALUES ('(069) 99933-0572', 2);
INSERT INTO telefone (numero, id_usuario) VALUES ('(078) 98203-3301', 3);
INSERT INTO telefone (numero, id_usuario) VALUES ('(092) 98382-0912', 3);
INSERT INTO telefone (numero, id_usuario) VALUES ('(012) 99928-0912', 4);
INSERT INTO telefone (numero, id_usuario) VALUES ('(071) 99283-8723', 4);

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
