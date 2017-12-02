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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `carretera` */

insert into `carretera` (`id`,`nombre`,`precio`) values (1,'Ruta 68',4000);
insert into `carretera` (`id`,`nombre`,`precio`) values (2,'Ruta del Sol',4500);
insert into `carretera` (`id`,`nombre`,`precio`) values (3,'Ruta Guardia Vieja',4300);
insert into `carretera` (`id`,`nombre`,`precio`) values (4,'Troncal Sur',4700);

/*Table structure for table `empresa` */

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE `empresa` (
  `rut_empresa` varchar(11) NOT NULL,
  `nombre_empresa` varchar(100) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rut_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `empresa` */

insert into `empresa` (`rut_empresa`,`nombre_empresa`,`direccion`) values ('11111111-1','empresa 1','direccion 1');
insert into `empresa` (`rut_empresa`,`nombre_empresa`,`direccion`) values ('22222222-2','empresa 2','direccion 2');
insert into `empresa` (`rut_empresa`,`nombre_empresa`,`direccion`) values ('33333333-3','empresa 3','direccion 3');

/*Table structure for table `encargado` */

DROP TABLE IF EXISTS `encargado`;

CREATE TABLE `encargado` (
  `rut_empresa` varchar(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `login` varchar(50) NOT NULL,
  `pass_encargado` varchar(50) NOT NULL,
  PRIMARY KEY (`login`),
  KEY `FK_encargado` (`rut_empresa`),
  CONSTRAINT `encargado_ibfk_1` FOREIGN KEY (`rut_empresa`) REFERENCES `empresa` (`rut_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `encargado` */

insert into `encargado` (`rut_empresa`,`nombre`,`login`,`pass_encargado`) values ('22222222-2','Juan Gonzalez','jgonzalez','5678');
insert into `encargado` (`rut_empresa`,`nombre`,`login`,`pass_encargado`) values ('11111111-1','Juan Perez','jperez','1234');
insert into `encargado` (`rut_empresa`,`nombre`,`login`,`pass_encargado`) values ('33333333-3','Juan Tapia','jtapia','9012');

/*Table structure for table `compra` */

DROP TABLE IF EXISTS `compra`;

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `pago` varchar(20) NOT NULL,
  `envio` varchar(20) NOT NULL,
  `total` int(11) NOT NULL,
  `encargado` varchar(50) NOT NULL,
  `fecha_compra` date NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `FK_compra` (`encargado`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`encargado`) REFERENCES `encargado` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `compra` */

insert into `compra` (`id_compra`,`pago`,`envio`,`total`,`encargado`,`fecha_compra`) values (1,'Transferencia','Oficina',12000,'jperez','2016-10-28');
insert into `compra` (`id_compra`,`pago`,`envio`,`total`,`encargado`,`fecha_compra`) values (2,'Pago en Linea','Envio Cliente',4700,'jgonzalez','2017-02-15');
insert into `compra` (`id_compra`,`pago`,`envio`,`total`,`encargado`,`fecha_compra`) values (3,'Orden de compra','Oficina',8600,'jtapia','2016-01-01');

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

insert into `detalle_compra` (`id_carretera`,`id_compra`,`cantidad`) values (1,1,3);
insert into `detalle_compra` (`id_carretera`,`id_compra`,`cantidad`) values (4,2,1);
insert into `detalle_compra` (`id_carretera`,`id_compra`,`cantidad`) values (3,3,2);


