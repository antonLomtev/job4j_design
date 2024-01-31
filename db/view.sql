
create table car_bodies(
	id serial primary key,
	name text
);

create table car_engines(
	id serial primary key,
	name text
);

create table car_transmissions(
	id serial primary key,
	name text
);

create table cars(
	id serial primary key,
	name text,
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values('S'), ('HB'), ('P'), ('L'), ('U');
insert into car_engines(name) values('BENZ'), ('DIZ'), ('ELEC'), ('GIBRID');
insert into car_transmissions(name) values('AT'), ('MT'), ('CVT'), ('AMT');

insert into cars(name, body_id, engine_id, transmission_id)
values ('BMW M5', 1, 1, 1), ('BMW X3', 2, 1, 1), ('MITSUBISHI L200', 3, 2, 2),
('TESLA', 1, 3, 1), ('MITSUBISHI OUTLANDER', 3, 1, 3), ('TOYOTA PRIUS', 2, 3, 1),
('LEXUS LX', 3, 2, 1),('BMW M1', null, 1, 1), ('BMW X6', 2, null, 1), ('MITSUBISHI PAJERO', 3, 2, null),
('TESLA MODEL1', null, 3, null), ('MITSUBISHI LANCER', 2, null, 1), ('TOYOTA PRADO', 2, 3, null),
('LEXUS RX', 3, null, null);

create view all_auto_full_complect
as select c.name as "auto", b.name as "type body", e.name as "engine type", t.name as "transmission type" from cars c
left join car_bodies b on c.body_id = b.id
left join car_engines e on c.engine_id = e.id
left join car_transmissions t on c.transmission_id = t.id
where c.body_id is not null and c.engine_id is not null and c.transmission_id is not null;

select * from all_auto_full_complect;