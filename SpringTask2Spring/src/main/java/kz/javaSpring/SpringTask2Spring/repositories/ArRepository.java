package kz.javaSpring.SpringTask2Spring.repositories;

import java.util.List;
import kz.javaSpring.SpringTask2Spring.Models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArRepository extends JpaRepository<ApplicationRequest, Long> {

}
