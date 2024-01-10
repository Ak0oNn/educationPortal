package G114Spring.SpringFinalySprintTask.service.impl;

import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.Task;
import G114Spring.SpringFinalySprintTask.repositories.TaskRepository;
import G114Spring.SpringFinalySprintTask.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Override
  public List<Task> findAll() {
    return taskRepository.findAll();
  }

  @Override
  public List<Task> findByFolder(Folder folder) {
    return taskRepository.findByFolder(folder);
  }

  @Override
  public Task findById(Long id) {
    return taskRepository.findById(id).orElse(null);
  }

  @Override
  public void addNewTask(Task task, Folder folder) {
    task.setStatus(0);
    task.setFolder(folder);
    taskRepository.save(task);
  }

  @Override
  public void editTask(Task task, Folder folder) {
    task.setFolder(folder);
    taskRepository.save(task);
  }

  @Override
  public void deleteTask(Task task) {
    taskRepository.delete(task);
  }

  @Override
  public List<Task> getTasksByFoldrId(Long folderId) {
    return taskRepository.findAllByFolderId(folderId);
  }
}
