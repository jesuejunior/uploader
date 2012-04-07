CREATE TABLE arquivo(
	id serial NOT NULL,
	nome VARCHAR(255) NOT NULL,
	caminho VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	
	);

	INSERT INTO migracao (script,data) VALUES('002',NOW());