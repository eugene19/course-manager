package by.epamtc.courses.entity;

public enum UserType {
    STUDENT(1, "Student"),
    LECTURE(2, "Lecture");

    private int id;
    private String text;

    UserType(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public static UserType getById(int id) {
        for (UserType value : UserType.values()) {
            if (value.id == id) {
                return value;
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
