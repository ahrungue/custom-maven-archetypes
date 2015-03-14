#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

-- Instancia Padrao
INSERT INTO instances VALUES ('2beedae542b840c8b7c57baeca721da8','system-instance');

-- Inserir usuarios - user_id, user_name, user_cpf, user_email, user_login, user_password, enabled, last_login, instance_id
INSERT INTO users VALUES('5c9fe70c-7e55-4ab5-b77a-ef94a2d48ddd', 'system-user','000.000.000-00','system@email.com','system-app', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', TRUE, NULL, '2beedae542b840c8b7c57baeca721da8' );

-- Inserir os grupos de usuario
INSERT INTO groups VALUES ('b2fa0335741d497a910f6db1646f747f','ADMIN'), ('711995f500f049febdaa712c3ff3da1c','MEMBER'), ('28f1c547816c42c7b1f635324af0a840','MANAGER');

-- Inserir usuario em um grupo -> {system-user - MANAGER}
INSERT INTO authorities VALUES ('5c9fe70c-7e55-4ab5-b77a-ef94a2d48ddd','28f1c547816c42c7b1f635324af0a840');
