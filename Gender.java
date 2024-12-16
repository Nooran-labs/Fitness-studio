public class Gender {
    private final String gender;


    private Gender(String gender) {
        this.gender = gender;
    }

    // Predefined gender instances
    public static final Gender Male = new Gender("Male");
    public static final Gender Female = new Gender("Female");


    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Gender gender1 = (Gender) obj;
        return gender.equals(gender1.gender);
}


}