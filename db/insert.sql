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


insert into users(name, roles_id)
            values('Anton', 1);

insert into items(item, categories_id, states_id, users_id)
            values('Cargo', 1, 1, 1);

insert into comments(comment, items_id) values('Fragile', 1);

insert into attachs(attach, items_id) values('Invoice', 1);
insert into attachs(attach, items_id) values('Scan', 1);