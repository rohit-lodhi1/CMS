-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2023 at 12:11 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rise`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity_logs`
--

CREATE TABLE `activity_logs` (
  `id` int(11) NOT NULL,
  `action` varchar(255) DEFAULT NULL,
  `changes` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `log_for` varchar(255) DEFAULT NULL,
  `log_for2` varchar(255) DEFAULT NULL,
  `log_for_id` int(11) DEFAULT NULL,
  `log_for_id2` int(11) DEFAULT NULL,
  `log_type` varchar(255) DEFAULT NULL,
  `log_type_id` int(11) DEFAULT NULL,
  `log_type_title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `activity_logs_seq`
--

CREATE TABLE `activity_logs_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `activity_logs_seq`
--

INSERT INTO `activity_logs_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `announcements`
--

CREATE TABLE `announcements` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `read_by` varchar(255) DEFAULT NULL,
  `share_with` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `announcements_seq`
--

CREATE TABLE `announcements_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `announcements_seq`
--

INSERT INTO `announcements_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `applied_candidate`
--

CREATE TABLE `applied_candidate` (
  `id` bigint(20) NOT NULL,
  `apply_date` date DEFAULT NULL,
  `candidate_email` varchar(255) DEFAULT NULL,
  `candidate_name` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `original_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `manage_jobs_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applied_candidate`
--

INSERT INTO `applied_candidate` (`id`, `apply_date`, `candidate_email`, `candidate_name`, `file_name`, `message`, `mobile_no`, `original_name`, `status`, `manage_jobs_id`) VALUES
(402, '2023-12-08', 'sddsf@gmail.com', 'vcxvcx', '4c33f847-0d3a-4f53-81ae-80fd8f607133Itachi.jpg', 'fdsfds', '', 'Itachi.jpg', 'new', 1);

-- --------------------------------------------------------

--
-- Table structure for table `applied_candidate_seq`
--

CREATE TABLE `applied_candidate_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applied_candidate_seq`
--

INSERT INTO `applied_candidate_seq` (`next_val`) VALUES
(501),
(501),
(501),
(501),
(501),
(501),
(501);

-- --------------------------------------------------------

--
-- Table structure for table `assets`
--

CREATE TABLE `assets` (
  `id` bigint(20) NOT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `asset_name` varchar(255) DEFAULT NULL,
  `asset_warrenty` varchar(255) DEFAULT NULL,
  `asset_condition` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  `purchase_from_date` date DEFAULT NULL,
  `serial_number` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `asset_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assets`
--

INSERT INTO `assets` (`id`, `amount`, `asset_name`, `asset_warrenty`, `asset_condition`, `description`, `is_delete`, `manufacturer`, `model`, `purchase_date`, `purchase_from_date`, `serial_number`, `status`, `supplier`, `asset_user_id`) VALUES
(1, 20001, 'fg/dl,ngh;lnhlnk', 'fgfg', 'fdvbfb', 'dfvbfdbfgbgfbfgbg', b'1', 'rgrfb', 'dfgfdb', '2023-11-09', '2023-12-02', 0, 'Deployed', '4354354', 2),
(2, 35435, 'ghn bh ', 'fgbfgn', 'gbn gbnb', 'fhbfgbgf', b'0', 'b b ', 'fbfg n', '2023-11-16', '2023-12-06', 0, 'Approved', 'fgn gh n', 1),
(52, 3423, 'vn gn b', '9', 'thn thn yh', 'v v v bgtngh ngh nghn', b'0', 'hn hgn ', 'thnytgngh', '2023-11-08', '2023-12-02', 0, 'Deployed', 'ytnghn', 5);

-- --------------------------------------------------------

--
-- Table structure for table `assets_seq`
--

CREATE TABLE `assets_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assets_seq`
--

INSERT INTO `assets_seq` (`next_val`) VALUES
(151),
(151),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` bigint(20) NOT NULL,
  `checked_at` datetime(6) DEFAULT NULL,
  `checked_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `in_time` datetime(6) DEFAULT NULL,
  `is_mispunched` bit(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `out_time` datetime(6) DEFAULT NULL,
  `reject_reason` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `checked_at`, `checked_by`, `deleted`, `in_time`, `is_mispunched`, `note`, `out_time`, `reject_reason`, `status`, `user_id_id`) VALUES
(1, NULL, NULL, b'0', '2023-11-07 14:24:00.000000', b'0', '', '2023-11-07 15:20:36.000000', '', '', 1),
(2, NULL, NULL, b'0', '2023-11-07 15:25:56.000000', b'1', '', NULL, '', '', 2),
(52, NULL, NULL, b'0', '2023-11-09 15:56:27.000000', b'1', '', NULL, '', '', 2),
(152, NULL, NULL, b'0', '2023-11-20 19:05:59.000000', b'1', '', NULL, '', '', 1),
(202, NULL, NULL, b'0', '2023-11-23 10:39:33.000000', b'0', '', '2023-11-23 13:01:43.000000', '', '', 1),
(252, NULL, NULL, b'0', '2023-11-23 12:27:56.000000', b'0', '', '2023-11-23 12:32:32.000000', '', '', 2),
(302, NULL, NULL, b'0', '2023-11-23 12:53:44.000000', b'1', '', NULL, '', '', 2),
(352, NULL, NULL, b'0', '2023-11-23 13:01:45.000000', b'0', '', '2023-11-23 13:01:49.000000', '', '', 1),
(353, NULL, NULL, b'0', '2023-11-23 13:01:50.000000', b'1', '', NULL, '', '', 1),
(402, NULL, NULL, b'0', '2023-11-25 14:38:36.000000', b'1', '', NULL, '', '', 1),
(452, NULL, NULL, b'0', '2023-11-25 17:11:37.000000', b'1', '', NULL, '', '', 2),
(502, NULL, NULL, b'0', '2023-11-27 17:16:32.000000', b'0', '', '2023-11-27 17:23:27.000000', '', '', 1),
(504, NULL, NULL, b'0', '2023-11-27 17:23:33.000000', b'0', '', '2023-11-27 17:27:47.000000', '', '', 1),
(506, NULL, NULL, b'0', '2023-11-27 18:53:18.000000', b'0', '', '2023-11-27 18:53:49.000000', '', '', 1),
(507, NULL, NULL, b'0', '2023-11-27 18:53:52.000000', b'0', '', '2023-11-27 19:07:10.000000', '', '', 1),
(552, NULL, NULL, b'0', '2023-11-27 19:07:11.000000', b'1', '', NULL, '', '', 1),
(602, NULL, NULL, b'0', '2023-11-28 10:10:38.000000', b'0', '', '2023-11-28 10:14:33.000000', '', '', 1),
(603, NULL, NULL, b'0', '2023-11-28 10:14:34.000000', b'1', '', NULL, '', '', 1),
(652, NULL, NULL, b'0', '2023-11-28 10:54:43.000000', b'0', '', '2023-11-28 11:23:06.000000', '', '', 2),
(702, NULL, NULL, b'0', '2023-11-28 11:23:11.000000', b'1', '', NULL, '', '', 2),
(752, NULL, NULL, b'0', '2023-11-29 10:44:55.000000', b'1', '', NULL, '', '', 1),
(802, NULL, NULL, b'0', '2023-11-29 12:18:02.000000', b'1', '', NULL, '', '', 2),
(852, NULL, NULL, b'0', '2023-11-30 14:19:53.000000', b'0', '', '2023-11-30 14:33:04.000000', '', '', 1),
(853, NULL, NULL, b'0', '2023-11-30 14:33:04.000000', b'1', '', NULL, '', '', 1),
(902, NULL, NULL, b'0', '2023-12-05 12:03:02.000000', b'0', '', '2023-12-05 12:03:35.000000', '', '', 1),
(903, NULL, NULL, b'0', '2023-12-05 12:03:38.000000', b'0', '', '2023-12-05 12:30:29.000000', '', '', 1),
(904, NULL, NULL, b'0', '2023-12-05 12:30:30.000000', b'0', '', '2023-12-05 12:56:13.000000', '', '', 1),
(905, NULL, NULL, b'0', '2023-12-05 12:58:43.000000', b'1', '', NULL, '', '', 1),
(952, NULL, NULL, b'0', '2023-12-06 16:11:10.000000', b'1', '', NULL, '', '', 1),
(1002, NULL, NULL, b'0', '2023-12-06 18:03:51.000000', b'1', '', NULL, '', '', 8),
(1052, NULL, NULL, b'0', '2023-12-07 09:47:23.000000', b'1', '', NULL, '', '', 1),
(1102, NULL, NULL, b'0', '2023-12-09 13:20:22.000000', b'1', '', NULL, '', '', 1),
(1152, NULL, NULL, b'0', '2023-12-09 13:22:15.000000', b'0', '', '2023-12-09 13:22:31.000000', '', '', 8),
(1153, NULL, NULL, b'0', '2023-12-09 13:22:32.000000', b'0', '', '2023-12-09 13:22:34.000000', '', '', 8),
(1154, NULL, NULL, b'0', '2023-12-09 13:22:35.000000', b'0', '', '2023-12-09 13:22:36.000000', '', '', 8),
(1155, NULL, NULL, b'0', '2023-12-09 13:22:38.000000', b'0', '', '2023-12-09 13:22:39.000000', '', '', 8),
(1156, NULL, NULL, b'0', '2023-12-09 13:22:39.000000', b'0', '', '2023-12-09 13:22:39.000000', '', '', 8),
(1157, NULL, NULL, b'0', '2023-12-09 13:22:39.000000', b'0', '', '2023-12-09 13:22:40.000000', '', '', 8),
(1158, NULL, NULL, b'0', '2023-12-09 13:22:40.000000', b'0', '', '2023-12-09 13:22:40.000000', '', '', 8);

-- --------------------------------------------------------

--
-- Table structure for table `attendance_seq`
--

CREATE TABLE `attendance_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance_seq`
--

INSERT INTO `attendance_seq` (`next_val`) VALUES
(1251),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `bank_information`
--

CREATE TABLE `bank_information` (
  `id` int(11) NOT NULL,
  `bank_account_no` bigint(20) DEFAULT NULL,
  `ifsccode` varchar(255) DEFAULT NULL,
  `panno` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `bank_information_seq`
--

CREATE TABLE `bank_information_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bank_information_seq`
--

INSERT INTO `bank_information_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `chat_files`
--

CREATE TABLE `chat_files` (
  `id` bigint(20) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `server_file_name` varchar(255) DEFAULT NULL,
  `message_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chat_files_seq`
--

CREATE TABLE `chat_files_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chat_files_seq`
--

INSERT INTO `chat_files_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `ci_sessions`
--

CREATE TABLE `ci_sessions` (
  `id` varchar(255) NOT NULL,
  `data` int(11) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `timestamp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ci_sessions_seq`
--

CREATE TABLE `ci_sessions_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ci_sessions_seq`
--

INSERT INTO `ci_sessions_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `client_groups` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `currency_symbol` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `disable_online_payment` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gst_number` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `starred_by` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `vat_number` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id`, `client_groups`, `address`, `city`, `company_name`, `country`, `created_date`, `currency`, `currency_symbol`, `deleted`, `disable_online_payment`, `email`, `gst_number`, `phone`, `starred_by`, `state`, `status`, `vat_number`, `website`, `zip`, `owner_id`) VALUES
(1, 'GOLD', 'vidisha', 'Indore', 'Dollop', 'Bharat', NULL, 'BIF', '$', b'0', NULL, '', '6757856', '9098832234', '', 'Mp', 'Active', '2424243', 'www.xzy.com', '455001', 2),
(2, 'GOLD', 'vidiskjn', 'Indore', 'Infosis', 'Bharat', NULL, 'BIF', 'FBu', b'0', NULL, '', '6757856', '9098832234', '', 'Mp', 'Active', '2424243', 'www.xzy.com', '455001', 3);

-- --------------------------------------------------------

--
-- Table structure for table `clients_seq`
--

CREATE TABLE `clients_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clients_seq`
--

INSERT INTO `clients_seq` (`next_val`) VALUES
(101),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `client_labels`
--

CREATE TABLE `client_labels` (
  `clients_id` int(11) NOT NULL,
  `labels` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client_labels`
--

INSERT INTO `client_labels` (`clients_id`, `labels`) VALUES
(1, '3fghd j'),
(2, '3fghd j');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `customer_feedback_id` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `created_by_id` int(11) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `task_id_id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `created_at`, `customer_feedback_id`, `deleted`, `description`, `type`, `created_by_id`, `project_id_id`, `task_id_id`, `task_id`) VALUES
(1, '2023-11-24 11:00:04.000000', 0, b'0', '', 'projectComment', 1, 2, NULL, NULL),
(2, '2023-11-24 11:00:12.000000', 0, b'0', '', 'projectComment', 1, 2, NULL, NULL),
(52, '2023-11-28 15:37:24.000000', 0, b'0', 'gtrthr', 'projectComment', 1, 2, NULL, NULL),
(53, '2023-11-28 15:39:32.000000', 0, b'0', 'gdfdfds', 'projectComment', 1, 2, NULL, NULL),
(102, '2023-11-28 15:38:50.000000', 0, b'0', 'bm ', 'projectComment', 5, 2, NULL, NULL),
(103, '2023-11-28 15:38:53.000000', 0, b'0', 'bm ', 'projectComment', 5, 2, NULL, NULL),
(104, '2023-11-28 15:38:53.000000', 0, b'0', 'bm ', 'projectComment', 5, 2, NULL, NULL),
(152, '2023-11-28 15:41:45.000000', 0, b'0', 'lavda\n', 'projectComment', 1, 2, NULL, NULL),
(202, '2023-11-30 16:47:46.000000', 0, b'0', 'vcbv bv', 'projectComment', 1, 2, NULL, NULL),
(252, '2023-11-30 17:20:22.000000', 0, b'0', 'dfsdf', 'projectComment', 1, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `comments_seq`
--

CREATE TABLE `comments_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments_seq`
--

INSERT INTO `comments_seq` (`next_val`) VALUES
(351),
(351),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `company_settings`
--

CREATE TABLE `company_settings` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `fax_number` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `pin_code` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `website_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `company_settings`
--

INSERT INTO `company_settings` (`id`, `email`, `address`, `city`, `company_name`, `contact_person`, `country`, `fax_number`, `mobile_number`, `phone_number`, `pin_code`, `state`, `website_url`) VALUES
(1, 'Kamal@Gmail.com', 'kaila devi road dewas', 'indore', 'softtechsolution', 'Kamal Gupta', 'INDIA', 'ddgfd24223', '1234567892', '04644467678', '42001', 'madhyapradesh', 'google.com');

-- --------------------------------------------------------

--
-- Table structure for table `company_settings_seq`
--

CREATE TABLE `company_settings_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `company_settings_seq`
--

INSERT INTO `company_settings_seq` (`next_val`) VALUES
(101),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `conversation`
--

CREATE TABLE `conversation` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `user_2` int(11) DEFAULT NULL,
  `user_1` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `conversation`
--

INSERT INTO `conversation` (`id`, `created_at`, `is_deleted`, `user_2`, `user_1`) VALUES
(1, '2023-12-08 16:19:37.000000', b'0', 3, 1),
(2, '2023-12-08 16:20:02.000000', b'0', 2, 1),
(3, '2023-12-08 16:20:09.000000', b'0', 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `custom_fields`
--

CREATE TABLE `custom_fields` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `field_type` varchar(255) DEFAULT NULL,
  `hide_from_clients` bit(1) DEFAULT NULL,
  `options` varchar(255) DEFAULT NULL,
  `placeholder` varchar(255) DEFAULT NULL,
  `related_to` varchar(255) DEFAULT NULL,
  `required` bit(1) DEFAULT NULL,
  `show_in_invoice` bit(1) DEFAULT NULL,
  `show_in_table` bit(1) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `visible_to_admins_only` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `custom_fields_seq`
--

CREATE TABLE `custom_fields_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `custom_fields_seq`
--

INSERT INTO `custom_fields_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `custom_field_values`
--

CREATE TABLE `custom_field_values` (
  `id` int(11) NOT NULL,
  `custom_field_id` int(11) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `related_to_id` int(11) DEFAULT NULL,
  `related_to_type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `custom_field_values_seq`
--

CREATE TABLE `custom_field_values_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `custom_field_values_seq`
--

INSERT INTO `custom_field_values_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `manage_jobs_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `description`, `is_active`, `is_deleted`, `title`, `manage_jobs_id`) VALUES
(1, 'This is about hr', b'1', b'0', 'HRs', NULL),
(2, 'This is about hrs. sdfsadf', b'1', b'0', 'Hello', NULL),
(52, 'This is money departement', b'1', b'0', 'Money', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `department_seq`
--

CREATE TABLE `department_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department_seq`
--

INSERT INTO `department_seq` (`next_val`) VALUES
(151),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `designation`
--

CREATE TABLE `designation` (
  `id` int(11) NOT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `designation`
--

INSERT INTO `designation` (`id`, `is_deleted`, `title`, `department_id`) VALUES
(1, b'0', 'Hr hai bhai', 1),
(2, b'0', 'Hai bhenchod', 2);

-- --------------------------------------------------------

--
-- Table structure for table `designation_performance_indicator`
--

CREATE TABLE `designation_performance_indicator` (
  `designation_id` int(11) NOT NULL,
  `performance_indicator_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `designation_seq`
--

CREATE TABLE `designation_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `designation_seq`
--

INSERT INTO `designation_seq` (`next_val`) VALUES
(101),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `education_informations`
--

CREATE TABLE `education_informations` (
  `id` int(11) NOT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `complete_date` datetime(6) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `starting_date` datetime(6) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `education_informations_seq`
--

CREATE TABLE `education_informations_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `education_informations_seq`
--

INSERT INTO `education_informations_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `email_templates`
--

CREATE TABLE `email_templates` (
  `id` int(11) NOT NULL,
  `custom_message` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `email_subject` varchar(255) DEFAULT NULL,
  `template_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `email_templates_seq`
--

CREATE TABLE `email_templates_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `email_templates_seq`
--

INSERT INTO `email_templates_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `emergency_contact`
--

CREATE TABLE `emergency_contact` (
  `id` int(11) NOT NULL,
  `phone3` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `name1` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `phone1` varchar(255) DEFAULT NULL,
  `phone2` varchar(255) DEFAULT NULL,
  `relationship` varchar(255) DEFAULT NULL,
  `relationship1` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `emergency_contact_seq`
--

CREATE TABLE `emergency_contact_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `emergency_contact_seq`
--

INSERT INTO `emergency_contact_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `estimates`
--

CREATE TABLE `estimates` (
  `id` varchar(255) NOT NULL,
  `bill_date` date DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `grand_total` bigint(20) DEFAULT NULL,
  `last_email_sent_date` date DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tax_cost` bigint(20) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  `client_id_id` int(11) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `taxe_id_id` int(11) DEFAULT NULL,
  `discount_percentage` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `estimates`
--

INSERT INTO `estimates` (`id`, `bill_date`, `deleted`, `discount`, `due_date`, `grand_total`, `last_email_sent_date`, `note`, `status`, `tax_cost`, `total`, `client_id_id`, `project_id_id`, `taxe_id_id`, `discount_percentage`) VALUES
('4d366303-72bf-421a-8b2c-a1149121b465', '2023-11-28', b'0', 1584, '2003-12-12', 15840, NULL, 'dfvfdknfknbkjngkjmblkglkkljndfkbjfnbngkbng,bg,bgidrd/vfdfdvmdf.v ., fjbnfb fm', NULL, 1440, 15840, 1, 252, 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `estimate_forms`
--

CREATE TABLE `estimate_forms` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `enable_at_tachment` int(11) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `estimate_forms_seq`
--

CREATE TABLE `estimate_forms_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `estimate_forms_seq`
--

INSERT INTO `estimate_forms_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `estimate_items`
--

CREATE TABLE `estimate_items` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `grand_total` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `unit_cost` double DEFAULT NULL,
  `estimate_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `estimate_items`
--

INSERT INTO `estimate_items` (`id`, `deleted`, `description`, `grand_total`, `quantity`, `rate`, `title`, `total`, `unit_cost`, `estimate_id`) VALUES
(1, NULL, 'jhbv', NULL, 120, NULL, 'xvjb', 14400, 120, '4d366303-72bf-421a-8b2c-a1149121b465');

-- --------------------------------------------------------

--
-- Table structure for table `estimate_items_seq`
--

CREATE TABLE `estimate_items_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `estimate_items_seq`
--

INSERT INTO `estimate_items_seq` (`next_val`) VALUES
(51),
(51),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `estimate_requests`
--

CREATE TABLE `estimate_requests` (
  `id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `assigned_to` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `files` varchar(255) DEFAULT NULL,
  `client_id_id` int(11) DEFAULT NULL,
  `estimate_form_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `estimate_requests_seq`
--

CREATE TABLE `estimate_requests_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `estimate_requests_seq`
--

INSERT INTO `estimate_requests_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `descripton` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `labels` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `share_with` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `client_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `events_seq`
--

CREATE TABLE `events_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `events_seq`
--

INSERT INTO `events_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `expense_date` date DEFAULT NULL,
  `paid_by` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expenses`
--

INSERT INTO `expenses` (`id`, `amount`, `deleted`, `description`, `expense_date`, `paid_by`, `status`, `title`, `user_id_id`) VALUES
(1, 2, b'0', 'mh', '2023-12-01', 'Cash', 'Pending', 'm nh', 3);

-- --------------------------------------------------------

--
-- Table structure for table `expenses_files`
--

CREATE TABLE `expenses_files` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_size` double DEFAULT NULL,
  `original_name` varchar(255) DEFAULT NULL,
  `expenses_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expenses_files`
--

INSERT INTO `expenses_files` (`id`, `created_at`, `deleted`, `description`, `file_name`, `file_size`, `original_name`, `expenses_id_id`) VALUES
(1, '2023-12-01 14:01:39.000000', NULL, NULL, '08b9e480-2a09-4899-a320-b6484ca42d51naman_InvoiceItem.csv', 179, 'naman_InvoiceItem.csv', 1);

-- --------------------------------------------------------

--
-- Table structure for table `expenses_files_seq`
--

CREATE TABLE `expenses_files_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expenses_files_seq`
--

INSERT INTO `expenses_files_seq` (`next_val`) VALUES
(51),
(51),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `expenses_seq`
--

CREATE TABLE `expenses_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expenses_seq`
--

INSERT INTO `expenses_seq` (`next_val`) VALUES
(51),
(51),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `expense_categories`
--

CREATE TABLE `expense_categories` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `expense_categories_seq`
--

CREATE TABLE `expense_categories_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expense_categories_seq`
--

INSERT INTO `expense_categories_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `experience_informations`
--

CREATE TABLE `experience_informations` (
  `id` int(11) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `job_position` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `period_from` datetime(6) DEFAULT NULL,
  `period_to` datetime(6) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `experience_informations_seq`
--

CREATE TABLE `experience_informations_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `experience_informations_seq`
--

INSERT INTO `experience_informations_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `family_informations`
--

CREATE TABLE `family_informations` (
  `id` int(11) NOT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` datetime(6) DEFAULT NULL,
  `relationship` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `family_informations_seq`
--

CREATE TABLE `family_informations_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `family_informations_seq`
--

INSERT INTO `family_informations_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `goal_list`
--

CREATE TABLE `goal_list` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `target_achievement` varchar(255) DEFAULT NULL,
  `goal_type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `goal_list`
--

INSERT INTO `goal_list` (`id`, `description`, `end_date`, `is_delete`, `start_date`, `status`, `subject`, `target_achievement`, `goal_type_id`) VALUES
(1, 'rtfjtmjk', '2023-12-15', b'0', '2023-12-02', 'InActive', 'fbnndj', ' fgnfcnf', 1);

-- --------------------------------------------------------

--
-- Table structure for table `goal_list_seq`
--

CREATE TABLE `goal_list_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `goal_list_seq`
--

INSERT INTO `goal_list_seq` (`next_val`) VALUES
(51),
(51),
(51),
(51),
(51),
(51),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `goal_type`
--

CREATE TABLE `goal_type` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `goal_type` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `goal_type`
--

INSERT INTO `goal_type` (`id`, `description`, `goal_type`, `is_delete`, `status`) VALUES
(1, 'm, vbm', 'm', b'0', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `goal_type_seq`
--

CREATE TABLE `goal_type_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `goal_type_seq`
--

INSERT INTO `goal_type_seq` (`next_val`) VALUES
(51),
(51),
(51),
(51),
(51),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `help_articles`
--

CREATE TABLE `help_articles` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `total_views` int(11) DEFAULT NULL,
  `category_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `help_articles_seq`
--

CREATE TABLE `help_articles_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `help_articles_seq`
--

INSERT INTO `help_articles_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `help_categories`
--

CREATE TABLE `help_categories` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `help_categories_seq`
--

CREATE TABLE `help_categories_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `help_categories_seq`
--

INSERT INTO `help_categories_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `holidays`
--

CREATE TABLE `holidays` (
  `id` int(11) NOT NULL,
  `day` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `holiday_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `holidays`
--

INSERT INTO `holidays` (`id`, `day`, `deleted`, `holiday_date`, `title`) VALUES
(1, 'Saturday', NULL, '2023-11-23', 'Diwali'),
(52, 'Tuesday', NULL, '2023-12-15', 'tyert'),
(202, 'Tuesday', NULL, '2023-11-15', 'Hello world'),
(253, 'Saturday', NULL, '2023-12-09', 'Client');

-- --------------------------------------------------------

--
-- Table structure for table `holidays_seq`
--

CREATE TABLE `holidays_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `holidays_seq`
--

INSERT INTO `holidays_seq` (`next_val`) VALUES
(351),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `invoices`
--

CREATE TABLE `invoices` (
  `id` varchar(255) NOT NULL,
  `bill_date` date DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `grand_total` bigint(20) DEFAULT NULL,
  `last_email_sent_date` date DEFAULT NULL,
  `next_recurring_date` date DEFAULT NULL,
  `no_of_cycles` int(11) DEFAULT NULL,
  `no_of_cycles_completed` int(11) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `paid_amount` bigint(20) DEFAULT NULL,
  `recurring` bit(1) DEFAULT NULL,
  `recurring_invoice_id` int(11) DEFAULT NULL,
  `repeat_every` int(11) DEFAULT NULL,
  `repeat_type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tax_cost` bigint(20) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  `client_id_id` int(11) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `tax_id_id` int(11) DEFAULT NULL,
  `discount_percentage` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoices`
--

INSERT INTO `invoices` (`id`, `bill_date`, `deleted`, `discount`, `due_date`, `grand_total`, `last_email_sent_date`, `next_recurring_date`, `no_of_cycles`, `no_of_cycles_completed`, `note`, `paid_amount`, `recurring`, `recurring_invoice_id`, `repeat_every`, `repeat_type`, `status`, `tax_cost`, `total`, `client_id_id`, `project_id_id`, `tax_id_id`, `discount_percentage`) VALUES
('048cef7e-76ad-407a-b5b3-78373804f8b8', '2023-12-09', b'0', 11, '2023-12-08', 1099, NULL, NULL, NULL, NULL, 'vbfgbgf', 1000, b'0', NULL, NULL, NULL, 'PartiallyPaid', 100, 1100, 1, 152, 2, 1),
('3d326017-be57-497b-b2de-763918f0f2fe', '2023-11-28', b'0', 1584, '2023-11-29', 15830, NULL, NULL, NULL, NULL, 'ghnhhmhm', 15830, b'0', NULL, NULL, NULL, 'overDue', 1440, 15840, 1, 152, 2, 10),
('946df1c7-0b25-48be-be0c-049209e0eee7', '2023-12-04', b'0', 2, '2023-12-27', 108, NULL, NULL, NULL, NULL, 'fdgffdgfdfg', 108, b'0', NULL, NULL, NULL, 'Paid', 10, 110, 1, 152, 2, 2),
('9841766c-9126-4a4f-aef4-1ad8fa51194f', '2023-12-04', b'0', 275, '2023-12-20', 2740, NULL, NULL, NULL, NULL, 'gnhmhmhmhmhmhmhmhmhhmmhmhmhmhmh', 274, b'0', NULL, NULL, NULL, 'PartiallyPaid', 250, 2750, 1, 152, 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `invoices_items`
--

CREATE TABLE `invoices_items` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `grand_total` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `unit_cost` double DEFAULT NULL,
  `invoices_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoices_items`
--

INSERT INTO `invoices_items` (`id`, `deleted`, `description`, `grand_total`, `quantity`, `rate`, `title`, `total`, `unit_cost`, `invoices_id`) VALUES
(1, NULL, 'dvfdbfb', NULL, 12, NULL, 'dvfdbfb', 14400, 1200, '3d326017-be57-497b-b2de-763918f0f2fe'),
(2, NULL, 'dfbfgbgbg', NULL, 10, NULL, 'bgfb', 1200, 120, '9841766c-9126-4a4f-aef4-1ad8fa51194f'),
(3, NULL, 'sadsd', NULL, 10, NULL, 'ssc', 1300, 130, '9841766c-9126-4a4f-aef4-1ad8fa51194f'),
(4, NULL, 'hgnhn h', NULL, 10, NULL, 'ngnn', 100, 10, '946df1c7-0b25-48be-be0c-049209e0eee7'),
(52, NULL, 'ddg', NULL, 10, NULL, 'dvd', 1000, 100, '048cef7e-76ad-407a-b5b3-78373804f8b8');

-- --------------------------------------------------------

--
-- Table structure for table `invoices_items_seq`
--

CREATE TABLE `invoices_items_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoices_items_seq`
--

INSERT INTO `invoices_items_seq` (`next_val`) VALUES
(151),
(151),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `invoice_payments`
--

CREATE TABLE `invoice_payments` (
  `id` int(11) NOT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  `invoice_id_id` varchar(255) DEFAULT NULL,
  `payment_method_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice_payments`
--

INSERT INTO `invoice_payments` (`id`, `amount`, `created_by`, `deleted`, `note`, `payment_date`, `status`, `transaction_id`, `invoice_id_id`, `payment_method_id_id`) VALUES
(1, 15830, NULL, NULL, NULL, '2023-12-12', 'Credit Cards', NULL, '3d326017-be57-497b-b2de-763918f0f2fe', NULL),
(2, 274, NULL, NULL, NULL, '2023-12-06', 'Cash', NULL, '9841766c-9126-4a4f-aef4-1ad8fa51194f', NULL),
(3, 108, NULL, NULL, NULL, '2023-12-07', 'Cash', NULL, '946df1c7-0b25-48be-be0c-049209e0eee7', NULL),
(52, 1000, NULL, NULL, NULL, '2023-12-14', 'Cash', NULL, '048cef7e-76ad-407a-b5b3-78373804f8b8', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `invoice_payments_seq`
--

CREATE TABLE `invoice_payments_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice_payments_seq`
--

INSERT INTO `invoice_payments_seq` (`next_val`) VALUES
(151),
(151),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `unit_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `items_seq`
--

CREATE TABLE `items_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `items_seq`
--

INSERT INTO `items_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `leaves`
--

CREATE TABLE `leaves` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leaves`
--

INSERT INTO `leaves` (`id`, `date`, `employee_id`) VALUES
(102, '2023-11-20', 8),
(103, '2023-11-20', 2),
(152, '2023-11-24', 1),
(153, '2023-11-24', 2),
(154, '2023-11-24', 3),
(155, '2023-11-24', 4),
(202, '2023-11-27', 2),
(203, '2023-11-27', 3),
(204, '2023-11-27', 4),
(252, '2023-11-29', 1),
(253, '2023-11-29', 2),
(254, '2023-11-29', 3),
(255, '2023-11-29', 4),
(256, '2023-11-29', 5),
(257, '2023-11-29', 6),
(302, '2023-11-30', 1),
(303, '2023-11-30', 2),
(304, '2023-11-30', 3),
(305, '2023-11-30', 4),
(306, '2023-11-30', 5),
(307, '2023-11-30', 6),
(352, '2023-12-04', 8),
(353, '2023-12-04', 3),
(354, '2023-12-04', 4),
(355, '2023-12-04', 5),
(356, '2023-12-04', 6),
(357, '2023-12-04', 2),
(358, '2023-12-04', 7),
(359, '2023-12-04', 8),
(402, '2023-12-04', 1),
(403, '2023-12-04', 3),
(404, '2023-12-04', 4),
(405, '2023-12-04', 5),
(406, '2023-12-04', 6),
(407, '2023-12-04', 2),
(408, '2023-12-04', 7),
(409, '2023-12-04', 8),
(452, '2023-12-04', 1),
(453, '2023-12-04', 3),
(454, '2023-12-04', 4),
(455, '2023-12-04', 5),
(456, '2023-12-04', 6),
(457, '2023-12-04', 2),
(458, '2023-12-04', 7),
(459, '2023-12-04', 8),
(502, '2023-12-06', 1),
(503, '2023-12-06', 3),
(504, '2023-12-06', 4),
(505, '2023-12-06', 5),
(506, '2023-12-06', 6),
(507, '2023-12-06', 2),
(508, '2023-12-06', 7),
(509, '2023-12-06', 8);

-- --------------------------------------------------------

--
-- Table structure for table `leaves_seq`
--

CREATE TABLE `leaves_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leaves_seq`
--

INSERT INTO `leaves_seq` (`next_val`) VALUES
(601),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `leave_applications`
--

CREATE TABLE `leave_applications` (
  `id` int(11) NOT NULL,
  `checked_at` date DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_days` double DEFAULT NULL,
  `total_hours` double DEFAULT NULL,
  `applicant_id_id` int(11) DEFAULT NULL,
  `checked_by_id` int(11) DEFAULT NULL,
  `leave_type_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leave_applications`
--

INSERT INTO `leave_applications` (`id`, `checked_at`, `created_at`, `created_by`, `deleted`, `end_date`, `reason`, `start_date`, `status`, `total_days`, `total_hours`, `applicant_id_id`, `checked_by_id`, `leave_type_id_id`) VALUES
(2, NULL, NULL, 0, b'0', '2023-11-02', 'IAe hibhecho', '2023-11-02', 'Approved', 1, 0, 2, 1, 2),
(52, NULL, NULL, 0, b'0', '2023-11-22', 'Aise hi re ', '2023-11-22', 'Approved', 1, 4, 1, 1, 2),
(102, NULL, NULL, 0, b'0', '2023-11-28', 'ghfghfghfghfdgh', '2023-11-26', 'Declined', 3, 0, 2, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `leave_applications_seq`
--

CREATE TABLE `leave_applications_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leave_applications_seq`
--

INSERT INTO `leave_applications_seq` (`next_val`) VALUES
(201),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `leave_types`
--

CREATE TABLE `leave_types` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leave_types`
--

INSERT INTO `leave_types` (`id`, `deleted`, `description`, `status`, `title`) VALUES
(1, b'0', '3', 'Active', 'Casual'),
(2, b'0', '7', 'Active', 'Medical Leaves');

-- --------------------------------------------------------

--
-- Table structure for table `leave_types_seq`
--

CREATE TABLE `leave_types_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leave_types_seq`
--

INSERT INTO `leave_types_seq` (`next_val`) VALUES
(101),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `manage_jobs`
--

CREATE TABLE `manage_jobs` (
  `id` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `is_deletd` bit(1) DEFAULT NULL,
  `job_location` varchar(255) DEFAULT NULL,
  `job_type` varchar(255) DEFAULT NULL,
  `no_of_vacancies` varchar(255) DEFAULT NULL,
  `salary_from` varchar(255) DEFAULT NULL,
  `salary_to` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `job_title_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manage_jobs`
--

INSERT INTO `manage_jobs` (`id`, `age`, `description`, `experience`, `expired_date`, `is_deletd`, `job_location`, `job_type`, `no_of_vacancies`, `salary_from`, `salary_to`, `start_date`, `status`, `department_id`, `job_title_id`) VALUES
(1, 23, 'bnb', '1', '2023-12-23', b'0', 'frd', 'Part Time', 'b', '234', '234', '2023-12-16', 'Open', 1, 1),
(2, 23, 'bfd bryn', '12', '2023-12-23', b'0', 'fdf', 'Full Time', 'fcvc', '1234', '12', '2023-12-19', 'Open', 1, 1),
(52, 34, ' cbncbnbbccbcgc', '12 years', '2023-12-14', b'0', 'sdvdd', 'Internship', '10', '20000', '220000', '2023-12-08', 'Open', 2, 2),
(102, 27, ' gdvghghfhgfgh', '1', '2023-12-20', b'0', 'indore', 'Internship', '4', '1000', '2000', '2023-12-14', 'Open', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `manage_jobs_seq`
--

CREATE TABLE `manage_jobs_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manage_jobs_seq`
--

INSERT INTO `manage_jobs_seq` (`next_val`) VALUES
(201),
(201),
(201),
(201),
(201),
(201),
(201);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `id` bigint(20) NOT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `is_seen` datetime(6) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `recieved` datetime(6) DEFAULT NULL,
  `sent` datetime(6) DEFAULT NULL,
  `conversation_id` int(11) DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `deleted_by_users` varchar(255) DEFAULT NULL,
  `files` varchar(255) DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `message_id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `messages_seq`
--

CREATE TABLE `messages_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `messages_seq`
--

INSERT INTO `messages_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `message_seq`
--

CREATE TABLE `message_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `message_seq`
--

INSERT INTO `message_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `milestones`
--

CREATE TABLE `milestones` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `due_date` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `milestones_seq`
--

CREATE TABLE `milestones_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `milestones_seq`
--

INSERT INTO `milestones_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `module_permissions`
--

CREATE TABLE `module_permissions` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `module_permissions`
--

INSERT INTO `module_permissions` (`id`, `name`) VALUES
(1, 'Employee'),
(2, 'Clients'),
(3, 'Projects'),
(4, 'Leads'),
(5, 'Tickets'),
(6, 'Accounts'),
(7, 'Payroll'),
(8, 'Policies'),
(9, 'Reports'),
(10, 'Performance'),
(11, 'Goals'),
(12, 'Training'),
(13, 'Promotion'),
(14, 'Resignation'),
(15, 'Termination'),
(16, 'Assets'),
(17, 'Jobs'),
(18, 'Knowledge'),
(19, 'Activities'),
(20, 'Users'),
(21, 'Settings'),
(22, 'Profile'),
(23, 'authentication'),
(24, 'subscription'),
(25, 'Apps');

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `tables` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `client_id_id` int(11) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `user_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `notes_seq`
--

CREATE TABLE `notes_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `notes_seq`
--

INSERT INTO `notes_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `id` int(11) NOT NULL,
  `actual_message_id` int(11) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `event` varchar(255) DEFAULT NULL,
  `notify_to` varchar(255) DEFAULT NULL,
  `parent_message_id` int(11) DEFAULT NULL,
  `read_by` varchar(255) DEFAULT NULL,
  `activity_log_id_id` int(11) DEFAULT NULL,
  `client_id_id` int(11) DEFAULT NULL,
  `estimate_id_id` varchar(255) DEFAULT NULL,
  `estimate_request_id_id` int(11) DEFAULT NULL,
  `invoice_id_id` varchar(255) DEFAULT NULL,
  `invoice_payment_id_id` int(11) DEFAULT NULL,
  `leave_id_id` int(11) DEFAULT NULL,
  `post_id_id` int(11) DEFAULT NULL,
  `project_comment_id_id` bigint(20) DEFAULT NULL,
  `project_file_id_id` bigint(20) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `task_id_id` bigint(20) DEFAULT NULL,
  `ticket_comment_id_id` int(11) DEFAULT NULL,
  `ticket_id_id` int(11) DEFAULT NULL,
  `to_user_id_id` int(11) DEFAULT NULL,
  `user_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `notifications_seq`
--

CREATE TABLE `notifications_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `notifications_seq`
--

INSERT INTO `notifications_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `notification_settings`
--

CREATE TABLE `notification_settings` (
  `id` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `enable_email` int(11) DEFAULT NULL,
  `enable_web` int(11) DEFAULT NULL,
  `event` varchar(255) DEFAULT NULL,
  `notify_to_team` varchar(255) DEFAULT NULL,
  `notify_to_team_members` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `notification_settings_seq`
--

CREATE TABLE `notification_settings_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `notification_settings_seq`
--

INSERT INTO `notification_settings_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `over_time`
--

CREATE TABLE `over_time` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `over_time_date` date DEFAULT NULL,
  `over_time_hours` double DEFAULT NULL,
  `over_time_type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `approved_by_id` int(11) DEFAULT NULL,
  `user_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `over_time`
--

INSERT INTO `over_time` (`id`, `description`, `is_deleted`, `over_time_date`, `over_time_hours`, `over_time_type`, `status`, `approved_by_id`, `user_id_id`) VALUES
(1, 'vbnmvbmghmfghgjnhmhhhjhgjhjhjhjh', b'1', '2023-11-24', 4, 'For Extra money', 'New', NULL, 2),
(2, 'fvfdvffbfdvfvbfbfbfffbfbfbfbfbfbfbfbfbfbffbfbfbfb', b'1', '2023-12-12', 3, 'For extra Work', 'Pending', NULL, 1),
(52, 'fhfgnhgnhgmnhgmhmhm', b'1', '2023-11-22', 3, 'For Extra money', 'New', NULL, 1),
(102, 'fhfgngnngnghnghnghn', b'1', '2023-12-12', 6, 'For Extra money', 'Approved', NULL, 1),
(152, 'fdrgbgbgngtnnygny', b'1', '2023-12-12', 3, 'For extra Work', 'New', NULL, 1),
(202, 'efdvfdvvbrfb', b'1', '2023-11-09', 3, 'For Extra money', 'New', NULL, 1),
(252, 'wefedfreregrrgr', b'1', '2002-12-12', 4, 'For Extra money', 'New', 3, 2),
(302, 'fchvngngnggfd', b'0', '2231-12-12', 12, 'For extra Work', 'Rejected', 1, 2),
(352, 'gyytkyukulului', b'1', '2003-12-12', 5, 'For Extra money', 'Pending', 1, 2),
(402, 'tgfgbfgbfrh', b'0', '2023-11-25', 4, 'For Extra money', 'Approved', 4, 3),
(403, 'vbfbfbfbfbfbfbfbfbfb', b'0', '2231-12-12', 12, 'For extra Work', 'Approved', 1, 2),
(404, 'sdfdddfgdgfdgfdf', b'0', '2231-12-12', 12, 'For extra Work', 'Approved', 1, 2),
(452, 'bfgbfbgfbgg', b'0', '2023-12-06', 3, 'For extra Work', 'Approved', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `over_time_seq`
--

CREATE TABLE `over_time_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `over_time_seq`
--

INSERT INTO `over_time_seq` (`next_val`) VALUES
(551),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `payment_methods`
--

CREATE TABLE `payment_methods` (
  `id` int(11) NOT NULL,
  `available_on_invoice` bit(1) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `minimum_payment_amount` double DEFAULT NULL,
  `online_payable` bit(1) DEFAULT NULL,
  `settings` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment_methods_seq`
--

CREATE TABLE `payment_methods_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment_methods_seq`
--

INSERT INTO `payment_methods_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `paypal_ipn`
--

CREATE TABLE `paypal_ipn` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `ipn_data` varchar(255) DEFAULT NULL,
  `ipn_hash` varchar(255) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `paypal_ipn_seq`
--

CREATE TABLE `paypal_ipn_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `paypal_ipn_seq`
--

INSERT INTO `paypal_ipn_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `payroll_items_additions`
--

CREATE TABLE `payroll_items_additions` (
  `id` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `unit_amount` double DEFAULT NULL,
  `unit_calculation` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payroll_items_additions`
--

INSERT INTO `payroll_items_additions` (`id`, `category`, `is_delete`, `name`, `unit_amount`, `unit_calculation`) VALUES
(1, 'Monthly remuneration', b'0', 'ghkyukyu', 667876, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `payroll_items_additions_seq`
--

CREATE TABLE `payroll_items_additions_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payroll_items_additions_seq`
--

INSERT INTO `payroll_items_additions_seq` (`next_val`) VALUES
(51),
(51),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `payroll_items_deductions`
--

CREATE TABLE `payroll_items_deductions` (
  `id` int(11) NOT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `unit_amount` double DEFAULT NULL,
  `unit_calculation` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payroll_items_deductions`
--

INSERT INTO `payroll_items_deductions` (`id`, `is_delete`, `name`, `unit_amount`, `unit_calculation`) VALUES
(1, b'0', 'Leave balance amount', 1.3, b'1'),
(2, b'1', 'Leave balance amount', 1.3, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `payroll_items_deductions_seq`
--

CREATE TABLE `payroll_items_deductions_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payroll_items_deductions_seq`
--

INSERT INTO `payroll_items_deductions_seq` (`next_val`) VALUES
(101),
(101),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `payroll_items_overtime`
--

CREATE TABLE `payroll_items_overtime` (
  `id` int(11) NOT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `rate_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payroll_items_overtime`
--

INSERT INTO `payroll_items_overtime` (`id`, `is_delete`, `name`, `rate`, `rate_type`) VALUES
(1, b'0', 'ghnmghm', 230, 'Daily Rate');

-- --------------------------------------------------------

--
-- Table structure for table `payroll_items_overtime_seq`
--

CREATE TABLE `payroll_items_overtime_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payroll_items_overtime_seq`
--

INSERT INTO `payroll_items_overtime_seq` (`next_val`) VALUES
(51),
(51),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `performance_appraisal`
--

CREATE TABLE `performance_appraisal` (
  `id` int(11) NOT NULL,
  `ability_to_meet_deadline` varchar(255) DEFAULT NULL,
  `administration` varchar(255) DEFAULT NULL,
  `attendance` varchar(255) DEFAULT NULL,
  `conflict_management` varchar(255) DEFAULT NULL,
  `critical_thinking` varchar(255) DEFAULT NULL,
  `customer_experience` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `efficiency` varchar(255) DEFAULT NULL,
  `integrity` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `management` varchar(255) DEFAULT NULL,
  `marketing` varchar(255) DEFAULT NULL,
  `presentation_skill` varchar(255) DEFAULT NULL,
  `professionalism` varchar(255) DEFAULT NULL,
  `quality_of_work` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `team_work` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `performance_indicator`
--

CREATE TABLE `performance_indicator` (
  `id` int(11) NOT NULL,
  `ability_to_meet_deadline` varchar(255) DEFAULT NULL,
  `administration` varchar(255) DEFAULT NULL,
  `attendance` varchar(255) DEFAULT NULL,
  `conflict_management` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `critical_thinking` varchar(255) DEFAULT NULL,
  `customer_experience` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `efficiency` varchar(255) DEFAULT NULL,
  `integrity` varchar(255) DEFAULT NULL,
  `management` varchar(255) DEFAULT NULL,
  `marketing` varchar(255) DEFAULT NULL,
  `presentation_skill` varchar(255) DEFAULT NULL,
  `professionalism` varchar(255) DEFAULT NULL,
  `quality_of_work` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `team_work` varchar(255) DEFAULT NULL,
  `designation_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `performance_indicator`
--

INSERT INTO `performance_indicator` (`id`, `ability_to_meet_deadline`, `administration`, `attendance`, `conflict_management`, `created_at`, `critical_thinking`, `customer_experience`, `deleted`, `efficiency`, `integrity`, `management`, `marketing`, `presentation_skill`, `professionalism`, `quality_of_work`, `status`, `team_work`, `designation_id`) VALUES
(1, 'Beginner', 'Beginner', 'Intermediate', 'Advanced', '2023-12-04', 'Beginner', 'Beginner', NULL, 'Advanced', 'Beginner', 'Beginner', 'Intermediate', 'Advanced', 'Beginner', 'Beginner', 'Active', 'Intermediate', 2),
(2, 'Beginner', 'Beginner', 'Advanced', 'Beginner', '2023-12-04', 'Beginner', 'Beginner', NULL, 'Intermediate', 'Beginner', 'Beginner', 'Beginner', 'Beginner', 'Beginner', 'Beginner', 'Active', 'Beginner', 2);

-- --------------------------------------------------------

--
-- Table structure for table `permissions`
--

CREATE TABLE `permissions` (
  `id` int(11) NOT NULL,
  `is_deleteable` bit(1) DEFAULT NULL,
  `is_editable` bit(1) DEFAULT NULL,
  `is_readable` bit(1) DEFAULT NULL,
  `is_writeable` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `module_permissions_id` int(11) DEFAULT NULL,
  `role_permissions` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `permissions`
--

INSERT INTO `permissions` (`id`, `is_deleteable`, `is_editable`, `is_readable`, `is_writeable`, `title`, `module_permissions_id`, `role_permissions`) VALUES
(0, b'1', b'1', b'1', b'1', NULL, NULL, NULL),
(1, b'1', b'1', b'1', b'1', 'Employee/AllEmployee', 1, 1),
(2, b'1', b'1', b'1', b'1', 'Employee/Holidays', 1, 1),
(3, b'1', b'1', b'1', b'1', 'Employee/Leaves_Admin', 1, 1),
(4, b'1', b'1', b'1', b'1', 'Employee/Leaves_Employee', 1, 1),
(5, b'1', b'1', b'1', b'1', 'Employee/leave_settings', 1, 1),
(6, b'1', b'1', b'1', b'1', 'Employee/Attendance_Admin', 1, 1),
(7, b'1', b'1', b'1', b'1', 'Employee/Attendance_Employee', 1, 1),
(8, b'1', b'1', b'1', b'1', 'Employee/Departments', 1, 1),
(9, b'1', b'1', b'1', b'1', 'Employee/Designations', 1, 1),
(10, b'1', b'1', b'1', b'1', 'Employee/Timesheet', 1, 1),
(11, b'1', b'1', b'1', b'1', 'Employee/Overtime', 1, 1),
(12, b'1', b'1', b'1', b'1', 'Clients', 2, 1),
(13, b'1', b'1', b'1', b'1', 'Projects/Projects', 3, 1),
(14, b'1', b'1', b'1', b'1', 'Projects/Tasks', 3, 1),
(15, b'1', b'1', b'1', b'1', 'Projects/TaskBoard', 3, 1),
(16, b'1', b'1', b'1', b'1', 'Leads', 4, 1),
(17, b'1', b'1', b'1', b'1', 'Tickets/Tickets', 5, 1),
(18, b'1', b'0', b'1', b'1', 'Tickets/Ticket_Types', 5, 1),
(19, b'1', b'1', b'1', b'1', 'Employee_Profile', 22, 1),
(20, b'1', b'1', b'1', b'1', 'Client_Profile', 22, 1),
(21, b'1', b'1', b'1', b'1', 'Admin_Profile', 22, 1),
(22, b'1', b'1', b'1', b'1', 'Accounts/Estimates', 6, 1),
(23, b'1', b'1', b'1', b'1', 'Accounts/Invoices', 6, 1),
(24, b'1', b'1', b'1', b'1', 'Accounts/Payments', 6, 1),
(25, b'1', b'1', b'1', b'1', 'Accounts/Expenses', 6, 1),
(26, b'1', b'1', b'1', b'1', 'Accounts/Provident_Fund', 6, 1),
(27, b'1', b'1', b'1', b'1', 'Accounts/Taxes', 6, 1),
(28, b'1', b'1', b'1', b'1', 'Payroll/Employee_Salary', 7, 1),
(29, b'1', b'1', b'1', b'1', 'Payroll/Payslip', 7, 1),
(30, b'1', b'1', b'1', b'1', 'Payroll/Payroll_Items', 7, 1),
(31, b'1', b'1', b'1', b'1', 'Policies', 8, 1),
(32, b'1', b'1', b'1', b'1', 'Reports/Expenses_Report', 9, 1),
(33, b'1', b'1', b'1', b'1', 'Reports/Invoice_Report', 9, 1),
(34, b'1', b'1', b'1', b'1', 'Performance/Performance_Indicator', 10, 1),
(35, b'1', b'1', b'1', b'1', 'Performance/Performance_Review', 10, 1),
(36, b'1', b'1', b'1', b'1', 'Performance/Performance_Appraisal', 10, 1),
(37, b'1', b'1', b'1', b'1', 'Goals/Goal_List', 11, 1),
(38, b'1', b'1', b'1', b'1', 'Goals/Goal_Type', 11, 1),
(39, b'1', b'1', b'1', b'1', 'Training/Training_List', 12, 1),
(40, b'1', b'1', b'1', b'1', 'Training/Trainers', 12, 1),
(41, b'1', b'1', b'1', b'1', 'Training/Training_Type', 12, 1),
(42, b'1', b'1', b'1', b'1', 'Promotion', 13, 1),
(43, b'1', b'1', b'1', b'1', 'Resignation', 14, 1),
(44, b'1', b'1', b'1', b'1', 'Termination', 15, 1),
(45, b'1', b'1', b'1', b'1', 'Assets', 16, 1),
(46, b'1', b'1', b'1', b'1', 'Jobs/Manage_Jobs', 17, 1),
(47, b'1', b'1', b'1', b'1', 'Jobs/Applied_Candidates', 17, 1),
(48, b'1', b'1', b'1', b'1', 'Knowledge_base', 18, 1),
(49, b'1', b'1', b'1', b'1', 'Activites', 19, 1),
(50, b'1', b'1', b'1', b'1', 'Users', 20, 1),
(51, b'1', b'1', b'1', b'1', 'Settings/Company_Settings', 21, 1),
(52, b'1', b'1', b'1', b'1', 'Settings/localization', 21, 1),
(53, b'1', b'1', b'1', b'1', 'Settings/theme_settings', 21, 1),
(54, b'1', b'1', b'1', b'1', 'Settings/Roles_Permissions', 21, 1),
(55, b'1', b'1', b'1', b'1', 'Settings/Email_Settings', 21, 1),
(56, b'1', b'1', b'1', b'1', 'Settings/Invoice_Settings', 21, 1),
(57, b'1', b'1', b'1', b'1', 'Settings/Salary_Settings', 21, 1),
(58, b'1', b'1', b'1', b'1', 'Settings/Notifications', 21, 1),
(59, b'1', b'1', b'1', b'1', 'Settings/Change_Password', 21, 1),
(60, b'1', b'1', b'1', b'1', 'Settings/Leave_Type', 21, 1),
(61, b'1', b'1', b'1', b'1', 'Authentication/Login', 23, 1),
(62, b'1', b'1', b'1', b'1', 'Authentication/Registration', 23, 1),
(63, b'1', b'1', b'1', b'1', 'Authentication/ForgetPassword', 23, 1),
(64, b'1', b'1', b'1', b'1', 'Authentication/OTP', 23, 1),
(65, b'1', b'1', b'1', b'1', 'Authentication/LockScreen', 23, 1),
(66, b'1', b'1', b'1', b'1', 'Subscriptions/Subscriptions_Admin', 24, 1),
(67, b'1', b'1', b'1', b'1', 'Subscriptions/Subscriptions_Company', 24, 1),
(68, b'1', b'1', b'1', b'1', 'Subscriptions/Subscribed_Companies', 24, 1),
(69, b'1', b'1', b'0', b'1', 'Employee/AllEmployee', 1, 2),
(70, b'1', b'1', b'1', b'0', 'Employee/Holidays', 1, 2),
(71, b'1', b'1', b'0', b'1', 'Employee/Leaves_Admin', 1, 2),
(72, b'1', b'1', b'1', b'1', 'Employee/Leaves_Employee', 1, 2),
(73, b'1', b'1', b'1', b'1', 'Employee/leave_settings', 1, 2),
(74, b'1', b'1', b'0', b'1', 'Employee/Attendance_Admin', 1, 2),
(75, b'1', b'1', b'1', b'1', 'Employee/Attendance_Employee', 1, 2),
(76, b'1', b'0', b'0', b'1', 'Employee/Departments', 1, 2),
(77, b'1', b'1', b'0', b'1', 'Employee/Designations', 1, 2),
(78, b'1', b'1', b'0', b'1', 'Employee/Timesheet', 1, 2),
(79, b'1', b'1', b'1', b'1', 'Employee/Overtime', 1, 2),
(80, b'1', b'1', b'1', b'1', 'Clients', 2, 2),
(81, b'1', b'1', b'1', b'0', 'Projects/Projects', 3, 2),
(82, b'1', b'1', b'1', b'1', 'Projects/Tasks', 3, 2),
(83, b'1', b'1', b'1', b'1', 'Projects/TaskBoard', 3, 2),
(84, b'1', b'1', b'1', b'1', 'Leads', 4, 2),
(85, b'1', b'1', b'1', b'1', 'Tickets/Tickets', 5, 2),
(86, b'1', b'1', b'1', b'1', 'Tickets/Ticket_Types', 5, 2),
(87, b'1', b'1', b'1', b'1', 'Employee_Profile', 22, 2),
(88, b'1', b'1', b'1', b'1', 'Client_Profile', 22, 2),
(89, b'1', b'1', b'1', b'1', 'Admin_Profile', 22, 2),
(90, b'1', b'1', b'1', b'1', 'Accounts/Estimates', 6, 2),
(91, b'1', b'1', b'1', b'1', 'Accounts/Invoices', 6, 2),
(92, b'1', b'1', b'1', b'1', 'Accounts/Payments', 6, 2),
(93, b'1', b'1', b'1', b'1', 'Accounts/Expenses', 6, 2),
(94, b'1', b'1', b'1', b'1', 'Accounts/Provident_Fund', 6, 2),
(95, b'1', b'1', b'1', b'1', 'Accounts/Taxes', 6, 2),
(96, b'1', b'1', b'1', b'1', 'Payroll/Employee_Salary', 7, 2),
(97, b'1', b'1', b'1', b'1', 'Payroll/Payslip', 7, 2),
(98, b'1', b'1', b'1', b'1', 'Payroll/Payroll_Items', 7, 2),
(99, b'1', b'1', b'1', b'1', 'Policies', 8, 2),
(100, b'1', b'1', b'1', b'1', 'Reports/Expenses_Report', 9, 2),
(101, b'1', b'1', b'1', b'1', 'Reports/Invoice_Report', 9, 2),
(102, b'1', b'1', b'1', b'1', 'Performance/Performance_Indicator', 10, 2),
(103, b'1', b'1', b'1', b'1', 'Performance/Performance_Review', 10, 2),
(104, b'1', b'1', b'1', b'1', 'Performance/Performance_Appraisal', 10, 2),
(105, b'1', b'1', b'1', b'1', 'Goals/Goal_List', 11, 2),
(106, b'1', b'1', b'1', b'1', 'Goals/Goal_Type', 11, 2),
(107, b'1', b'1', b'1', b'1', 'Training/Training_List', 12, 2),
(108, b'1', b'1', b'1', b'1', 'Training/Trainers', 12, 2),
(109, b'1', b'1', b'1', b'1', 'Training/Training_Type', 12, 2),
(110, b'1', b'1', b'1', b'1', 'Promotion', 13, 2),
(111, b'1', b'1', b'1', b'1', 'Resignation', 14, 2),
(112, b'1', b'1', b'1', b'1', 'Termination', 15, 2),
(113, b'1', b'1', b'1', b'1', 'Assets', 16, 2),
(114, b'1', b'1', b'1', b'1', 'Jobs/Manage_Jobs', 17, 2),
(115, b'1', b'1', b'1', b'1', 'Jobs/Applied_Candidates', 17, 2),
(116, b'1', b'1', b'1', b'1', 'Knowledge_base', 18, 2),
(117, b'1', b'1', b'1', b'1', 'Activites', 19, 2),
(118, b'1', b'1', b'1', b'1', 'Users', 20, 2),
(119, b'1', b'1', b'1', b'1', 'Settings/Company_Settings', 21, 2),
(120, b'1', b'1', b'1', b'1', 'Settings/localization', 21, 2),
(121, b'1', b'1', b'1', b'1', 'Settings/theme_settings', 21, 2),
(122, b'1', b'1', b'1', b'1', 'Settings/Roles_Permissions', 21, 2),
(123, b'1', b'1', b'1', b'1', 'Settings/Email_Settings', 21, 2),
(124, b'1', b'1', b'1', b'1', 'Settings/Invoice_Settings', 21, 2),
(125, b'1', b'1', b'1', b'1', 'Settings/Salary_Settings', 21, 2),
(126, b'1', b'1', b'1', b'1', 'Settings/Notifications', 21, 2),
(127, b'1', b'1', b'1', b'1', 'Settings/Change_Password', 21, 2),
(128, b'1', b'1', b'1', b'1', 'Settings/Leave_Type', 21, 2),
(129, b'1', b'1', b'1', b'1', 'Authentication/Login', 23, 2),
(130, b'1', b'1', b'1', b'1', 'Authentication/Registration', 23, 2),
(131, b'1', b'1', b'1', b'1', 'Authentication/ForgetPassword', 23, 2),
(132, b'1', b'1', b'1', b'1', 'Authentication/OTP', 23, 2),
(133, b'1', b'1', b'1', b'1', 'Authentication/LockScreen', 23, 2),
(134, b'1', b'1', b'1', b'1', 'Subscriptions/Subscriptions_Admin', 24, 2),
(135, b'1', b'1', b'1', b'1', 'Subscriptions/Subscriptions_Company', 24, 2),
(136, b'1', b'1', b'1', b'1', 'Subscriptions/Subscribed_Companies', 24, 2),
(137, b'1', b'1', b'1', b'1', 'Employee/AllEmployee', 1, 3),
(138, b'1', b'1', b'1', b'1', 'Employee/Holidays', 1, 3),
(139, b'1', b'1', b'1', b'1', 'Employee/Leaves_Admin', 1, 3),
(140, b'1', b'1', b'1', b'1', 'Employee/Leaves_Employee', 1, 3),
(141, b'1', b'1', b'1', b'1', 'Employee/leave_settings', 1, 3),
(142, b'1', b'1', b'1', b'1', 'Employee/Attendance_Admin', 1, 3),
(143, b'1', b'1', b'1', b'1', 'Employee/Attendance_Employee', 1, 3),
(144, b'1', b'1', b'1', b'1', 'Employee/Departments', 1, 3),
(145, b'1', b'1', b'1', b'1', 'Employee/Designations', 1, 3),
(146, b'1', b'1', b'1', b'1', 'Employee/Timesheet', 1, 3),
(147, b'1', b'1', b'1', b'1', 'Employee/Overtime', 1, 3),
(148, b'1', b'1', b'1', b'1', 'Clients', 2, 3),
(149, b'1', b'1', b'1', b'1', 'Projects/Projects', 3, 3),
(150, b'1', b'1', b'1', b'1', 'Projects/Tasks', 3, 3),
(151, b'1', b'1', b'1', b'1', 'Projects/TaskBoard', 3, 3),
(152, b'1', b'1', b'1', b'1', 'Leads', 4, 3),
(153, b'1', b'1', b'1', b'1', 'Tickets/Tickets', 5, 3),
(154, b'1', b'1', b'1', b'1', 'Tickets/Ticket_Types', 5, 3),
(155, b'1', b'1', b'1', b'1', 'Employee_Profile', 22, 3),
(156, b'1', b'1', b'1', b'1', 'Client_Profile', 22, 3),
(157, b'1', b'1', b'1', b'1', 'Admin_Profile', 22, 3),
(158, b'1', b'1', b'1', b'1', 'Accounts/Estimates', 6, 3),
(159, b'1', b'1', b'1', b'1', 'Accounts/Invoices', 6, 3),
(160, b'1', b'1', b'1', b'1', 'Accounts/Payments', 6, 3),
(161, b'1', b'1', b'1', b'1', 'Accounts/Expenses', 6, 3),
(162, b'1', b'1', b'1', b'1', 'Accounts/Provident_Fund', 6, 3),
(163, b'1', b'1', b'1', b'1', 'Accounts/Taxes', 6, 3),
(164, b'1', b'1', b'1', b'1', 'Payroll/Employee_Salary', 7, 3),
(165, b'1', b'1', b'1', b'1', 'Payroll/Payslip', 7, 3),
(166, b'1', b'1', b'1', b'1', 'Payroll/Payroll_Items', 7, 3),
(167, b'1', b'1', b'1', b'1', 'Policies', 8, 3),
(168, b'1', b'1', b'1', b'1', 'Reports/Expenses_Report', 9, 3),
(169, b'1', b'1', b'1', b'1', 'Reports/Invoice_Report', 9, 3),
(170, b'1', b'1', b'1', b'1', 'Performance/Performance_Indicator', 10, 3),
(171, b'1', b'1', b'1', b'1', 'Performance/Performance_Review', 10, 3),
(172, b'1', b'1', b'1', b'1', 'Performance/Performance_Appraisal', 10, 3),
(173, b'1', b'1', b'1', b'1', 'Goals/Goal_List', 11, 3),
(174, b'1', b'1', b'1', b'1', 'Goals/Goal_Type', 11, 3),
(175, b'1', b'1', b'1', b'1', 'Training/Training_List', 12, 3),
(176, b'1', b'1', b'1', b'1', 'Training/Trainers', 12, 3),
(177, b'1', b'1', b'1', b'1', 'Training/Training_Type', 12, 3),
(178, b'1', b'1', b'1', b'1', 'Promotion', 13, 3),
(179, b'1', b'1', b'1', b'1', 'Resignation', 14, 3),
(180, b'1', b'1', b'1', b'1', 'Termination', 15, 3),
(181, b'1', b'1', b'1', b'1', 'Assets', 16, 3),
(182, b'1', b'1', b'1', b'1', 'Jobs/Manage_Jobs', 17, 3),
(183, b'1', b'1', b'1', b'1', 'Jobs/Applied_Candidates', 17, 3),
(184, b'1', b'1', b'1', b'1', 'Knowledge_base', 18, 3),
(185, b'1', b'1', b'1', b'1', 'Activites', 19, 3),
(186, b'1', b'1', b'1', b'1', 'Users', 20, 3),
(187, b'1', b'1', b'1', b'1', 'Settings/Company_Settings', 21, 3),
(188, b'1', b'1', b'1', b'1', 'Settings/localization', 21, 3),
(189, b'1', b'1', b'1', b'1', 'Settings/theme_settings', 21, 3),
(190, b'1', b'1', b'1', b'1', 'Settings/Roles_Permissions', 21, 3),
(191, b'1', b'1', b'1', b'1', 'Settings/Email_Settings', 21, 3),
(192, b'1', b'1', b'1', b'1', 'Settings/Invoice_Settings', 21, 3),
(193, b'1', b'1', b'1', b'1', 'Settings/Salary_Settings', 21, 3),
(194, b'1', b'1', b'1', b'1', 'Settings/Notifications', 21, 3),
(195, b'1', b'1', b'1', b'1', 'Settings/Change_Password', 21, 3),
(196, b'1', b'1', b'1', b'1', 'Settings/Leave_Type', 21, 3),
(197, b'1', b'1', b'1', b'1', 'Authentication/Login', 23, 3),
(198, b'1', b'1', b'1', b'1', 'Authentication/Registration', 23, 3),
(199, b'1', b'1', b'1', b'1', 'Authentication/ForgetPassword', 23, 3),
(200, b'1', b'1', b'1', b'1', 'Authentication/OTP', 23, 3),
(201, b'1', b'1', b'1', b'1', 'Authentication/LockScreen', 23, 3),
(202, b'1', b'1', b'1', b'1', 'Subscriptions/Subscriptions_Admin', 24, 3),
(203, b'1', b'1', b'1', b'1', 'Subscriptions/Subscriptions_Company', 24, 3),
(204, b'1', b'1', b'1', b'1', 'Subscriptions/Subscribed_Companies', 24, 3),
(205, b'1', b'1', b'1', b'1', 'Employee/AllEmployee', 1, 4),
(206, b'1', b'1', b'1', b'1', 'Employee/Holidays', 1, 4),
(207, b'1', b'1', b'1', b'1', 'Employee/Leaves_Admin', 1, 4),
(208, b'1', b'1', b'1', b'1', 'Employee/Leaves_Employee', 1, 4),
(209, b'1', b'1', b'1', b'1', 'Employee/leave_settings', 1, 4),
(210, b'1', b'1', b'1', b'1', 'Employee/Attendance_Admin', 1, 4),
(211, b'1', b'1', b'1', b'1', 'Employee/Attendance_Employee', 1, 4),
(212, b'1', b'1', b'1', b'1', 'Employee/Departments', 1, 4),
(213, b'1', b'1', b'1', b'1', 'Employee/Designations', 1, 4),
(214, b'1', b'1', b'1', b'1', 'Employee/Timesheet', 1, 4),
(215, b'1', b'1', b'1', b'1', 'Employee/Overtime', 1, 4),
(216, b'1', b'1', b'1', b'1', 'Clients', 2, 4),
(217, b'1', b'1', b'1', b'1', 'Projects/Projects', 3, 4),
(218, b'1', b'1', b'1', b'1', 'Projects/Tasks', 3, 4),
(219, b'1', b'1', b'1', b'1', 'Projects/TaskBoard', 3, 4),
(220, b'1', b'1', b'1', b'1', 'Leads', 4, 4),
(221, b'1', b'1', b'1', b'1', 'Tickets/Tickets', 5, 4),
(222, b'1', b'1', b'1', b'1', 'Tickets/Ticket_Types', 5, 4),
(223, b'1', b'1', b'1', b'1', 'Employee_Profile', 22, 4),
(224, b'1', b'1', b'1', b'1', 'Client_Profile', 22, 4),
(225, b'1', b'1', b'1', b'1', 'Admin_Profile', 22, 4),
(226, b'1', b'1', b'1', b'1', 'Accounts/Estimates', 6, 4),
(227, b'1', b'1', b'1', b'1', 'Accounts/Invoices', 6, 4),
(228, b'1', b'1', b'1', b'1', 'Accounts/Payments', 6, 4),
(229, b'1', b'1', b'1', b'1', 'Accounts/Expenses', 6, 4),
(230, b'1', b'1', b'1', b'1', 'Accounts/Provident_Fund', 6, 4),
(231, b'1', b'1', b'1', b'1', 'Accounts/Taxes', 6, 4),
(232, b'1', b'1', b'1', b'1', 'Payroll/Employee_Salary', 7, 4),
(233, b'1', b'1', b'1', b'1', 'Payroll/Payslip', 7, 4),
(234, b'1', b'1', b'1', b'1', 'Payroll/Payroll_Items', 7, 4),
(235, b'1', b'1', b'1', b'1', 'Policies', 8, 4),
(236, b'1', b'1', b'1', b'1', 'Reports/Expenses_Report', 9, 4),
(237, b'1', b'1', b'1', b'1', 'Reports/Invoice_Report', 9, 4),
(238, b'1', b'1', b'1', b'1', 'Performance/Performance_Indicator', 10, 4),
(239, b'1', b'1', b'1', b'1', 'Performance/Performance_Review', 10, 4),
(240, b'1', b'1', b'1', b'1', 'Performance/Performance_Appraisal', 10, 4),
(241, b'1', b'1', b'1', b'1', 'Goals/Goal_List', 11, 4),
(242, b'1', b'1', b'1', b'1', 'Goals/Goal_Type', 11, 4),
(243, b'1', b'1', b'1', b'1', 'Training/Training_List', 12, 4),
(244, b'1', b'1', b'1', b'1', 'Training/Trainers', 12, 4),
(245, b'1', b'1', b'1', b'1', 'Training/Training_Type', 12, 4),
(246, b'1', b'1', b'1', b'1', 'Promotion', 13, 4),
(247, b'1', b'1', b'1', b'1', 'Resignation', 14, 4),
(248, b'1', b'1', b'1', b'1', 'Termination', 15, 4),
(249, b'1', b'1', b'1', b'1', 'Assets', 16, 4),
(250, b'1', b'1', b'1', b'1', 'Jobs/Manage_Jobs', 17, 4),
(251, b'1', b'1', b'1', b'1', 'Jobs/Applied_Candidates', 17, 4),
(252, b'1', b'1', b'1', b'1', 'Knowledge_base', 18, 4),
(253, b'1', b'1', b'1', b'1', 'Activites', 19, 4),
(254, b'1', b'1', b'1', b'1', 'Users', 20, 4),
(255, b'1', b'1', b'1', b'1', 'Settings/Company_Settings', 21, 4),
(256, b'1', b'1', b'1', b'1', 'Settings/localization', 21, 4),
(257, b'1', b'1', b'1', b'1', 'Settings/theme_settings', 21, 4),
(258, b'1', b'1', b'1', b'1', 'Settings/Roles_Permissions', 21, 4),
(259, b'1', b'1', b'1', b'1', 'Settings/Email_Settings', 21, 4),
(260, b'1', b'1', b'1', b'1', 'Settings/Invoice_Settings', 21, 4),
(261, b'1', b'1', b'1', b'1', 'Settings/Salary_Settings', 21, 4),
(262, b'1', b'1', b'1', b'1', 'Settings/Notifications', 21, 4),
(263, b'1', b'1', b'1', b'1', 'Settings/Change_Password', 21, 4),
(264, b'1', b'1', b'1', b'1', 'Settings/Leave_Type', 21, 4),
(265, b'1', b'1', b'1', b'1', 'Authentication/Login', 23, 4),
(266, b'1', b'1', b'1', b'1', 'Authentication/Registration', 23, 4),
(267, b'1', b'1', b'1', b'1', 'Authentication/ForgetPassword', 23, 4),
(268, b'1', b'1', b'1', b'1', 'Authentication/OTP', 23, 4),
(269, b'1', b'1', b'1', b'1', 'Authentication/LockScreen', 23, 4),
(270, b'1', b'1', b'1', b'1', 'Subscriptions/Subscriptions_Admin', 24, 4),
(271, b'1', b'1', b'1', b'1', 'Subscriptions/Subscriptions_Company', 24, 4),
(272, b'1', b'1', b'1', b'1', 'Subscriptions/Subscribed_Companies', 24, 4),
(400, b'1', b'1', b'1', b'1', 'Tickets/Ticket_View', 5, 1),
(401, b'1', b'1', b'1', b'1', 'Projects/Projects_View', 3, 1),
(402, b'1', b'1', b'1', b'1', 'Estimates_Create', 6, 1),
(403, b'1', b'1', b'1', b'1', 'Estimates_Edit', 6, 1),
(404, b'1', b'1', b'1', b'1', 'Estimates_View', 6, 1),
(405, b'1', b'1', b'1', b'1', 'Invoices_Create', 6, 1),
(406, b'1', b'1', b'1', b'1', 'Invoices_View', 6, 1),
(407, b'1', b'1', b'1', b'1', 'Invoices_Edit', 6, 1),
(408, b'1', b'1', b'1', b'1', 'Clients/Client_View', 2, 1),
(409, b'1', b'1', b'1', b'1', 'Apps/Chats', 25, 1),
(410, b'1', b'1', b'1', b'1', 'Apps/Chats', 25, 2);

-- --------------------------------------------------------

--
-- Table structure for table `permissions_seq`
--

CREATE TABLE `permissions_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `permissions_seq`
--

INSERT INTO `permissions_seq` (`next_val`) VALUES
(351),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `personal_informations`
--

CREATE TABLE `personal_informations` (
  `id` int(11) NOT NULL,
  `maritalstatus` varchar(255) DEFAULT NULL,
  `employment_of_spouse` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `no_of_children` int(11) DEFAULT NULL,
  `passport_expiry_date` datetime(6) DEFAULT NULL,
  `passport_no` varchar(255) DEFAULT NULL,
  `religion` datetime(6) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `personal_informations_seq`
--

CREATE TABLE `personal_informations_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `personal_informations_seq`
--

INSERT INTO `personal_informations_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `policy`
--

CREATE TABLE `policy` (
  `id` int(11) NOT NULL,
  `created_at` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `policy`
--

INSERT INTO `policy` (`id`, `created_at`, `description`, `is_deleted`, `name`, `department_id`) VALUES
(2, '2023-12-01', 'Lorem ipsum dollar g', b'0', 'Leave Policy', NULL),
(3, '2023-12-01', 'Lorem ipsum dolla rj j', b'0', '	Permission Policy', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `policy_files`
--

CREATE TABLE `policy_files` (
  `id` bigint(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `original_file_name` varchar(255) DEFAULT NULL,
  `size` bigint(20) NOT NULL,
  `policy_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `policy_files`
--

INSERT INTO `policy_files` (`id`, `deleted`, `file_name`, `original_file_name`, `size`, `policy_id`) VALUES
(2, b'0', 'd14d8ae5-d881-4d62-92ab-e4aa6b127e40nullstaffSalarys.csv', 'nullstaffSalarys.csv', 358, 2),
(3, b'0', '958f5f0c-a064-4462-a490-dcd671054941naman_InvoiceItem.csv', 'naman_InvoiceItem.csv', 179, 3);

-- --------------------------------------------------------

--
-- Table structure for table `policy_files_seq`
--

CREATE TABLE `policy_files_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `policy_files_seq`
--

INSERT INTO `policy_files_seq` (`next_val`) VALUES
(101),
(101),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `policy_seq`
--

CREATE TABLE `policy_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `policy_seq`
--

INSERT INTO `policy_seq` (`next_val`) VALUES
(101),
(101),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `files` varchar(255) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `share_with` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `posts_seq`
--

CREATE TABLE `posts_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `posts_seq`
--

INSERT INTO `posts_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `id` int(11) NOT NULL,
  `created_date` date DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `project_type` varchar(255) DEFAULT NULL,
  `starred_by` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `created_by_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`id`, `created_date`, `deadline`, `deleted`, `description`, `price`, `project_type`, `starred_by`, `start_date`, `status`, `title`, `client_id`, `created_by_id`) VALUES
(2, '2023-11-24', '2023-11-30', b'0', 'sdvdfc cvvf fmn,fnb m,gfṁgn gkj gmn gj g j vj bgfj g ggn g fgk nfg fgmfg mgfjnfnbfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfgjkfg', 220000, 'Client Project', '', '2023-11-24', 'Completed', 'Administration Manager', 2, NULL),
(52, '2023-11-24', '2023-11-28', b'0', 'regrgrgrthrththththht', 20000000, 'Client Project', '', '2023-11-23', 'InProgress', 'ghmhmhmh', 2, NULL),
(102, '2023-11-24', '2023-11-30', b'0', 'wccdcdd', 222222222, 'Client Project', '', '2023-11-24', 'InProgress', 'fdmnbfdknfknffjk', 2, NULL),
(152, '2023-11-24', '2023-12-07', b'0', 'wdsfcsdvdvfdvbfbf', 214223432, 'Client Project', '', '2023-11-25', 'Completed', 'gyjnghmhm', 1, NULL),
(202, '2023-11-24', '2023-11-17', b'0', 'sdfasdfsaf', 898, 'Intern Project', '', '2023-11-05', 'InProgress', 'Gymnastic', 2, NULL),
(252, '2023-11-25', '2023-12-21', b'0', '3223232323dvc vbv b gb gb nhb nbh nbh  bh hbn ', 200000, 'Client Project', '', '2023-11-25', 'Completed', 'ProjectInJava', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `projects_seq`
--

CREATE TABLE `projects_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `projects_seq`
--

INSERT INTO `projects_seq` (`next_val`) VALUES
(351),
(351),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `projects_tasks`
--

CREATE TABLE `projects_tasks` (
  `projects_id` int(11) NOT NULL,
  `tasks_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `project_files`
--

CREATE TABLE `project_files` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_size` double DEFAULT NULL,
  `original_name` varchar(255) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `uploaded_by_id` int(11) DEFAULT NULL,
  `project_comment_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project_files`
--

INSERT INTO `project_files` (`id`, `created_at`, `deleted`, `description`, `file_name`, `file_size`, `original_name`, `project_id_id`, `uploaded_by_id`, `project_comment_id`) VALUES
(2, '2023-11-24 09:42:12.000000', NULL, NULL, '26f4088f-1061-49f9-bda6-a01849187231blog-app-api.zip', 269184, 'blog-app-api.zip', 2, 1, NULL),
(52, '2023-11-24 11:00:04.000000', NULL, NULL, 'f035ebbb-0fbe-4df8-88ea-cbde83ab64541307669.jpeg', 901035, '1307669.jpeg', NULL, 1, 1),
(53, '2023-11-24 11:00:12.000000', NULL, NULL, 'c304ccf1-e65f-4f4d-9e03-47ceda467a75John-Wick-Chapter-4-Backgrounds-Laptop.jpg', 510327, 'John-Wick-Chapter-4-Backgrounds-Laptop.jpg', NULL, 2, 2),
(54, '2023-11-24 11:15:13.000000', NULL, NULL, 'b03eeadf-2d33-4ec3-8493-58ec040e57a5Gmail - Invoice_SLEC4538829,Purchased on_2023-09-08.pdf', 1376426, 'Gmail - Invoice_SLEC4538829,Purchased on_2023-09-08.pdf', 2, 1, NULL),
(56, '2023-11-24 15:14:39.000000', NULL, NULL, 'ec40676e-2f53-458f-aa12-750bd141acf2John-Wick-Chapter-4-Backgrounds-Laptop (3).jpg', 510327, 'John-Wick-Chapter-4-Backgrounds-Laptop (3).jpg', 2, 1, NULL),
(57, '2023-11-24 15:15:07.000000', NULL, NULL, 'c12ac8ad-4e8a-41ca-a39b-ed379d9cd753lombok.jar', 2011339, 'lombok.jar', 2, 1, NULL),
(102, '2023-11-24 16:07:41.000000', NULL, NULL, '1e7f58c6-18cf-45ea-9471-bd2fcbaf283eCollege-Management-System-in-Php_5.5.zip', 922117, 'College-Management-System-in-Php_5.5.zip', 52, NULL, NULL),
(152, '2023-11-24 17:13:17.000000', NULL, NULL, 'b4ca0513-066b-4883-9b7d-42d3471d3e0dblog-app-api.zip', 269184, 'blog-app-api.zip', 102, NULL, NULL),
(202, '2023-11-24 17:24:06.000000', NULL, NULL, '92b5e633-84d4-4f80-910f-4d2eefc13f62index.html', 58984, 'index.html', 2, 1, NULL),
(252, '2023-11-24 18:26:15.000000', NULL, NULL, '97ac6506-352a-47f7-bf91-455e1bfffeb3College-Management-System-In-PHP-Source-Code.zip', 9612577, 'College-Management-System-In-PHP-Source-Code.zip', 2, 1, NULL),
(302, '2023-11-24 18:49:36.000000', NULL, NULL, '1b642c19-fcdd-4ad6-a2d1-10213997fd4eCollege-Management-System-in-Php_5.5.zip', 922117, 'College-Management-System-in-Php_5.5.zip', 152, NULL, NULL),
(352, '2023-11-24 18:51:20.000000', NULL, NULL, '197a9d49-6d4d-49fa-afd2-fbca86ecec2eassets.html', 57458, 'assets.html', 202, 1, NULL),
(402, '2023-11-24 19:03:44.000000', NULL, NULL, '0dc8cf92-873b-4f29-81aa-ba59bbf646ecJohn-Wick-Chapter-4-Backgrounds-Laptop.jpg', 510327, 'John-Wick-Chapter-4-Backgrounds-Laptop.jpg', 202, 1, NULL),
(452, '2023-11-25 09:49:16.000000', NULL, NULL, 'f38f95ea-d6c5-410c-afb7-1ae998fd0334rohan_InvoiceItem (1).csv', 126, 'rohan_InvoiceItem (1).csv', 252, NULL, NULL),
(502, '2023-11-25 16:34:58.000000', NULL, NULL, 'c6cde4e4-e6bd-4a60-aa0d-8abc19c5dc16activity.svg', 282, 'activity.svg', 52, 1, NULL),
(552, '2023-11-27 17:32:34.000000', NULL, NULL, '34148833-81ce-4d4d-8439-74527521adf41307669.jpeg', 901035, '1307669.jpeg', 52, 1, NULL),
(553, '2023-11-27 17:32:46.000000', NULL, NULL, '629b6d4a-97ac-40dd-9cb5-14b51f130d8aJohn-Wick-Chapter-4-Backgrounds-Laptop.jpg', 510327, 'John-Wick-Chapter-4-Backgrounds-Laptop.jpg', NULL, 1, NULL),
(554, '2023-11-27 17:33:08.000000', NULL, NULL, '0e56e450-c892-4c9a-a85b-1d36f91d69f0John-Wick-Chapter-4-Backgrounds-Laptop.jpg', 510327, 'John-Wick-Chapter-4-Backgrounds-Laptop.jpg', NULL, NULL, NULL),
(555, '2023-11-27 17:34:00.000000', NULL, NULL, 'a0567f37-fc4b-4b82-be44-7a67068e5a49John-Wick-Chapter-4-Backgrounds-Laptop.jpg', 510327, 'John-Wick-Chapter-4-Backgrounds-Laptop.jpg', 52, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `project_files_seq`
--

CREATE TABLE `project_files_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project_files_seq`
--

INSERT INTO `project_files_seq` (`next_val`) VALUES
(651),
(651),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `project_labels`
--

CREATE TABLE `project_labels` (
  `projects_id` int(11) NOT NULL,
  `project_label` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project_labels`
--

INSERT INTO `project_labels` (`projects_id`, `project_label`) VALUES
(2, 'HighPriority'),
(102, 'OnTrack'),
(152, 'Urgent'),
(202, 'OnTrack'),
(202, 'Urgent'),
(252, 'HighPriority'),
(52, 'Urgent');

-- --------------------------------------------------------

--
-- Table structure for table `project_members`
--

CREATE TABLE `project_members` (
  `id` bigint(20) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `is_leader` bit(1) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `user_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project_members`
--

INSERT INTO `project_members` (`id`, `deleted`, `is_leader`, `project_id_id`, `user_id_id`) VALUES
(4, b'0', b'0', 2, 8),
(55, b'0', b'1', 2, 3),
(56, b'0', b'0', 2, 2),
(57, b'0', b'1', 2, 2),
(102, b'0', b'1', 52, 2),
(152, b'0', b'1', 202, 4),
(153, b'0', b'0', 202, 5),
(202, b'0', b'1', 102, 1),
(203, b'0', b'1', 102, 8),
(205, b'0', b'1', 52, 2),
(207, b'0', b'0', 102, 3);

-- --------------------------------------------------------

--
-- Table structure for table `project_members_seq`
--

CREATE TABLE `project_members_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project_members_seq`
--

INSERT INTO `project_members_seq` (`next_val`) VALUES
(301),
(301),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `project_settings`
--

CREATE TABLE `project_settings` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `setting_name` varchar(255) DEFAULT NULL,
  `setting_value` varchar(255) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `project_settings_seq`
--

CREATE TABLE `project_settings_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project_settings_seq`
--

INSERT INTO `project_settings_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `project_time`
--

CREATE TABLE `project_time` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `task_id_id` bigint(20) DEFAULT NULL,
  `user_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `project_time_seq`
--

CREATE TABLE `project_time_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project_time_seq`
--

INSERT INTO `project_time_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `id` int(11) NOT NULL,
  `designation_from` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `promotion_date` date DEFAULT NULL,
  `designation_to_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`id`, `designation_from`, `is_deleted`, `promotion_date`, `designation_to_id`, `employee_id`) VALUES
(1, '', b'0', '2023-12-08', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `promotion_seq`
--

CREATE TABLE `promotion_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `promotion_seq`
--

INSERT INTO `promotion_seq` (`next_val`) VALUES
(51),
(51),
(51),
(51),
(51),
(51),
(51);

-- --------------------------------------------------------

--
-- Table structure for table `resignation`
--

CREATE TABLE `resignation` (
  `id` int(11) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `notice_date` date DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `resigning` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `resignation_seq`
--

CREATE TABLE `resignation_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `resignation_seq`
--

INSERT INTO `resignation_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `deleted`, `title`) VALUES
(1, b'0', 'ADMIN'),
(2, b'0', 'EMPLOYEE'),
(3, b'0', 'USER'),
(4, b'0', 'CLIENT');

-- --------------------------------------------------------

--
-- Table structure for table `settings`
--

CREATE TABLE `settings` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `setting_name` varchar(255) DEFAULT NULL,
  `setting_value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `settings_seq`
--

CREATE TABLE `settings_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `settings_seq`
--

INSERT INTO `settings_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `social_links`
--

CREATE TABLE `social_links` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `digg` varchar(255) DEFAULT NULL,
  `facebook` varchar(255) DEFAULT NULL,
  `github` varchar(255) DEFAULT NULL,
  `googleplus` varchar(255) DEFAULT NULL,
  `instagram` varchar(255) DEFAULT NULL,
  `linkedin` varchar(255) DEFAULT NULL,
  `pinterest` varchar(255) DEFAULT NULL,
  `tumblr` varchar(255) DEFAULT NULL,
  `twitter` varchar(255) DEFAULT NULL,
  `vine` varchar(255) DEFAULT NULL,
  `youtube` varchar(255) DEFAULT NULL,
  `user_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `social_links_seq`
--

CREATE TABLE `social_links_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `social_links_seq`
--

INSERT INTO `social_links_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `staff_salary`
--

CREATE TABLE `staff_salary` (
  `id` int(11) NOT NULL,
  `basic` bigint(20) DEFAULT NULL,
  `conveyance` int(11) DEFAULT NULL,
  `da` int(11) DEFAULT NULL,
  `esi` int(11) DEFAULT NULL,
  `hra` int(11) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `labour_welfare` int(11) DEFAULT NULL,
  `medical_allowance` int(11) DEFAULT NULL,
  `others` int(11) DEFAULT NULL,
  `others1` int(11) DEFAULT NULL,
  `pf` int(11) DEFAULT NULL,
  `prof_tax` int(11) DEFAULT NULL,
  `staff_leave` int(11) DEFAULT NULL,
  `tds` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `allowance` int(11) DEFAULT NULL,
  `basic_staff_salary` bigint(20) DEFAULT NULL,
  `net_salary` double DEFAULT NULL,
  `payslip` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff_salary`
--

INSERT INTO `staff_salary` (`id`, `basic`, `conveyance`, `da`, `esi`, `hra`, `is_deleted`, `labour_welfare`, `medical_allowance`, `others`, `others1`, `pf`, `prof_tax`, `staff_leave`, `tds`, `staff_id`, `allowance`, `basic_staff_salary`, `net_salary`, `payslip`) VALUES
(4, NULL, 1, 123, 12, 12, b'0', 6, 1, 11, 11, 1, 5, NULL, 1, 6, 1, 12, 161, 123);

-- --------------------------------------------------------

--
-- Table structure for table `staff_salary_seq`
--

CREATE TABLE `staff_salary_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff_salary_seq`
--

INSERT INTO `staff_salary_seq` (`next_val`) VALUES
(101),
(101),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE `tasks` (
  `id` bigint(20) NOT NULL,
  `deadline` date DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `points` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `assigned_to_id` int(11) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`id`, `deadline`, `deleted`, `description`, `points`, `start_date`, `status`, `title`, `assigned_to_id`, `project_id_id`, `project_id`) VALUES
(1, '2023-11-30', b'0', 'cbfb gnbgngnn', '3 Point', '2023-11-24', 'Completed', 'Add Login Form', 8, 2, NULL),
(2, '2023-11-29', b'0', 'fdbfgb fgb gg g bghghh nrtrthbtrt', '3 Point', '2023-11-25', 'Completed', 'form create', 3, 2, NULL),
(52, '2023-11-16', b'0', 'fsdafsadfsd', '3 Point', '2023-11-04', 'Completed', 'Hello', 8, 202, NULL),
(102, '2023-12-27', b'0', 'vfdfdvdvfd', '2 Point', '2023-12-29', 'Pending', 'dfvdfvf', 3, 2, NULL),
(103, '2023-12-27', b'0', 'fgngnnggn', '2 Point', '2023-12-06', 'InProgress', 'bfgngn', 3, 2, NULL),
(104, '2023-12-28', b'0', 'gfngn', '2 Point', '2023-12-06', 'OnHold', 'gfgngfng', 6, 2, NULL),
(105, '2023-12-21', b'0', 'hmhjm', '4 Point', '2023-12-06', 'Review', 'gfgfngn', 5, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tasks_collaborators`
--

CREATE TABLE `tasks_collaborators` (
  `tasks_id` bigint(20) NOT NULL,
  `collaborators_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tasks_collaborators`
--

INSERT INTO `tasks_collaborators` (`tasks_id`, `collaborators_id`) VALUES
(1, 2),
(1, 3),
(2, 4),
(52, 2),
(102, 5),
(103, 7),
(103, 5),
(104, 2),
(105, 6),
(105, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tasks_seq`
--

CREATE TABLE `tasks_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tasks_seq`
--

INSERT INTO `tasks_seq` (`next_val`) VALUES
(201),
(201),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `task_labels`
--

CREATE TABLE `task_labels` (
  `tasks_id` bigint(20) NOT NULL,
  `task_label` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `taxes`
--

CREATE TABLE `taxes` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taxes`
--

INSERT INTO `taxes` (`id`, `deleted`, `percentage`, `status`, `title`) VALUES
(1, b'0', 18, 'Approved', 'Gst'),
(2, b'0', 10, 'Approved', 'VST'),
(52, b'0', 12, 'Pending', 'mn.k.k'),
(53, b'1', 12, 'Pending', 'mn.k.k');

-- --------------------------------------------------------

--
-- Table structure for table `taxes_seq`
--

CREATE TABLE `taxes_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taxes_seq`
--

INSERT INTO `taxes_seq` (`next_val`) VALUES
(151),
(151),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `members` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `team_member_job_info`
--

CREATE TABLE `team_member_job_info` (
  `id` int(11) NOT NULL,
  `date_of_hire` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `salary_term` varchar(255) DEFAULT NULL,
  `user_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `team_member_job_info_seq`
--

CREATE TABLE `team_member_job_info_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `team_member_job_info_seq`
--

INSERT INTO `team_member_job_info_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `team_seq`
--

CREATE TABLE `team_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `team_seq`
--

INSERT INTO `team_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `termination`
--

CREATE TABLE `termination` (
  `id` int(11) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `notice_date` date DEFAULT NULL,
  `termination_date` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `termination_type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `termination`
--

INSERT INTO `termination` (`id`, `department`, `reason`, `is_delete`, `notice_date`, `termination_date`, `employee_id`, `termination_type_id`) VALUES
(1, NULL, 'bv  cv', b'0', '2023-12-16', '2023-12-08', 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `termination_seq`
--

CREATE TABLE `termination_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `termination_seq`
--

INSERT INTO `termination_seq` (`next_val`) VALUES
(51),
(51),
(51),
(51),
(51),
(51),
(51);

-- --------------------------------------------------------

--
-- Table structure for table `termination_type`
--

CREATE TABLE `termination_type` (
  `id` int(11) NOT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `termination_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `termination_type`
--

INSERT INTO `termination_type` (`id`, `is_delete`, `termination_type`) VALUES
(1, b'0', 'rebgv fc');

-- --------------------------------------------------------

--
-- Table structure for table `termination_type_seq`
--

CREATE TABLE `termination_type_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `termination_type_seq`
--

INSERT INTO `termination_type_seq` (`next_val`) VALUES
(51),
(51),
(51),
(51),
(51),
(51),
(51);

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `labels` varchar(255) DEFAULT NULL,
  `last_activity_at` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `assigned_id` int(11) DEFAULT NULL,
  `client_id_id` int(11) DEFAULT NULL,
  `created_by_id` int(11) DEFAULT NULL,
  `requested_by_id` int(11) DEFAULT NULL,
  `ticket_type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tickets`
--

INSERT INTO `tickets` (`id`, `created_at`, `deleted`, `description`, `labels`, `last_activity_at`, `status`, `title`, `assigned_id`, `client_id_id`, `created_by_id`, `requested_by_id`, `ticket_type_id`) VALUES
(1, '2023-11-25 16:34:39.000000', b'1', 'dvfv f gf gfv g ', 'Urgent', NULL, 'Open', 'dfgfbfbgfb', 3, 1, 1, 1, 1),
(2, '2023-11-25 16:35:02.000000', b'1', 'fg b ng  n n n ngn g', 'Perfect', NULL, 'Open', 'fgb fgv g', 4, 1, 1, 2, 2),
(52, '2023-11-28 10:59:35.000000', b'1', 'vfdfv f fbfb', 'HighPriority', NULL, 'Open', 'For Laptop Issue', 3, 1, 1, 1, 2),
(102, '2023-11-28 12:48:16.000000', b'1', 'fbfbfbfb', 'HighPriority', NULL, 'Open', 'dfbfbfbfb', 3, 2, 1, 1, 2),
(103, '2023-11-28 12:56:38.000000', b'1', '', 'Urgent', NULL, 'Open', 'cvbvnn ', 4, 1, 1, 1, 1),
(152, '2023-11-28 15:02:48.000000', b'1', '', 'HighPriority', NULL, 'Open', 'hgngnhh', 4, 2, 1, 1, 2),
(202, '2023-11-28 16:16:47.000000', b'1', '', 'MediumPriority', NULL, 'Open', 'tytyjyuku', 3, 2, 1, 6, 1),
(252, '2023-11-29 11:21:27.000000', b'0', '', 'MediumPriority', NULL, 'Open', 'gjnghmh', 5, 2, 1, 3, 1),
(302, '2023-11-29 11:23:12.000000', b'1', 'gvefvfbrfbb', 'HighPriority', NULL, 'Open', 'gb gvf g', 5, 1, 1, 3, 1),
(352, '2023-11-29 11:26:29.000000', b'0', 'fb gfv gb bg gn g bxc,mvbcmnc vmnvnm vmnvvbjfb f,m', 'LowPriority', NULL, 'Closed', 'cbcvv ', 3, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tickets_files`
--

CREATE TABLE `tickets_files` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_size` double DEFAULT NULL,
  `original_name` varchar(255) DEFAULT NULL,
  `tickets_id` int(11) DEFAULT NULL,
  `uploaded_by_id` int(11) DEFAULT NULL,
  `tickets_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tickets_files`
--

INSERT INTO `tickets_files` (`id`, `created_at`, `deleted`, `description`, `file_name`, `file_size`, `original_name`, `tickets_id`, `uploaded_by_id`, `tickets_id_id`) VALUES
(1, '2023-11-25 16:34:39.000000', NULL, NULL, '794cd2e7-94e6-48d5-a921-3f8fdbce151brohan_InvoiceItem.csv', 126, 'rohan_InvoiceItem.csv', NULL, NULL, 1),
(2, '2023-11-28 10:59:35.000000', NULL, NULL, '979d14a1-9e8d-43ca-883f-6c8cdea97380rohan_InvoiceItem.csv', 126, 'rohan_InvoiceItem.csv', NULL, 1, 52),
(52, '2023-11-28 12:48:16.000000', NULL, NULL, '962b7424-9df0-44e9-ad65-f2743d2e399aWe Bare Bears wallpaper ·① Download free cool  wallpapers for desktop, mobile, laptop in any resolution_ desktop, Android, iPhone, iPad 1920x1080, 320x480, 1680x1050, 1280x900 etc_ WallpaperTag.jpg', 35169, 'We Bare Bears wallpaper ·① Download free cool  wallpapers for desktop, mobile, laptop in any resolution_ desktop, Android, iPhone, iPad 1920x1080, 320x480, 1680x1050, 1280x900 etc_ WallpaperTag.jpg', NULL, 1, 102),
(53, '2023-11-28 12:56:38.000000', NULL, NULL, 'f3a0a256-4899-4e13-b1b8-406ad4f54341defaultUserImage.png', 16608, 'defaultUserImage.png', NULL, 1, 103),
(102, '2023-11-28 15:02:48.000000', NULL, NULL, '8b574e7a-ebcf-49c1-b295-c1dd48439687lord shiva is our soul!!!.jpg', 30648, 'lord shiva is our soul!!!.jpg', NULL, 1, 152),
(152, '2023-11-28 16:16:47.000000', NULL, NULL, '4bac04a1-b084-4695-9b4b-00292bd37d02defaultUserImage.png', 16608, 'defaultUserImage.png', NULL, 1, 202),
(153, '2023-11-28 16:16:47.000000', NULL, NULL, 'b7f052f1-14dc-4511-ba11-7387f6f68742rohan_InvoiceItem (1).csv', 126, 'rohan_InvoiceItem (1).csv', NULL, 1, 202),
(202, '2023-11-29 11:21:27.000000', NULL, NULL, 'b6711da7-818f-41af-bcbe-de8a1793d686rohan_InvoiceItem.csv', 126, 'rohan_InvoiceItem.csv', NULL, 1, 252),
(252, '2023-11-29 11:26:29.000000', NULL, NULL, '4231adb8-e54f-40fe-8ddb-ca67ae5678a9rohan_InvoiceItem.csv', 126, 'rohan_InvoiceItem.csv', NULL, 1, 352);

-- --------------------------------------------------------

--
-- Table structure for table `tickets_files_seq`
--

CREATE TABLE `tickets_files_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tickets_files_seq`
--

INSERT INTO `tickets_files_seq` (`next_val`) VALUES
(351),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `tickets_seq`
--

CREATE TABLE `tickets_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tickets_seq`
--

INSERT INTO `tickets_seq` (`next_val`) VALUES
(451),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `ticket_comments`
--

CREATE TABLE `ticket_comments` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `files` varchar(255) DEFAULT NULL,
  `ticket_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ticket_comments_seq`
--

CREATE TABLE `ticket_comments_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ticket_comments_seq`
--

INSERT INTO `ticket_comments_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `ticket_types`
--

CREATE TABLE `ticket_types` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ticket_types`
--

INSERT INTO `ticket_types` (`id`, `description`, `is_deleted`, `title`) VALUES
(1, 'ghnghhgmgh', b'0', 'b nb n  n'),
(2, 'ggnhg nh', b'0', 'fghgnghmnh');

-- --------------------------------------------------------

--
-- Table structure for table `time_sheets`
--

CREATE TABLE `time_sheets` (
  `id` int(11) NOT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `total_time` varchar(255) DEFAULT NULL,
  `client_id_id` int(11) DEFAULT NULL,
  `project_id_id` int(11) DEFAULT NULL,
  `task_id_id` bigint(20) DEFAULT NULL,
  `assigned_hours` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `time_sheet_date` date DEFAULT NULL,
  `worked_hours` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `trainers`
--

CREATE TABLE `trainers` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trainers`
--

INSERT INTO `trainers` (`id`, `description`, `email`, `first_name`, `is_deleted`, `last_name`, `phone`, `status`, `role_id`) VALUES
(1, 'hthb', 'sumitd.dollop@Gmail.com', 'naman', b'0', 'Dhakar', '+919522215342', 'InActive', 1);

-- --------------------------------------------------------

--
-- Table structure for table `trainers_seq`
--

CREATE TABLE `trainers_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trainers_seq`
--

INSERT INTO `trainers_seq` (`next_val`) VALUES
(51),
(51),
(51),
(51),
(51),
(51),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `training_list`
--

CREATE TABLE `training_list` (
  `id` int(11) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `trainer_cost` bigint(20) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `trainers_id` int(11) DEFAULT NULL,
  `training_type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `training_list`
--

INSERT INTO `training_list` (`id`, `deleted`, `description`, `end_date`, `start_date`, `status`, `trainer_cost`, `employee_id`, `trainers_id`, `training_type_id`) VALUES
(1, b'0', 'vfv', '2023-12-29', '2023-12-22', 'Active', 123243, 3, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `training_list_seq`
--

CREATE TABLE `training_list_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `training_list_seq`
--

INSERT INTO `training_list_seq` (`next_val`) VALUES
(51),
(51),
(51),
(51),
(51),
(51),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `training_type`
--

CREATE TABLE `training_type` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `training_type`
--

INSERT INTO `training_type` (`id`, `description`, `is_delete`, `status`, `type`) VALUES
(1, ' nnb', b'0', 'InActive', 'jhb'),
(2, ' nnb  nmbjkb', b'0', 'InActive', 'jhb');

-- --------------------------------------------------------

--
-- Table structure for table `training_type_seq`
--

CREATE TABLE `training_type_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `training_type_seq`
--

INSERT INTO `training_type_seq` (`next_val`) VALUES
(101),
(101),
(101),
(101),
(101),
(101),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `alternative_address` varchar(255) DEFAULT NULL,
  `alternative_phone` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `disable_login` bit(1) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enable_email_notification` bit(1) DEFAULT NULL,
  `enable_web_notification` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image` tinyblob DEFAULT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  `is_prime` bit(1) DEFAULT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `message_checked_at` date DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `notification_checked_at` date DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `skype` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `sticky_note` varchar(255) DEFAULT NULL,
  `designation_id` int(11) DEFAULT NULL,
  `original_name` varchar(255) DEFAULT NULL,
  `profile_name` varchar(255) DEFAULT NULL,
  `followers_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `address`, `alternative_address`, `alternative_phone`, `created_at`, `deleted`, `disable_login`, `dob`, `email`, `enable_email_notification`, `enable_web_notification`, `first_name`, `gender`, `image`, `is_admin`, `is_prime`, `job_title`, `last_name`, `message_checked_at`, `note`, `notification_checked_at`, `password`, `phone`, `skype`, `ssn`, `status`, `sticky_note`, `designation_id`, `original_name`, `profile_name`, `followers_id`) VALUES
(1, 'banglorexcxzc', 'ufyfyt', '0909883223', '2023-11-04', b'0', b'0', '2003-12-02', 'rohitd.dollop@gmail.com', b'0', b'0', 'Rohit', 'Female', NULL, b'0', b'0', NULL, 'Lodhi', NULL, NULL, NULL, '$2a$10$XwKbn.xNa6zdm5Lrz/pLV.mHqCj355lr64snUxtppIzflYOZiLyNa', '0464446767', NULL, 'fsdf', NULL, NULL, 1, 'download.jpg', '40c2f40e-633c-4520-9a0e-4a177fd8ea3fdownload.jpg', 102),
(2, 'rohitlodhi nsfdsafsadf', 'indore', '6263703637', '2023-11-07', b'0', b'0', '2000-11-15', 'sumitdhakar@gmail.com', b'0', b'0', 'Sumit', 'Male', NULL, b'0', b'0', NULL, 'Lodhi', NULL, NULL, NULL, '$2a$10$AtHRgF/CMR15BL8t51EwTeloQkJBHSKp2M/LOizR29ulS9pnMBFcy', '6273984598', NULL, 'fsdf', NULL, NULL, 2, 'marvel_doctor_strange-t2.jpg', '8f238689-ef5e-40c6-bf0d-ba82a7cdbca5marvel_doctor_strange-t2.jpg', 302),
(3, 'vidiskjn', 'mnb1', '7687687644', '2023-11-23', b'0', b'0', '2000-11-23', 'rohan.dollop@gmail.com', b'0', b'0', 'fbrthr6jjnythj', 'Male', NULL, b'0', b'0', NULL, 'sharma', NULL, NULL, NULL, '$2a$10$1JdFRISQuUlfEMxo9lJVlu3ZFkXQLuBtfkk4ji1qIcc5FReRoxiqu', '9098832234', NULL, 'fsdg', NULL, NULL, 2, 'lord shiva is our soul!!!.jpg', '2024b0a2-e13d-4246-ba1c-7303ede9096elord shiva is our soul!!!.jpg', 152),
(4, 'Indore', 'mnb1', '7687687612', '2023-11-23', b'1', b'0', '2000-02-23', 'rohansharma39033@gmail.com', b'0', b'0', 'sddsdsds', 'Male', NULL, b'0', b'0', NULL, 'bcdf', NULL, NULL, NULL, '$2a$10$dOs2dmHjXWP3mVP0GbOD0.h2lux15y6Kn.h2.fCt1CGBGSds.mS2K', '8678687612', NULL, 'fsdg', NULL, NULL, 1, 'profileImage', 'defaultUserImage.png', 352),
(5, NULL, NULL, NULL, '2023-11-28', b'0', b'0', NULL, 'sumitd.dollop@gmail.com12', b'0', b'0', 'naman', 'Female', NULL, b'0', NULL, NULL, 'Dhakar', NULL, NULL, NULL, '$2a$10$oKxdAdcyx7el7ecP9dX0fO6urnmbB8s2sUpGCNjpcD1ZhESHzQipS', NULL, NULL, NULL, NULL, NULL, 2, 'willian-justen-de-vasconcellos-JuhxRDzAHok-unsplash.jpg', 'cf12a53f-8da4-4cc2-9157-d2c8a63106cbwillian-justen-de-vasconcellos-JuhxRDzAHok-unsplash.jpg', 103),
(6, 'Bhopal', 'Rasien', '9522215342', '2023-11-28', b'0', b'0', '2001-05-12', 'sumitd.dllop@gmail.com12', b'0', b'0', 'nitinb', 'Male', NULL, b'0', b'0', NULL, 'Dhakar', NULL, NULL, NULL, '$2a$10$uSgz2kaf57dzR9O8x4/4ZOeZPRxell2n84fLbzNie8jVuIEIoD12S', '9522215342', NULL, '1234', NULL, NULL, 2, 'Capture001.png', '100dbd77-e4ac-4462-8cd0-1a9663a6142eCapture001.png', NULL),
(7, NULL, NULL, NULL, '2023-12-01', b'1', b'0', NULL, 'patidarsurbhi270@gmail.com', b'0', b'0', NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, '$2a$10$1BxHjQsYkaGP6TOR7CgFoO2X7pAG/saccwQYWM7hWJdJXF9VB3cLe', NULL, NULL, NULL, NULL, NULL, NULL, 'profileImage', 'defaultUserImage.png', NULL),
(8, NULL, NULL, NULL, '2023-12-04', b'0', b'0', NULL, 'sumitd.dollop@gmail.com', b'0', b'0', 'sumit', NULL, NULL, b'0', NULL, NULL, 'Dhakar', NULL, NULL, NULL, '$2a$10$P6pQPmYGqeeX/f5QxSx4fuQqIToAygDqeHe53UasSmqyUa.xFIxK6', NULL, NULL, NULL, NULL, NULL, NULL, 'Capture001.png', '37254a4b-0892-4457-bdc4-cd7d0ea1cf0bCapture001.png', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_active_status`
--

CREATE TABLE `user_active_status` (
  `id` bigint(20) NOT NULL,
  `is_showable` bit(1) DEFAULT NULL,
  `last_active` datetime(6) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_active_status_seq`
--

CREATE TABLE `user_active_status_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_active_status_seq`
--

INSERT INTO `user_active_status_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `user_registration`
--

CREATE TABLE `user_registration` (
  `id` int(11) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `generated_time` datetime(6) DEFAULT NULL,
  `otp` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_registration`
--

INSERT INTO `user_registration` (`id`, `active`, `email`, `generated_time`, `otp`, `password`, `user_name`) VALUES
(1, b'1', 'rohitd.dollop@gmail.com', '2023-12-04 11:00:02.000000', '7840', '$2a$10$J5f4sHmr3CayxFuShRb2EOdSCdMj8Zj6ykMCmAjQM2QmZEHleC3vW', 'Rohit Lodhi'),
(2, b'0', 'rohan.dollop@gmail.com', '2023-11-28 10:32:53.000000', '4024', '$2a$10$CILcuFixlKR11OPva3aQrOo.6.8CNN64Rm44smaIMV.1/lUJsjfdC', 'rohan.dollop@gmail.com'),
(3, b'0', 'rohansharma39033@gmail.com', '2023-11-28 10:38:20.000000', '4381', '$2a$10$HmSmN.WqEttuCeC93TagzefkkS8Daf9cCODNaSr5jbqg9.tVILiBS', 'rohan sharma'),
(102, b'0', 'patidars5ty@gmail.com', '2023-12-01 15:03:09.000000', '8759', '$2a$10$SozUoKpYIKIlaa1YzqGPB.nMipziuHGITBc8MvkvaEeGQDK413azG', 'surbhi'),
(103, b'1', 'patidarsurbhi270@gmail.com', '2023-12-01 15:04:56.000000', '8878', '$2a$10$1BxHjQsYkaGP6TOR7CgFoO2X7pAG/saccwQYWM7hWJdJXF9VB3cLe', 'Surbhi'),
(152, b'1', 'sumitd.dollop@gmail.com', '2023-12-07 11:25:18.000000', '9760', '$2a$10$WWAtVFlN/dGQk4JJ4MPtVOAeFRu9AZFL5lkqv/lYYwoYLw6h1CS5q', 'sumit'),
(202, b'0', 'patidarsurbh12i270@gmail.com', '2023-12-06 11:30:46.000000', '8744', '$2a$10$qTPWSVxnfa/CZoqvDhlOFeqFJ6jEkCp3cdgkBh5d6uXS8hd4LIf0G', 'Rohan');

-- --------------------------------------------------------

--
-- Table structure for table `user_registration_seq`
--

CREATE TABLE `user_registration_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_registration_seq`
--

INSERT INTO `user_registration_seq` (`next_val`) VALUES
(301),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `id` bigint(20) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`id`, `role_id`, `u_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(302, 2, 3),
(303, 2, 4),
(352, 2, 5),
(354, 2, 6),
(402, 1, 5),
(502, 1, 2),
(503, 2, 2),
(552, 2, 7),
(602, 2, 8);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles_seq`
--

CREATE TABLE `user_roles_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_roles_seq`
--

INSERT INTO `user_roles_seq` (`next_val`) VALUES
(701),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `user_types`
--

CREATE TABLE `user_types` (
  `id` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity_logs`
--
ALTER TABLE `activity_logs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `announcements`
--
ALTER TABLE `announcements`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `applied_candidate`
--
ALTER TABLE `applied_candidate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKerxyduo757d5irctd4d4ttjxo` (`manage_jobs_id`);

--
-- Indexes for table `assets`
--
ALTER TABLE `assets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1f99qn6iecx3hfcy2vupt6e9k` (`asset_user_id`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKja872f4miuk8o46tthms2j9ph` (`user_id_id`);

--
-- Indexes for table `bank_information`
--
ALTER TABLE `bank_information`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_a9novfln740thk63wftcrargq` (`user_id`);

--
-- Indexes for table `chat_files`
--
ALTER TABLE `chat_files`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK129fq6f2mptnpgp3fvm5f7lcq` (`message_id`);

--
-- Indexes for table `ci_sessions`
--
ALTER TABLE `ci_sessions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_idwnnk6mns0b3wqhktbcq5uw6` (`owner_id`);

--
-- Indexes for table `client_labels`
--
ALTER TABLE `client_labels`
  ADD KEY `FKkv4iwtmrgt17pq1sdso19bldf` (`clients_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKakkm6qfydu7vgnfne1yo0xmed` (`created_by_id`),
  ADD KEY `FKhb8drwfb8xnr7h8itchtt24j8` (`project_id_id`),
  ADD KEY `FK8pf0ya2fmlgk7s1wyl0dl5sf0` (`task_id_id`),
  ADD KEY `FKi7pp0331nbiwd2844kg78kfwb` (`task_id`);

--
-- Indexes for table `company_settings`
--
ALTER TABLE `company_settings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `conversation`
--
ALTER TABLE `conversation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqslncg7pcc89gvjjpp9jypbha` (`user_2`),
  ADD KEY `FKbpye100rp9qp74u7na30k4ejr` (`user_1`);

--
-- Indexes for table `custom_fields`
--
ALTER TABLE `custom_fields`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `custom_field_values`
--
ALTER TABLE `custom_field_values`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK755inoxvxi1jfgdah5twffrpv` (`manage_jobs_id`);

--
-- Indexes for table `designation`
--
ALTER TABLE `designation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh72becwvjn8flf7qpgs8vgaa6` (`department_id`);

--
-- Indexes for table `designation_performance_indicator`
--
ALTER TABLE `designation_performance_indicator`
  ADD UNIQUE KEY `UK_bef95vm0s4gcoathgmoc7uijt` (`performance_indicator_id`),
  ADD KEY `FKcnka5ewti9jnvriaxv53cc8sp` (`designation_id`);

--
-- Indexes for table `education_informations`
--
ALTER TABLE `education_informations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb0xhp1ju06h6qq86u5hpqr7ew` (`user_id`);

--
-- Indexes for table `email_templates`
--
ALTER TABLE `email_templates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `emergency_contact`
--
ALTER TABLE `emergency_contact`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_7ngsqlyjlf1aep0hbrsbtv7y1` (`user_id`);

--
-- Indexes for table `estimates`
--
ALTER TABLE `estimates`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcq9j4ubvy2414g37rpvj6s4wa` (`client_id_id`),
  ADD KEY `FK7bi59k7tb02x38sg7yfb96ell` (`project_id_id`),
  ADD KEY `FK7pyhpr618nfr7oa6dnp2bhvi1` (`taxe_id_id`);

--
-- Indexes for table `estimate_forms`
--
ALTER TABLE `estimate_forms`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `estimate_items`
--
ALTER TABLE `estimate_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqgbltt3sxh9ec1eyv22mmr6w4` (`estimate_id`);

--
-- Indexes for table `estimate_requests`
--
ALTER TABLE `estimate_requests`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjcvs5itc51374ggtunwfosfm9` (`client_id_id`),
  ADD KEY `FK70i8d06ovajj9i6g8t1vrcdg9` (`estimate_form_id_id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcx79wrkd5hu3gw844pc5judb0` (`client_id_id`);

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmots4hss6f6t9vln8s60aua2n` (`user_id_id`);

--
-- Indexes for table `expenses_files`
--
ALTER TABLE `expenses_files`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc1en8w5sxoxklj48nolq9xb0t` (`expenses_id_id`);

--
-- Indexes for table `expense_categories`
--
ALTER TABLE `expense_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `experience_informations`
--
ALTER TABLE `experience_informations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2xfddh8a3hgldba69ntcy5om1` (`user_id`);

--
-- Indexes for table `family_informations`
--
ALTER TABLE `family_informations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlf1p32txp2eglc4ee896ehp9f` (`user_id`);

--
-- Indexes for table `goal_list`
--
ALTER TABLE `goal_list`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6yncs5vcunlf7gcx1rpsah1du` (`goal_type_id`);

--
-- Indexes for table `goal_type`
--
ALTER TABLE `goal_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `help_articles`
--
ALTER TABLE `help_articles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc1ddroya43utlkhgo7vg4wr1k` (`category_id_id`);

--
-- Indexes for table `help_categories`
--
ALTER TABLE `help_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `holidays`
--
ALTER TABLE `holidays`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoices`
--
ALTER TABLE `invoices`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdojwc0lrj6v3yhty1wk9aajy5` (`client_id_id`),
  ADD KEY `FKs4rf0vnpho9n0eubwsgqg3en2` (`project_id_id`),
  ADD KEY `FK8b7w7momtlg8pthj2u7kerklf` (`tax_id_id`);

--
-- Indexes for table `invoices_items`
--
ALTER TABLE `invoices_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3qdb4fsrw129gotn9rxs8n2wy` (`invoices_id`);

--
-- Indexes for table `invoice_payments`
--
ALTER TABLE `invoice_payments`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_bcnp6sn9hp9xxtnx1qyjx5gdn` (`invoice_id_id`),
  ADD KEY `FKe8blhcr76wxepgc9uk0m82v96` (`payment_method_id_id`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `leaves`
--
ALTER TABLE `leaves`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfixkbk6u4selcsan3cpl13h6a` (`employee_id`);

--
-- Indexes for table `leave_applications`
--
ALTER TABLE `leave_applications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqc4o91x73s8xoi8n90m648i6l` (`applicant_id_id`),
  ADD KEY `FKh5ru6riay58nog8goxyysy5xd` (`checked_by_id`),
  ADD KEY `FKjsbceyiow7aldopdcsqb4g8df` (`leave_type_id_id`);

--
-- Indexes for table `leave_types`
--
ALTER TABLE `leave_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `manage_jobs`
--
ALTER TABLE `manage_jobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjcoqej0r2j3uwd3j7g1a08oey` (`department_id`),
  ADD KEY `FK3bocb1hn4xy85jou0vcm0tphe` (`job_title_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6yskk3hxw5sklwgi25y6d5u1l` (`conversation_id`),
  ADD KEY `FK6ym9ojpy2t5aytdw25r4hsn2s` (`from_user_id`),
  ADD KEY `FK1uv23ovkid0grayvivw5vkpf0` (`to_user_id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `milestones`
--
ALTER TABLE `milestones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKalmyh3g2ac8as2t0kkbo9ss7m` (`project_id_id`);

--
-- Indexes for table `module_permissions`
--
ALTER TABLE `module_permissions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrp3s1ttwis8f0vh4uxcul7l4x` (`client_id_id`),
  ADD KEY `FKrmi1thqctood64k3256mj0pfr` (`project_id_id`),
  ADD KEY `FKaet7hjxq2mg2qby3c48tpr3kx` (`user_id_id`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_38aqgh4qi8e5h66iqx2njdf0p` (`activity_log_id_id`),
  ADD UNIQUE KEY `UK_ccqga8h7bv6tcyd20frobnqi2` (`invoice_payment_id_id`),
  ADD UNIQUE KEY `UK_aj5w464onu5cougb8sth7uu57` (`leave_id_id`),
  ADD UNIQUE KEY `UK_f5uyv04qy6ogep0ge2252t1f7` (`post_id_id`),
  ADD UNIQUE KEY `UK_1kijidpckq4246dl5kyrvvcr9` (`project_comment_id_id`),
  ADD UNIQUE KEY `UK_fs3cd6rg8o8t38rms5fq2tdgs` (`ticket_comment_id_id`),
  ADD UNIQUE KEY `UK_s3ml1aifinfajpe16a0kcencf` (`to_user_id_id`),
  ADD KEY `FKrekc67andeeas5pwmavy3exwe` (`client_id_id`),
  ADD KEY `FKn0a6bc25slhhf6g9381xw2m2t` (`estimate_id_id`),
  ADD KEY `FK4cj8p71bcncfaxvsms8avh2cc` (`estimate_request_id_id`),
  ADD KEY `FKk74xtm6qtwjb1qbxmsixud01v` (`invoice_id_id`),
  ADD KEY `FKhy7dk3p1kym8q161ngso60x4f` (`project_file_id_id`),
  ADD KEY `FKcjr85bedgs58vvrc9dandwakj` (`project_id_id`),
  ADD KEY `FKbra2ivvecfmkhjeay5lah2x15` (`task_id_id`),
  ADD KEY `FK4odjgsx9jow2xslattp4nq71h` (`ticket_id_id`),
  ADD KEY `FKy4c1q0dfexnkvqenktfohyy4` (`user_id_id`);

--
-- Indexes for table `notification_settings`
--
ALTER TABLE `notification_settings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `over_time`
--
ALTER TABLE `over_time`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK77pyreelygc9f7f1xg0eyflrp` (`approved_by_id`),
  ADD KEY `FKl0s1vbcysacmg0cow2ihprhp9` (`user_id_id`);

--
-- Indexes for table `payment_methods`
--
ALTER TABLE `payment_methods`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `paypal_ipn`
--
ALTER TABLE `paypal_ipn`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payroll_items_additions`
--
ALTER TABLE `payroll_items_additions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payroll_items_deductions`
--
ALTER TABLE `payroll_items_deductions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payroll_items_overtime`
--
ALTER TABLE `payroll_items_overtime`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `performance_appraisal`
--
ALTER TABLE `performance_appraisal`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_3h2354i7w1776oplwsecb4ahf` (`user_id`);

--
-- Indexes for table `performance_indicator`
--
ALTER TABLE `performance_indicator`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp2s0le00b4q4289i52aiokves` (`designation_id`);

--
-- Indexes for table `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKscn1k1gy21or31vapehxyhudo` (`module_permissions_id`),
  ADD KEY `FKsglsdxqwhyhbonekk1iickjvu` (`role_permissions`);

--
-- Indexes for table `personal_informations`
--
ALTER TABLE `personal_informations`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ksbgb2xefbajdln2ijur0un62` (`user_id`);

--
-- Indexes for table `policy`
--
ALTER TABLE `policy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpm3y7pcs02o9spl64325sua2k` (`department_id`);

--
-- Indexes for table `policy_files`
--
ALTER TABLE `policy_files`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk4x52qfuopxvfslpyoqgog3te` (`policy_id`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKksdiyuily2f4ca2y53k07pmq` (`client_id`),
  ADD KEY `FKm6hycbkdujcdmevl11ir8dphq` (`created_by_id`);

--
-- Indexes for table `projects_tasks`
--
ALTER TABLE `projects_tasks`
  ADD UNIQUE KEY `UK_6vsxsod0qnr1k2um2d6c81xf2` (`tasks_id`),
  ADD KEY `FKt6x9t4hfh5x0kplu5cy9nie04` (`projects_id`);

--
-- Indexes for table `project_files`
--
ALTER TABLE `project_files`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKldt4isruox2m6kjp4k8p4q5l0` (`project_id_id`),
  ADD KEY `FKad8sm7ile5i0owrcqvj3342bo` (`uploaded_by_id`),
  ADD KEY `FK9ko3l1na4vj9fnq8inxsfl1jm` (`project_comment_id`);

--
-- Indexes for table `project_labels`
--
ALTER TABLE `project_labels`
  ADD KEY `FKigkjo8qojyc6ukebdxafhv8uk` (`projects_id`);

--
-- Indexes for table `project_members`
--
ALTER TABLE `project_members`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK23le78u5mj7oeys49utwgra08` (`project_id_id`),
  ADD KEY `FK2x0ujvyq3w6bob0svnuyxxv03` (`user_id_id`);

--
-- Indexes for table `project_settings`
--
ALTER TABLE `project_settings`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_qgginguxu4joqe2g2gb8l3vk2` (`project_id_id`);

--
-- Indexes for table `project_time`
--
ALTER TABLE `project_time`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_32lfromu8if0mhygyar3my6mw` (`project_id_id`),
  ADD UNIQUE KEY `UK_pgib9qky309hohq1ydkmgej0u` (`task_id_id`),
  ADD UNIQUE KEY `UK_ox57crv7kx2kgei4rgl2hmcos` (`user_id_id`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa92roshwfdch4c24l19jn8kns` (`designation_to_id`),
  ADD KEY `FKiwnyrjvy8f5kr1rrc5v62nq0o` (`employee_id`);

--
-- Indexes for table `resignation`
--
ALTER TABLE `resignation`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_13eydpvba2jsd83vrxrs0fkhq` (`employee_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `settings`
--
ALTER TABLE `settings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `social_links`
--
ALTER TABLE `social_links`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_jrg24nfivc7pgnvft630l2r76` (`user_id_id`);

--
-- Indexes for table `staff_salary`
--
ALTER TABLE `staff_salary`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK301qbskcgo118k4cf9tuwgg8s` (`staff_id`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4516wfa828r15k9u3iw5er4vi` (`assigned_to_id`),
  ADD KEY `FKitmb97h7s96bhbvs9mruwhqta` (`project_id_id`),
  ADD KEY `FKsfhn82y57i3k9uxww1s007acc` (`project_id`);

--
-- Indexes for table `tasks_collaborators`
--
ALTER TABLE `tasks_collaborators`
  ADD KEY `FKrm3ydprkhukbxllpwm2a33823` (`collaborators_id`),
  ADD KEY `FKblseuq8clfuew5ighobrks0oa` (`tasks_id`);

--
-- Indexes for table `task_labels`
--
ALTER TABLE `task_labels`
  ADD KEY `FKehsovvjgddjmo7xjfstql0po2` (`tasks_id`);

--
-- Indexes for table `taxes`
--
ALTER TABLE `taxes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `team_member_job_info`
--
ALTER TABLE `team_member_job_info`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiy00uhgcvil66vxi653ykxa04` (`user_id_id`);

--
-- Indexes for table `termination`
--
ALTER TABLE `termination`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_q436cc7w6cvlsfpv6g40fraoe` (`employee_id`),
  ADD UNIQUE KEY `UK_p9oaalhw2rbkmqf2q4ooejuwe` (`termination_type_id`);

--
-- Indexes for table `termination_type`
--
ALTER TABLE `termination_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK19o3vkge04ngs94cy5nlq9nur` (`assigned_id`),
  ADD KEY `FKh3vsyrqpoxg60oiwt048ktr9s` (`client_id_id`),
  ADD KEY `FKmyfs6v8v389r3g1rq49cutsda` (`created_by_id`),
  ADD KEY `FKpj6s6xyw9jsk1xu77buio8o4f` (`requested_by_id`),
  ADD KEY `FKotik7mbbb14hu8n9og7o92k5h` (`ticket_type_id`);

--
-- Indexes for table `tickets_files`
--
ALTER TABLE `tickets_files`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK76op8b1fh6cdqbdlt9qyeoi6o` (`tickets_id`),
  ADD KEY `FKnugvgvahku10bsglpp7yhytme` (`uploaded_by_id`),
  ADD KEY `FK77tm3uhhllsii5g9benjl57ow` (`tickets_id_id`);

--
-- Indexes for table `ticket_comments`
--
ALTER TABLE `ticket_comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1gq2hpe494e1w13h8e2mo13dx` (`ticket_id_id`);

--
-- Indexes for table `ticket_types`
--
ALTER TABLE `ticket_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `time_sheets`
--
ALTER TABLE `time_sheets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi8mc17kr7yvochdh79p6h0lg7` (`client_id_id`),
  ADD KEY `FKqhoat72b96dc3ismpmybj9h16` (`project_id_id`),
  ADD KEY `FK4otfvsut2p2raqwq7n3l79eww` (`task_id_id`),
  ADD KEY `FKrya2n0ndau74fhqewp3p8ttb6` (`user_id`);

--
-- Indexes for table `trainers`
--
ALTER TABLE `trainers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlp469npgapmjj40fq5u60o863` (`role_id`);

--
-- Indexes for table `training_list`
--
ALTER TABLE `training_list`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg6p39icdobycgweuib6qojyop` (`employee_id`),
  ADD KEY `FKody6xnbfn0oxj1fmyp7y8rrms` (`trainers_id`),
  ADD KEY `FKa5xyj68olqtdh436elxqfrfyy` (`training_type_id`);

--
-- Indexes for table `training_type`
--
ALTER TABLE `training_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe3n1ycu62p82yg0qd3rfeckd2` (`designation_id`),
  ADD KEY `FK1c00dln3le1vrg6nl7kboi01c` (`followers_id`);

--
-- Indexes for table `user_active_status`
--
ALTER TABLE `user_active_status`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_4mxqxq14hpao6upblowjq1amu` (`user_id`);

--
-- Indexes for table `user_registration`
--
ALTER TABLE `user_registration`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  ADD KEY `FK1mac1j6p5n4qb8okpetcbjji2` (`u_id`);

--
-- Indexes for table `user_types`
--
ALTER TABLE `user_types`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `conversation`
--
ALTER TABLE `conversation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `performance_appraisal`
--
ALTER TABLE `performance_appraisal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `performance_indicator`
--
ALTER TABLE `performance_indicator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `ticket_types`
--
ALTER TABLE `ticket_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `time_sheets`
--
ALTER TABLE `time_sheets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user_types`
--
ALTER TABLE `user_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `applied_candidate`
--
ALTER TABLE `applied_candidate`
  ADD CONSTRAINT `FKerxyduo757d5irctd4d4ttjxo` FOREIGN KEY (`manage_jobs_id`) REFERENCES `manage_jobs` (`id`);

--
-- Constraints for table `assets`
--
ALTER TABLE `assets`
  ADD CONSTRAINT `FK1f99qn6iecx3hfcy2vupt6e9k` FOREIGN KEY (`asset_user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `FKja872f4miuk8o46tthms2j9ph` FOREIGN KEY (`user_id_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `bank_information`
--
ALTER TABLE `bank_information`
  ADD CONSTRAINT `FK4s89gck3gk8jc8g3fup27h4hj` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `chat_files`
--
ALTER TABLE `chat_files`
  ADD CONSTRAINT `FK129fq6f2mptnpgp3fvm5f7lcq` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`);

--
-- Constraints for table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `FK85q9co3b5a74s7prbrws4g2un` FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `client_labels`
--
ALTER TABLE `client_labels`
  ADD CONSTRAINT `FKkv4iwtmrgt17pq1sdso19bldf` FOREIGN KEY (`clients_id`) REFERENCES `clients` (`id`);

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `FK8pf0ya2fmlgk7s1wyl0dl5sf0` FOREIGN KEY (`task_id_id`) REFERENCES `tasks` (`id`),
  ADD CONSTRAINT `FKakkm6qfydu7vgnfne1yo0xmed` FOREIGN KEY (`created_by_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKhb8drwfb8xnr7h8itchtt24j8` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `FKi7pp0331nbiwd2844kg78kfwb` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Constraints for table `conversation`
--
ALTER TABLE `conversation`
  ADD CONSTRAINT `FKbpye100rp9qp74u7na30k4ejr` FOREIGN KEY (`user_1`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKqslncg7pcc89gvjjpp9jypbha` FOREIGN KEY (`user_2`) REFERENCES `users` (`id`);

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `FK755inoxvxi1jfgdah5twffrpv` FOREIGN KEY (`manage_jobs_id`) REFERENCES `manage_jobs` (`id`);

--
-- Constraints for table `designation`
--
ALTER TABLE `designation`
  ADD CONSTRAINT `FKh72becwvjn8flf7qpgs8vgaa6` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `designation_performance_indicator`
--
ALTER TABLE `designation_performance_indicator`
  ADD CONSTRAINT `FK2khkj06jy9kwbawwedul48e0p` FOREIGN KEY (`performance_indicator_id`) REFERENCES `performance_indicator` (`id`),
  ADD CONSTRAINT `FKcnka5ewti9jnvriaxv53cc8sp` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`id`);

--
-- Constraints for table `education_informations`
--
ALTER TABLE `education_informations`
  ADD CONSTRAINT `FKb0xhp1ju06h6qq86u5hpqr7ew` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `emergency_contact`
--
ALTER TABLE `emergency_contact`
  ADD CONSTRAINT `FKntgmuu2ichvsflk6uupb4w6q9` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `estimates`
--
ALTER TABLE `estimates`
  ADD CONSTRAINT `FK7bi59k7tb02x38sg7yfb96ell` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `FK7pyhpr618nfr7oa6dnp2bhvi1` FOREIGN KEY (`taxe_id_id`) REFERENCES `taxes` (`id`),
  ADD CONSTRAINT `FKcq9j4ubvy2414g37rpvj6s4wa` FOREIGN KEY (`client_id_id`) REFERENCES `clients` (`id`);

--
-- Constraints for table `estimate_items`
--
ALTER TABLE `estimate_items`
  ADD CONSTRAINT `FKqgbltt3sxh9ec1eyv22mmr6w4` FOREIGN KEY (`estimate_id`) REFERENCES `estimates` (`id`);

--
-- Constraints for table `estimate_requests`
--
ALTER TABLE `estimate_requests`
  ADD CONSTRAINT `FK70i8d06ovajj9i6g8t1vrcdg9` FOREIGN KEY (`estimate_form_id_id`) REFERENCES `estimate_forms` (`id`),
  ADD CONSTRAINT `FKjcvs5itc51374ggtunwfosfm9` FOREIGN KEY (`client_id_id`) REFERENCES `clients` (`id`);

--
-- Constraints for table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `FKcx79wrkd5hu3gw844pc5judb0` FOREIGN KEY (`client_id_id`) REFERENCES `clients` (`id`);

--
-- Constraints for table `expenses`
--
ALTER TABLE `expenses`
  ADD CONSTRAINT `FKmots4hss6f6t9vln8s60aua2n` FOREIGN KEY (`user_id_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `expenses_files`
--
ALTER TABLE `expenses_files`
  ADD CONSTRAINT `FKc1en8w5sxoxklj48nolq9xb0t` FOREIGN KEY (`expenses_id_id`) REFERENCES `expenses` (`id`);

--
-- Constraints for table `experience_informations`
--
ALTER TABLE `experience_informations`
  ADD CONSTRAINT `FK2xfddh8a3hgldba69ntcy5om1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `family_informations`
--
ALTER TABLE `family_informations`
  ADD CONSTRAINT `FKlf1p32txp2eglc4ee896ehp9f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `goal_list`
--
ALTER TABLE `goal_list`
  ADD CONSTRAINT `FK6yncs5vcunlf7gcx1rpsah1du` FOREIGN KEY (`goal_type_id`) REFERENCES `goal_type` (`id`);

--
-- Constraints for table `help_articles`
--
ALTER TABLE `help_articles`
  ADD CONSTRAINT `FKc1ddroya43utlkhgo7vg4wr1k` FOREIGN KEY (`category_id_id`) REFERENCES `help_categories` (`id`);

--
-- Constraints for table `invoices`
--
ALTER TABLE `invoices`
  ADD CONSTRAINT `FK8b7w7momtlg8pthj2u7kerklf` FOREIGN KEY (`tax_id_id`) REFERENCES `taxes` (`id`),
  ADD CONSTRAINT `FKdojwc0lrj6v3yhty1wk9aajy5` FOREIGN KEY (`client_id_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `FKs4rf0vnpho9n0eubwsgqg3en2` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`);

--
-- Constraints for table `invoices_items`
--
ALTER TABLE `invoices_items`
  ADD CONSTRAINT `FK3qdb4fsrw129gotn9rxs8n2wy` FOREIGN KEY (`invoices_id`) REFERENCES `invoices` (`id`);

--
-- Constraints for table `invoice_payments`
--
ALTER TABLE `invoice_payments`
  ADD CONSTRAINT `FKahu8e18qwv1g461sognmg5fmc` FOREIGN KEY (`invoice_id_id`) REFERENCES `invoices` (`id`),
  ADD CONSTRAINT `FKe8blhcr76wxepgc9uk0m82v96` FOREIGN KEY (`payment_method_id_id`) REFERENCES `payment_methods` (`id`);

--
-- Constraints for table `leaves`
--
ALTER TABLE `leaves`
  ADD CONSTRAINT `FKfixkbk6u4selcsan3cpl13h6a` FOREIGN KEY (`employee_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `leave_applications`
--
ALTER TABLE `leave_applications`
  ADD CONSTRAINT `FKh5ru6riay58nog8goxyysy5xd` FOREIGN KEY (`checked_by_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKjsbceyiow7aldopdcsqb4g8df` FOREIGN KEY (`leave_type_id_id`) REFERENCES `leave_types` (`id`),
  ADD CONSTRAINT `FKqc4o91x73s8xoi8n90m648i6l` FOREIGN KEY (`applicant_id_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `manage_jobs`
--
ALTER TABLE `manage_jobs`
  ADD CONSTRAINT `FK3bocb1hn4xy85jou0vcm0tphe` FOREIGN KEY (`job_title_id`) REFERENCES `designation` (`id`),
  ADD CONSTRAINT `FKjcoqej0r2j3uwd3j7g1a08oey` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK1uv23ovkid0grayvivw5vkpf0` FOREIGN KEY (`to_user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FK6ym9ojpy2t5aytdw25r4hsn2s` FOREIGN KEY (`from_user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FK6yskk3hxw5sklwgi25y6d5u1l` FOREIGN KEY (`conversation_id`) REFERENCES `conversation` (`id`);

--
-- Constraints for table `milestones`
--
ALTER TABLE `milestones`
  ADD CONSTRAINT `FKalmyh3g2ac8as2t0kkbo9ss7m` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`);

--
-- Constraints for table `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `FKaet7hjxq2mg2qby3c48tpr3kx` FOREIGN KEY (`user_id_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKrmi1thqctood64k3256mj0pfr` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `FKrp3s1ttwis8f0vh4uxcul7l4x` FOREIGN KEY (`client_id_id`) REFERENCES `clients` (`id`);

--
-- Constraints for table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `FK1727pmqs8rmqdv5b615x1knyi` FOREIGN KEY (`ticket_comment_id_id`) REFERENCES `ticket_comments` (`id`),
  ADD CONSTRAINT `FK4cj8p71bcncfaxvsms8avh2cc` FOREIGN KEY (`estimate_request_id_id`) REFERENCES `estimate_requests` (`id`),
  ADD CONSTRAINT `FK4odjgsx9jow2xslattp4nq71h` FOREIGN KEY (`ticket_id_id`) REFERENCES `tickets` (`id`),
  ADD CONSTRAINT `FK6qhmry7h73dsrkucix34jtqa0` FOREIGN KEY (`project_comment_id_id`) REFERENCES `comments` (`id`),
  ADD CONSTRAINT `FK74w0fikp6uccxad0cskgki86u` FOREIGN KEY (`to_user_id_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKahmm5ag538gkelk5sp4td22im` FOREIGN KEY (`activity_log_id_id`) REFERENCES `activity_logs` (`id`),
  ADD CONSTRAINT `FKblmhw6c42abaoplayfe5su9v3` FOREIGN KEY (`invoice_payment_id_id`) REFERENCES `invoice_payments` (`id`),
  ADD CONSTRAINT `FKbra2ivvecfmkhjeay5lah2x15` FOREIGN KEY (`task_id_id`) REFERENCES `tasks` (`id`),
  ADD CONSTRAINT `FKcjr85bedgs58vvrc9dandwakj` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `FKext58bvhva6dyvygj36tj5hda` FOREIGN KEY (`post_id_id`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `FKhy7dk3p1kym8q161ngso60x4f` FOREIGN KEY (`project_file_id_id`) REFERENCES `project_files` (`id`),
  ADD CONSTRAINT `FKk74xtm6qtwjb1qbxmsixud01v` FOREIGN KEY (`invoice_id_id`) REFERENCES `invoices` (`id`),
  ADD CONSTRAINT `FKn0a6bc25slhhf6g9381xw2m2t` FOREIGN KEY (`estimate_id_id`) REFERENCES `estimates` (`id`),
  ADD CONSTRAINT `FKo3dyibc5iudue3h4pu1o2j0la` FOREIGN KEY (`leave_id_id`) REFERENCES `leave_applications` (`id`),
  ADD CONSTRAINT `FKrekc67andeeas5pwmavy3exwe` FOREIGN KEY (`client_id_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `FKy4c1q0dfexnkvqenktfohyy4` FOREIGN KEY (`user_id_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `over_time`
--
ALTER TABLE `over_time`
  ADD CONSTRAINT `FK77pyreelygc9f7f1xg0eyflrp` FOREIGN KEY (`approved_by_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKl0s1vbcysacmg0cow2ihprhp9` FOREIGN KEY (`user_id_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `performance_appraisal`
--
ALTER TABLE `performance_appraisal`
  ADD CONSTRAINT `FKssfo8cc18l59ux45vnb45cgaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `performance_indicator`
--
ALTER TABLE `performance_indicator`
  ADD CONSTRAINT `FKp2s0le00b4q4289i52aiokves` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`id`);

--
-- Constraints for table `permissions`
--
ALTER TABLE `permissions`
  ADD CONSTRAINT `FKscn1k1gy21or31vapehxyhudo` FOREIGN KEY (`module_permissions_id`) REFERENCES `module_permissions` (`id`),
  ADD CONSTRAINT `FKsglsdxqwhyhbonekk1iickjvu` FOREIGN KEY (`role_permissions`) REFERENCES `roles` (`id`);

--
-- Constraints for table `personal_informations`
--
ALTER TABLE `personal_informations`
  ADD CONSTRAINT `FK9jeeorp6mebtb9gcrlh7xn2vd` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `policy`
--
ALTER TABLE `policy`
  ADD CONSTRAINT `FKpm3y7pcs02o9spl64325sua2k` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `policy_files`
--
ALTER TABLE `policy_files`
  ADD CONSTRAINT `FKk4x52qfuopxvfslpyoqgog3te` FOREIGN KEY (`policy_id`) REFERENCES `policy` (`id`);

--
-- Constraints for table `projects`
--
ALTER TABLE `projects`
  ADD CONSTRAINT `FKksdiyuily2f4ca2y53k07pmq` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `FKm6hycbkdujcdmevl11ir8dphq` FOREIGN KEY (`created_by_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `projects_tasks`
--
ALTER TABLE `projects_tasks`
  ADD CONSTRAINT `FKt6x9t4hfh5x0kplu5cy9nie04` FOREIGN KEY (`projects_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `FKtglcsgx2tbf8mpv3qp3dujqwg` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`id`);

--
-- Constraints for table `project_files`
--
ALTER TABLE `project_files`
  ADD CONSTRAINT `FK9ko3l1na4vj9fnq8inxsfl1jm` FOREIGN KEY (`project_comment_id`) REFERENCES `comments` (`id`),
  ADD CONSTRAINT `FKad8sm7ile5i0owrcqvj3342bo` FOREIGN KEY (`uploaded_by_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKldt4isruox2m6kjp4k8p4q5l0` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`);

--
-- Constraints for table `project_labels`
--
ALTER TABLE `project_labels`
  ADD CONSTRAINT `FKigkjo8qojyc6ukebdxafhv8uk` FOREIGN KEY (`projects_id`) REFERENCES `projects` (`id`);

--
-- Constraints for table `project_members`
--
ALTER TABLE `project_members`
  ADD CONSTRAINT `FK23le78u5mj7oeys49utwgra08` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `FK2x0ujvyq3w6bob0svnuyxxv03` FOREIGN KEY (`user_id_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `project_settings`
--
ALTER TABLE `project_settings`
  ADD CONSTRAINT `FKcxsycryfbib5j4nljslxkjflw` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`);

--
-- Constraints for table `project_time`
--
ALTER TABLE `project_time`
  ADD CONSTRAINT `FK4kq7jxpmxy93dl8pqsd44ebd5` FOREIGN KEY (`task_id_id`) REFERENCES `tasks` (`id`),
  ADD CONSTRAINT `FKc7ywr8yna3qu8c4p20766ixhv` FOREIGN KEY (`user_id_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKebh1rhid6g9o8o0s3n35bwg36` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`);

--
-- Constraints for table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `FKa92roshwfdch4c24l19jn8kns` FOREIGN KEY (`designation_to_id`) REFERENCES `designation` (`id`),
  ADD CONSTRAINT `FKiwnyrjvy8f5kr1rrc5v62nq0o` FOREIGN KEY (`employee_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `resignation`
--
ALTER TABLE `resignation`
  ADD CONSTRAINT `FKfde1tou9oxq83wjq13rc32wd0` FOREIGN KEY (`employee_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `social_links`
--
ALTER TABLE `social_links`
  ADD CONSTRAINT `FKq6ofr0w683htex8hltwwxo5ef` FOREIGN KEY (`user_id_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `staff_salary`
--
ALTER TABLE `staff_salary`
  ADD CONSTRAINT `FK301qbskcgo118k4cf9tuwgg8s` FOREIGN KEY (`staff_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `FK4516wfa828r15k9u3iw5er4vi` FOREIGN KEY (`assigned_to_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKitmb97h7s96bhbvs9mruwhqta` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `FKsfhn82y57i3k9uxww1s007acc` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);

--
-- Constraints for table `tasks_collaborators`
--
ALTER TABLE `tasks_collaborators`
  ADD CONSTRAINT `FKblseuq8clfuew5ighobrks0oa` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`id`),
  ADD CONSTRAINT `FKrm3ydprkhukbxllpwm2a33823` FOREIGN KEY (`collaborators_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `task_labels`
--
ALTER TABLE `task_labels`
  ADD CONSTRAINT `FKehsovvjgddjmo7xjfstql0po2` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`id`);

--
-- Constraints for table `team_member_job_info`
--
ALTER TABLE `team_member_job_info`
  ADD CONSTRAINT `FKiy00uhgcvil66vxi653ykxa04` FOREIGN KEY (`user_id_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `termination`
--
ALTER TABLE `termination`
  ADD CONSTRAINT `FK666ur5ib0us3xq3ps3jug07d5` FOREIGN KEY (`employee_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKmf7l278gwoyo1fprvxt728ct4` FOREIGN KEY (`termination_type_id`) REFERENCES `termination_type` (`id`);

--
-- Constraints for table `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `FK19o3vkge04ngs94cy5nlq9nur` FOREIGN KEY (`assigned_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKh3vsyrqpoxg60oiwt048ktr9s` FOREIGN KEY (`client_id_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `FKmyfs6v8v389r3g1rq49cutsda` FOREIGN KEY (`created_by_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKotik7mbbb14hu8n9og7o92k5h` FOREIGN KEY (`ticket_type_id`) REFERENCES `ticket_types` (`id`),
  ADD CONSTRAINT `FKpj6s6xyw9jsk1xu77buio8o4f` FOREIGN KEY (`requested_by_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `tickets_files`
--
ALTER TABLE `tickets_files`
  ADD CONSTRAINT `FK76op8b1fh6cdqbdlt9qyeoi6o` FOREIGN KEY (`tickets_id`) REFERENCES `tickets` (`id`),
  ADD CONSTRAINT `FK77tm3uhhllsii5g9benjl57ow` FOREIGN KEY (`tickets_id_id`) REFERENCES `tickets` (`id`),
  ADD CONSTRAINT `FKnugvgvahku10bsglpp7yhytme` FOREIGN KEY (`uploaded_by_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `ticket_comments`
--
ALTER TABLE `ticket_comments`
  ADD CONSTRAINT `FK1gq2hpe494e1w13h8e2mo13dx` FOREIGN KEY (`ticket_id_id`) REFERENCES `tickets` (`id`);

--
-- Constraints for table `time_sheets`
--
ALTER TABLE `time_sheets`
  ADD CONSTRAINT `FK4otfvsut2p2raqwq7n3l79eww` FOREIGN KEY (`task_id_id`) REFERENCES `tasks` (`id`),
  ADD CONSTRAINT `FKi8mc17kr7yvochdh79p6h0lg7` FOREIGN KEY (`client_id_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `FKqhoat72b96dc3ismpmybj9h16` FOREIGN KEY (`project_id_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `FKrya2n0ndau74fhqewp3p8ttb6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `trainers`
--
ALTER TABLE `trainers`
  ADD CONSTRAINT `FKlp469npgapmjj40fq5u60o863` FOREIGN KEY (`role_id`) REFERENCES `designation` (`id`);

--
-- Constraints for table `training_list`
--
ALTER TABLE `training_list`
  ADD CONSTRAINT `FKa5xyj68olqtdh436elxqfrfyy` FOREIGN KEY (`training_type_id`) REFERENCES `training_type` (`id`),
  ADD CONSTRAINT `FKg6p39icdobycgweuib6qojyop` FOREIGN KEY (`employee_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKody6xnbfn0oxj1fmyp7y8rrms` FOREIGN KEY (`trainers_id`) REFERENCES `trainers` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK1c00dln3le1vrg6nl7kboi01c` FOREIGN KEY (`followers_id`) REFERENCES `tickets` (`id`),
  ADD CONSTRAINT `FKe3n1ycu62p82yg0qd3rfeckd2` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`id`);

--
-- Constraints for table `user_active_status`
--
ALTER TABLE `user_active_status`
  ADD CONSTRAINT `FK56nsl0pckepvvhscjynboinng` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK1mac1j6p5n4qb8okpetcbjji2` FOREIGN KEY (`u_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
