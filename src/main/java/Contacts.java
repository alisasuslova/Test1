import java.util.HashMap;
import java.util.Map;

public class Contacts {
    Map<String, Contact> contacts = new HashMap<>();

    public void addContact(String phone, Contact contact) {
        contacts.put(phone, contact);
        System.out.println("Контакт добавлен");
    }

    public Contact getByPhone(String phone) {
        return contacts.get(phone);
    }

    @Override
    public String toString() {
        return "Контакт: " + contacts;
    }
}
