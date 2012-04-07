ALTER TABLE arquivo ADD COLUMN tamanho VARCHAR(255)  NOT NULL DEFAULT 0;

INSERT INTO migracao (script,data) VALUES('003',now());