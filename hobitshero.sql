-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 09 أغسطس 2023 الساعة 17:45
-- إصدار الخادم: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hobitshero`
--

-- --------------------------------------------------------

--
-- بنية الجدول `goals`
--

CREATE TABLE `goals` (
  `id` int NOT NULL,
  `name` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `start_date` varchar(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- إرجاع أو استيراد بيانات الجدول `goals`
--

INSERT INTO `goals` (`id`, `name`, `start_date`, `created_at`) VALUES
(21, '32', '2023-05-23', '2023-05-23 08:06:01'),
(22, '88', '2023-05-28', '2023-05-23 08:06:07'),
(23, '3', '2023-05-23', '2023-05-23 08:09:37'),
(24, '3', '2023-05-01', '2023-05-23 08:12:59'),
(25, 'انهاء اختبار فاينل', '2023-05-23', '2023-05-23 08:20:30'),
(26, 'تخرج من الجامعة', '2025-05-23', '2023-05-23 09:31:09'),
(27, 'Math final 002', '2023-05-31', '2023-05-24 20:22:13'),
(28, 'Java Final', '2023-05-30', '2023-05-24 20:22:25'),
(29, 'ENG final', '2023-06-01', '2023-05-24 20:22:38'),
(30, 'GDMC final', '2023-06-07', '2023-05-24 20:22:47'),
(31, 'Ethics Final', '2023-06-04', '2023-05-24 20:23:10'),
(32, 'انهاء السنة الثانية في الجامعة', '2024-06-01', '2023-07-14 22:08:14');

-- --------------------------------------------------------

--
-- بنية الجدول `tasks`
--

CREATE TABLE `tasks` (
  `id` int NOT NULL,
  `name` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `start_date` varchar(11) NOT NULL,
  `time` int NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- إرجاع أو استيراد بيانات الجدول `tasks`
--

INSERT INTO `tasks` (`id`, `name`, `description`, `start_date`, `time`, `status`, `created_at`) VALUES
(55, 'ناصر', 'ناصر تجربة', '2023-05-15', 3, 1, '2023-05-21 07:12:22'),
(63, '3', '3', '2023-05-18', 3, 0, '2023-05-23 07:49:15'),
(64, '3', '3', '2023-05-18', 3, 0, '2023-05-23 07:49:15'),
(68, '42', '42', '2023-05-24', 4, 0, '2023-05-23 07:56:03'),
(69, 'انهاء بحث علمي', 'مادة GDMC', '2023-05-22', 1, 1, '2023-05-23 08:19:39'),
(70, '3', '3', '2023-05-22', 1, 1, '2023-05-23 08:24:42'),
(71, 'final exam', 'test', '2023-05-23', 1, 1, '2023-05-23 09:28:16'),
(73, 'انهاء واجب', '01032', '2023-07-15', 1, 1, '2023-07-14 22:09:30');

-- --------------------------------------------------------

--
-- بنية الجدول `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `username` varchar(256) NOT NULL,
  `password` varchar(124) NOT NULL,
  `fullname` varchar(256) NOT NULL,
  `active` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- إرجاع أو استيراد بيانات الجدول `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `fullname`, `active`) VALUES
(1, 'admin', 'admin', 'Bashar Naial', 1),
(2, 'salem', 'salem', 'Salem', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `goals`
--
ALTER TABLE `goals`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `goals`
--
ALTER TABLE `goals`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
