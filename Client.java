import java.util.List;

public class Client extends Person {
    private int balance;
    private Gender gender;
    private String name;
    private String DateOfBarth;
    private List<String> notifications;
    public Client(Person person) {
        super(person.getName(), person.getBalance(), person.getGender(), person.getDateOfBarth());
    }

    public Client(String name, int balance, Gender gender, String birth) {
        super(name, balance, gender, birth);
    }
    @Override
    public Gender getGender() {
        return gender;
    }
    @Override
    public int getBalance() {
        return balance;
    }
    @Override
    public String getDateOfBarth() {
        return DateOfBarth;
    }

    @Override
    public String getName() {
        return name;
    }

}
