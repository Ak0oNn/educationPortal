package kz.bitlab.educationPortal.repository;

import java.util.List;
import kz.bitlab.educationPortal.model.Item;
import kz.bitlab.educationPortal.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
  List<Task> findByItem(Item item);
}
