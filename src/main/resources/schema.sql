create table if not exists user(
    user_seq int auto_increment primary key,
    user_id varchar(255) unique,
    user_password varchar(255) not null,
    user_name varchar(255) not null,
    user_address varchar(255) DEFAULT NULL,
    user_telno varchar(255) DEFAULT NULL,
    user_email varchar(255) DEFAULT NULL,
    user_role varchar(255) not null,
    user_rank int(100) not null,
    user_comment varchar(255) DEFAULT NULL,
    category varchar(255) not null,
    add_date datetime DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
);

create table if not exists board(
    board_seq int auto_increment primary key,
    title varchar(255) not null,
    category varchar(255) not null,
    content varchar(255) not null,
    user_role varchar(255) not null,
    user_seq int not null,
    add_date datetime DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
);

create table if not exists likeunlike(
    seq int auto_increment primary key,
    likes varchar(1) not null,
    user_seq int not null
);


