create table teens(
	id serial primary key,
	name text,
	gender text
);

insert into teens(name, gender) values ('Vasya', 'M'),
					('Ira', 'F'),('Egor', 'M'), ('Sveta', 'F'),
					('Kuzya', 'M'), ('Marfa', 'F');

select t1.name, t2.name from teens t1 cross join teens t2
where t1.id < t2.id;