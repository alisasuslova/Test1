import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class MissedCallsTests {

    MissedCallsTests sut;

    @BeforeEach
    public void init() {
        System.out.println("Test started");
        sut = new MissedCallsTests();
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("Test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Tests completed");
    }


    @Test
    public void testDelMissedCalls() {

        Map<LocalDateTime, String> missedCalls = new TreeMap<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        boolean expected = true;
        missedCalls.put(localDateTime, "4445566");
        missedCalls.put(localDateTime, "7773344");
        missedCalls.put(localDateTime, "1112233");
        boolean check = missedCalls.isEmpty(); //false
        System.out.println(check + ", В списке есть контакты");

        missedCalls.clear();

        assertEquals(expected, missedCalls.isEmpty());
    }

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


}
