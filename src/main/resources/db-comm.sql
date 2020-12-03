-- Table: users
create table my_db.users
(
    id       BIGINT       NOT NULL AUTO_INCREMENT primary key,
    username varchar(255) NOT NULL,
    password varchar(255) not null
)
    engine = InnoDB;

-- Table: roles
create table my_db.roles
(
    id    BIGINT       NOT NULL AUTO_INCREMENT primary key,
    roles varchar(255) NOT NULL
)
    engine = InnoDB;

-- Table: users_roles
create table my_db.users_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    foreign key (user_id) REFERENCES my_db.users (id),
    foreign key (role_id) REFERENCES my_db.roles (id),
    unique (user_id, role_id)
)
    engine = InnoDB;

-- Insert users and role
insert into my_db.users (id, username, password) values (1, 'admin', '$2y$12$UwkwqFdlhJFaesTRDtQsS.uQ2793OnaVH7nXB0nMWXbdz40cgJCDu' );
insert into my_db.users (id, username, password) values (2, 'user', '$2y$12$XKovyIDDgwvF4t1alp1EL.dMfL60HU8UbiVCMPiCa1qKqn9OJjiry' );

insert into my_db.users values (1,'$2y$12$UwkwqFdlhJFaesTRDtQsS.uQ2793OnaVH7nXB0nMWXbdz40cgJCDu', 'admin'  );
insert into my_db.users values (2,'$2y$12$XKovyIDDgwvF4t1alp1EL.dMfL60HU8UbiVCMPiCa1qKqn9OJjiry', 'user'  );

insert into my_db.users (id, username, password) values (3,'admin', 'admin'  );
insert into my_db.users (id, username, password) values (4,'user', 'user'  );

insert into my_db.roles (id, roles) values (1, 'ROLE_ADMIN');
insert into my_db.roles (id, roles) values (2, 'ROLE_USER');

insert into my_db.users_roles values (1, 2);

select * from users, roles;

INSERT INTO `my_db`.`users` (`id`, `role`, `password`, `salary`, `username`, `enabled`) VALUES ('1', 'ROLE_EMPLOYEE', 'admin', '200', 'max', b'1');
INSERT INTO `my_db`.`users` (`id`, `role`, `password`, `salary`, `username`, `enabled`) VALUES ('2', 'ROLE_CLIENT', 'user', '1500', 'vlad', b'0');
INSERT INTO `my_db`.`users` (`id`, `role`, `password`, `salary`, `username`, `enabled`) VALUES ('3', 'ROLE_CLIENT', '111111', '500', 'kolya', b'1');
INSERT INTO `my_db`.`users` (`id`, `role`, `password`, `salary`, `username`, `enabled`) VALUES ('4', 'ROLE_CLIENT', 'серов', '500', 'максим', b'1');


USE my_db;

CREATE TABLE users (
  username varchar(15),
  password varchar(100),
  enabled tinyint(1),
  PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
  username varchar(15),
  authority varchar(25),
  FOREIGN KEY (username) references users(username)
) ;

INSERT INTO my_db.users (username, password, enabled)
VALUES
	('zaur', '{noop}zaur', 1),
	('elena', '{noop}elena', 1),
	('ivan', '{noop}ivan', 1);

INSERT INTO my_db.authorities (username, authority)
VALUES
	('zaur', 'ROLE_EMPLOYEE'),
	('elena', 'ROLE_HR'),
    ('ivan', 'ROLE_HR'),
	('ivan', 'ROLE_MANAGER');