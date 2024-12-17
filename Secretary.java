import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.Exception.InvalidAgeException;

import java.util.ArrayList;
import java.util.List;

public class Secretary {
    private Person person;
    private int salary;
    private Gym gym;

    public Secretary(Person person, int salary, Gym gym) {
        this.person = person;
        this.salary = salary;
        this.gym = gym;
    }
    private void validateSecretary() {
        if (!this.equals(gym.getSecretary())) {
            throw new IllegalStateException("Error: Former secretaries are not permitted to perform actions");
        }
    }

    public Client registerClient(Person person) throws DuplicateClientException, InvalidAgeException {
        if(!gym.getClients().isEmpty()) {
            for (Client client : gym.getClients()) {
                if (client.getName().equals(person.getName())) {
                    throw new DuplicateClientException("Error: The client is already registered");
                }
            }
        }
        validateSecretary();
        if (person.getAge() < 18) {  // Use the updated getAge() method
            throw new InvalidAgeException("Error: Client must be at least 18 years old to register");
        }
        Client newClient = new Client(person);
        gym.addClient(newClient);
        gym.getActions().add("Registered new client: " + newClient.getName());
        newClient.addNotification("You have ben registered for the gym successfully");
        return newClient;
    }

    public void unregisterClient(Client client) throws ClientNotRegisteredException {
        validateSecretary();
        if (!gym.getClients().contains(client)) {
            throw new ClientNotRegisteredException("Error: The client is not registered with the gym");
        }
        gym.getClients().remove(client);
        gym.getActions().add("Unregistered client: " + client.getName());
    }

    public Instructor hireInstructor(Person person, int salary, List<SessionType> certifications) {
        validateSecretary();
        Instructor instructor = new Instructor(person, salary, certifications);
        gym.addInstructor(instructor);
        gym.getActions().add("Hired new instructor: " + person.getName() + " with salary per hour: " + salary);
        return instructor;
    }

    public Session addSession(SessionType type, String dateTime, ForumType forum, Instructor instructor)
            throws InstructorNotQualifiedException {
        validateSecretary();
        if (!instructor.getCertifiedClasses().contains(type)) {
            throw new InstructorNotQualifiedException("Error: Instructor is not qualified to conduct this session type.");
        }
        Session session = new Session(type, dateTime, forum, instructor);
        gym.addSession(session);
        gym.getActions().add("Created new session: " + type + " on " + dateTime + " with instructor: " + instructor.getPerson().getName());
        return session;
    }
    public void paySalaries(){
        validateSecretary();
        gym.getSecretary().person.addToBalance(gym.getSecretary().salary);
        for(Instructor instructor : gym.getInstructors()){
            instructor.getPayed();

        }
        gym.getActions().add("Salaries have ben payed to all the workers");
    }

    public void registerClientToLesson(Client client, Session session) throws DuplicateClientException,ClientNotRegisteredException {
        validateSecretary();
        if (session.getForumType() != ForumType.All && !session.getForumType().equals(client.getGender())) {
            throw new IllegalArgumentException("Error: Client's gender doesn't match the session's forum requirements.");
        }
        session.Clients().add(client);
        gym.getActions().add("Registered client: " + client.getName() + " to session: " + session.getSessionType() + " on " + session.getDateNTime());
        client.addNotification("You have been registered for " + session.getSessionType() + " on " + session.getDateNTime());
    }

    /**
     * This "notify" method notifies all the clients in the gym
     * @param message
     */

    public void notify(String message) {
        validateSecretary();
        for (Client client : gym.getClients()) {
            client.addNotification(message);
        }
        gym.getActions().add("Sent notification to all clients: " + message);
    }

    /**
     * This "notify" method notifies all the clients that are registered to the session
     * @param session
     * @param message
     */
    public void notify(Session session,String message) {
        validateSecretary();
        for (Client client : session.Clients()) {
            client.addNotification(message);
        }
        gym.getActions().add("Sent notification to clients in the "+session.getSessionType()+" session on "+session.getDateNTime()+" : " + message);
    }

    /**
     * This "notify" method notifies all the clients that have a session at this date
     * @param date
     * @param message
     */
    public void notify(String date,String message) {
        validateSecretary();
        for (Session session : gym.getSessions()) {
            String Date = session.getDateNTime().substring(0,10);
            if(Date.equals(date)){
               notify(session,message);
            }
        }
    }

    // Print all actions performed by the secretary
    public void printActions() {
        validateSecretary();
        for(int i = 0; i < gym.getActions().size(); i++){
            String action = gym.getActions().get(i);
            System.out.println(action);
        }
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "Name='" + person.getName() + '\'' +
                ", Salary=" + salary +
                '}';
    }
}
