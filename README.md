Выпускной проект
===============================
Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) without frontend.

The task is:

Build a voting system for deciding where to have lunch.

- 2 types of users: admin and regular users
- Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
- Menu changes each day (admins do the updates)
- Users can vote on which restaurant they want to have lunch at
- Only one vote counted per user
- If user votes again the same day:
    - If it is before 11:00 we assume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed
- Each restaurant provides a new menu each day.

###Details

####Users

- Anonymous access is prohibited

- You must have credentials to access voting system. You can use this login/password for tests:

User login: user password: test1 Authorization: Basic dXNlcjp0ZXN0MQ==

####Sample user's functionality:

- get their voting history

<pre>curl -X GET -H "Authorization: Basic dXNlcjp0ZXN0MQ==" "http://{hostname}/user/votes-history"</pre>

- vote for menu

<pre>curl -X POST -H "Authorization: Basic dXNlcjp0ZXN0MQ==" -H "Content-type:application/json" -d " {\"rest_id\": 100001}"  "http://localhost:8080/user/vote"</pre>


####Admin

You must use credentials to access admin features. Admin add/delete menus, dishes, and restaurants.

Admin login: admin password: test2 Authorization: Basic YWRtaW46dGVzdDI=

####Sample admin's functionality:

- add new dish

<pre>curl -X POST -H "Authorization: Basic YWRtaW46dGVzdDI=" -H "Content-type:application/json" -d " { \"name\": \"Pizza\", \"prica\": 600 } " "http://localhost:8080/admin/dishes"</pre>

- get all menus and dishes

<pre>curl -X GET -H "Authorization: Basic YWRtaW46dGVzdDI=" "http://localhost:8080/admin/menus"</pre>

- delete dish by id

<pre>curl -X DELETE -H "Authorization: Basic YWRtaW46dGVzdDI=" "http://localhost:8080/admin/dishes/100001"</pre>