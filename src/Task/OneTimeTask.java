package Task;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, String description, Type taskType, LocalDateTime taskTime) throws IncorrectArgumentException {
        super(title, description, taskType, LocalDate.from(taskTime));
    }

    @Override
    public LocalDate getRepeatTime(LocalDate dateTime) {
        return null;
    }

}
