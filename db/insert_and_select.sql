insert into fauna(name, avg_age, discovery_date) 
			values('Cat', 10010, '1800-08-01'),
			('Dog', 20010, '1799-07-05'),
			('Fish', 300100, '1759-01-01'),
			('Amphibian', 19111, '1876-04-05'),
			('Dragon', 2000000, '999-01-02'),
			('Birds', 18030, '1121-09-02'),
			('Swordfish', 9000, '1595-06-03'),
			('Frog', 5678, '1786-09-08');
select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';
