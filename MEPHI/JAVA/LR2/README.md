Java Lab2
------------
Написать web-приложение, которое умеет отдавать 2 страницы count_to_get_in.html и hello_inside.html

count_to_get_in.html - форма, на которой задаётся вопрос о сумме двух чисел (два числа должны быть в отрезке от -125 до 347). Числа генерируются на сервере. В форме должно быть скрытое поле, идентифицирующее вопрос, т. е. пару чисел, в виде хэша, с подмешиванием серверного времени.

Если числа введены верно, то в cookie будет установлено значение sessionId (сгенерированный случайный UID). Сохранить его в множество выданных sessionId, которое должно быть доступно не только в сервлете (использовать патерн синглтон).

Реализовать фильтр, который проверяет наличие в cookie установленного sessionId и, если оно есть, его наличие в множестве выданных sessionId. Получение множества выданных sessionId нужно инициализировать в методе init().

Если cookie нет и не получен запрос на страницу count_to_get_in.html, то нужно делать redirect на /count_to_get_in.html Если cookie есть и он валиден, то нужно сделать forward на /hello_inside.html, если запроса туда не было.

Если в браузере есть валидный sessionId, то должно быть невозможно увидеть страницу count_to_get_in.html. 
Если нет валидного sessionId, то должно быть невозможно увидеть страницу hello_inside.html.

HOW TO INSTALL
------------
Download .java files
1. MainServlet.java
2. MyFilter.java
3. SingltoneSet.java

Download .jsp files
1. count_to_get_in.jsp

Download .html files
1. hello_inside.html

Download .xml files
1. pom.xml
2. web.xml

my contacts
------------
You can connect with me by email: 
cheraten@yandex.ru
