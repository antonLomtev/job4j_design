insert into roles(role) values('User'); 
insert into roles(role) values('Owner');
insert into roles(role) values('Manager');

insert into rules(rule) values('Full Access');
insert into rules(rule) values('Purchase');
insert into rules(rule) values('Edit');

insert into roles_rules(roles_id, rules_id) values(2, 1);
insert into roles_rules(roles_id, rules_id) values(1, 2);
insert into roles_rules(roles_id, rules_id) values(3, 2);
insert into roles_rules(roles_id, rules_id) values(3, 3);

insert into states(state) values('Assembly');
insert into states(state) values('Sent');
insert into states(state) values('Canceled');
insert into states(state) values('Completed');

insert into categories(category) values('Common');
insert into categories(category) values('VIP');

insert into attachs(attach) values('Invoice');
insert into attachs(attach) values('Scan');

insert into comments(comment) values('Fragile');

insert into items(item, comments_id, attachs_id, categories_id, states_id)
            values('Cargo', 1, 1, 2, 1);
			
insert into users(name, roles_id, items_id)
            values('Anton', 1, 1);