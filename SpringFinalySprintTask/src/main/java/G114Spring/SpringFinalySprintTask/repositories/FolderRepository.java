package G114Spring.SpringFinalySprintTask.repositories;

import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.TaskCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository <Folder, Long>{
}
