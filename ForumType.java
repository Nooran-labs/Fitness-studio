public class ForumType {
    public static final ForumType All = new ForumType("All");
    public static final ForumType Female = new ForumType("Female");
    public static final ForumType Male = new ForumType("Male");
    public static final ForumType Seniors = new ForumType("Seniors");

    private final String Type;

    private ForumType(String Type) {
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
        ForumType forumType = (ForumType) obj;
        return Type.equals(forumType.Type);
    }


}
