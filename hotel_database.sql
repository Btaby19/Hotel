-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 19, 2017 at 08:53 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `car_id` varchar(20) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `ModelNo` varchar(255) NOT NULL,
  `Price` int(11) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`ModelNo`, `Price`, `Description`, `Quantity`) VALUES
('BMW-RX2', 2500, '4 seats', 5),
('Toyota Corolla', 500, '5 seats', 10),
('Toyota Premio', 1000, '5 seats, large space', 10);

-- --------------------------------------------------------

--
-- Table structure for table `car_p`
--

CREATE TABLE `car_p` (
  `car_id` varchar(20) NOT NULL,
  `package_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `check_in` varchar(20) DEFAULT NULL,
  `check_out` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `username`, `password`, `address`, `phone`, `email`, `check_in`, `check_out`) VALUES
('0', 'rifat', 'r', '123', 'd', '0123', 'a@g.ocm', '12', '13'),
('01', 'Md. Ali', 'ali', '123', 'Dhanmondi,Dhaka', '017888888', 'ali123@yahoo.com', '22-05-17', '28-05-17');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `check_in` varchar(255) NOT NULL,
  `check_out` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`username`, `name`, `password`, `address`, `phone`, `email`, `check_in`, `check_out`) VALUES
('abc', '', ' abc', '', '', '', '', ''),
('laila', 'laila', 'laila', 'dhaka', '12345678', 'laila@yahoo.com', '22-8-17', '25-8-17'),
('mahjabeen', 'mahjabeen', 'mahjabeen', 'edweif545y7', '145346', 'mahjabeen@gmail.com', '30-08-17', '2-09-17'),
('miraz', 'miraz', 'miraz', 'dhaka', '123456789', 'miraz@yahoo.com', '23-8-17', '26-8-17'),
('rana', 'rana', 'rana', 'rana', 'rana', 'rana', '12', '16'),
('rifat', 'rifat', 'rifat', '123', '018881231', 'rifat1816@gmail.com', '123', '1223'),
('shama', 'shama', 'shama', 'dhaka', '123123', 'shama@gmail.com', '12/09/12', '15//09/12'),
('shovon', 'shovon', 'shovon', 'dhaka', '1234345768', 'shovon@gmail.com', '31-8-17', '2-9-17');

-- --------------------------------------------------------

--
-- Table structure for table `c_car`
--

CREATE TABLE `c_car` (
  `car_id` varchar(20) NOT NULL,
  `id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `c_p`
--

CREATE TABLE `c_p` (
  `id` varchar(20) NOT NULL,
  `package_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `c_r`
--

CREATE TABLE `c_r` (
  `id` varchar(20) NOT NULL,
  `room_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `package_id` varchar(20) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `packages`
--

CREATE TABLE `packages` (
  `Name` varchar(255) NOT NULL,
  `Price` int(11) NOT NULL,
  `Description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `packages`
--

INSERT INTO `packages` (`Name`, `Price`, `Description`) VALUES
('ABC', 1000, '1212'),
('Bronze', 1000, '1212'),
('Golden', 6000, '4 BED'),
('Platinum', 4000, '3 BED'),
('Silver', 5000, '3 BED');

-- --------------------------------------------------------

--
-- Table structure for table `phone`
--

CREATE TABLE `phone` (
  `phone` varchar(20) NOT NULL,
  `id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phone_no`
--

CREATE TABLE `phone_no` (
  `phone_no` varchar(20) NOT NULL,
  `staff_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `RoomNo` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `isAvailable` int(11) NOT NULL,
  `Type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`RoomNo`, `Price`, `Description`, `isAvailable`, `Type`) VALUES
(101, 1000, '1 BED', 1, 'Single'),
(102, 1000, '1 BED', 0, 'Single'),
(103, 1000, '2 bed', 1, 'Single'),
(201, 2500, '2 Bed , With Freeze,TV', 1, 'Double'),
(202, 2100, '2 Bed', 0, 'Double'),
(203, 12121, '12121', 1, 'Double'),
(204, 2000, '3 bed', 1, 'Double'),
(301, 1500, '1 BED,FUll AC', 1, 'Single AC'),
(302, 1500, '1 BED, FULL AC,complimantory breakfast', 0, 'Single AC'),
(401, 3500, '2 BED,FUll Ac', 1, 'Double AC'),
(402, 3500, '2 BED,Full AC', 0, 'Double AC');

-- --------------------------------------------------------

--
-- Table structure for table `r_p`
--

CREATE TABLE `r_p` (
  `room_type` varchar(20) NOT NULL,
  `package_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `selection`
--

CREATE TABLE `selection` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `packageName` varchar(100) DEFAULT NULL,
  `roomNo` int(11) DEFAULT NULL,
  `carModel` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `selection`
--

INSERT INTO `selection` (`id`, `username`, `packageName`, `roomNo`, `carModel`) VALUES
(1, 'shama', 'null', 202, 'Toyota Corolla'),
(2, 'laila', 'Platinum', 301, 'null'),
(3, 'rifat', 'Golden', 402, 'BMW-RX2'),
(4, 'abc', 'null', 201, 'null'),
(5, 'shama', 'null', 201, 'null');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staff_id` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `shift` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`car_id`);

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`ModelNo`);

--
-- Indexes for table `car_p`
--
ALTER TABLE `car_p`
  ADD PRIMARY KEY (`car_id`,`package_id`),
  ADD KEY `package_id` (`package_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `c_car`
--
ALTER TABLE `c_car`
  ADD PRIMARY KEY (`id`,`car_id`),
  ADD KEY `car_id` (`car_id`);

--
-- Indexes for table `c_p`
--
ALTER TABLE `c_p`
  ADD PRIMARY KEY (`id`,`package_id`),
  ADD KEY `package_id` (`package_id`);

--
-- Indexes for table `c_r`
--
ALTER TABLE `c_r`
  ADD PRIMARY KEY (`id`,`room_type`),
  ADD KEY `room_type` (`room_type`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`package_id`);

--
-- Indexes for table `packages`
--
ALTER TABLE `packages`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`phone`,`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `phone_no`
--
ALTER TABLE `phone_no`
  ADD PRIMARY KEY (`phone_no`,`staff_id`),
  ADD KEY `staff_id` (`staff_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`RoomNo`);

--
-- Indexes for table `r_p`
--
ALTER TABLE `r_p`
  ADD PRIMARY KEY (`room_type`,`package_id`),
  ADD KEY `package_id` (`package_id`);

--
-- Indexes for table `selection`
--
ALTER TABLE `selection`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `selection`
--
ALTER TABLE `selection`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `car_p`
--
ALTER TABLE `car_p`
  ADD CONSTRAINT `car_p_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `car` (`car_id`),
  ADD CONSTRAINT `car_p_ibfk_2` FOREIGN KEY (`package_id`) REFERENCES `package` (`package_id`);

--
-- Constraints for table `c_car`
--
ALTER TABLE `c_car`
  ADD CONSTRAINT `c_car_ibfk_1` FOREIGN KEY (`id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `c_car_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `car` (`car_id`);

--
-- Constraints for table `c_p`
--
ALTER TABLE `c_p`
  ADD CONSTRAINT `c_p_ibfk_1` FOREIGN KEY (`id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `c_p_ibfk_2` FOREIGN KEY (`package_id`) REFERENCES `package` (`package_id`);

--
-- Constraints for table `c_r`
--
ALTER TABLE `c_r`
  ADD CONSTRAINT `c_r_ibfk_1` FOREIGN KEY (`id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `c_r_ibfk_2` FOREIGN KEY (`room_type`) REFERENCES `room` (`room_type`);

--
-- Constraints for table `phone`
--
ALTER TABLE `phone`
  ADD CONSTRAINT `phone_ibfk_1` FOREIGN KEY (`id`) REFERENCES `customer` (`id`);

--
-- Constraints for table `phone_no`
--
ALTER TABLE `phone_no`
  ADD CONSTRAINT `phone_no_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`);

--
-- Constraints for table `r_p`
--
ALTER TABLE `r_p`
  ADD CONSTRAINT `r_p_ibfk_1` FOREIGN KEY (`room_type`) REFERENCES `room` (`room_type`),
  ADD CONSTRAINT `r_p_ibfk_2` FOREIGN KEY (`package_id`) REFERENCES `package` (`package_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
