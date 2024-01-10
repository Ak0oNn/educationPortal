package G114Spring.SpringFinalySprintTask.repositories;

import G114Spring.SpringFinalySprintTask.models.Comment;
import G114Spring.SpringFinalySprintTask.models.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  @Query("delete from Comment c where c.task.id = :id")
  void deleteAllByTask(Long id);
  List<Comment> findAllByTask(Task task);

}
