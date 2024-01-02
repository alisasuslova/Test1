# Задача "Использование JUnit"

## Входные данные:
За основу была взята ранее написанная мной программа, выполняющая логику записной книжки. В нне можно добавлять контакты, добавлять пропущенные вызовы, просматривать список всех вызовов. Если контакт был ранее сохранен, то вместо номера телефона будет выведено имя контакта.

## Выходные данные:

Написаны три теста, позволяющие протестировать каждый логический блок программы.  

## Реализация:

1. Подключила две зависимости JUnit и JUnit с параметрами в pom.xml:
```xml
<dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
```
2. Создала класс для тестов в папке `src/test/java`.  

3. В классе три метода.
* `testDelMissedCalls()` - проверяет не пустой ли сейчас список контактов:
```text
@Test
    public void testDelMissedCalls() {

        Map<LocalDateTime, String> missedCalls = new TreeMap<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        boolean expected = true;
        missedCalls.put(localDateTime, "4445566");
        missedCalls.put(localDateTime, "7773344");
        missedCalls.put(localDateTime, "1112233");
        boolean check = missedCalls.isEmpty();
        System.out.println(check + ", В списке есть контакты");

        missedCalls.clear();

        assertEquals(expected, missedCalls.isEmpty());
    }
```

* `testAddMissedCalls()` - проверяет добавился ли новый контакт в список контактов:
```text
@Test
    public void testAddMissedCalls() {

        String localDateTime = "22.10.2021";
        String testPhone = "1111111";
        Map<String, String> missedCalls = new TreeMap<>();
        missedCalls.put(localDateTime, testPhone);
        String expected = "{22.10.2021=1111111}";
        String result = missedCalls.toString();

        assertEquals(expected, result);
    }
```

* `testGetMissedCalls()` - возвращает контакт, если он уже есть в списке:
```text
@Test
    public void testGetMissedCalls() {

        Map<String, String> missedCalls = new HashMap<>();
        missedCalls.put("22.12.2021", "8888888");
        missedCalls.put("25.12.2021", "7773344");
        missedCalls.put("06.01.2022", "5555555");

        Map<String, Contact> contacts = new HashMap<>();
        contacts.put("3333333", new Contact("surname1", "name1", "3333333"));
        contacts.put("7773344", new Contact("surname2", "name2", "7773344"));
        contacts.put("4444444", new Contact("surname3", "name3", "4444444"));

        String testNumber = "7773344";
        boolean expected = true;
        boolean result = false;

        if(missedCalls.containsValue(testNumber) == contacts.containsKey(testNumber)) {result = true;}

        assertEquals(expected, result);
    }
```
