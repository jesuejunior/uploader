CREATE TABLE `migracao` (
  `id` INTEGER  NOT NULL AUTO_INCREMENT,
  `script` VARCHAR(10)  NOT NULL,
  `data` DATETIME  NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

INSERT INTO migracao (script,data) VALUES('001',CURDATE());