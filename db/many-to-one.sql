create table posts(
    id serial primary key,
    name varchar(255)
);

create table comments(
    id serial primary key,
    name varchar(255),
    posts_id int references posts(id)
);

insert into posts(name) values ('Java');
insert into comments(name, posts_id) VALUES ('Learning Java', 1);

select * from comments;

select * from posts where id in (select posts_id from comments);