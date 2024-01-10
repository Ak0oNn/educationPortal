package kz.bitlab.educationPortal.repository;

import java.util.List;
import kz.bitlab.educationPortal.model.Role;
import kz.bitlab.educationPortal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  User findByEmail(String email);

  List<User> findByRoles(Role role);
}
