CREATE TABLE categories
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    title            VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE jt_instructors
(
    instructor_id     BIGINT NOT NULL,
    subject_expertise VARCHAR(255) NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_jt_instructors PRIMARY KEY (instructor_id)
);

CREATE TABLE jt_mentors
(
    mentor_id           BIGINT NOT NULL,
    company_name        VARCHAR(255) NULL,
    years_of_experience INT NULL,
    CONSTRAINT pk_jt_mentors PRIMARY KEY (mentor_id)
);

CREATE TABLE jt_ta
(
    ta_id                           BIGINT NOT NULL,
    number_of_help_requests_handled INT NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (ta_id)
);

CREATE TABLE jt_users
(
    id           BIGINT NOT NULL,
    first_name   VARCHAR(255) NULL,
    last_name    VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone_number INT NULL,
    CONSTRAINT pk_jt_users PRIMARY KEY (id)
);

CREATE TABLE products
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    title            VARCHAR(255) NULL,
    price DOUBLE NULL,
    `description`    VARCHAR(255) NULL,
    image_url        VARCHAR(255) NULL,
    category_id      BIGINT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id                              BIGINT NOT NULL,
    user_type                       INT    NOT NULL,
    first_name                      VARCHAR(255) NULL,
    last_name                       VARCHAR(255) NULL,
    email                           VARCHAR(255) NULL,
    phone_number                    INT NULL,
    number_of_help_requests_handled INT NULL,
    rating DOUBLE NULL,
    company_name                    VARCHAR(255) NULL,
    years_of_experience             INT NULL,
    subject_expertise               VARCHAR(255) NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE super_class_instructor
(
    id                BIGINT NOT NULL,
    first_name        VARCHAR(255) NULL,
    last_name         VARCHAR(255) NULL,
    email             VARCHAR(255) NULL,
    phone_number      INT NULL,
    subject_expertise VARCHAR(255) NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_superclass_instructor PRIMARY KEY (id)
);

CREATE TABLE super_class_mentor
(
    id                  BIGINT NOT NULL,
    first_name          VARCHAR(255) NULL,
    last_name           VARCHAR(255) NULL,
    email               VARCHAR(255) NULL,
    phone_number        INT NULL,
    company_name        VARCHAR(255) NULL,
    years_of_experience INT NULL,
    CONSTRAINT pk_superclass_mentor PRIMARY KEY (id)
);

CREATE TABLE super_class_ta
(
    id                              BIGINT NOT NULL,
    first_name                      VARCHAR(255) NULL,
    last_name                       VARCHAR(255) NULL,
    email                           VARCHAR(255) NULL,
    phone_number                    INT NULL,
    number_of_help_requests_handled INT NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_superclass_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id                BIGINT NOT NULL,
    first_name        VARCHAR(255) NULL,
    last_name         VARCHAR(255) NULL,
    email             VARCHAR(255) NULL,
    phone_number      INT NULL,
    subject_expertise VARCHAR(255) NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id                  BIGINT NOT NULL,
    first_name          VARCHAR(255) NULL,
    last_name           VARCHAR(255) NULL,
    email               VARCHAR(255) NULL,
    phone_number        INT NULL,
    company_name        VARCHAR(255) NULL,
    years_of_experience INT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id                              BIGINT NOT NULL,
    first_name                      VARCHAR(255) NULL,
    last_name                       VARCHAR(255) NULL,
    email                           VARCHAR(255) NULL,
    phone_number                    INT NULL,
    number_of_help_requests_handled INT NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_users
(
    id           BIGINT NOT NULL,
    first_name   VARCHAR(255) NULL,
    last_name    VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    phone_number INT NULL,
    CONSTRAINT pk_tpc_users PRIMARY KEY (id)
);

ALTER TABLE jt_instructors
    ADD CONSTRAINT FK_JT_INSTRUCTORS_ON_INSTRUCTOR FOREIGN KEY (instructor_id) REFERENCES jt_users (id);

ALTER TABLE jt_mentors
    ADD CONSTRAINT FK_JT_MENTORS_ON_MENTOR FOREIGN KEY (mentor_id) REFERENCES jt_users (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_TA FOREIGN KEY (ta_id) REFERENCES jt_users (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);