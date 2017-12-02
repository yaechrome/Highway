/*
SQLyog - Free MySQL GUI v5.11
Host - 5.5.24-log : Database - highway
*********************************************************************
Server version : 5.5.24-log
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `highway`;

USE `highway`;

/*Table structure for table `carretera` */

DROP TABLE IF EXISTS `carretera`;

CREATE TABLE `carretera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `carretera` */

/*Table structure for table `empresa` */

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE `empresa` (
  `rut_empresa` varchar(11) NOT NULL,
  `nombre_empresa` varchar(100) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rut_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `empresa` */

/*Table structure for table `encargado` */

DROP TABLE IF EXISTS `encargado`;

CREATE TABLE `encargado` (
  `rut_empresa` varchar(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`login`),
  KEY `FK_encargado` (`rut_empresa`),
  CONSTRAINT `encargado_ibfk_1` FOREIGN KEY (`rut_empresa`) REFERENCES `empresa` (`rut_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `encargado` */

/*Table structure for table `compra` */

DROP TABLE IF EXISTS `compra`;

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL,
  `pago` varchar(20) NOT NULL,
  `envio` varchar(20) NOT NULL,
  `total` int(11) NOT NULL,
  `encargado` varchar(50) NOT NULL,
  `fecha_compra` date NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `FK_compra` (`encargado`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`encargado`) REFERENCES `encargado` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `compra` */

/*Table structure for table `detalle_compra` */

DROP TABLE IF EXISTS `detalle_compra`;

CREATE TABLE `detalle_compra` (
  `id_carretera` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  KEY `FK_detalle_compra` (`id_carretera`),
  KEY `FK_det_cpra` (`id_compra`),
  CONSTRAINT `detalle_compra_ibfk_2` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`id_carretera`) REFERENCES `carretera` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `detalle_compra` */
