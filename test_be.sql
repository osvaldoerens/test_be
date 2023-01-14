-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2023 at 09:48 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test_be`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(3);

-- --------------------------------------------------------

--
-- Table structure for table `login_model`
--

CREATE TABLE `login_model` (
  `id_user` bigint(20) NOT NULL,
  `acces_token` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` bigint(20) NOT NULL,
  `acces_token` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `acces_token`, `created_at`, `password_hash`, `updated_at`, `username`) VALUES
(1, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJPc3ZhbGRvIiwiZXhwIjoxNjczNjk4ODM4LCJpYXQiOjE2NzM2ODA4Mzh9.k5PIEDzjzCq6qAtKRbXvxxEWbO1x7KQuA7OwFUYJLBywLu5t3RDt3MMk2Kd8bEBIxDZz1TzSr-i0bjtbi1FXNw', '2023-01-14 11:58:51', '161ebd7d45089b3446ee4e0d86dbcf92', '2023-01-14 14:20:38', 'Osvaldo'),
(2, NULL, '2023-01-14 12:03:37', '161ebd7d45089b3446ee4e0d86dbcf92', '2023-01-14 12:03:37', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_model`
--
ALTER TABLE `login_model`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `UK_4ht2e0h9d86vf7paryo6akdnp` (`acces_token`) USING HASH,
  ADD UNIQUE KEY `UK_rfkdmkv0nyifsyq3ucv89i2jn` (`username`) USING HASH;

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `UK_9g6twa8nf670dj14oit322ad8` (`acces_token`) USING HASH,
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`) USING HASH;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
