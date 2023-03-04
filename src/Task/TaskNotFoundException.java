package Task;

public class TaskNotFoundException extends Exception {

    public TaskNotFoundException(Integer taskId) {
        super("Задачи с id = " + taskId + " не существует!");
    }

}