CREATE TABLE review_audit_table
(
    user_id      INT          NOT NULL,
    action_type  VARCHAR(255) NOT NULL,
    ModifiedDate DATETIME DEFAULT NULL
);

/*Demo values
INSERT INTO `reviews`
VALUES (6, 'Exceptional tour to Washington', '4', '2021-04-11', 'tbd', 5, 2);*/

DELIMITER
$$
CREATE TRIGGER after_review_insert
    AFTER INSERT
    ON reviews
    FOR EACH ROW
BEGIN
    INSERT INTO review_audit_table
    VALUES (NEW.user_id, 'insert', NOW());
END$$

DELIMITER ;

/*  Trigger drop command
    DROP TRIGGER SDDB.after_review_insert;
*/