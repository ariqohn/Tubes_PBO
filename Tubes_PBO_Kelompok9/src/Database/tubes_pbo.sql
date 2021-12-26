-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2021 at 04:24 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubes_pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `kode_dokter` varchar(20) NOT NULL,
  `nama_dokter` varchar(50) NOT NULL,
  `email_dokter` varchar(50) NOT NULL,
  `spesialis` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `farmasi`
--

CREATE TABLE `farmasi` (
  `kode_obat` varchar(20) NOT NULL,
  `nama_obat` varchar(50) NOT NULL,
  `deskripsi_obat` text NOT NULL,
  `kode_pasien` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `kode_pasien` varchar(20) NOT NULL,
  `keluhan` text NOT NULL,
  `tgl_pendaftaran` date NOT NULL,
  `dokter_rujukan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `noPembayaran` int(11) NOT NULL,
  `jumlah_tagihan` int(11) NOT NULL,
  `deskripsi_pembayaran` varchar(50) NOT NULL,
  `metodePembayaran` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rekam_medik`
--

CREATE TABLE `rekam_medik` (
  `kode_terapi` varchar(20) NOT NULL,
  `nama_terapi` varchar(20) NOT NULL,
  `deskripsi_terapi` text NOT NULL,
  `kode_dokter` varchar(20) NOT NULL,
  `kode_pasien` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `terapi`
--

CREATE TABLE `terapi` (
  `jenis_terapi` varchar(20) NOT NULL,
  `jenis_penyakit` varchar(20) NOT NULL,
  `deskripsi_penyakit` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `terapi_kimia`
--

CREATE TABLE `terapi_kimia` (
  `kode_terapi` varchar(20) NOT NULL,
  `nama_terapi` varchar(20) NOT NULL,
  `deskripsi_terapi` text NOT NULL,
  `kode_dokter` varchar(20) NOT NULL,
  `kode_pasien` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `terapi_psikologis`
--

CREATE TABLE `terapi_psikologis` (
  `kode_terapi` varchar(20) NOT NULL,
  `nama_terapi` varchar(20) NOT NULL,
  `deskripsi_terapi` text NOT NULL,
  `kode_dokter` varchar(20) NOT NULL,
  `kode_pasien` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`kode_dokter`);

--
-- Indexes for table `farmasi`
--
ALTER TABLE `farmasi`
  ADD PRIMARY KEY (`kode_obat`),
  ADD KEY `kode_pasien` (`kode_pasien`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`kode_pasien`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`noPembayaran`);

--
-- Indexes for table `rekam_medik`
--
ALTER TABLE `rekam_medik`
  ADD PRIMARY KEY (`kode_terapi`),
  ADD KEY `kode_dokter` (`kode_dokter`,`kode_pasien`);

--
-- Indexes for table `terapi`
--
ALTER TABLE `terapi`
  ADD PRIMARY KEY (`jenis_terapi`);

--
-- Indexes for table `terapi_kimia`
--
ALTER TABLE `terapi_kimia`
  ADD KEY `kode_terapi` (`kode_terapi`,`kode_dokter`,`kode_pasien`);

--
-- Indexes for table `terapi_psikologis`
--
ALTER TABLE `terapi_psikologis`
  ADD KEY `kode_terapi` (`kode_terapi`,`kode_dokter`,`kode_pasien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `noPembayaran` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
