package project.bitlab.finalyProjectNewsPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.bitlab.finalyProjectNewsPortal.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
  @Query("select r from Role r where r.name = 'USER_NAME'")
  Role findRoleUser();
}
