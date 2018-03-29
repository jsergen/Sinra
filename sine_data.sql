-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Anamakine: localhost
-- Üretim Zamanı: 30 Mar 2018, 00:33:12
-- Sunucu sürümü: 5.7.21-0ubuntu0.16.04.1
-- PHP Sürümü: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `sine_data`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `filmler`
--

CREATE TABLE `filmler` (
  `film_id` int(11) NOT NULL,
  `film_ad` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `yonetmen` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `yazar` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `tur` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `sure` int(5) NOT NULL,
  `yas_siniri` varchar(3) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `filmler`
--

INSERT INTO `filmler` (`film_id`, `film_ad`, `yonetmen`, `yazar`, `tur`, `sure`, `yas_siniri`) VALUES
(1, '12 Angry Men', 'Sidney Lumet', 'Reginald Rose', 'Suç, Dram', 96, '+7'),
(2, 'Ernest&Celestine', 'Stephane Aubier', 'Daniel Pennac', 'Animasyon, Macera, Komedi', 80, 'PG'),
(3, 'Batman Begins', 'Christopher Nolan', 'Bob Kane', 'Aksiyon, Macera', 140, '+13'),
(4, 'Yüzüklerin Efendisi: Yüzük Kardeşliği', 'Peter Jackson', 'J.R.R Tolkien', 'Fantastik, Macera, Drama', 178, '+13'),
(5, 'BVS', 'Zack', 'Chris', 'Süper Hero', 151, '+13'),
(6, 'Moonrise Kingdom', 'Wes Anderson', 'Wes Anderson', 'Komedi, Drama, Macera', 94, '+13');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici`
--

CREATE TABLE `kullanici` (
  `kullanici_id` int(11) NOT NULL,
  `kullanici_ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `kullanici_sifre` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `kayit_tarihi` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `kullanici_durum` enum('1','0') COLLATE utf8_turkish_ci NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `kullanici`
--

INSERT INTO `kullanici` (`kullanici_id`, `kullanici_ad`, `kullanici_sifre`, `kayit_tarihi`, `kullanici_durum`) VALUES
(1, 'farad', '123', '2018-03-27 17:05:12', '1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yorumlar`
--

CREATE TABLE `yorumlar` (
  `yorum_id` int(11) NOT NULL,
  `kullanici_idS` int(11) NOT NULL,
  `film_idS` int(11) NOT NULL,
  `yorum` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `yorumlar`
--

INSERT INTO `yorumlar` (`yorum_id`, `kullanici_idS`, `film_idS`, `yorum`) VALUES
(1, 1, 4, 'degişik');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `filmler`
--
ALTER TABLE `filmler`
  ADD PRIMARY KEY (`film_id`);

--
-- Tablo için indeksler `kullanici`
--
ALTER TABLE `kullanici`
  ADD PRIMARY KEY (`kullanici_id`);

--
-- Tablo için indeksler `yorumlar`
--
ALTER TABLE `yorumlar`
  ADD PRIMARY KEY (`yorum_id`),
  ADD KEY `kullanici_id` (`kullanici_idS`),
  ADD KEY `film_id` (`film_idS`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `filmler`
--
ALTER TABLE `filmler`
  MODIFY `film_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Tablo için AUTO_INCREMENT değeri `kullanici`
--
ALTER TABLE `kullanici`
  MODIFY `kullanici_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `yorumlar`
--
ALTER TABLE `yorumlar`
  MODIFY `yorum_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `yorumlar`
--
ALTER TABLE `yorumlar`
  ADD CONSTRAINT `yorumlar_ibfk_1` FOREIGN KEY (`kullanici_idS`) REFERENCES `kullanici` (`kullanici_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `yorumlar_ibfk_2` FOREIGN KEY (`film_idS`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
