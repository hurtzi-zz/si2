-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 29-12-2015 a las 17:42:05
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `landetxeak`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `baliabidea`
--

CREATE TABLE IF NOT EXISTS `baliabidea` (
  `BalibideID` int(11) NOT NULL,
  `Helbidea` varchar(255) NOT NULL,
  `Prezioa` float NOT NULL,
  `Webgunea` varchar(255) NOT NULL,
  `Deskripzioa` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `NAN` varchar(9) NOT NULL,
  `Izena` varchar(255) NOT NULL,
  `Abizena` varchar(255) NOT NULL,
  `Pasahitza` varchar(255) NOT NULL,
  `Telefonoa` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`NAN`, `Izena`, `Abizena`, `Pasahitza`, `Telefonoa`) VALUES
('999', 'Axi', 'axi', '123', 999199911);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `erreserba`
--

CREATE TABLE IF NOT EXISTS `erreserba` (
  `ErreserbaID` int(11) NOT NULL,
  `Client` varchar(9) NOT NULL,
  `OfertaID` int(11) NOT NULL,
  `Data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `iruzkina`
--

CREATE TABLE IF NOT EXISTS `iruzkina` (
  `IruzkinID` int(11) NOT NULL,
  `Testua` varchar(255) NOT NULL,
  `Puntuazioa` float NOT NULL,
  `landetxeZbkia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `landetxea`
--

CREATE TABLE IF NOT EXISTS `landetxea` (
  `Owner` varchar(9) NOT NULL,
  `Helbidea` varchar(255) NOT NULL,
  `izena` varchar(255) NOT NULL,
  `Zenbakia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE IF NOT EXISTS `oferta` (
  `Landetxea` int(11) NOT NULL,
  `HasData` date NOT NULL,
  `AmaiData` date NOT NULL,
  `Prezioa` float NOT NULL,
  `OfertaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `owner`
--

CREATE TABLE IF NOT EXISTS `owner` (
  `Izena` varchar(255) NOT NULL,
  `Abizena` varchar(255) NOT NULL,
  `NAN` varchar(9) NOT NULL,
  `Telefonoa` int(9) NOT NULL,
  `Kontua` int(20) NOT NULL,
  `Mota` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `txangoa`
--

CREATE TABLE IF NOT EXISTS `txangoa` (
  `TxangoID` int(11) NOT NULL,
  `Nondik` varchar(255) NOT NULL,
  `Nora` varchar(255) NOT NULL,
  `PlazaKop` int(11) NOT NULL,
  `Noiz` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `baliabidea`
--
ALTER TABLE `baliabidea`
  ADD PRIMARY KEY (`BalibideID`);

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`NAN`);

--
-- Indices de la tabla `erreserba`
--
ALTER TABLE `erreserba`
  ADD PRIMARY KEY (`ErreserbaID`);

--
-- Indices de la tabla `iruzkina`
--
ALTER TABLE `iruzkina`
  ADD PRIMARY KEY (`IruzkinID`);

--
-- Indices de la tabla `landetxea`
--
ALTER TABLE `landetxea`
  ADD PRIMARY KEY (`Zenbakia`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`OfertaID`);

--
-- Indices de la tabla `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`NAN`);

--
-- Indices de la tabla `txangoa`
--
ALTER TABLE `txangoa`
  ADD PRIMARY KEY (`TxangoID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `baliabidea`
--
ALTER TABLE `baliabidea`
  MODIFY `BalibideID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `erreserba`
--
ALTER TABLE `erreserba`
  MODIFY `ErreserbaID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `iruzkina`
--
ALTER TABLE `iruzkina`
  MODIFY `IruzkinID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `landetxea`
--
ALTER TABLE `landetxea`
  MODIFY `Zenbakia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `oferta`
--
ALTER TABLE `oferta`
  MODIFY `OfertaID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `txangoa`
--
ALTER TABLE `txangoa`
  MODIFY `TxangoID` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
