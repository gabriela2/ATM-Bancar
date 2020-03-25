-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: mai 20, 2019 la 05:37 PM
-- Versiune server: 10.1.38-MariaDB
-- Versiune PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `proiectjsp`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `depozit`
--

CREATE TABLE `depozit` (
  `idUtilizator` int(11) NOT NULL,
  `idDepozit` int(11) NOT NULL,
  `codDepozit` varchar(4) NOT NULL,
  `suma` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `depozit`
--

INSERT INTO `depozit` (`idUtilizator`, `idDepozit`, `codDepozit`, `suma`) VALUES
(33, 50, '6547', '150'),
(33, 51, '6626', '100'),
(34, 52, '7774', '800'),
(34, 53, '7884', '800');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `tranzactie`
--

CREATE TABLE `tranzactie` (
  `idTranzactie` int(11) NOT NULL,
  `idUtilizator1` int(11) NOT NULL,
  `idDepozit1` int(11) NOT NULL,
  `idUtilizator2` int(11) NOT NULL,
  `idDepozit2` int(11) NOT NULL,
  `suma` int(11) NOT NULL,
  `acceptata` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `tranzactie`
--

INSERT INTO `tranzactie` (`idTranzactie`, `idUtilizator1`, `idDepozit1`, `idUtilizator2`, `idDepozit2`, `suma`, `acceptata`) VALUES
(33, 33, 51, 34, 52, 100, 1),
(34, 33, 51, 34, 52, 100, 1);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `utilizator`
--

CREATE TABLE `utilizator` (
  `idUtilizator` int(11) NOT NULL,
  `nume` varchar(200) NOT NULL,
  `prenume` varchar(200) NOT NULL,
  `parola` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `utilizator`
--

INSERT INTO `utilizator` (`idUtilizator`, `nume`, `prenume`, `parola`) VALUES
(33, 'Popescu', 'Marcel', '1234'),
(34, 'Popescu', 'Mircea', '1234');

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `depozit`
--
ALTER TABLE `depozit`
  ADD PRIMARY KEY (`idDepozit`);

--
-- Indexuri pentru tabele `tranzactie`
--
ALTER TABLE `tranzactie`
  ADD PRIMARY KEY (`idTranzactie`);

--
-- Indexuri pentru tabele `utilizator`
--
ALTER TABLE `utilizator`
  ADD PRIMARY KEY (`idUtilizator`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `depozit`
--
ALTER TABLE `depozit`
  MODIFY `idDepozit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT pentru tabele `tranzactie`
--
ALTER TABLE `tranzactie`
  MODIFY `idTranzactie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT pentru tabele `utilizator`
--
ALTER TABLE `utilizator`
  MODIFY `idUtilizator` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
