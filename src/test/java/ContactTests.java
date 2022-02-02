import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTests {



    @Test
    public void testContact(){
        String surname = "testSurname";
        String name = "testName";
        String phone = "1111111";

        Contact contact = new Contact(surname,name,phone);

        String expected = "testSurname testName 1111111";
        String result = contact.toString();

        assertEquals(expected, result);

    }
}
