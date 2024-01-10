package G114Spring.SpringFinalySprintTask.service;

import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.Task;
import java.util.List;

public interface TaskService {
   List<Task> findAll();
   List<Task> findByFolder(Folder folder);
   Task findById(Long id);

   void addNewTask(Task task, Folder folder);

   void editTask(Task task, Folder folder);

   void deleteTask(Task task);
   List<Task> getTasksByFoldrId(Long folderId);
}
