package kz.bitlab.educationPortal.dto;

import kz.bitlab.educationPortal.model.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserView {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Group group;
}
