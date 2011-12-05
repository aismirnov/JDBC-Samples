Реализованы три примера из презентации Якова Фаина по JDBC, по отдельному классу на каждый пример.

В примерах со Statement и  PreparedStatement (классы EmployeeListStatement и EmployeeListPreparedStatement соответственно) используется база данных Lesson22, описанная в презентации.

Для работы примера с ручным управлением транзакциями (класс OrdersTransaction) необходимо создать базу данных Lesson22-2:
connect 'jdbc:derby:Lesson22-2;create=true';
CREATE TABLE Orders (ID int NOT NULL, ACTION varchar(10) NOT NULL, COMPANY varchar(30) NOT NULL, SHARES_COUNT int NOT NULL);
CREATE TABLE OrderDetail(NAME varchar(30) NOT NULL, BROKER varchar(30) NOT NULL, DATE varchar(8) NOT NULL);
