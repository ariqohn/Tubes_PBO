-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2022 at 10:34 AM
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

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`username`, `password`) VALUES
('admin1', 'admin1'),
('admin10', 'admin10'),
('admin2', 'admin2'),
('admin3', 'admin3'),
('admin4', 'admin4'),
('admin5', 'admin5'),
('admin6', 'admin6'),
('admin7', 'admin7'),
('admin8', 'admin8'),
('admin9', 'admin9');

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

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`kode_dokter`, `nama_dokter`, `email_dokter`, `spesialis`) VALUES
('DRU01', 'dr. Surya Seftiawan Pratama', 'suryaseftiawanpratama@gmail.com', 'Umum'),
('DRU02', 'dr. Andreas Stevan', 'andreasstevan@gmail.com', 'Umum'),
('SPA01', 'dr. Hendra Widjaja, Sp.A', 'hendrawidjaja@gmail.com', 'Anak'),
('SPA02', 'dr. Elisa Iskandar, Sp.A', 'elisaiskandar@gmail.com', 'Anak'),
('SPG01', 'drg. Loviamanda', 'loviamanda@gmail.com', 'Gigi'),
('SPG02', 'drg. Finna Lianty', 'finnalianty@gmail.com', 'Gigi'),
('SPM01', 'dr. Dian Paramitasari, Sp.M', 'dianparamitasari@gmail.com', 'Mata'),
('SPP01', 'dr. Hendri Ongkojoyo S.Psi, M.Psi', 'hendriongkojoyo@gmail.com', 'Psikolog'),
('SPS01', 'dr. Devi Virnayanti, Sp.S', 'devivimayanti@gmail.com', 'Saraf'),
('SPS02', 'dr. Hendra Hardiansyah, Sp.S, M.Kes', 'hendrahardiansyah@gmail.com', 'Saraf');

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

--
-- Dumping data for table `farmasi`
--

INSERT INTO `farmasi` (`kode_obat`, `nama_obat`, `deskripsi_obat`, `kode_pasien`) VALUES
('OB01', 'Ibuprofen', 'Menurunkan demam', 'PAS01'),
('OB02', 'OBH Batuk', 'menurunkan gejala batuk dari ringan hingga sedang', 'PAS02'),
('OB03', 'Ponstan', 'meringankan nyeri pada area gigi', 'PAS03'),
('OB04', 'Chloramphenicol', 'obat antibiotik untuk mengatasi beragam infeksi bakteri serius, terutama saat penyakit infeksi tidak membaik dengan obat lain. Obat ini tersedia dalam bentuk tetes salep mata, tablet, kapsul, sirop, serta suntik.', 'PAS04'),
('OB05', 'Ultraflu', 'meringankan gejala demam, flu, dan batuk', 'PAS05'),
('OB06', 'antikoagulan', 'antikoagulan dalam manajemen stroke untuk pencegahan primer dan sekunder pada pasien dengan gangguan trombotik, seperti atrial fibrilasi. ', 'PAS06'),
('OB07', 'Sodium valproate', 'mengatasi gejala penyakit epilepsi dan mencegah kepala pusing pada anak dan orang dewasa', 'PAS07'),
('OB08', 'Kortikosteroid', 'mencegah dan mengatasi peradangan yang terjadi di saluran pernapasan.', 'PAS08'),
('OB09', 'Paracetamol', 'meredakan nyeri akibat kondisi tertentu, seperti demam, pusing, dan nyeri gigi berlubang', 'PAS09'),
('OB10', 'Escitalopram', 'Selective serotonin reuptake inhibitors (SSRIs) bekerja dengan cara menekan penyerapan kembali serotonin di dalam otak. efek sampingnya rendah', 'PAS10');

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

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`kode_pasien`, `keluhan`, `tgl_pendaftaran`, `dokter_rujukan`) VALUES
('PAS01', 'anak umur 8 tahun Demam tinggi, mual, muntah muntah', '2021-12-30', 'SPA01'),
('PAS02', 'Batuk-batuk selama seminggu', '2021-12-30', 'DRU01'),
('PAS03', 'Sakit pada area belakang gigi', '2021-12-30', 'SPG01'),
('PAS04', 'Sakit pada bagian mata, pusing serta mual', '2021-12-31', 'SPM01'),
('PAS05', 'Demam tinggi, flu berat selama 1 minggu', '2021-12-31', 'DRU02'),
('PAS06', 'mengalami stroke', '2021-12-31', 'SPS01'),
('PAS07', 'Mengalami epilepsi', '2022-01-01', 'SPS02'),
('PAS08', 'anak umur 12 tahun mengalami sesak nafas', '2022-01-01', 'SPA02'),
('PAS09', 'Gigi berlubang', '2022-01-01', 'SPG02'),
('PAS10', 'Depresi, stress berat', '2022-01-02', 'SPP01');

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

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`noPembayaran`, `jumlah_tagihan`, `deskripsi_pembayaran`, `metodePembayaran`) VALUES
(1, 50000, 'Biaya temu dan biaya obat Ibuprofen', 'cash'),
(2, 50000, 'Biaya temu dan biaya obat OBH batuk', 'cash'),
(3, 100000, 'Biaya temu dan biaya obat Ponstan', 'cash'),
(4, 100000, 'Biaya temu dan biaya obat Chloramphenicol', 'debit'),
(5, 50000, 'Biaya temu dan biaya obat ultraflu', 'debit'),
(6, 350000, 'Biaya temu dan biaya obat antikoagulan', 'debit'),
(7, 200000, 'Biaya temu dan biaya obat sodium valproate', 'BPJS'),
(8, 200000, 'Biaya temu dan biaya obat kortikosteroid', 'BPJS'),
(9, 50000, 'Biaya temu dan biaya obat paracetamol', 'cash'),
(10, 300000, 'Biaya temu dan biaya obat antidepresan', 'debit');

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
  `kode_dokter` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `terapi_kimia`
