--Создать БД--
CREATE database movies_db;

--Создать таблицу Фильмы--
CREATE TABLE movies (
id SERIAL PRIMARY KEY,
"name" varchar(100) not NULL,
"year" int not NULL
);

--Наполнить таблицу Фильмы тестовыми данными--
insert into movies
("name", "year")
values
('Pulp Fiction', 1994),
('Desperado', 1995),
('From Disc Till Down', 1995),
('The Hateful Eight', 2015);

--Создать Таблицу Люди--
CREATE TABLE people (
id SERIAL PRIMARY KEY,
name varchar(100) not NULL
);

--Наполнить таблицу Люди тестовыми данными--
insert into people
("name")
values
('Quentin Tarantino'),
('Uma Thurman'),
('Antonio Banderas');

--Создать таблицу Роли--
CREATE TABLE cast_roles (
id SERIAL PRIMARY KEY,
cast_role varchar(100) not NULL
);

--Наполнить таблицу Роли тестовыми данными--
insert into cast_roles
(cast_role)
values
('Actor'),
('Director');


--Создать кросс-таблицу--
CREATE TABLE movies_cross_people (
id SERIAL PRIMARY KEY,
movie_id int not NULL,
person_id int not NULL,
cast_role_id int not NULL,
FOREIGN KEY (movie_id) REFERENCES movies(id),
FOREIGN KEY (person_id) REFERENCES people (id),
FOREIGN KEY (cast_role_id) REFERENCES cast_roles (id)
);

--Наполнить кросс-таблицу тестовыми данными--
insert into movies_cross_people
(movie_id, person_id, cast_role_id)
values
(1, 1, 1),
(1, 1, 2),
(2, 3, 1),
(3, 1, 1),
(4, 1, 2),
(1, 2, 1);

--Проверить как создались и наполнились таблицы--
select
    m."name"     as "movie",
    m."year"     as "year",
    p."name"     as "person",
    cr.cast_role as "cast_role"
from movies m
    inner join
        movies_cross_people mcp
        on
        m.id = mcp.movie_id
    inner join
        people p
        on
        p.id = mcp.person_id
    inner join
        cast_roles cr
        on
        cr.id = mcp.cast_role_id
where m."name" = 'Pulp Fiction';



--Удалить БД--
DROP DATABASE movies_db;



