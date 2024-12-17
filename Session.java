public class Session {
    private SessionType sessionType;
    private String DateNTime;
    private ForumType forumType;
    private Instructor instructor;
    public Session(SessionType s, String DNT,ForumType f, Instructor i){
        this.sessionType = s;
        this.DateNTime = DNT;
        this.forumType = f;
        this.instructor = i;
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
}
