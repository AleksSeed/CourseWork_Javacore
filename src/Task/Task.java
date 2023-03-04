package Task;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public abstract class Task {
    private String title;
    private Type type;
    private LocalDate taskTime;
    private String description;
    private final Integer id;
    private static int counter = 1;

    public Task(String title, String description, Type taskType, LocalDate taskTime) throws IncorrectArgumentException {
        setTitle(title);
        setDescription(description);
        setTaskType(taskType);
        setTaskTime(taskTime);
        this.id = counter;
        counter++;
    }

    public void setTaskType(Type type) throws IncorrectArgumentException {
        if (type != null) {
            this.type = type;
        } else {
            throw new IncorrectArgumentException(" Тип задания ");
        }
    }

    public void setTaskTime(LocalDate taskTime) throws IncorrectArgumentException {
        if (taskTime != null) {
            this.taskTime = taskTime;
        } else {
            throw new IncorrectArgumentException(" Время задания ");
        }
    }

    public Integer getId() {
        return id;
    }


    public LocalDate getTaskTime() {
        return taskTime;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            throw new IncorrectArgumentException(" Заголовок задания ");
        }
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        } else {
            throw new IncorrectArgumentException(" Описание задания ");
        }
    }

    @Override
    public String toString() {
        return "Задание номер " + id +
                " название " + title +
                ", тип " + type +
                ", время создания " + taskTime +
                ", описание " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return title.equals(task.title) && type == task.type && taskTime.equals(task.taskTime) && description.equals(task.description) && id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, taskTime, description, id);
    }

    public abstract LocalDate getRepeatTime(LocalDate dateTime);

    public static class TaskManager {
        private final Map<Integer, Task> taskMap = new HashMap<>();

        public void add(Task task) {
            this.taskMap.put(task.getId(),task);
        }

        public void remove(Integer id) throws TaskNotFoundException {
            if (taskMap.containsKey(id)) {
                this.taskMap.remove(id);
            } else {
                throw new TaskNotFoundException(id);
            }
        }

        public Collection<Task> getAllByDate(LocalDate date) {
            Collection<Task> taskByDay = new ArrayList<>();
            for (Task task :
                    taskMap.values()) {
                LocalDate taskTime = LocalDate.from(task.getTaskTime());
                LocalDate taskNextTime = task.getRepeatTime(taskTime);

                if (taskNextTime == null || taskTime.equals(date)) {
                    taskByDay.add(task);
                    continue;
                }
                do {
                    if (taskNextTime.equals(date)) {
                        taskByDay.add(task);
                        break;
                    }
                    taskNextTime = task.getRepeatTime(taskNextTime);
                } while (taskNextTime.isBefore(date));
            }
            return taskByDay;
        }
    }
}
