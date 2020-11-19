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
insert into my_db.users values (1, 'admin', '$2y$12$UwkwqFdlhJFaesTRDtQsS.uQ2793OnaVH7nXB0nMWXbdz40cgJCDu' );
insert into my_db.users values (2, 'user', '$2y$12$XKovyIDDgwvF4t1alp1EL.dMfL60HU8UbiVCMPiCa1qKqn9OJjiry' );

insert into my_db.users values (1,'$2y$12$UwkwqFdlhJFaesTRDtQsS.uQ2793OnaVH7nXB0nMWXbdz40cgJCDu', 'admin'  );
insert into my_db.users values (2,'$2y$12$XKovyIDDgwvF4t1alp1EL.dMfL60HU8UbiVCMPiCa1qKqn9OJjiry', 'user'  );

insert into my_db.users values (3,'admin', 'admin'  );
insert into my_db.users values (4,'user', 'user'  );

insert into my_db.roles values (1, 'ROLE_ADMIN');
insert into my_db.roles values (2, 'ROLE_USER');

insert into my_db.users_roles values (1, 2);

select * from users;