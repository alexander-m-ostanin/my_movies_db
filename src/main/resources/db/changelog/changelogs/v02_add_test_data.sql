--наполнить таблицу фильмы тестовыми данными--
insert into movies
("name", "year")
values ('Pulp Fiction', 1994),
       ('Desperado', 1995),
       ('From Disc Till Down', 1995),
       ('The Hateful Eight', 2015);

--наполнить таблицу люди тестовыми данными--
insert into people
("name")
values ('Quentin Tarantino'),
       ('Uma Thurman'),
       ('Antonio Banderas');

--наполнить таблицу роли тестовыми данными--
insert into roles
("name")
values ('actor'),
       ('director');

--наполнить кросс-таблицу тестовыми данными--
insert into movies_people_roles
(movie_id, person_id, role_id)
values (1, 1, 1),
       (1, 1, 2),
       (2, 3, 1),
       (3, 1, 1),
       (4, 1, 2),
       (1, 2, 1);