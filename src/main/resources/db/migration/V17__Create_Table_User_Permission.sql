CREATE TABLE IF NOT EXISTS "rest-with-spring-boot".user_permission (
    id_user BIGINT NOT NULL,
    id_permission BIGINT NOT NULL,
    PRIMARY KEY (id_user, id_permission),
    CONSTRAINT fk_user_permission_user
    FOREIGN KEY (id_user)
    REFERENCES "rest-with-spring-boot".users (id),
    CONSTRAINT fk_user_permission_permission
    FOREIGN KEY (id_permission)
    REFERENCES "rest-with-spring-boot".permission (id)
    );
