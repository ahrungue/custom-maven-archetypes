#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

-- Usuario
CREATE USER applicationDB WITH PASSWORD 'applicationDB951753';

-- Criar database pertencendo ao usuario da aplicação
CREATE DATABASE  ${artifactId} OWNER applicationDB;

-- Extensão para gerar uuid
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";