import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static Gym instance;
    private String name;
    private Secretary secretary;
    private List<Client> clients;
    private List<Instructor> instructors;
    private List<Session> sessions;
    private List<String> actions ;

    private Gym() {
        clients = new ArrayList<>();
        instructors = new ArrayList<>();
        sessions = new ArrayList<>();
        actions = new ArrayList<>();
    }

    // Singleton implementation
    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Person person, int salary) {
        this.secretary = new Secretary(person, salary, this);
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public void addSession(Session session) {
        sessions.add(session);
    }
    public List<String> getActions(){
        return actions;
    }


    @Override
    public String toString() {
        return "Gym Name: " + name + "\n" +
                "Secretary: " + secretary + "\n" +
                "Clients: " + clients.size() + "\n" +
                "Instructors: " + instructors.size() + "\n" +
                "Sessions: " + sessions.size();
    }
}
