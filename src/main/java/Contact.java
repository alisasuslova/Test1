public class Contact {

    private String surname;
    private String name;
    private String phone;


    public Contact(String surname, String name, String phone) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;

    }

    @Override
    public String toString() {
        return surname + " " + name + " " + phone ;
    }
}
