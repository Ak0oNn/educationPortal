package Bitlab.SprintTask.Entity.Task1;

import java.util.ArrayList;

public class DBManagerTask1 {
    private static final ArrayList<SprintTask1Task> tasks = new ArrayList<>();
    static int  id =6;
    static {
        tasks.add
                (new SprintTask1Task
                (1,
                        "Создать WEB приложение",
                        "10.06.2023",
                        "ДА"));
        tasks.add
                (new SprintTask1Task
                        (2,
                                "Убраться Дома",
                                "11.06.2023",
                                "ДА"));
        tasks.add
                (new SprintTask1Task
                        (3,
                                "Выполнить Sprint Task",
                                "14.06.2023",
                                "НЕТ"));
        tasks.add(new SprintTask1Task(4,"Идти на тренировку","14.06.2023","НЕТ"));
        tasks.add(new SprintTask1Task(5,"Учить Англиский","15.06.2023","НЕТ"));
    }
    public static void addTask(SprintTask1Task Task){
        Task.setId(id);
        tasks.add(Task);
        id++;
    }

    public static void deleteTask(int id){
        for(SprintTask1Task t: tasks){
            if(t.getId() == id){
                tasks.remove(t);
                break;
            }
        }
    }

    public static ArrayList<SprintTask1Task> getTasks(){
        return tasks;
    }


    public static void getTask(SprintTask1Task Task) {
        for (SprintTask1Task t : tasks) {
            if (t.getId() == Task.getId()) {
                t.setName(Task.getName());
                t.setStatus(Task.getStatus());
                t.setDeadlineDate(Task.getDeadlineDate());
                break;
            }
        }

    }
}
