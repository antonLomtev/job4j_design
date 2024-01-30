create table people(
	id serial primary key,
	appart_number int,
	first_name text,
	last_name text
);

create table home(
	id serial primary key,
	address text,
	people_id int references people(id)
);

insert into people(appart_number, first_name, last_name)
			values(1, 'Kirill', 'Petrov'),
			(10, 'Vasya', 'Zaycev'),
			(5, 'Anton', 'Vyalkov'),
			(7, 'Alex', 'Novikov'),
			(21, 'Maxim', 'Vasilev'),
			(30, 'Egor', 'Ivanov'),
			(32, 'Slavik', 'Sidorov');
insert into home(address, people_id) 
			values('Lenina', 1),
			('Lenina', 2),
			('Lenina', 3),
			('Lenina', 4),
			('Kosmonavtov', 5),
			('Kosmonavtov', 6),
			('Kosmonavtov', 7);

select * from home
join people on home.people_id = people.id;

select h.address, p.first_name, p.last_name, p.appart_number
from home as h join people as p on h.people_id = p.id;

select h.address Адрес, p.appart_number as "Номер квартиры", p.first_name Имя, p.last_name Фамилия
from home h join people p on h.people_id = p.id;