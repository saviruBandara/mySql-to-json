CREATE DEFINER=`root`@`localhost` FUNCTION `totalDistance`(Array_String VARCHAR(45)) RETURNS text CHARSET utf8
BEGIN
DECLARE totalDistance VARCHAR(450);
DECLARE mileage VARCHAR(450);
DECLARE position INT;
DECLARE journeyFrom TEXT;
DECLARE journeyTo TEXT;
DECLARE valueTable TEXT;
DECLARE valueTableArray TEXT;

SET position = LOCATE(",",Array_String);
SET totalDistance = 0;
SET valueTableArray='"mileageRow":[';

WHILE position > 0 DO
SET journeyFrom = SUBSTRING(Array_String,1,position-1);
SET Array_String = SUBSTRING(Array_String,position+1);
SET position = LOCATE(",",Array_String); 

IF position = 0 THEN
SET journeyTo = SUBSTRING(Array_String,1);
SET mileage = getDistance(journeyFrom, journeyTo);
SET valueTable = CONCAT('{"from":"',journeyFrom,'","to":"',journeyTo,'","mileage":"',mileage,'"}');

ELSE

SET journeyTo = SUBSTRING(Array_String,1,position-1);
SET mileage = getDistance(journeyFrom, journeyTo);
SET valueTable = CONCAT('{"from":"',journeyFrom,'","to":"',journeyTo,'","mileage":"',mileage,'"},');

END IF;

SET totalDistance = totalDistance + mileage;
SET valueTableArray = CONCAT(valueTableArray,valueTable);

END WHILE;

SET valueTableArray = CONCAT(valueTableArray,']');

RETURN CONCAT('{ "totalDistance":["',totalDistance,'"],',valueTableArray,'}');

END