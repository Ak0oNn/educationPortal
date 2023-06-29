package Bitlab.SprintTask.DB;

import Bitlab.SprintTask.Entity.Task1.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static Connection connection;


    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/javaEE_JDBC",
                    "postgres",
                    "kenzo2015"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select  * from tasks");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setDeadlineDate(resultSet.getString("deadline_date"));
                task.setStatus(resultSet.getString("status"));
                tasks.add(task);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public static Task getTaskById(int id) {
        Task task = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select  * from tasks where  id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setDeadlineDate(resultSet.getString("deadline_date"));
                task.setStatus(resultSet.getString("status"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return task;
    }

    public static void addTask(Task task) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into tasks(name, description, deadline_date, status )"
                            + "values (?,?,?,?)");
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDeadlineDate());
            statement.setString(4, task.getStatus());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTaskById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from tasks where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editTask(Task task) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "update tasks set "
                            + " name = ?, description = ? , deadline_date = ? , status = ? "
                            + " where id = ?");
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDeadlineDate());
            statement.setString(4, task.getStatus());
            statement.setInt(5, task.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

