--создать бд--
create
database movies_db;

--создать таблицу фильмы--
create table movies
(
    id     serial primary key,
    "name" varchar(100) not null,
    "year" int          not null
);

--наполнить таблицу фильмы тестовыми данными--
insert into movies
    ("name", "year")
values ('Pulp Fiction', 1994),
       ('Desperado', 1995),
       ('From Disc Till Down', 1995),
       ('The Hateful Eight', 2015);

--создать таблицу люди--
create table people
(
    id     serial primary key,
    "name" varchar(100) not null
);

--наполнить таблицу люди тестовыми данными--
insert into people
    ("name")
values ('Quentin Tarantino'),
       ('Uma Thurman'),
       ('Antonio Banderas');

--создать таблицу роли--
create table roles
(
    id     serial primary key,
    "name" varchar(100) not null
);

--наполнить таблицу роли тестовыми данными--
insert into roles
    ("name")
values ('actor'),
       ('director');

--создать кросс-таблицу--
create table movies_people_roles
(
    id        serial primary key,
    movie_id  int not null,
    person_id int not null,
    role_id   int not null,
    foreign key (movie_id) references movies (id),
    foreign key (person_id) references people (id),
    foreign key (role_id) references roles (id)
);

--наполнить кросс-таблицу тестовыми данными--
insert into movies_people_roles
    (movie_id, person_id, role_id)
values (1, 1, 1),
       (1, 1, 2),
       (2, 3, 1),
       (3, 1, 1),
       (4, 1, 2),
       (1, 2, 1);

--проверить как создались и наполнились таблицы--
select m."name" as "movie",
       m."year" as "year",
       p."name" as "person",
       r."name" as "role"
from movies m
         inner join
     movies_people_roles mpr
     on
         m.id = mpr.movie_id
         inner join
     people p
     on
         p.id = mpr.person_id
         inner join
     roles r
     on
         r.id = mpr.role_id
where m."name" = 'Pulp Fiction'

--удалить таблицы--
drop table movies;

drop table people;

drop table roles;

drop table movies_people_roles;

--удалить бд--
drop
database movies_db;