package kz.bitlab.securitySpringBoot.repository;

import java.util.List;
import kz.bitlab.securitySpringBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);

  User findByUsername(String username);

  @Modifying
  void deleteById(long id);


  List<User> findByUsernameContaining(String searchTerm);

  List<User> findAll();

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);


}
