package kz.bitlab.educationPortal.repository;

import kz.bitlab.educationPortal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  @Query("select r from Role r where r.name ='ROLE_USER'")
  Role findRoleUser();

  @Query("select r from Role r where r.name='ROLE_TEACHER'")
  Role findRoleTeacher();

  @Query("select r from Role r where r.name='ROLE_ADMIN'")
  Role findRoleAdmin();
}
