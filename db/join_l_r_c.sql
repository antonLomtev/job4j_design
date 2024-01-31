create table departments(
	id serial primary key,
	name text
);

create table employees(
	id serial primary key,
	name text,
	departments_id int references departments(id)
);

insert into departments(name) values('Manager'),
						('Owner'), ('Ingineer'), ('Operator');
						
insert into employees(name, departments_id) values('Kiril', 1),
						('Max', 1), ('Kristina', 1),('Stas', 2),
						('Egor', 3), ('Max', 3), ('Yulia', 3),
						('Sveta', 3), ('Vasya', null), ('Sergei', null);

select * from employees e
left join departments d on e.departments_id = d.id;

select * from departments d
left join employees e on d.id = e.departments_id;

select * from departments d
right join employees e on e.departments_id = d.id;

select * from employees e
full join departments d on e.departments_id = d.id;

select * from employees
cross join departments;

select * from departments d
left join employees e on d.id = e.departments_id
where e.id is null;

select * from employees e
left join departments d on e.departments_id = d.id;
select * from departments d
right join employees e on e.departments_id = d.id;