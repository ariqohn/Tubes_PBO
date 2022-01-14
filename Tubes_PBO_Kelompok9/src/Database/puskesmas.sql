-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2022 at 01:31 PM
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
-- Database: `puskesmas`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama_admin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`username`, `password`, `nama_admin`) VALUES
('admin1', 'admin1', 'Anton'),
('admin10', 'admin10', 'Budi'),
('admin2', 'admin2', 'Caca'),
('admin3', 'admin3', 'Didan'),
('admin4', 'admin4', 'Eko'),
('admin5', 'admin5', 'Fakhri'),
('admin6', 'admin6', 'Gilang'),
('admin7', 'admin7', 'Hendra'),
('admin8', 'admin8', 'Ika'),
('admin9', 'admin9', 'Jono');

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
('SPP01', 'dr. Hendri Ongkojoyo', 'hendriongkojoyo@gmail.com', 'psikologis'),
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
  `kode_pasien` varchar(20) NOT NULL,
  `harga_obat` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `farmasi`
--

INSERT INTO `farmasi` (`kode_obat`, `nama_obat`, `deskripsi_obat`, `kode_pasien`, `harga_obat`) VALUES
('OB01', 'Ibuprofen', 'Menurunkan demam', 'PAS01', 50000),
('OB02', 'OBH Batuk', 'menurunkan gejala batuk dari ringan hingga sedang', 'PAS02', 50000),
('OB03', 'Ponstan', 'meringankan nyeri pada area gigi', 'PAS03', 100000),
('OB04', 'Chloramphenicol', 'obat antibiotik untuk mengatasi beragam infeksi bakteri serius, terutama saat penyakit infeksi tidak membaik dengan obat lain. Obat ini tersedia dalam bentuk tetes salep mata, tablet, kapsul, sirop, serta suntik.', 'PAS04', 100000),
('OB05', 'Ultraflu', 'meringankan gejala demam, flu, dan batuk', 'PAS05', 50000),
('OB06', 'antikoagulan', 'antikoagulan dalam manajemen stroke untuk pencegahan primer dan sekunder pada pasien dengan gangguan trombotik, seperti atrial fibrilasi. ', 'PAS06', 350000),
('OB07', 'Sodium valproate', 'mengatasi gejala penyakit epilepsi dan mencegah kepala pusing pada anak dan orang dewasa', 'PAS07', 250000),
('OB08', 'Kortikosteroid', 'mencegah dan mengatasi peradangan yang terjadi di saluran pernapasan.', 'PAS08', 200000),
('OB09', 'Paracetamol', 'meredakan nyeri akibat kondisi tertentu, seperti demam, pusing, dan nyeri gigi berlubang', 'PAS09', 50000),
('OB10', 'Antidepresan', 'menyeimbangkan kandungan senyawa kimia alami di dalam otak yang disebut neurotransmitter, sehingga bisa meredakan keluhan dan membantu memperbaiki suasana hati dan emosi.', 'PAS10', 250000);

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `kode_pasien` varchar(20) NOT NULL,
  `nama_pasien` varchar(50) NOT NULL,
  `keluhan` text NOT NULL,
  `tgl_pendaftaran` date NOT NULL,
  `dokter_rujukan` varchar(20) NOT NULL,
  `noPembayaran` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`kode_pasien`, `nama_pasien`, `keluhan`, `tgl_pendaftaran`, `dokter_rujukan`, `noPembayaran`) VALUES
