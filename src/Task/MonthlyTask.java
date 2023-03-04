package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, String description, Type taskType, LocalDateTime taskTime) throws IncorrectArgumentException {
        super(title, description, taskType, LocalDate.from(taskTime));
    }

    @Override
    public LocalDate getRepeatTime(LocalDate dateTime) {
        return dateTime.plusMonths(1);
    }

    @Override
    public LocalDateTime getRepeatTime(LocalDateTime dateTime) {
        return null;
    }

    @Override
    public boolean appearsIn(LocalDate dateForChecking) {
        return false;
    }

}
