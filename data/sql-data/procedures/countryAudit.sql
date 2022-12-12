CREATE TABLE country_audit_table
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    action_type  VARCHAR(255) NOT NULL,
    ModifiedDate DATETIME DEFAULT NULL
);

/*Demo values
INSERT INTO `countries`
VALUES (9, 'Germany');*/

DELIMITER
$$
CREATE TRIGGER after_country_insert
    AFTER INSERT
    ON countries
    FOR EACH ROW
BEGIN
    INSERT INTO country_audit_table
    VALUES (NEW.id, 'insert', NOW());
END$$

DELIMITER ;


/*  Trigger drop command
    DROP TRIGGER SDDB.after_country_insert;
*/