package Bitlab.SprintTask.DB;

import Bitlab.SprintTask.Entity.Task1.Task;

import java.util.ArrayList;
import java.util.List;

public class dbManager {
    static List<Task> tasks = new ArrayList<>();
    private static int id=6;
    static {
    tasks.add(new Task(1,
            "Создать WEB приложение",
            "Создать приложения для WEB",
            "10.06.2023",
            "ДА"));
        tasks.add
                (new Task
                        (2,
                                "Убраться Дома",
                                "Очистить дом",
                                "11.06.2023",
                                "ДА"));
        tasks.add
                (new Task
                        (3,
                                "Выполнить Sprint Task",
                                "Сделать ДЗ ",
                                "14.06.2023",
                                "НЕТ"));
        tasks.add
                (new Task
                        (4,
                                "Идти на тренировку",
                                "Тренировка",
                                "14.06.2023",
                                "НЕТ"));
        tasks.add
                (new Task
                        (5,
                                "Учить Англиский",
                                "Знать языки",
                                "15.06.2023",
                                "НЕТ"));
    }
    public static List<Task> getTasks(){
        return tasks;
    }
    public static void addTask(Task task){
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static void getTask(Task task) {
        for (Task t : tasks) {
            if (t.getId() == task.getId()) {
                t.setName(task.getName());
                t.setDescription(task.getDescription());
                t.setStatus(task.getStatus());
                t.setDeadlineDate(task.getDeadlineDate());
                break;
            }
        }
    }
    public static void deleteTask(int id){
        for(Task t: tasks){
            if(t.getId() == id){
                tasks.remove(t);
                break;
            }
        }
    }

}
