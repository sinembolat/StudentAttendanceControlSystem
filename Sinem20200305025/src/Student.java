import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<Course> courses;
    private List<List<Boolean>> weeklyAttendance;

    public Student(String name) {
        super(name);
        this.courses = new ArrayList<>();
        this.weeklyAttendance = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
        weeklyAttendance.add(new ArrayList<>());
    }

    public List<List<Boolean>> getWeeklyAttendance() {
        return weeklyAttendance;
    }

    public void markAttendance(int week, boolean isPresent) {
        List<Boolean> weekAttendance = getWeekAttendance(week);
        weekAttendance.add(isPresent);
    }

    public List<Boolean> getWeekAttendance(int week) {
        for (int i = weeklyAttendance.size(); i <= week; i++) {
            weeklyAttendance.add(new ArrayList<>());
        }
        return weeklyAttendance.get(week);
    }
}



