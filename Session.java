import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private SessionType sessionType;
    private String DateNTime;
    private ForumType forumType;
    private Instructor instructor;
    private List<Client> clients;

    public Session(SessionType s, String DNT, ForumType f, Instructor i) {
        this.sessionType = s;
        this.DateNTime = DNT;
        this.forumType = f;
        this.instructor = i;
        this.clients = new ArrayList<>();

    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public String getDateNTime() {
        return DateNTime;
    }

    public ForumType getForumType() {
        return forumType;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Client> Clients() {
        return clients;

    }

}
