import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void querySimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(8, "Записаться к врачу");

        boolean actual = simpleTask.matches("Помыть кота");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    public void querySimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(6, "Убраться");

        boolean actual = simpleTask.matches("Убраться");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryEpicFalse() {
        String[] subtasks = {"Сходить в магазин", "Приготовить еду", "Сделать ДЗ"};
        Epic epic = new Epic(7, subtasks);

        boolean actual = epic.matches("Не делать ДЗ");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryEpicTrue() {
        String[] subtasks = {"Сходить в магазин", "Приготовить еду", "Сделать ДЗ"};
        Epic epic = new Epic(7, subtasks);

        boolean actual = epic.matches("Сделать ДЗ");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryMeetingFalse() {

        Meeting meeting = new Meeting(
                13,
                "Экология",
                "Глобальное потепление",
                "22.12.2023, 14:00");

        boolean actual = meeting.matches("Экология и экономика");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void queryMeetingTrue() {

        Meeting meeting = new Meeting(13, "Экология", "Глобальное потепление", "22.12.2023, 14:00");

        boolean actual = meeting.matches("Глобальное потепление");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

    }
}
