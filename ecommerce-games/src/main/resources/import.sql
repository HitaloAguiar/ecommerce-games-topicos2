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


INSERT INTO produto (nome, descricao, preco) VALUES ('GRIS', 'Gris é uma obra de arte visual e emocional. Sem palavras, a protagonista enfrenta a tristeza, explorando um mundo deslumbrante. Com bela trilha sonora, Gris é uma experiência poética de superação e descoberta.', 46.99);--1
INSERT INTO produto (nome, descricao, preco) VALUES ('Outer Wilds', 'Outer Wilds: Exploração cósmica em loop temporal. Desvende segredos celestiais antes da supernova. Narrativa não linear, física cativante e uma jornada cósmica envolvente e única.', 59.99);--2
INSERT INTO produto (nome, descricao, preco) VALUES ('Hollow Knight', 'Hollow Knight, obra-prima indie, mergulha jogadores em um mundo sombrio e encantador. Explore cavernas, enfrente criaturas e desvende mistérios, enquanto o cavaleiro vence desafios. Uma jornada atmosférica, rica em detalhes e repleta de descobertas', 62.50);--3
INSERT INTO produto (nome, descricao, preco) VALUES ('Baldur''s Gate 3', 'Baldur''s Gate 3, da Larian Studios, é uma épica aventura de RPG baseada em Dungeons & Dragons. Com gráficos deslumbrantes e escolhas impactantes, os jogadores exploram traições, monstros e magias, moldando o destino em um mundo rico e cheio de perigos.', 199.90);--4
INSERT INTO produto (nome, descricao, preco) VALUES ('Sekiro: Shadows Die Twice', 'Sekiro: Shadows Die Twice, da FromSoftware, é um jogo de ação desafiador ambientado no Japão feudal. Controle o astuto shinobi, enfrentando inimigos implacáveis, desvendando mistérios e dominando a arte da espada em um mundo sombrio e implacável.', 274.00);--5
INSERT INTO produto (nome, descricao, preco) VALUES ('Elden Ring', 'Elden Ring, criação da FromSoftware em parceria com George R. R. Martin, é um épico de fantasia sombria. Com vastos reinos, combate desafiador e uma narrativa envolvente, o jogo promete uma jornada inesquecível em um mundo repleto de mistérios e perigos.', 229.90);--6
INSERT INTO produto (nome, descricao, preco) VALUES ('Super Mario Odyssey', 'Super Mario Odyssey: Mario viaja por mundos incríveis usando seu chapéu mágico para capturar inimigos e objetos, embarcando em uma missão emocionante para salvar a Princesa Peach das garras de Bowser', 289.90);--7
INSERT INTO produto (nome, descricao, preco) VALUES ('God of War Ragnarok', 'God of War: Ragnarok é a continuação da saga de Kratos e Atreus. Ambientado no mundo nórdico, o jogo promete intensidade mitológica, batalhas colossais e uma narrativa envolvente enquanto pai e filho enfrentando desafios durante o apocalipse nórdico', 193.51);--8
INSERT INTO produto (nome, descricao, preco) VALUES ('Zelda: Tears of the Kingdom', 'The Legend of Zelda: mergulha os jogadores em um épico reino de fantasia, onde Link enfrenta trevas e transformações para salvar Hyrule. Com gráficos aprimorados, narrativa envolvente, jornada cativante com quebra-cabeças desafiadores e batalhas épicas.', 306.90);--9
INSERT INTO produto (nome, descricao, preco) VALUES ('The Last Of Us 2', 'The Last of Us Part II, da Naughty Dog, é uma saga de Ellie em um mundo pós-apocalíptico. Com narrativa envolvente e gráficos deslumbrantes, o jogo explora temas profundos, como vingança e compaixão, oferecendo uma experiência emocional e impactante.', 150.15);--10
INSERT INTO produto (nome, descricao, preco) VALUES ('Doom Eternal', 'Doom Eternal, da id Software, é um frenesi demoníaco. O Doom Slayer enfrenta hordas do inferno com armas poderosas em ambientes épicos, proporcionando ação intensa e brutal. Um espetáculo infernal de destruição e sobrevivência.', 160.90);--11
INSERT INTO produto (nome, descricao, preco) VALUES ('Alan Wake 2', 'Alan Wake 2 é um jogo de sobrevivência e terror feito pela Remedy Entertainment. É a sequência de Alan Wake, lançado em 2010. Alan Wake, um escritor de suspense, está preso em um mundo obscuro, onde seus pesadelos e medos se manifestam como realidade. ', 225.00);--12
INSERT INTO produto (nome, descricao, preco) VALUES ('Star Wars Jedi: Survivor', 'Star Wars Jedi: Survivor é um jogo de ação e aventura que se passa cinco anos após a queda da Ordem Jedi. Cal Kestis, um Jedi sobrevivente, precisa encontrar um novo lugar para se esconder e treinar, enquanto é perseguido pelo Império.', 299.00);--13
INSERT INTO produto (nome, descricao, preco) VALUES ('Mega Man X Legacy Collection', 'Mega Man X, clássico da Capcom, oferece ação intensa com o herói X enfrentando robôs rebeldes. Com gráficos avançados, armaduras poderosas e desafios eletrizantes, o jogo define a excelência dos jogos de plataforma e a nostalgia dos fãs.', 66.90);--14
INSERT INTO produto (nome, descricao, preco) VALUES ('Hogwarts Legacy', 'Hogwarts Legacy mergulha os jogadores no Mundo Bruxo décadas antes de Harry Potter. Em uma escola expansiva, explore mistérios, aprenda magia, enfrente criaturas místicas. Uma jornada no universo mágico de Harry Potter', 249.99);--15
INSERT INTO produto (nome, descricao, preco) VALUES ('Cyberpunk 2077', 'Cyberpunk 2077, da CD Projekt, é um RPG imersivo ambientado em Night City, uma metrópole futurista repleta de conspirações e tecnologia avançada. Com enredo cativante, escolhas impactantes e visuais deslumbrantes, o jogo oferece uma experiência intensa.', 199.90);--16
INSERT INTO produto (nome, descricao, preco) VALUES ('Death Stranding', 'Death Stranding, dirigido por Hideo Kojima, é uma jornada única e misteriosa. Sam Bridges,  enfrenta um mundo fragmentado e conectado por laços emocionais. Com uma narrativa profunda, mecânicas inovadoras e paisagens deslumbrantes.', 159.00);--17
INSERT INTO produto (nome, descricao, preco) VALUES ('Katana ZERO', 'Katana ZERO é um jogo indie frenético e estilizado. Como um samurai mercenário, que desafia o tempo para cortar inimigos com precisão. Com uma trama envolvente, estética pixel art e mecânicas ágeis, o jogo oferece uma experiência intensa e de cinema.', 46.99);--18
INSERT INTO produto (nome, descricao, preco) VALUES ('Devil May Cry 5', 'Devil May Cry 5 (DMC5): Ação intensa e estilosa com Dante, Nero e V. Enfrente demônios, desvende mistérios e libere combos impressionantes. Com gráficos incríveis e uma trilha sonora empolgante, DMC5 é uma celebração da franquia hack and slash.', 99.90);--19
INSERT INTO produto (nome, descricao, preco) VALUES ('Dark Souls 3', 'Dark Souls III: RPG implacável em mundo sombrio. Enfrente inimigos desafiadores, explore cenários detalhados e mergulhe na atmosfera épica. Com mecânicas profundas, é uma jornada desafiadora e inesquecível.', 229.90);--20


INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2018-12-13', 8, 'gris-cover.jpg', 'gris1.jpg', 'gris2.jpg', 'gris2.jpg', 1);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2019-05-28', 9, 'outer-wilds-cover.jpg', 'outer1.jpg', 'outer2.jpg', 'outer3.jpg', 2);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2017-02-24', 10, 'hollow-knight-cover.jpg', 'hk1.jpg', 'hk2.jpg', 'hk3.jpg', 3);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2023-08-03', 11, 'bg3-cover.png', 'bg1.jpg', 'bg2.jpg', 'bg33.jpg', 4);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2019-03-22', 7, 'sekiro-cover.jpg', 'sekiro1.jpg', 'sekiro2.jpg', 'sekiro3.jpg', 5);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2022-02-25', 7, 'elden-ring-cover.jpg', 'elden1.jpg', 'elden2.jpg', 'elden3.jpg', 6);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2017-10-27', 3, 'super-mario-odyssey-cover.png', 'mario1.jpg', 'mario2.jpg', 'mario3.jpg', 7);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2022-11-09', 2, 'gow-cover.jpg', 'gow1.jpg', 'gow2.jpg', 'gow3.jpg', 8);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2023-05-17', 3, 'zelda-totk-cover.jpg', 'zelda1.jpg', 'zelda2.jpg' ,'zelda3.png', 9);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2020-06-19', 4, 'tlou-2-cover.jpg', 'tlou1.jpg', 'tlou2.jpg', 'tlou3.jpg', 10);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2020-03-20', 5, 'doom-eternal-cover.png', 'doom1.jpg', 'doom2.jpg', 'doom3.jpg', 11);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2023-10-17', 12, 'alan-wake-2-cover.png', 'wake1.jpg', 'wake2.jpg', 'wake3.png', 12);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2023-04-28', 13, 'star-wars-jedi-survivor-cover.jpg', 'star1.jpg', 'star2.jpg', 'star3.jpg', 13);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2018-07-24', 14, 'mega-man-x-cover.jpg', 'mega1.jpg', 'mega2.jpg', 'mega3.jpg', 14);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2023-02-10', 15, 'hogwarts-legacy-cover.jpg', 'hogwarts1.jpg', 'hogwarts2.jpg', 'hogwarts3.jpg', 15);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2020-12-10', 16, 'cyberpunk-cover.jpg', 'punk1.jpg', 'punk2.jpg', 'punk3.jpg', 16);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2020-07-14', 17, 'death-stranding-cover.jpg', 'strand1.jpg', 'strand2.jpg', 'strand3.jpg', 17);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2019-04-18', 18, 'katana-zero-cover.jpg', 'katana1.jpg', 'katana2.jpg', 'katana3.jpg', 18);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2019-04-08', 14, 'dmc5-cover.jpg', 'dmc1.jpg', 'dmc2.jpg', 'dmc3.jpg', 19);
INSERT INTO game (anoLancamento, id_developer, nomeImagem, nomeImagem1, nomeImagem2, nomeImagem3, id) VALUES ('2016-04-16', 7, 'dark-souls-3-cover.png', 'dark1.jpg', 'dark2.jpg', 'dark3.jpg', 20);


