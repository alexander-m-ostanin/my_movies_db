--создать бд--
-- create
-- database movies_db;

--создать таблицу фильмы--
create table movies
(
    id     serial primary key,
    "name" varchar(100) not null,
    "year" int          not null
);

--создать таблицу люди--
create table people
(
    id     serial primary key,
    "name" varchar(100) not null
);

--создать таблицу роли--
create table roles
(
    id     serial primary key,
    "name" varchar(100) not null
);

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