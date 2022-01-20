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
    public void testGetByPhone() {
        //arrange
        Map<String, Contact> contacts = new HashMap<>();
        String phone = "7773366";
        Contact contact = new Contact("Test1", "Test2", phone);
        contacts.put(phone, contact);

        //act
        Contact result = contacts.get(phone);

        //assert
        assertEquals(contact, result);
    }
}
