package kz.bitlab.JavaSpring_SprintTask1.db;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.JavaSpring_SprintTask1.Model.Student;

public class DBManager {

  public static List<Student> students = new ArrayList<>();

  private static Long id = 4L;

  static {
    students.add(new Student(1L, "Ayan", "Nurgali", 100, "A"));
    students.add(new Student(2L, "Shyngys", "Abubakir", 95, "A"));
    students.add(new Student(3L, "Marat", "Maratovich", 49, "F"));
  }

  public static List<Student> getStudents() {
    return students;
  }

  public static void addStudent(Student student) {
    student.setId(id);
    id++;
    students.add(student);
  }
}
