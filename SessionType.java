public class SessionType {
    public static final SessionType Pilates = new SessionType("Pilates");
    public static final SessionType MachinePilates = new SessionType("MachinePilates");
    public static final SessionType ThaiBoxing = new SessionType("ThaiBoxing");
    public static final SessionType Ninja = new SessionType("Ninja");

    private final String Type;

    private SessionType(String Type) {
        this.Type = Type;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
        return Type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SessionType sessionType = (SessionType) obj;
        return Type.equals(sessionType.Type);
    }
}
