create table address(
    id serial primary key,
    address varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255)
);

create table address_employees(
    id serial primary key,
    address_id int references address(id) unique,
    employees_id int references employees(id) unique
);