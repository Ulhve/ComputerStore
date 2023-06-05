## Запуск приложения

### 1. Сборка приложения

Для сборки используется команда Maven:

```
mvn clean package
```

### 2. Запуск приложения

Для запуска приложения используется команда:

```
java -jar target/ComputerStore-1.0-SNAPSHOT.jar
```

### 3. Swagger UI

Для тестирования можно использовать Swagger UI по адресу `http://localhost:8181/swagger-ui/index.html`.

### 4. База данных

Создается и заполняется небольшим набором тестовых данных с помощью liquibase.
Зайти в бд через браузер:

* `localhost:8181/h2-console`
* DB: jdbc:h2:./shop
* User: `sa`
* Password: `sa`
