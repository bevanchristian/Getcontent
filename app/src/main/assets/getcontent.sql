-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Des 2020 pada 03.40
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `getcontent`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `paket_vendor`
--

CREATE TABLE `paket_vendor` (
  `id_paketvendor` varchar(45) NOT NULL,
  `id_vendor` varchar(45) NOT NULL,
  `nama_paket` varchar(45) NOT NULL,
  `deskripsi_paket` text NOT NULL,
  `harga` varchar(45) NOT NULL,
  `foto_paket` varchar(45) NOT NULL,
  `id_promo` varchar(45) NOT NULL,
  `harga_diskon` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `paket_vendor`
--

INSERT INTO `paket_vendor` (`id_paketvendor`, `id_vendor`, `nama_paket`, `deskripsi_paket`, `harga`, `foto_paket`, `id_promo`, `harga_diskon`) VALUES
('pv1', 'v1', 'Silver', 'Silver: 15 konten IG feeds + 5 konten IG story  (bisa by request jumlah konten IG feeds atau IG storynya, total 20 konten)\r\n\r\nFree konsultasi\r\n\r\nFree revisi maksimum 2 kali\r\n', '650000', 'https://drive.google.com/file/d/1MQymld_MI8Jd', 'pm1', '630000'),
('pv2', 'v1', 'Gold', 'Gold: 30 konten IG feeds + 5 konten IG story 1jt (juga bisa by request)\r\n\r\nFree konsultasi\r\n\r\nFree revisi maksimum 2 kali\r\n', '1000000', 'https://drive.google.com/file/d/1OPprtpi4GHZ0', 'pm1', '980000'),
('pv3', 'v1', 'Photoshoot', 'Photoshoot: 15 foto produk yang sudah diedit bagus dan berkualitas,sekali datang \r\n\r\nFree konsultasi\r\n\r\nFree revisi maksimum 2 kali\r\n\r\nPhotographer akan datang ke tempat anda daerah surabaya\r\n', '500000', 'https://drive.google.com/file/d/1s4VpM2YCbGYw', 'pm1', '480000'),
('pv4', 'v1', 'Videoshoot', 'Videoshoot: video 1 menit yang sudah diedit bagus dan berkualitas \r\n\r\nFree konsultasi\r\n\r\nFree revisi maksimum 2 kali\r\n\r\nVideographer akan datang ke tempat anda daerah surabaya\r\n', '500000', 'https://drive.google.com/file/d/1tDuB5wmHrFJR', 'pm1', '480000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `paket_vendor_projek`
--

CREATE TABLE `paket_vendor_projek` (
  `id_projek` varchar(45) NOT NULL,
  `id_paketvendor` varchar(45) NOT NULL,
  `foto` varchar(45) NOT NULL,
  `deskripsi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `portofolio`
--

CREATE TABLE `portofolio` (
  `id_portofolio` varchar(45) NOT NULL,
  `id_vendor` varchar(45) NOT NULL,
  `nama_portofolio` varchar(45) NOT NULL,
  `foto_portofolio` varchar(45) NOT NULL,
  `deskripsi_portofolio` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `portofolio`
--

INSERT INTO `portofolio` (`id_portofolio`, `id_vendor`, `nama_portofolio`, `foto_portofolio`, `deskripsi_portofolio`) VALUES
('p1', 'v1', 'Kopi sejati', 'https://drive.google.com/file/d/1ZRH357btV7Gk', 'Photoshoot produk Kopi sejati'),
('p2', 'v1', 'Kopi sejati 2', 'https://drive.google.com/file/d/1AWn0k4Zhzqak', 'Photoshoot produk Kopi sejati '),
('p3', 'v1', 'Cream puff', 'https://drive.google.com/file/d/1aNwDbW3C-AhA', 'Photoshoot produk cream puff'),
('p4', 'v1', 'Konten grafis corona', 'https://drive.google.com/file/d/1SPycsGgAcJsk', 'Konten grafis mengenai bahaya corona'),
('p5', 'v1', 'Konten grafis hari Kartini', 'https://drive.google.com/file/d/1KZ9VqjcBsf0g', 'Konten grafis mengingat hari Kartini');

-- --------------------------------------------------------

--
-- Struktur dari tabel `promo`
--

CREATE TABLE `promo` (
  `id_promo` varchar(45) NOT NULL,
  `nama_promo` varchar(45) NOT NULL,
  `deskripsi_promo` text NOT NULL,
  `tanggal_promo` varchar(45) NOT NULL,
  `syarat_ketentuan` text NOT NULL,
  `gambar_promo` varchar(45) NOT NULL,
  `besar_potongan` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `promo`
--

INSERT INTO `promo` (`id_promo`, `nama_promo`, `deskripsi_promo`, `tanggal_promo`, `syarat_ketentuan`, `gambar_promo`, `besar_potongan`) VALUES
('pm1', 'GrandLaunching', 'Dapatkan Diskon 10% untuk setiap pembelian paket tanpa minimum harga', '1 Desember 2020 - 31 Desember 2020', '1. Produk yang dikenakan diskon khusus paket yang berada di app Getcontent  2.Getcontent tidak bertanggung jawab jika konten yang dihasilkan tidak sesuai ekspetasi  3.Promo hanya berlaku hingga 23.59 31 Desember 2020 ', 'https://drive.google.com/file/d/1Juqwcduz8b_h', '20000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `vendor`
--

CREATE TABLE `vendor` (
  `id_vendor` varchar(45) NOT NULL,
  `nama_vendor` varchar(45) NOT NULL,
  `deskripsi_vendor` text NOT NULL,
  `foto_profil_vendor` varchar(45) NOT NULL,
  `bintang` varchar(45) NOT NULL,
  `no_telp` varchar(45) NOT NULL,
  `fotobanner` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `vendor`
--

INSERT INTO `vendor` (`id_vendor`, `nama_vendor`, `deskripsi_vendor`, `foto_profil_vendor`, `bintang`, `no_telp`, `fotobanner`) VALUES
('v1', 'march_media', 'Sebuah Photoshoot dan Videography agency yang berada di surabaya dan sudah berpengalaman selama 5 tahun', 'https://drive.google.com/file/d/1F65tTe_TkhmD', '5', '082225556088', 'https://drive.google.com/file/d/1aNwDbW3C-AhA');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `paket_vendor`
--
ALTER TABLE `paket_vendor`
  ADD PRIMARY KEY (`id_paketvendor`),
  ADD KEY `FK_paket_vendor_1` (`id_vendor`),
  ADD KEY `FK_paket_vendor_2` (`id_promo`);

--
-- Indeks untuk tabel `paket_vendor_projek`
--
ALTER TABLE `paket_vendor_projek`
  ADD PRIMARY KEY (`id_paketvendor`);

--
-- Indeks untuk tabel `portofolio`
--
ALTER TABLE `portofolio`
  ADD PRIMARY KEY (`id_portofolio`),
  ADD KEY `FK_portofolio_1` (`id_vendor`);

--
-- Indeks untuk tabel `promo`
--
ALTER TABLE `promo`
  ADD PRIMARY KEY (`id_promo`);

--
-- Indeks untuk tabel `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id_vendor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
