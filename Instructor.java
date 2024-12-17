import java.util.ArrayList;
import java.util.List;

public class Instructor{
    private Person person;
    private int salary;
    private List<SessionType> certifiedClasses;

    public Instructor(Person person, int salary, List<SessionType> certified){
        this.person = person;
        this.salary = salary;
        this.certifiedClasses = certified;
    }

    public Person getPerson() {
        return person;
    }

    public int getSalary() {
        return salary;
    }
    public void getPayed(){
        this.person.addToBalance(salary);
    }

    public List<SessionType> getCertifiedClasses() {
        return certifiedClasses;
    }
}
