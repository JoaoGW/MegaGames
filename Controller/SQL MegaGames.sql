CREATE DATABASE IF NOT EXISTS MegaGames;
USE MegaGames;

CREATE TABLE IF NOT EXISTS Desenvolvedores(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cnpj VARCHAR(14),
    email VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Jogos(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    preco FLOAT,
    avaliacao FLOAT,
    iddesenvolvedor INT
);

CREATE TABLE IF NOT EXISTS Usuarios(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(50),
    nickname VARCHAR(50) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    telefone VARCHAR(11),
    idJogo int, 
    FOREIGN KEY (idJogo) REFERENCES Jogos(id)
);

-- tabela intermediaria entre usuario e jogos
CREATE TABLE IF NOT EXISTS Bibliotecas(
    usuarios INT,
    FOREIGN KEY (usuarios) REFERENCES Usuarios(id),
    jogos INT,
    FOREIGN KEY (jogos) REFERENCES Jogos(id),
    concluido BINARY,
    wishlist BINARY
);

-- tabela intermediaria entre desenvolvedores e jogos
CREATE TABLE IF NOT EXISTS BibliotecasDev(
	desenvolvedores INT,
    jogos INT,
    FOREIGN KEY (desenvolvedores) REFERENCES Desenvolvedores(id),
    FOREIGN KEY (jogos) REFERENCES Jogos(id)
);

-- INSERTS
INSERT INTO Usuarios (nome, nickname, senha, telefone, idJogo) VALUES ("Lucas Kenji", "aharp44", "123456", NULL, null);
INSERT INTO Usuarios (nome, nickname, senha, telefone, idJogo) VALUES ("Caio Pereira", "Kaboo", "654321", "114425425", null);
INSERT INTO Jogos (nome, preco, avaliacao) VALUES ("Terraria", 19.99, 4.5);
INSERT INTO Jogos (nome, preco, avaliacao) VALUES ("Subnautica", 89.99, 4.9);
INSERT INTO Desenvolvedores (nome, cnpj, email) VALUES ("Re-Logic", "1314799", "relogic@re.com");
INSERT INTO Desenvolvedores (nome, cnpj, email) VALUES ("Unknown Worlds", "1314799", "subnautica@uw.com");
INSERT INTO Bibliotecas(usuarios, jogos) VALUES (1, 1);
INSERT INTO Bibliotecas(usuarios, jogos) VALUES (1, 2);
INSERT INTO Bibliotecas(usuarios, jogos) VALUES (2, 1);
INSERT INTO BibliotecasDev(desenvolvedores, jogos) VALUES (1, 1);
INSERT INTO BibliotecasDev(desenvolvedores, jogos) VALUES (2, 2);

-- SELECTS
SELECT * FROM Usuarios;
SELECT * FROM Desenvolvedores;
SELECT * FROM Jogos;
SELECT * FROM Bibliotecas;
SELECT * FROM BibliotecasDev;
