package Bitlab.SprintTask.Entity.Task1;

public class SprintTask1Task {
    private int id;
    private String name;

    private String deadlineDate;
    private String status;

    public SprintTask1Task() {
    }

    public SprintTask1Task(int id, String name, String deadlineDate, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.deadlineDate = deadlineDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}
