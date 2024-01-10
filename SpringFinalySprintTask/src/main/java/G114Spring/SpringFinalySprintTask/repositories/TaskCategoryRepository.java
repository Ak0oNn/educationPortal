package G114Spring.SpringFinalySprintTask.repositories;

import G114Spring.SpringFinalySprintTask.models.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {
}
