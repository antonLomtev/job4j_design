create table company(
    id integer not null,
    name character varying,
    constraint company_pkey primary key (id)
);

create table person(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    constraint person_pkey primary key (id)
);

insert into company(id, name) values(1, 'LUKOIL');
insert into company(id, name) values(2, 'GAZPROM');
insert into company(id, name) values(3, 'TATNEFT');
insert into company(id, name) values(4, 'URALMASCH');
insert into company(id, name) values(5, 'ROSTELECOM');
insert into company(id, name) values(6, 'TTK');

insert into person(id, name, company_id) values(1, 'Anton', 1),
(2, 'Yulia', 2), (3, 'Igor', 3), (4, 'Vasya', 4), (5, 'Petya', 5),
(6, 'Kiril', 6), (7, 'Egor', 1), (8, 'Yuriy', 2), (9, 'Kostya', 3),
(10, 'Ira', 4), (11, 'Ulya', 5), (12, 'Kristina', 6), (13, 'Ruslan', 1),
(14, 'Max', 2), (15, 'Ayub', 3), (16, 'Filipp', 1), (17, 'Sergey', 4),
(18, 'Olga', 5), (19, 'Alex', 6), (20, 'Alisa', 5);

select p.name, c.name from person p
join company c on p.company_id = c.id where p.company_id != 5;

create view count_person_by_company
as
select c.name, count(p.name)
from company c
join person p on c.id = p.company_id
group by c.name;

select c.name, c.count from count_person_by_company c
where c.count = (select max(c.count) from count_person_by_company c);
