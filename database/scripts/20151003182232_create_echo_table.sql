-- // create echo table
-- Migration SQL that makes the change goes here.

CREATE TABLE echo (message VARCHAR(200) NOT NULL,
                   created_on TIMESTAMP NOT NULL);

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE echo;
