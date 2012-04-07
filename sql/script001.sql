CREATE TABLE migracao(
	id serial NOT NULL,
	script VARCHAR(10) NOT NULL,
	data timestamp NOT NULL,
	PRIMARY KEY(id)
);	
INSERT INTO migracao (script,data) VALUES('001',now());