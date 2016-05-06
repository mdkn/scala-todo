# Users schema

# --- !Ups

CREATE TABLE IF NOT EXISTS todo (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    text VARCHAR (255) NOT NULL,
    is_done INT NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE todo;