--

INSERT INTO `terapi_kimia` (`kode_terapi`, `nama_terapi`, `deskripsi_terapi`, `kode_dokter`) VALUES
('TK01', 'Diathermy', 'Diathermy merupakan jenis terapi dengan menggunakan panas yang dialirkan melalui arus elektromagnetik berfrekuensi tinggi untuk menyembuhkan berbagai kondisi.', 'SPS01'),
('TK02', 'Ultrasound', 'Ultrasound terapeutik membantu menurunkan peradangan dengan mendorong panas ke daerah yang cedera sehingga menyembuhkan kejang otot, meningkatkan metabolisme, dan meningkatkan aliran darah ke jaringan yang rusak.', 'SPS01'),
('TK03', 'phonophoresis', 'phonophoresis adalah teknik yang memanfaatkan gelombang ultrasonik untuk membantu penyerapan obat oles secara maksimal.', 'SPS01'),
('TK04', 'Kemoterapi', 'Kemoterapi atau kemo bekerja dengan cara menghentikan pertumbuhan sel kanker yang bersarang di dalam tubuh. Meski pengobatan ini dapat membantu mengatasi penyakit kanker, kemoterapi juga memiliki efek samping yang tidak sedikit.', 'SPS02'),
('TK05', 'Long-acting beta ago', 'Pengobatan asma yang termasuk ke dalam kategori long-acting beta agonist adalah bronkodilator. Bronkodilator adalah terapi menggunakan obat-obatan untuk meningkatkan kapasitas paru dalam menyerap oksigen. Dengan begitu Anda bisa bernapas lebih lancar dan lega.', 'SPA01');

-- --------------------------------------------------------

--
-- Table structure for table `terapi_psikologis`
--

CREATE TABLE `terapi_psikologis` (
  `kode_terapi` varchar(20) NOT NULL,
  `nama_terapi` varchar(20) NOT NULL,
  `deskripsi_terapi` text NOT NULL,
  `kode_dokter` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `terapi_psikologis`
--

INSERT INTO `terapi_psikologis` (`kode_terapi`, `nama_terapi`, `deskripsi_terapi`, `kode_dokter`) VALUES
('TP01', 'Terapi perilaku kogn', 'Terapi perilaku kognitif bertujuan untuk mengevaluasi pola pikir, emosi, dan perilaku yang menjadi sumber masalah dalam kehidupan pasien. Setelah itu, dokter atau psikolog akan melatih pasien untuk merespon sumber masalah tersebut dengan cara yang positif.', 'SPP01'),
('TP02', 'Terapi psikoanalitik', 'Jenis psikoterapi ini akan menuntun pasien melihat lebih dalam ke alam bawah sadarnya. Pasien akan diajak untuk menggali berbagai kejadian atau masalah yang selama ini terpendam dan tidak disadari.', 'SPP01'),
('TP03', 'Terapi interpersonal', 'Jenis psikoterapi ini akan menuntun pasien untuk mengevaluasi dan memahami bagaimana cara pasien menjalin hubungan dengan orang lain, misalnya keluarga, pasangan, sahabat, atau rekan kerja. Terapi ini akan membantu pasien menjadi lebih peka saat berinteraksi atau menyelesaikan konflik dengan orang lain.', 'SPP01'),
('TP04', 'Terapi keluarga', 'Terapi ini dilakukan dengan melibatkan anggota keluarga pasien, khususnya jika pasien memiliki masalah psikologis yang berhubungan dengan masalah keluarga. Tujuannya agar masalah yang dihadapi pasien dapat diatasi bersama dan memperbaiki hubungan yang sempat retak antara pasien dan keluarga.', 'SPP01'),
('TP05', 'Hipnoterapi', 'Hipnoterapi adalah teknik psikoterapi yang memanfaatkan hipnosis untuk membantu pasien agar bisa mengendalikan perilaku, emosi, atau pola pikirnya dengan lebih baik.', 'SPP01');

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
  ADD KEY `kode_terapi` (`kode_terapi`,`kode_dokter`);

--
-- Indexes for table `terapi_psikologis`
--
ALTER TABLE `terapi_psikologis`
  ADD KEY `kode_terapi` (`kode_terapi`,`kode_dokter`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `noPembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
