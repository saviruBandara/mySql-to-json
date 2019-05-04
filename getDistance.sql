CREATE DEFINER=`root`@`localhost` FUNCTION `getDistance`(journeyFrom INT,journeyTo INT) RETURNS double
BEGIN
DECLARE milage DOUBLE;

SET milage = 0;
SELECT distance INTO milage FROM locationmatrix WHERE locationid1=journeyFrom AND locationid2=journeyTo;
#select distance from locationmatrix where locationid1=#{p1} and locationid2=#{p2};
RETURN milage;

END