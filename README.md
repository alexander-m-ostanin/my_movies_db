Тестовое задание на соискание должности Java разработчика

**ЗАДАЧА**

Необходимо пользователю (фронтенду) предоставить информацию о фильме:
- Название фильма,
- Год выпуска фильма,
- Список актеров,
- Список режисеров (актер и режисер могут быть одним человеком).

Пользователь (фронтенд) отправляет на сервер id фильма в ответ должен получить Json с информацией о фильме.

Результатом решения задачи должны являться:
- sql-скрипты создания БД
- исходный код приложения на Java (ссылка на GitHub)


**РЕЗУЛЬТАТ РЕШЕНИЯ ЗАДАЧИ**

Исходный код приложения размещен в:

https://github.com/alexander-m-ostanin/my_movies_db

SQL-скрипты расположены в:

src/main/resources/database/initDB.sql

**ДОКУМЕНТАЦИЯ К API**

**1. GET запросы**

**1.1. Получить краткую информацию о фильме (наименование, дата выхода) по id фильма**

GET запрос по адресу: /api/movies/{movieId}

Пример посылаемого GET запроса:

http://localhost:8080/api/movies/1

Пример возвращаемого JSON:

{
"id": 1,
"name": "Pulp Fiction",
"year": 1994
}

**1.2. Получить краткую информацию о персоне (имя) по id**

GET запрос по адресу: /api/people/{personId}

Пример посылаемого GET запроса:

http://localhost:8080/api/people/1

Пример возвращаемого JSON:

{
"id": 1,
"name": "Quentin Tarantino"
}

**1.3. Получить полную информацию о фильме (наименование, дата выхода, список ролей, список персон для каждой роли) по id фильма**

GET запрос по адресу: /api/movies/poster/{movieId}

Пример посылаемого GET запроса

http://localhost:8080/api/movies/poster/1

Пример возвращаемого JSON:

{
"movie": {
"id": 1,
"name": "Pulp Fiction",
"year": 1994
},
"movieTeam": {
"CastRole(id=1, name=Actor)": [
{
"id": 2,
"name": "Uma Thurman"
},
{
"id": 4,
"name": "Samuel L. Jackson"
},
{
"id": 1,
"name": "Quentin Tarantino"
}
],
"CastRole(id=2, name=Director)": [
{
"id": 1,
"name": "Quentin Tarantino"
}
]
}
}

**1.4. Обработка ошибок**

Если поступил запрос с не существующим id, система вернет JSON с сообщением о не существующем id.

Пример JSON с сообщением о не существующем id:

{
"info": "There is no Person with ID = 13 in Database",
"code": "200 OK"
}


**2. POST запросы**

**2.1. Создать новый фильм**

POST запрос по адресу /api/movies/

Пример посылаемого POST запроса:

URL:

http://localhost:8080/api/movies/

BODY:

{
"name": "The Hateful Eigh",
"year": 2015
}

**2.2. Отредактировать существующий фильм**

POST запрос по адресу /api/movies/

Пример посылаемого POST запроса:

URL:

http://localhost:8080/api/movies/

BODY:

{
"id": 6,
"name": "The Hateful Eigh",
"year": 2015
}

**2.3. Создать новую персону**

POST запрос по адресу /api/people/

Пример посылаемого POST запроса:

URL:

http://localhost:8080/api/people/

BODY:

{
"name": "John Travolta"
}

**2.4. Отредактировать существующую персону**

POST запрос по адресу /api/people/

Пример посылаемого POST запроса:

URL:

http://localhost:8080/api/people/

BODY:

{
"id": 6,
"name": "John Travolta"
}

**2.5. Добавить связь фильма с персоной**

POST запрос по адресу /api/movies-people-roles/

Пример посылаемого POST запроса:

URL:

http://localhost:8080/api/movies-people-roles/

BODY:

{
"movieId": 1,
"personId": 6,
"castRoleId": 1
}

**2.6. Отредактировать связь фильма с персоной**

POST запрос по адресу /api/movies-people-roles/

Пример посылаемого POST запроса:

URL:

http://localhost:8080/api/movies-people-roles/

BODY:

{
"id": 11,
"movieId": 1,
"personId": 6,
"castRoleId": 1
}

**3. DELETE  запросы**

**3.1. Удалить фильм по id**

DELETE запрос по адресу: /api/movies/{movieId}

Пример посылаемого DELETE запроса:

http://localhost:8080/api/movies/1

Пример возвращаемого подтверждения удаления:

Movie with id = 1 was deleted

**3.2. Удалить персону по id**

DELETE запрос по адресу: /api/people/{personId}

Пример посылаемого DELETE запроса:

http://localhost:8080/api/people/1

Пример возвращаемого подтверждения удаления:

Person with id = 1 was deleted

**3.3. Удалить связь фильма с персоной**

DELETE запрос по адресу: /api/movies-people-roles/{moviePersonRoleId}

Пример посылаемого DELETE запроса:

http://localhost:8080/api/movies-people-roles/1

Пример возвращаемого подтверждения удаления:

MoviePersonCastRole with id = 1 was deleted



