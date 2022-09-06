create database agencia_viagem;
Use agencia_viagem;

CREATE TABLE Cliente_login (
id int primary key auto_increment,
nome varchar(50),
cpf VARCHAR(10),
email VARCHAR(10),
data_nascimento INTEGER,
usuario VARCHAR( 50), 
senha VARCHAR(10)
);

CREATE TABLE Passagem (
id int primary key auto_increment,
dataPassagem varchar(50),
hora_partida varchar(10),
hora_chegada varchar(10),
origem VARCHAR(50),
destino varchar(50),
tipoDeVoo VARCHAR(10),
valor NUMERIC(10),
bagagem VARCHAR(10),
nome_cliente varchar(50),
cpf VARCHAR(10)
);

CREATE TABLE Cidade (
id INTEGER PRIMARY KEY auto_increment,
nome_cidade VARCHAR(50),
categoria VARCHAR(50),
pais VARCHAR(50),
aeroporto VARCHAR(10)
);


SELECT *FROM cliente_login;
SELECT *FROM cidade;
SELECT *FROM passagem;

INSERT INTO cidade (nome_cidade,categoria,pais,aeroporto) values ('salvador', 'nacional','Brasil','2 de julho');

INSERT INTO cidade (nome_cidade,categoria,pais,aeroporto) values ('sao paulo', 'nacional','Brasil','guarulhos');

INSERT INTO cidade (nome_cidade,categoria,pais,aeroporto) values ('luanda', 'internacional','Agonla', 'guineuia');