('PAS01', 'Abizar', 'anak umur 8 tahun Demam tinggi, mual, muntah muntah', '2021-12-30', 'SPA01', 1),
('PAS02', 'Bagus', 'Batuk-batuk selama seminggu', '2021-12-30', 'DRU01', 2),
('PAS03', 'Clarine', 'Sakit pada area belakang gigi', '2021-12-30', 'SPG01', 3),
('PAS04', 'Diva', 'Sakit pada bagian mata, pusing serta mual', '2021-12-31', 'SPM01', 4),
('PAS05', 'Erlangga', 'Demam tinggi, flu berat selama 1 minggu', '2021-12-31', 'DRU02', 5),
('PAS06', 'Farrel', 'mengalami stroke', '2021-12-31', 'SPS01', 6),
('PAS07', 'Gio', 'Mengalami epilepsi', '2022-01-01', 'SPS02', 7),
('PAS08', 'Hasan', 'anak umur 12 tahun mengalami sesak nafas', '2022-01-01', 'SPA02', 8),
('PAS09', 'Intan', 'Gigi berlubang', '2022-01-01', 'SPG02', 9),
('PAS10', 'Januar', 'susah tidur, depresi', '2022-01-02', 'SPP01', 10);

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
(10, 250000, 'Biaya temu dan biaya obat antidepresan', 'debit');

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

--
-- Dumping data for table `rekam_medik`
--

INSERT INTO `rekam_medik` (`kode_terapi`, `nama_terapi`, `deskripsi_terapi`, `kode_dokter`, `kode_pasien`) VALUES
('', '', '', 'SPA01', 'PAS01'),
('', '', '', 'DRU01', 'PAS02'),
('', '', '', 'SPG01', 'PAS03'),
('', '', '', 'SPM01', 'PAS04'),
('', '', '', 'DRU02', 'PAS05'),
('TK02', 'Ultrasound', 'menurunkan peradangan dengan mendorong panas ke daerah yang cedera sehingga menyembuhkan kejang otot, meningkatkan metabolisme, dan meningkatkan aliran darah ke jaringan yang rusak.', 'SPS01', 'PAS06'),
('', '', '', 'SPS02', 'PAS07'),
('', '', '', 'SPA02', 'PAS08'),
('', '', '', 'SPG02', 'PAS09'),
('TP05', 'Hipnoterapi', 'hipnosis untuk membantu pasien agar bisa mengendalikan perilaku, emosi, atau pola pikirnya dengan lebih baik.', 'SPP01', 'PAS10');

-- --------------------------------------------------------

--
-- Table structure for table `terapi`
--

