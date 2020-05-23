CREATE TABLE roles
(
    name varchar(15) NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (name)
);

CREATE TABLE skill_infos
(
    id          int4         NOT NULL,
    role_name   varchar(15)  NOT NULL,
    name        varchar(30)  NOT NULL,
    description varchar(400) NOT NULL,
    max_level   int4         NOT NULL,
    CONSTRAINT skill_infos_id_unique UNIQUE (id),
    CONSTRAINT skill_infos_pkey PRIMARY KEY (id),
    CONSTRAINT fk_skill_infos_role_name_name FOREIGN KEY (role_name) REFERENCES roles (name) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE skill_info_prerequisites
(
    skill_info_id      int4 NOT NULL,
    prerequisite_id    int4 NOT NULL,
    prerequisite_level int4 NOT NULL,
    CONSTRAINT fk_skill_info_prerequisites_prerequisite_id_id FOREIGN KEY (prerequisite_id) REFERENCES skill_infos (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_skill_info_prerequisites_skill_info_id_id FOREIGN KEY (skill_info_id) REFERENCES skill_infos (id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE INDEX skill_info_prerequisites_skill_info_id ON skill_info_prerequisites USING btree (skill_info_id);

CREATE TABLE characters
(
    id   INT4        NOT NULL,
    name VARCHAR(30) NOT NULL,
    role VARCHAR(15) NOT NULL,
    CONSTRAINT characters_id_unique UNIQUE (id),
    CONSTRAINT fk_characters_role_name FOREIGN KEY (role) REFERENCES roles (name) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE skills
(
    id            INT4 NOT NULL,
    skill_info_id INT4 NOT NULL,
    level         INT4 NOT NULL,
    character_id  INT4 NOT NULL,
    CONSTRAINT skills_id_unique UNIQUE (id),
    CONSTRAINT skills_skill_info_id_character_id UNIQUE (skill_info_id, character_id),
    CONSTRAINT fk_skills_character_id_id FOREIGN KEY (character_id) REFERENCES characters (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_skills_skill_info_id_id FOREIGN KEY (skill_info_id) REFERENCES skill_infos (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE parties
(
    id   INT4        NOT NULL,
    name VARCHAR(20) NOT NULL,
    CONSTRAINT parties_id_unique UNIQUE (id)
);

CREATE TABLE party_members
(
    party_id  INT4        NOT NULL,
    member_id INT4        NOT NULL,
    position  VARCHAR(15) NOT NULL,
    CONSTRAINT party_members_party_id_member_id_unique UNIQUE (party_id, member_id),
    CONSTRAINT party_members_party_id_position_unique UNIQUE (party_id, position) DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT fk_party_members_member_id_id FOREIGN KEY (member_id) REFERENCES characters (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_party_members_party_id_id FOREIGN KEY (party_id) REFERENCES parties (id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE INDEX party_members_party_id ON party_members USING btree (party_id);
