create table products(
	id serial primary key,
	name varchar(50),
	producer varchar(50),
	count integer default 0,
	price integer
);

create or replace function nalog()
returns trigger as
$$
  begin
  update products
  set price = price * 1.2
  where id = (select id from inserted);
  return new;
  end;
$$
LANGUAGE 'plpgsql';

create trigger nalog_trigger
after insert
on products
referencing new table as inserted
for each statement
execute procedure nalog();

insert into products(name, producer, count, price)
			values('MILk', 'apple', 20, 50);

insert into products(name, producer, count, price)
			values('BUBLIK', 'apple', 20, 200);

create
or replace function nalog_before()
		returns trigger as
		$$
			begin
				update products
				set price = price * 1.2
				where id = new.id;
				return new;
			end;
		$$
LANGUAGE 'plpgsql';

create trigger nalog_before
before insert
on products
for each row
execute procedure nalog_before();

create table history_of_price(
	id serial primary key,
	name varchar(50),
	price integer,
	date timestamp
);

create
or replace function create_table()
		returns trigger as
		$$
			begin
				insert into history_of_price(name, price, date)
				values(new.name, new.price, current_timestamp);
				return new;
			end;
		$$
LANGUAGE 'plpgsql';

create trigger create_after_table
after insert
on products
for each row
execute procedure create_table();

insert into products(name, producer, count, price)
			values('MANDARINKA', 'mandarinka', 1, 200);