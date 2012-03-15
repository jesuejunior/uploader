ALTER TABLE `arquivo` ADD COLUMN `tamanho` VARCHAR(255)  NOT NULL AFTER `caminho`;

INSERT INTO migracao (script,data) VALUES('003',CURDATE());