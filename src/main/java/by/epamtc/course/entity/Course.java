package by.epamtc.course.entity;

import java.util.Objects;

public class Course {

    private int id;
    private String topic;
    private String description;
    private CourseStatus status;

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                Objects.equals(topic, course.topic) &&
                Objects.equals(description, course.description) &&
                status == course.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, description, status);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
