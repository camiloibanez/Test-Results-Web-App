use prelim_task_test_results_web_app;

DELIMITER //

DROP PROCEDURE IF EXISTS addClient //

CREATE PROCEDURE addClient(IN clientId INT, IN email VARCHAR(200), IN username VARCHAR(255), IN pwd VARCHAR(255), IN addressLine1 VARCHAR(200), IN addressLine2 VARCHAR(200), IN city VARCHAR(100), IN state VARCHAR(50), IN zipCode VARCHAR(20), IN insuranceNo VARCHAR(100), IN phone VARCHAR(30), IN firstName VARCHAR(100), IN lastName VARCHAR(200), IN cardNo VARCHAR(100), IN expMonth INT, IN expYear INT, IN securityCode INT)
BEGIN
	INSERT INTO clients(clientId, email, username, pwd, addressLine1, addressLine2, city, state, zipCode, insuranceNo, phone, firstName, lastName, cardNo, expMonth, expYear, securityCode) 
    VALUES (clientId, email, username, pwd, addressLine1, addressLine2, city, state, zipCode, insuranceNo, phone, firstName, lastName, cardNo, expMonth, expYear, securityCode);
END //

DROP PROCEDURE IF EXISTS updateClient //

CREATE PROCEDURE updateClient(IN clientId_in INT, IN email_in VARCHAR(200), IN username_in VARCHAR(255), IN pwd_in VARCHAR(255), IN addressLine1_in VARCHAR(200), IN addressLine2_in VARCHAR(200), IN city_in VARCHAR(100), IN state_in VARCHAR(50), IN zipCode_in VARCHAR(20), IN insuranceNo_in VARCHAR(100), IN phone_in VARCHAR(30), IN firstName_in VARCHAR(100), IN lastName_in VARCHAR(200), IN cardNo_in VARCHAR(100), IN expMonth_in INT, IN expYear_in INT, IN securityCode_in INT)
BEGIN
	UPDATE clients SET email = email_in, username = username_in, pwd = pwd_in, addressLine1 = addressLine1_in, addressLine2 = addressLine2_in, city = city_in, state = state_in, zipCode = zipCode_in, insuranceNo = insuranceNo_in, phone = phone_in, firstName = firstName_in, lastName = lastName_in, cardNo = cardNo_in, expMonth = expMonth_in, expYear = expYear_in, securityCode = securityCode_in WHERE clientId = clientId_in;
END //

DELIMITER ;

SELECT * FROM  information_schema.routines;
