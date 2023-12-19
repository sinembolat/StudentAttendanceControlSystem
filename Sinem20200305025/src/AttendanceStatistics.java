import java.util.List;

public interface AttendanceStatistics {
    int getAttendanceCountForWeek(int week);
    List<Integer> getWeeklyAttendanceStatistics();
}

