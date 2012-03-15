CREATE TABLE `arquivo` (
  `id` INTEGER  NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255)  NOT NULL,
  `caminho` VARCHAR(255)  NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;


INSERT INTO migracao (script,data) VALUES('002',CURDATE());