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
}
