package kz.bitlab.JavaSpring_SprintTask1.Controller;

import kz.bitlab.JavaSpring_SprintTask1.Model.Student;
import kz.bitlab.JavaSpring_SprintTask1.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("students", DBManager.getStudents());
    return "home";
  }

  @GetMapping("/add-student")
  public String addStudents() {
    return "addStudent";
  }

  @PostMapping("/add-student")
  public String addStudent(@RequestParam String name,
      @RequestParam String surname,
      @RequestParam int exam) {
    Student student = new Student();
    student.setName(name);
    student.setExam(exam);
    student.setSurname(surname);
    DBManager.addStudent(student);
    student.setMark(exam);
    return "redirect:/";
  }
}
