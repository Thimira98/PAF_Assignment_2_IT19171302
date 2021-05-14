-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2021 at 12:14 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pafproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyers`
--

CREATE TABLE `buyers` (
  `BuyerID` int(10) NOT NULL,
  `Name` varchar(60) NOT NULL,
  `Email` varchar(65) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `ContactNumber` varchar(10) NOT NULL,
  `NameOnCard` varchar(10) NOT NULL,
  `CreditCardNumber` varchar(20) NOT NULL,
  `ExpiryDate` varchar(20) NOT NULL,
  `CVV` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyers`
--

INSERT INTO `buyers` (`BuyerID`, `Name`, `Email`, `Address`, `ContactNumber`, `NameOnCard`, `CreditCardNumber`, `ExpiryDate`, `CVV`) VALUES
(1, 'Thimira Isiwara', 'thimiraisiwara98@gmail.com', 'no 77/8, udugama road, makuluwa, galle', '0719798300', 'BOC', '2347 5678 4537 6734', '2021/12/31', '134'),
(2, 'dhammika guruge', 'dhamika19se@gmail.com', 'no 21, kollupitiya road, bambalapitiya', '0715673456', 'BOC', '2342 6789 4567 2345', '2022/09/19', '494'),
(3, 'tharusha nethmina', 'tharumuthu@gmail.com', 'no 8, akuressa road, mathara', '0913678478', 'Sampath', '3456 2345 7234 7890', '2022/01/31', '623'),
(4, 'pasindu lakshitha', 'pasindu1996@gmail.com', 'no 222/B, theldeniya road, peraadeniya, kandy', '0918347449', 'NSB', '2678 3245 7834 6209', '2023/12/31', '724');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyers`
--
ALTER TABLE `buyers`
  ADD PRIMARY KEY (`BuyerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyers`
--
ALTER TABLE `buyers`
  MODIFY `BuyerID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
