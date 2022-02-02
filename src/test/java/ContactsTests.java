import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactsTests {

    ContactsTests sut;

    @BeforeEach
    public void init() {
        System.out.println("Test started");
        sut = new ContactsTests();
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
    public void testAddContact() {

        Map<String, Contact> contacts = new HashMap<>();
        Contact contact1 = new Contact("surname1", "name1", "phone1");
        Contact contact2 = new Contact("surname2", "name2", "phone2");
        contacts.put("phone1", contact1);
        contacts.put("phone2", contact2);
        int expected = 2;

        int result = contacts.size();

        assertEquals(expected, result);
    }

}
