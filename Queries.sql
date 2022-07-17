-- Cria o banco
CREATE DATABASE spring;

-- Cria as tabelas e colunas (manualmente)
CREATE TABLE 'person' (
  'id' INT NOT NULL AUTO_INCREMENT,
  'age' INT NOT NULL,
  'name' VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY ('id')
);
