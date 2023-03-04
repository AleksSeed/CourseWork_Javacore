package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task{

    public DailyTask(String title, String description, Type taskType, LocalDateTime taskTime) throws IncorrectArgumentException {
        super(title, description, taskType, LocalDate.from(taskTime));
    }

    @Override
    public LocalDate getRepeatTime(LocalDate dateTime) {
        return dateTime.plusDays(1);
    }

}
