create table devices(
	id serial primary key,
	name varchar(255),
	price float
);

create table people(
	id serial primary key,
	name varchar(255)
);

create table devices_people(
	id serial primary key,
	devices_id int references devices(id),
	people_id int references people(id)
);

insert into devices(name, price)
			values('Phone', 30120),('Laptop', 45300.4),('TV', 56300.50),('MacBook', 119000),
			('Watch', 9999.99);

insert into people(name)
			values('Kirill'),('Anton'),('Alex'),('Sergei'),('Maxim'),('Anna'),('Olga'),('Irina');

insert into devices_people(devices_id, people_id)
			values(1, 1),(2, 1),(3, 1),(4, 1),(5, 1),(1, 2),(3, 2),(5, 2),(4, 2),(3, 3),(5, 3),(1, 3),
			      (2, 3),(1, 4),(5, 4),(1, 5),(3, 5),(5, 5),(1, 6),(1, 7),(4, 7),(3, 8),(4, 8),(5, 8);

select avg(devices.price) from devices;

select p.name, avg(d.price)
from people p join devices_people dp
on p.id = dp.people_id
join devices d on dp.devices_id = d.id
group by p.name;

select p.name, avg(d.price)
from people p join devices_people dp
on p.id = dp.people_id
join devices d on dp.devices_id = d.id
group by p.name
having avg(d.price) > 5000;