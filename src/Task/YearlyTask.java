package Task;



import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, String description, Type taskType, LocalDateTime taskTime) throws IncorrectArgumentException {
        super(title, description, taskType, LocalDate.from(taskTime));
    }

    @Override
    public LocalDateTime getRepeatTime(LocalDateTime dateTime) {
        return dateTime.plusYears(1);
    }

    @Override
    public boolean appearsIn(LocalDate dateForChecking) {
        return false;
    }

    @Override
    public LocalDate getRepeatTime(LocalDate dateTime) {
        return null;
    }

}
