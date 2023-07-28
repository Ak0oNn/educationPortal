package kz.bitlab.JavaSpring_SprintTask1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  private Long id;
  private String name;
  private String surname;
  private int exam;
  private String mark;

  public void setMark(int exam) {
    if (exam >= 90 && exam == 100) {
      mark = "A";
    } else if (exam >= 75 && exam < 90) {
      mark = "B";
    } else if (exam >= 60 && exam < 75) {
      mark = "C";
    } else if (exam >= 50 && exam < 60) {
      mark = "D";
    } else {
      mark = "F";
    }
  }
}
