package kz.bitlab.securitySpringBoot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import kz.bitlab.securitySpringBoot.models.enums.Gender;
import kz.bitlab.securitySpringBoot.models.enums.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "is_banned")
  private boolean isBanned;
  private Gender gender;
  private String email;
  private String password;
  @Enumerated(EnumType.ORDINAL)
  private Role role;

  @Column(unique = true)
  private String username;
  private String firstname;
  private String lastname;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthdate;


  public void changeBan() {
    isBanned = !isBanned;
  }
}
