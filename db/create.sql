create table roles(
    id serial primary key,
    role varchar(255)
);

create table comments(
	id serial primary key,
	comment varchar(255)
);

create table attachs(
	id serial primary key,
	attach varchar(255)
);

create table states(
	id serial primary key,
	state varchar(255)
);
create table categories(
	id serial primary key,
	category varchar(255)
);

create table rules(
    id serial primary key,
	rule varchar(255)
);

create table roles_rules(
	id serial primary key,
	roles_id int references roles(id),
	rules_id int references rules(id)
);

create table items(
	id serial primary key,
	item varchar(255),
	comments_id int references comments(id),
	attachs_id int references attachs(id),
	categories_id int references categories(id),
	states_id int references states(id)
);
create table users(
    id serial primary key,
    name varchar(255),
	roles_id int references roles(id),
	items_id int references items(id)
);

