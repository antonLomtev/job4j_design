CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers(first_name, last_name, age, country)
			values('Kirill', 'Sokolov', 30, 'Russia'),
			('Max', 'Johns', 35, 'USA'), ('John', 'Trivolta', 40, 'USA'),
			('Petr', 'Petrovkiy', 29, 'Poland'), ('Sergei', 'Ivanov', 29, 'Russia'),
			('Egor', 'Smirnov', 29, 'Russia'), ('Katerina', 'Johnson', 35, 'USA');

select * from customers c
where c.age = (select min(age) from customers);

create table orders (
	id serial primary key,
	amount int,
	customer_id int references customers(id)
);

insert into orders(amount, customer_id)
			values(1, 1), (0, 2), (0, 3), (2, 4), (3, 5),
			(3, 6), (3, 7);

insert into customers(first_name, last_name, age, country)
			values('Stas', 'Sokolov', 31, 'Russia'),
			('Maxim', 'Johnson', 37, 'USA'), ('Johnathan', 'Trivolta', 41, 'USA'),
			('Oleg', 'Petrovkiy', 28, 'Poland'), ('Artur', 'Ivanov', 29, 'Russia'),
			('Yuriy', 'Smirnov', 29, 'Russia'), ('Svetlana', 'Johnson', 35, 'USA');

select * from customers c
where c.id not in (select orders.id from orders);