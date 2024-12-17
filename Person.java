import java.time.LocalDate;

public class Person {
    private int balance;
    private Gender gender;
    private String name;
    private String DateOfBarth;
    public Person(String name, int balance, Gender gender,String birth){
        this.name = name;
        this.balance = balance;
        this.gender = gender;
        this.DateOfBarth = birth;
    }

    public Gender getGender() {
        return gender;
    }

    public int getBalance() {
        return balance;
    }
    public void addToBalance(int salary){
        this.balance += salary;
    }

    public String getDateOfBarth() {
        return DateOfBarth;
    }

    public String getName() {
        return name;
    }
    public boolean equals(Person p){
        if(this.name.equals(p.getName()) && this.balance == p.getBalance() && this.gender.equals(p.getGender()) && this.DateOfBarth.equals(p.getDateOfBarth())){
            return true;
        }
        return false;
    }
    public double getAge(){
        String day = this.DateOfBarth.substring(0,2);
        String month = this.DateOfBarth.substring(3,5);
        String year = this.DateOfBarth.substring(6,10);

        int d = Integer.parseInt(day);
        int m = Integer.parseInt(month);
        int y = Integer.parseInt(year);

        LocalDate now = LocalDate.now();
        int age = now.getYear()-y;
        if(now.getMonthValue() < m || (now.getMonthValue() == m && now.getMonthValue() < m)){
            age--;
        }

        return age;

    }
}
