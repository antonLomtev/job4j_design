create table posts(
id serial primary key,
	name varchar(255)
);
create table tag(
	id serial primary key,
	name varchar(255)
);
create table posts_tag(
	id serial primary key,
	posts_id int references posts(id),
	tag_id int references tag(id)
);
insert into posts(name) values ('Learning SQL');
insert into posts(name) values ('Learning Java');
insert into posts(name) values ('Learning Spring');

insert into tag(name) values ('It');
insert into tag(name) values ('Programming language');
insert into tag(name) values ('Framevork');

insert into posts_tag(posts_id, tag_id) values (1, 1);
insert into posts_tag(posts_id, tag_id) values (1, 2);
insert into posts_tag(posts_id, tag_id) values (1, 3);
insert into posts_tag(posts_id, tag_id) values (2, 1);
insert into posts_tag(posts_id, tag_id) values (2, 2);
insert into posts_tag(posts_id, tag_id) values (3, 3);

select * from posts;
select * from tag;