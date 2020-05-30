-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecommerce` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

USE `ecommerce` ;

-- -----------------------------------------------------
-- Table `ecommerce`.`tb_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`tb_cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `cpf` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`tb_endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`tb_endereco` (
  `id_endereco` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NULL DEFAULT NULL,
  `logradouro` VARCHAR(45) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_endereco`),
  CONSTRAINT `fk_Endereco_Cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `ecommerce`.`tb_cliente` (`id_cliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`tb_estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`tb_estoque` (
  `id_estoque` INT NOT NULL AUTO_INCREMENT,
  `id_produto` INT NOT NULL,
  `quantidade` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_estoque`, `id_produto`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`tb_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`tb_status` (
  `id_status` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_status`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`tb_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`tb_pedido` (
  `id_pedido` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NULL DEFAULT NULL,
  `data_pedido` DATE NULL DEFAULT NULL,
  `id_status` INT NOT NULL,
  `id_endereco` INT NULL DEFAULT NULL,
  `valor_total` DECIMAL(10,0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pedido`, `id_status`),
  INDEX `FKo9233kiaxmqfvdo1jocl06ul0` (`id_endereco` ASC),
  CONSTRAINT `fk_Pedido_Cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `ecommerce`.`tb_cliente` (`id_cliente`),
  CONSTRAINT `fk_Pedido_Status`
    FOREIGN KEY (`id_status`)
    REFERENCES `ecommerce`.`tb_status` (`id_status`),
  CONSTRAINT `FKo9233kiaxmqfvdo1jocl06ul0`
    FOREIGN KEY (`id_endereco`)
    REFERENCES `ecommerce`.`tb_endereco` (`id_endereco`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`tb_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`tb_produto` (
  `id_produto` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `valor_unitario` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`id_produto`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`tb_item_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`tb_item_pedido` (
  `id_item_pedido` INT NOT NULL AUTO_INCREMENT,
  `id_pedido` INT NULL DEFAULT NULL,
  `id_produto` INT NULL DEFAULT NULL,
  `quantidade` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_item_pedido`),
  INDEX `fk_ItemPedido_Pedido_idx` (`id_pedido` ASC),
  INDEX `fk_ItemPedido_Produto_idx` (`id_produto` ASC),
  CONSTRAINT `fk_ItemPedido_Pedido`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `ecommerce`.`tb_pedido` (`id_pedido`),
  CONSTRAINT `fk_ItemPedido_Produto`
    FOREIGN KEY (`id_produto`)
    REFERENCES `ecommerce`.`tb_produto` (`id_produto`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
