package G114Spring.SpringFinalySprintTask.repositories;

import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository <Task,Long> {
  @Query("delete from Task t where t.folder.id= :id")
  void deleteAllByFolder(Long id);

  List<Task> findAllByFolderId(Long id);
  List<Task> findByFolder(Folder folder);


}
