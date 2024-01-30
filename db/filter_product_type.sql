create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key,
	name text,
	type_id int references type(id),
	expired_date date,
	price float
);
insert into type(name) values('МОЛОКО'),('ЧАЙ'),('КОФЕ'),
			('СЫР'), ('ВЫПЕЧКА'), ('КРУПА');

insert into product(name, type_id, expired_date, price) 
			values('Сыр российский', 4, '2024-02-05', 200.50),
			('Сыр моцарелла', 4, '2024-02-05', 250.8),
			('Сыр пошехонский', 4, '2024-02-07', 180.9),
			('Сыр гауда', 4, '2024-02-03', 300.15),
			('Вятушка', 1, '2024-02-07', 89),
			('Село зеленое', 1, '2024-02-09', 91),
			('Изваильское', 1, '2024-02-10', 200.50),
			('Гринфилд', 2, '2024-10-05', 400.50),
			('Ричард', 2, '2024-10-25', 450.50),
			('Цейлонский', 2, '2024-11-05', 210.50),
			('Амбассадор', 3, '2024-11-10', 500.50),
			('Жардин', 3, '2024-12-15', 400.50),
			('Жокей', 3, '2024-12-05', 350.50),
			('Хлеб белый', 5, '2024-02-03', 35.50),
			('Хлеб черный', 5, '2024-02-05', 33.50),
			('Пирожок', 5, '2024-02-05', 50),
			('Гречка', 6, '2025-04-05', 125),
			('Овсянка', 6, '2025-05-05', 93),
			('Перловка', 6, '2025-06-05', 80),
			('Рис', 6, '2025-07-05', 105);

select p.name, p.expired_date, p.price from product p
join type t on p.type_id = t.id
where t.name like '%СЫР%';

select * from product p
where p.name like '%Мороженое%';

select * from product p
where p.expired_date < current_date;

select name, price from product p
where p.price = (select max(price) from product);

select t.name, count(distinct p.name) Количество from type t
join product p on t.id = p.type_id
group by t.name;

select p.name, t.name, p.price from product p
join type t on p.type_id = t.id
where t.name like '%СЫР%' or t.name like '%МОЛОКО%';

select t.name, count(distinct p.name) Количество from type t
join product p on t.id = p.type_id
group by t.name
having count(distinct p.name) < 10;

select p.name, p.expired_date, p.price, t.name from product p
join type t on p.type_id = t.id;