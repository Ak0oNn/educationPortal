package project.bitlab.finalyProjectNewsPortal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cityId;
  private String cityName;
  @ManyToOne
  private Post city;
}
