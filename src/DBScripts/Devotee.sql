CREATE DEFINER=`root`@`localhost` PROCEDURE `calculate_success_percentage`(out success_percentage float)
BEGIN
select round(((select count(*) from ajay.devotees_success where status = 'success')/count(*)*100),2) into success_percentage
from ajay.devotees_success;
END

CREATE TABLE `devotees_registration` (
  `devoteeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `husbandName` varchar(20) NOT NULL,
  `mobileNo` bigint(20) NOT NULL,
  `childNo` tinyint(4) NOT NULL,
  `pregnancyDate` date NOT NULL,
  `registeredDate` date DEFAULT NULL,
  `firstDate` date NOT NULL,
  `visitDate` date NOT NULL,
  `visitStatus` varchar(15) NOT NULL,
  `daysBetweenPdateAndFdate` smallint(6) NOT NULL,
  `daysBetweenPdateAndRdate` smallint(6) NOT NULL,
  `daysBetweenPdateAndVdate` smallint(6) NOT NULL,
  `village` varchar(20) NOT NULL,
  `mandal` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  `otherDetails` varchar(100) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`devoteeId`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8