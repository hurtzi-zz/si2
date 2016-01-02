-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 02-01-2016 a las 19:37:33
-- Versión del servidor: 5.5.46-0ubuntu0.14.04.2
-- Versión de PHP: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `landetxeak`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `baliabidea`
--

CREATE TABLE IF NOT EXISTS `baliabidea` (
  `BalibideID` int(11) NOT NULL AUTO_INCREMENT,
  `Helbidea` varchar(255) NOT NULL,
  `Prezioa` float NOT NULL,
  `Webgunea` varchar(255) NOT NULL,
  `Deskripzioa` varchar(255) NOT NULL,
  PRIMARY KEY (`BalibideID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Erabiltzailea`
--

CREATE TABLE IF NOT EXISTS `Erabiltzailea` (
  `NAN` varchar(9) NOT NULL,
  `Izena` varchar(255) DEFAULT NULL,
  `Abizena` varchar(255) DEFAULT NULL,
  `Pasahitza` varchar(255) DEFAULT NULL,
  `Telefonoa` int(9) DEFAULT NULL,
  `Mota` int(1) DEFAULT NULL,
  `Kontu_zbkia` int(20) DEFAULT NULL,
  PRIMARY KEY (`NAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Erabiltzailea`
--

INSERT INTO `Erabiltzailea` (`NAN`, `Izena`, `Abizena`, `Pasahitza`, `Telefonoa`, `Mota`, `Kontu_zbkia`) VALUES
('123123', 'Mr', 'Dorito', 'i', 321, 0, 0),
('321', 'Chester', 'Cheeto', '111', 21, 1, 0),
('9123', 'Mr Cheeto', 'Hate doritos', '111', 321, 0, 0),
('999', 'Axi', 'axi', '123', 999199911, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `erreserba`
--

CREATE TABLE IF NOT EXISTS `erreserba` (
  `ErreserbaID` int(11) NOT NULL AUTO_INCREMENT,
  `Client` varchar(9) NOT NULL,
  `OfertaID` int(11) NOT NULL,
  `Data` date NOT NULL,
  PRIMARY KEY (`ErreserbaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `iruzkina`
--

CREATE TABLE IF NOT EXISTS `iruzkina` (
  `IruzkinID` int(11) NOT NULL AUTO_INCREMENT,
  `Testua` varchar(255) NOT NULL,
  `Puntuazioa` float NOT NULL,
  `landetxeZbkia` int(11) NOT NULL,
  PRIMARY KEY (`IruzkinID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Landetxea`
--

CREATE TABLE IF NOT EXISTS `Landetxea` (
  `Owner` varchar(9) NOT NULL,
  `herria` varchar(255) NOT NULL,
  `Helbidea` varchar(255) NOT NULL,
  `izena` varchar(255) NOT NULL,
  `Zenbakia` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Zenbakia`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7474 ;

--
-- Volcado de datos para la tabla `Landetxea`
--

INSERT INTO `Landetxea` (`Owner`, `herria`, `Helbidea`, `izena`, `Zenbakia`) VALUES
('Chester', 'vi', 'Jose le', 'Lehena', 11),
('Chester', 'aa', 'a', 'qaqa', 6110),
('Chester', 'aukera2', '22221', 'azken2', 7112),
('Chester', 'Donos', 'zumalaka', 'Bigarren', 7473);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Oferta`
--

CREATE TABLE IF NOT EXISTS `Oferta` (
  `Landetxea` int(11) NOT NULL,
  `HasData` date NOT NULL,
  `AmaiData` date NOT NULL,
  `Prezioa` float NOT NULL,
  `OfertaID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`OfertaID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8436 ;

--
-- Volcado de datos para la tabla `Oferta`
--

INSERT INTO `Oferta` (`Landetxea`, `HasData`, `AmaiData`, `Prezioa`, `OfertaID`) VALUES
(11, '2016-01-03', '2016-01-10', 44, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Owner`
--

CREATE TABLE IF NOT EXISTS `Owner` (
  `Izena` varchar(255) NOT NULL,
  `Abizena` varchar(255) NOT NULL,
  `NAN` varchar(9) NOT NULL,
  `Telefonoa` int(9) NOT NULL,
  `Kontua` int(20) NOT NULL,
  `Mota` varchar(5) NOT NULL,
  PRIMARY KEY (`NAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `txangoa`
--

CREATE TABLE IF NOT EXISTS `txangoa` (
  `TxangoID` int(11) NOT NULL AUTO_INCREMENT,
  `Nondik` varchar(255) NOT NULL,
  `Nora` varchar(255) NOT NULL,
  `PlazaKop` int(11) NOT NULL,
  `Noiz` date NOT NULL,
  PRIMARY KEY (`TxangoID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
