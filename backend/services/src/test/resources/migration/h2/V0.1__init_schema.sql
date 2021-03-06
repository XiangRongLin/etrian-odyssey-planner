CREATE TABLE roles(
                      name VARCHAR(15) NOT NULL,
                      CONSTRAINT roles_pk PRIMARY KEY (name)
);

CREATE TABLE skill_infos
(
    id          INT4         NOT NULL,
    role        VARCHAR(15)  NOT NULL,
    name        VARCHAR(30)  NOT NULL,
    description VARCHAR(350) NOT NULL,
    max_level   INT4         NOT NULL,
    CONSTRAINT skill_infos_pk PRIMARY KEY (id),
    CONSTRAINT skill_infos__role_name_fk FOREIGN KEY (role) REFERENCES roles (name) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE skill_info_prerequisites
(
    skill_info_id      INT4 NOT NULL,
    prerequisite_id    INT4 NOT NULL,
    prerequisite_level INT4 NOT NULL,
    CONSTRAINT skill_info_prerequisites__skill_info_id__prerequisite_id_ux PRIMARY KEY (skill_info_id, prerequisite_id),
    CONSTRAINT skill_info_prerequisites__prerequisite_id_fk FOREIGN KEY (prerequisite_id) REFERENCES skill_infos (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT skill_info_prerequisites__skill_info_id_fk FOREIGN KEY (skill_info_id) REFERENCES skill_infos (id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE INDEX skill_info_prerequisites__skill_info_id_ix ON skill_info_prerequisites (skill_info_id);

CREATE TABLE users
(
    id          INT4        NOT NULL AUTO_INCREMENT,
    jwt_subject VARCHAR(40) NOT NULL,
    CONSTRAINT users__id_pk PRIMARY KEY (id),
    CONSTRAINT users__jwt_subject_ux UNIQUE (jwt_subject)
);
CREATE INDEX users__jwt_subject_ix ON users (jwt_subject);


CREATE TABLE characters
(
    id      INT4        NOT NULL AUTO_INCREMENT,
    name    VARCHAR(30) NOT NULL,
    role    VARCHAR(15) NOT NULL,
    user_id INT4        NOT NULL,
    CONSTRAINT characters_pk PRIMARY KEY (id),
    CONSTRAINT characters__role_fk FOREIGN KEY (role) REFERENCES roles (name) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT characters__user_id_fk FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE

);

CREATE TABLE skills
(
    skill_info_id INT4 NOT NULL,
    level         INT4 NOT NULL,
    character_id  INT4 NOT NULL,
    CONSTRAINT skills__skill_info_id__character_id_ux PRIMARY KEY (skill_info_id, character_id),
    CONSTRAINT skills__character_id_fk FOREIGN KEY (character_id) REFERENCES characters (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT skills__skill_info_id_fk FOREIGN KEY (skill_info_id) REFERENCES skill_infos (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE parties
(
    id      INT4        NOT NULL AUTO_INCREMENT,
    name    VARCHAR(20) NOT NULL,
    user_id INT4        NOT NULL,
    CONSTRAINT parties__id_pk PRIMARY KEY (id),
    CONSTRAINT parties__user_id_fk FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE party_members
(
    party_id  INT4        NOT NULL,
    member_id INT4        NOT NULL,
    position  VARCHAR(15) NOT NULL,
    CONSTRAINT party_members__party_id__member_id_ux PRIMARY KEY (party_id, member_id),
    CONSTRAINT party_members__party_id__position_ux UNIQUE (party_id, position) /*DEFERRABLE INITIALLY DEFERRED*/,
    CONSTRAINT party_members__member_id_fk FOREIGN KEY (member_id) REFERENCES characters (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT party_members__party_id_fk FOREIGN KEY (party_id) REFERENCES parties (id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE INDEX party_members__party_id_ix ON party_members (party_id);
