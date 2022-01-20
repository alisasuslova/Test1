import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.time.format.DateTimeFormatter;

public class MissedCalls {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissedCalls(String inputCall) {
        missedCalls.put(LocalDateTime.now(), inputCall);
        System.out.println("Пропущенный вызов добавлен");
    }

    public void getMissedCalls(Contacts contacts) {
        if (missedCalls.isEmpty()) {
            System.out.println("Список пропущенных вызовов пуст!");
        } else {
            System.out.println("Список пропущенных вызовов:");
            for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
                Contact contact = contacts.getByPhone(entry.getValue());
                if (contact == null) {
                    System.out.println(entry.getKey() +
                            "   " + entry.getValue());
                } else {
                    System.out.println(entry.getKey() + "  " + contact);
                }
            }
        }
    }

    public void delMissedCalls() {
        missedCalls.clear();
        System.out.println("Журнал пропущенных вызовов очищен.");
        System.out.println();
    }
}

