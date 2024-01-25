create table lesson(
	id serial primary key,
	name varchar(255),
	last_name text,
	age int
);
insert into lesson(name, last_name, age) values ('Василий', 'Джавов', 35);
update lesson set name = 'Кирилл';
delete from lesson;