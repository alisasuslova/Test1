import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MissedCalls missedCalls = new MissedCalls();
        Contacts contacts = new Contacts();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Программа: пропущенные вызовы.");
        System.out.println();

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Добавить пропущенный вызов");
            System.out.println("3. Вывести все пропущенные вызовы");
            System.out.println("4. Очистить пропущенные вызовы");
            System.out.println("5. Выход");
            System.out.println("Выберите пункт из меню (1-4):");
            String input = scanner.nextLine();

            switch (input) {
                case ("1"):
                    System.out.println("Добавьте контакт: Фамилия, Имя, телефон, группа");
                    String inputContact = scanner.nextLine();

                    String[] part = inputContact.split(" ");
                    String surname = part[0];
                    String name = part[1];
                    String phone = part[2];




                    Contact contact = new Contact(surname, name, phone);
                    contacts.addContact(phone, contact);
                    break;

                case ("2"):
                    System.out.println("Добавьте номер пропущенного вызова");
                    String inputCall = scanner.nextLine();
                    missedCalls.addMissedCalls(inputCall);
                    break;

                case ("3"):
                    missedCalls.getMissedCalls(contacts);
                    break;

                case ("4"):
                    missedCalls.delMissedCalls();
                    break;
            }

            if ("5".equals(input)) {
                System.out.println("программа завершена");
                break;
            }

        }

    }


}