INSERT INTO generos_game (id_game, id_genero) VALUES (1, 3);
INSERT INTO generos_game (id_game, id_genero) VALUES (1, 4);
INSERT INTO generos_game (id_game, id_genero) VALUES (1, 15);
INSERT INTO generos_game (id_game, id_genero) VALUES (1, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (2, 4);
INSERT INTO generos_game (id_game, id_genero) VALUES (2, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (2, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (2, 18);
INSERT INTO generos_game (id_game, id_genero) VALUES (3, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (3, 11);
INSERT INTO generos_game (id_game, id_genero) VALUES (3, 18);
INSERT INTO generos_game (id_game, id_genero) VALUES (3, 19);
INSERT INTO generos_game (id_game, id_genero) VALUES (4, 5);
INSERT INTO generos_game (id_game, id_genero) VALUES (4, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (4, 9);
INSERT INTO generos_game (id_game, id_genero) VALUES (4, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (4, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (5, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (5, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (5, 11);
INSERT INTO generos_game (id_game, id_genero) VALUES (5, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (5, 16);

INSERT INTO generos_game (id_game, id_genero) VALUES (6, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 11);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 14);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 16);
INSERT INTO generos_game (id_game, id_genero) VALUES (6, 17);
INSERT INTO generos_game (id_game, id_genero) VALUES (7, 3);
INSERT INTO generos_game (id_game, id_genero) VALUES (7, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (8, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (8, 7);
INSERT INTO generos_game (id_game, id_genero) VALUES (8, 4);
INSERT INTO generos_game (id_game, id_genero) VALUES (9, 6);
INSERT INTO generos_game (id_game, id_genero) VALUES (9, 2);
INSERT INTO generos_game (id_game, id_genero) VALUES (10, 1);
INSERT INTO generos_game (id_game, id_genero) VALUES (11, 8);
INSERT INTO generos_game (id_game, id_genero) VALUES (11, 1);
INSERT INTO generos_game (id_game, id_genero) VALUES (11, 3);
INSERT INTO generos_game (id_game, id_genero) VALUES (11, 6);
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


INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (1, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (1, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (1, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (1, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (1, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (2, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (2, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (2, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (2, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (3, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (3, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (3, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (3, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (3, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (4, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (4, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (4, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (5, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (5, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (5, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (5, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (6, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (6, 3);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (6, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (6, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (7, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (8, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (8, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (8, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (9, 2);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (10, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (10, 5);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (10, 6);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (11, 1);
INSERT INTO plataformas_game (id_game, id_plataforma) VALUES (11, 2);
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


INSERT INTO endereco (logradouro, bairro, numero, complemento, cep, id_cidade) 
       VALUES ('Algum aí','Aquele lá', '000', 'em frente à rua', '11111000', 2);

INSERT INTO usuario (nome, cpf, email, login, senha, perfil) VALUES ('José Alencar', '09112332145', 'jose_alencar@hotmail.com', 'JoseAlen', '1234', 'USER');
INSERT INTO usuario (nome, cpf, email, login, senha, perfil) VALUES ('João Aguiar', '89114182345', 'joao_aguia@gmail.com', 'Joao123', 'senha', 'ADMIN');
INSERT INTO usuario (nome, cpf, email, login, senha, perfil, id_endereco) VALUES ('John Dev', '19429301284', 'johndev@hotmail.com', 'johndev', 'h1KDIE+Ewow56JmrlT7GlkSbpRLU8BUfHTTZxObDNMYz/eQaHR0gBniTsIng4epGIOvigtDvyd0YjHlwymhsOw==', 'USER', 1);
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
