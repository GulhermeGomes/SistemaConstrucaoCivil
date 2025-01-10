CREATE DATABASE construcaocivil;

USE construcaocivil;

CREATE TABLE Projeto(
	cnpj VARCHAR(14) PRIMARY KEY,
    nome_empresa VARCHAR(50) NOT NULL,
    nome_projeto varchar(50) NOT NULL,
    quantidade_m2 INT NOT NULL,
    valor_projeto DOUBLE NOT NULL,
    status_projeto VARCHAR(15),
    nome_engenheiro VARCHAR(50) NOT NULL
);
