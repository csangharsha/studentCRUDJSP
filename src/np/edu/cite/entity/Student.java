package np.edu.cite.entity;

public class Student {

    private int id;
    private String name;
    private int roll;
    private boolean isEnrolled;

    public Student() {
    }

    public Student(int id, String name, int roll, boolean isEnrolled) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.isEnrolled = isEnrolled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public void setEnrolled(boolean enrolled) {
        isEnrolled = enrolled;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", isEnrolled=" + isEnrolled +
                '}';
    }


}