CREATE TABLE `terapi` (
  `kode_terapi` varchar(20) NOT NULL,
  `jenis_terapi` varchar(20) NOT NULL,
  `jenis_penyakit` varchar(20) NOT NULL,
  `deskripsi_penyakit` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `terapi`
--

INSERT INTO `terapi` (`kode_terapi`, `jenis_terapi`, `jenis_penyakit`, `deskripsi_penyakit`) VALUES
('TK01', 'Kimia', 'Kolagen', 'kumpulan penyakit jaringan ikat yang disebabkan oleh kelainan kolagen seperti persendian, pembuluh darah, dan otot.'),
('TK02', 'Kimia', 'Cedera muskuloskelet', 'cedera pada otot maupun sendi'),
('TK03', 'Kimia', 'Cedera otot', 'Cedera pada otot,sendi, ligamen, atau bagian lain dari sistem muskuloskeletal'),
('TK04', 'Kimia', 'Kanker', 'Kanker adalah penyakit yang terjadi akibat pertumbuhan sel-sel abnormal yang tidak terkendali, menyebabkan jaringan tubuh normal rusak'),
('TK05', 'Kimia', 'Asma', 'Asma adalah suatu kelainan berupa peradangan kronik saluran napas yang menyebabkan penyempitan saluran napas (hiperaktifitas bronkus) sehingga menyebabkan gejala episodik berulang berupa mengi, sesak napas, dada terasa berat, dan batuk terutama pada malam atau dini hari'),
('TP01', 'Psikologis', 'stress ringan', 'pola pkir, emosi, dan perilaku yang tidak stabil'),
('TP02', 'Psikologis', 'Psikis internal', 'memendam terlalu banyak masalah yang tidak disadari'),
('TP03', 'Psikologis', 'psikis relations', 'gangguan psikis akibat masalah dalam hubungan/interaksi dengan orang lain'),
('TP04', 'Psikologis', 'psikis family', 'gangguan psikis akibat masalah dalam keluarga'),
('TP05', 'Psikologis', 'Depresi', 'gangguan kecemasan, masalah konsentrasi, upaya berhenti merokok, dll.');

-- --------------------------------------------------------

--
-- Table structure for table `terapi_kimia`
--

CREATE TABLE `terapi_kimia` (
  `kode_terapi` varchar(20) NOT NULL,
  `nama_terapi` varchar(20) NOT NULL,
  `deskripsi_terapi` text NOT NULL,
  `kode_dokter` varchar(20) NOT NULL,
  `biaya_terapi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `terapi_kimia`
--

INSERT INTO `terapi_kimia` (`kode_terapi`, `nama_terapi`, `deskripsi_terapi`, `kode_dokter`, `biaya_terapi`) VALUES
('TK01', 'Diathermy', 'Diathermy merupakan jenis terapi dengan menggunakan panas yang dialirkan melalui arus elektromagnetik berfrekuensi tinggi untuk menyembuhkan berbagai kondisi.', 'SPS01', 5000000),
('TK02', 'Ultrasound', 'Ultrasound terapeutik membantu menurunkan peradangan dengan mendorong panas ke daerah yang cedera sehingga menyembuhkan kejang otot, meningkatkan metabolisme, dan meningkatkan aliran darah ke jaringan yang rusak.', 'SPS01', 5000000),
('TK03', 'phonophoresis', 'phonophoresis adalah teknik yang memanfaatkan gelombang ultrasonik untuk membantu penyerapan obat oles secara maksimal.', 'SPS01', 5000000),
('TK04', 'Kemoterapi', 'Kemoterapi atau kemo bekerja dengan cara menghentikan pertumbuhan sel kanker yang bersarang di dalam tubuh. Meski pengobatan ini dapat membantu mengatasi penyakit kanker, kemoterapi juga memiliki efek samping yang tidak sedikit.', 'SPS02', 10000000),
('TK05', 'Long-acting beta ago', 'Pengobatan asma yang termasuk ke dalam kategori long-acting beta agonist adalah bronkodilator. Bronkodilator adalah terapi menggunakan obat-obatan untuk meningkatkan kapasitas paru dalam menyerap oksigen. Dengan begitu Anda bisa bernapas lebih lancar dan lega.', 'SPA01', 5000000);

-- --------------------------------------------------------

--
-- Table structure for table `terapi_psikologis`
--

CREATE TABLE `terapi_psikologis` (
  `kode_terapi` varchar(20) NOT NULL,
  `nama_terapi` varchar(20) NOT NULL,
  `deskripsi_terapi` text NOT NULL,
  `kode_dokter` varchar(20) NOT NULL,
  `biaya_terapi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `terapi_psikologis`
--

INSERT INTO `terapi_psikologis` (`kode_terapi`, `nama_terapi`, `deskripsi_terapi`, `kode_dokter`, `biaya_terapi`) VALUES
('TP01', 'Terapi perilaku kogn', 'Terapi perilaku kognitif bertujuan untuk mengevaluasi pola pikir, emosi, dan perilaku yang menjadi sumber masalah dalam kehidupan pasien. Setelah itu, dokter atau psikolog akan melatih pasien untuk merespon sumber masalah tersebut dengan cara yang positif.', 'SPP01', 1000000),
('TP02', 'Terapi psikoanalitik', 'Jenis psikoterapi ini akan menuntun pasien melihat lebih dalam ke alam bawah sadarnya. Pasien akan diajak untuk menggali berbagai kejadian atau masalah yang selama ini terpendam dan tidak disadari.', 'SPP01', 1000000),
('TP03', 'Terapi interpersonal', 'Jenis psikoterapi ini akan menuntun pasien untuk mengevaluasi dan memahami bagaimana cara pasien menjalin hubungan dengan orang lain, misalnya keluarga, pasangan, sahabat, atau rekan kerja. Terapi ini akan membantu pasien menjadi lebih peka saat berinteraksi atau menyelesaikan konflik dengan orang lain.', 'SPP01', 1000000),
('TP04', 'Terapi keluarga', 'Terapi ini dilakukan dengan melibatkan anggota keluarga pasien, khususnya jika pasien memiliki masalah psikologis yang berhubungan dengan masalah keluarga. Tujuannya agar masalah yang dihadapi pasien dapat diatasi bersama dan memperbaiki hubungan yang sempat retak antara pasien dan keluarga.', 'SPP01', 1000000),
('TP05', 'Hipnoterapi', 'Hipnoterapi adalah teknik psikoterapi yang memanfaatkan hipnosis untuk membantu pasien agar bisa mengendalikan perilaku, emosi, atau pola pikirnya dengan lebih baik.', 'SPP01', 1000000);

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
  ADD PRIMARY KEY (`kode_pasien`),
  ADD KEY `noPembayaran` (`noPembayaran`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`noPembayaran`);

--
-- Indexes for table `rekam_medik`
--
ALTER TABLE `rekam_medik`
  ADD KEY `kode_dokter` (`kode_dokter`,`kode_pasien`),
  ADD KEY `kode_pasien` (`kode_pasien`);

--
-- Indexes for table `terapi`
--
ALTER TABLE `terapi`
  ADD PRIMARY KEY (`kode_terapi`);

--
-- Indexes for table `terapi_kimia`
--
ALTER TABLE `terapi_kimia`
  ADD KEY `kode_terapi` (`kode_terapi`,`kode_dokter`),
  ADD KEY `kode_dokter` (`kode_dokter`);

--
-- Indexes for table `terapi_psikologis`
--
ALTER TABLE `terapi_psikologis`
  ADD KEY `kode_terapi` (`kode_terapi`,`kode_dokter`),
  ADD KEY `kode_dokter` (`kode_dokter`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `noPembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `farmasi`
--
ALTER TABLE `farmasi`
  ADD CONSTRAINT `farmasi_ibfk_1` FOREIGN KEY (`kode_pasien`) REFERENCES `pasien` (`kode_pasien`);

--
-- Constraints for table `pasien`
--
ALTER TABLE `pasien`
  ADD CONSTRAINT `pasien_ibfk_1` FOREIGN KEY (`noPembayaran`) REFERENCES `payment` (`noPembayaran`);

--
-- Constraints for table `rekam_medik`
--
ALTER TABLE `rekam_medik`
  ADD CONSTRAINT `rekam_medik_ibfk_1` FOREIGN KEY (`kode_pasien`) REFERENCES `pasien` (`kode_pasien`),
  ADD CONSTRAINT `rekam_medik_ibfk_2` FOREIGN KEY (`kode_dokter`) REFERENCES `dokter` (`kode_dokter`);

--
-- Constraints for table `terapi_kimia`
--
ALTER TABLE `terapi_kimia`
  ADD CONSTRAINT `terapi_kimia_ibfk_1` FOREIGN KEY (`kode_dokter`) REFERENCES `dokter` (`kode_dokter`),
  ADD CONSTRAINT `terapi_kimia_ibfk_2` FOREIGN KEY (`kode_terapi`) REFERENCES `terapi` (`kode_terapi`);

--
-- Constraints for table `terapi_psikologis`
--
ALTER TABLE `terapi_psikologis`
  ADD CONSTRAINT `terapi_psikologis_ibfk_1` FOREIGN KEY (`kode_dokter`) REFERENCES `dokter` (`kode_dokter`),
  ADD CONSTRAINT `terapi_psikologis_ibfk_2` FOREIGN KEY (`kode_terapi`) REFERENCES `terapi` (`kode_terapi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
