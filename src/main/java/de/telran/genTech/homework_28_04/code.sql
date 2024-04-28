-- создание таблицы reactions
create table reactions (
reaction_id int primary key auto_increment,
created_at timestamp,
reaction_type int,
video_id int,
user_id int
);

-- создание таблицы comments
create table comments (
comment_id int primary key auto_increment,
created_at timestamp,
video_id int,
user_id int,
comment_text varchar(256)
);

-- заполнение таблицы reactions
insert into reactions (created_at, reaction_type, video_id, user_id)
values
(current_timestamp(), 5, 2, 1),
(current_timestamp(), 3, 1, 4),
(current_timestamp(), 4, 2, 3),
(current_timestamp(), 1, 3, 1);

-- заполнение таблицы comments
insert into comments (created_at, user_id, video_id, comment_text)
values
(current_timestamp(), 1, 3, 'Super'),
(current_timestamp(), 1, 4, 'comment 2'),
(current_timestamp(), 2, 6, 'comment 3'),
(current_timestamp(), 3, 3, 'comment 4');