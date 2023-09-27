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
