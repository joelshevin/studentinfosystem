-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2016 at 06:12 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `st_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `stu_id` varchar(10) NOT NULL,
  `stu_fname` varchar(10) DEFAULT NULL,
  `stu_mname` varchar(10) DEFAULT NULL,
  `stu_surname` varchar(20) DEFAULT NULL,
  `address` varchar(35) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `program` int(11) DEFAULT NULL,
  `enroll_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cur_sem` int(11) NOT NULL DEFAULT '1',
  `pwd` varchar(20) DEFAULT NULL,
  `Pro_pic` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`stu_id`, `stu_fname`, `stu_mname`, `stu_surname`, `address`, `phone`, `dob`, `email`, `program`, `enroll_date`, `cur_sem`, `pwd`, `Pro_pic`) VALUES
('EN16797399', 'Joel', 'Shevin', 'Peiris', 'Moratuwa', '0775632652', '1995-02-01', 'shevin@gmail.com', 6, '2016-04-06 06:22:39', 1, 'EN16797399', NULL),
('EN16805098', 'vkdjvh', 'mvkldh', 'nvbuhoiw', 'nvjkduie', '0112635956', '1994-02-03', 'vhgyu', 6, '2016-04-06 08:45:08', 1, 'EN16805098', NULL),
('EN16919412', 'cjklhkuah', 'vkjhu', 'jnvkjhiuw', 'nvugiuw', 'lmcjh', '1994-05-03', 'cjhqyuu', 7, '2016-04-05 09:06:28', 1, NULL, NULL),
('IT16279610', 'Dinuksha', 'Ishwari', 'Kanda Samanage', 'Rajagiriya', '0772659863', '1994-09-03', 'dinu@gmail.com', 2, '2016-04-04 13:28:57', 2, 'test', NULL),
('IT16315812', 'mcs', 'cnj', ' vmw', 'lmvk', '0771542365', '1995-05-02', 'dickdlq', 2, '2016-04-07 05:34:22', 1, 'IT16315812', NULL),
('IT16944642', 'Madumal', 'Sameera', 'Piyasundara', 'Boralesgamuwa', '0775018380', '1993-02-08', 'sam@gmail.com', 2, '2016-04-02 15:30:28', 1, 'student', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stu_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
