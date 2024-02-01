create or replace procedure delete_id(d_id integer)
language 'plpgsql'
as $$
		begin 
			delete from products where id = d_id;
		end
	$$;

insert into products(name, producer, count, price)
values('MILk', 'apple', 20, 50);

insert into products(name, producer, count, price)
values('BUBLIK', 'apple', 20, 200);

call delete_id(1);

create or replace function delete_count_values(d_count integer)
returns void
language 'plpgsql'
as
$$
begin
delete from products where count <= d_count;
end;
$$;

insert into products(name, producer, count, price)
values('M', 'apple', 15, 50);

insert into products(name, producer, count, price)
values('B', 'apple', 100, 200);

insert into products(name, producer, count, price)
values('0', 'apple', 0, 50);

insert into products(name, producer, count, price)
values('5', 'apple', 5, 200);

select delete_count_values(5);