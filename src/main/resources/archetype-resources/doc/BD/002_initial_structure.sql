#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

-- Tabela de Instancias
CREATE TABLE public.instances(
  instance_id     VARCHAR(36)   NOT NULL,
  instance_name   VARCHAR(150)  NOT NULL,
-- **************************** Constraints **************************** --
  CONSTRAINT pk_instance  PRIMARY KEY  (instance_id)
);

-- Tabela de usuarios de login do sistema
CREATE TABLE public.users(
  user_id         VARCHAR(36)   NOT NULL,
  user_name       VARCHAR(150)  NOT NULL UNIQUE,
  user_cpf        VARCHAR(150)  NOT NULL UNIQUE,
  user_email      VARCHAR(150)  NOT NULL UNIQUE,
  user_login      VARCHAR(150)  NOT NULL UNIQUE,
  user_password   VARCHAR(150)  NOT NULL,
  enabled         BOOLEAN       NOT NULL DEFAULT TRUE,
  last_login      TIMESTAMP     DEFAULT  current_timestamp,
-- **************************** Foreign Keys *************************** --
  instance_id     VARCHAR(36)   NOT NULL,
-- **************************** Constraints **************************** --
  CONSTRAINT pk_user          PRIMARY KEY (user_id),
  CONSTRAINT fk_user_instance FOREIGN KEY (instance_id) REFERENCES public.instances(instance_id)
);

-- Tabela de com o nome dos grupos de acesso do usuaria
CREATE TABLE public.groups(
  group_id        VARCHAR(36)   NOT NULL,
  group_name      VARCHAR(36)   NOT NULL,
-- **************************** Constraints **************************** --
  CONSTRAINT pk_group PRIMARY KEY (group_id)
);

-- Tabela com a relação entre os grupos de acesso e usuarios
CREATE TABLE authorities(
  user_id         VARCHAR(36)   NOT NULL,
  group_id        VARCHAR(36)   NOT NULL,
-- **************************** Constraints **************************** --
  CONSTRAINT pk_authority       PRIMARY KEY(user_id, group_id),
  CONSTRAINT fk_authority_user  FOREIGN KEY(user_id)  REFERENCES public.users(user_id)    ON UPDATE CASCADE,
  CONSTRAINT fk_authority_group FOREIGN KEY(group_id) REFERENCES public.groups(group_id)  ON UPDATE CASCADE
);