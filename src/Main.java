import Task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    private static final Task.TaskManager TASK_MANAGER = new Task.TaskManager();
    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("\\d{2}.\\d{2}.\\d{4} \\d{2}:\\d{2}");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{2}.\\d{2}.\\d{4}");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {

      /*  try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            printAllByDate(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void printAllByDate(Scanner scanner) {
        System.out.print("Введите дату и время в формате dd.mm.yyyy ");

        if (scanner.hasNext(DATE_PATTERN)) {
            String dateTime = scanner.next(DATE_PATTERN);
            LocalDate inputDate = LocalDate.parse(dateTime, DATE_FORMATTER);
            Collection<Task> tasksByDay = TASK_MANAGER.getAllByDate(inputDate);
            for (Task task : tasksByDay
            ) {
                System.out.println(task);
            }
        } else {
            System.out.println("Введите дату и время в формате dd.mm.yyyy hh:mm ");
        }
    }

    private static String inputTaskTitle(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String title = scanner.next();
        if (title.isBlank()) {
            System.out.print("Не указано название задачи");
            scanner.close();
        }
        return title;
    }

    private static String inputTaskDescription(Scanner scanner) {
        System.out.print("Введите описание задачи: ");
        String description = scanner.next();
        if (description.isBlank()) {
            System.out.print("Не указано описание задачи");
        }
        return description;
    }

    private static Type inputTaskType(Scanner scanner) {
        System.out.print("Введите тип задачи(1 - личная, 2 - рабочая): ");
        Type type = null;

        int taskTypeSelection = scanner.nextInt();
        switch (taskTypeSelection) {
            case 1:
                type = Type.PERSONAL;
                break;
            case 2:
                type = Type.WORK;
                break;
            default:
                System.out.println(" Не верно указан тип задачи ");
        }
        return type;
    }

    private static LocalDateTime inputTaskTime(Scanner scanner) {
        System.out.print("Введите дату и время создания задачи в формате dd.mm.yyyy hh:mm ");
        LocalDateTime taskTime = null;
        while (taskTime == null) {
            if (scanner.hasNext(DATE_TIME_PATTERN)) {
                String dateTime = scanner.next(DATE_TIME_PATTERN);
                taskTime = LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
            } else {
                System.out.println("Введите дату и время создания задачи в формате dd.mm.yyyy hh:mm ");
                // косячёк с циклом
            }
        }
        return taskTime;
    }

    private static Integer inputRepeatability(Scanner scanner) {
        System.out.print("Введите повторяемость задачи(1 - однократно, 2 - ежедневно, 3 - еженедельно, 4 - ежемесячно, 5 - ежегодно): ");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Введены число, из списка");
        }
        return null;
    }

    private static void createTask(String title, String description, Type type, LocalDateTime taskTime, Integer repeatability) {
        Task task = null;
        try {
            switch (repeatability) {
                case 1:
                    task = new OneTimeTask(title, description, type, taskTime);
                    break;
                case 2:
                    task = new DailyTask(title, description, type, taskTime);
                    break;
                case 3:
                    task = new WeeklyTask(title, description, type, taskTime);
                    break;
                case 4:
                    task = new MonthlyTask(title, description, type, taskTime);
                    break;
                case 5:
                    task = new YearlyTask(title, description, type, taskTime);
                    break;
                default:
                    System.out.println("Указана некорректная частота повторения");
            }
        } catch (IncorrectArgumentException e) {
            throw new RuntimeException(e);
        }
        if (task != null) {
            TASK_MANAGER.add(task);
            System.out.println("Задача добавлена");
        } else {
            System.out.println("Введены некорректные значения");
        }
    }

    private static void removeTask(Scanner scanner) {
        System.out.println("Введите id задачи для удаления(id с 1)");
        try {
            Integer id = scanner.nextInt();
            TASK_MANAGER.remove(id);
            System.out.println("Задача номер " + id + " удалена");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void inputTask(Scanner scanner) {
        scanner.useDelimiter("\n");
        String title = inputTaskTitle(scanner);
        String description = inputTaskDescription(scanner);
        Type type = inputTaskType(scanner);
        LocalDateTime taskTime = inputTaskTime(scanner);
        Integer repeatability = inputRepeatability(scanner);
        createTask(title, description, type, taskTime, repeatability);
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Получить задачу на указанный день");
        System.out.println("0. Выход");
    }*/

        /** ================================= Функциональное программирование ======================================= **/

        System.out.println("Введите текст:");
        // String input = "yourapp the quick brown fox jumps over the lazy dog";
        String input = args.length == 0 ? new Scanner(System.in).nextLine() : args[0];
        String[] tokens = input.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(tokens).forEach(s -> map.compute(s, (str, integer) -> map.containsKey(str) ? map.get(str) + 1 : 1));

        System.out.println("Output:\nВ тексте " + map.size() + " слов\nTOP 10:");

        map.keySet().stream().map(key -> new Tuple(key, map.get(key)))
                .sorted().limit(10).forEach(System.out::println);
    }
}

class Tuple implements Comparable<Tuple> {
    private final String k;
    private final Integer v;

    public Tuple(String k, Integer v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public int compareTo(Tuple o) {
        if (this.v < o.v) return 1;
        else if (this.v > o.v) return -1;
        else return this.k.compareTo(o.k);
    }

    @Override
    public String toString() {
        return v + " - " + k;
    }

}
