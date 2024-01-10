package G114Spring.SpringFinalySprintTask.service.impl;

import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.Task;
import G114Spring.SpringFinalySprintTask.models.TaskCategory;
import G114Spring.SpringFinalySprintTask.repositories.CommentRepository;
import G114Spring.SpringFinalySprintTask.repositories.FolderRepository;
import G114Spring.SpringFinalySprintTask.repositories.TaskRepository;
import G114Spring.SpringFinalySprintTask.service.FolderService;
import G114Spring.SpringFinalySprintTask.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl implements FolderService {

  @Autowired
  private FolderRepository folderRepository;
  @Autowired
  private TaskRepository taskRepository;
  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private TaskService taskService;
  @Override
  public List<Folder> getAllFolders() {

    return folderRepository.findAll();
  }

  @Override
  public void addFolder(Folder folder) {
    folderRepository.save(folder);
  }

  @Override
  public Folder findById(Long id) {
    return folderRepository.findById(id).orElse(null);
  }

  @Override
  public void updateFolder(Folder folder) {
    folderRepository.save(folder);
  }

  @Override
  public void deleteFolder(Long folderId) {
    List <Task> tasks = taskService.getTasksByFoldrId(folderId);
    for (Task task: tasks){
      commentRepository.deleteAllByTask(task.getId());
      taskService.deleteTask(task);
    }
    folderRepository.deleteById(folderId);
  }


  @Override
  public void deleteAllByFolderId(Long id) {
    taskRepository.deleteAllByFolder(id);
  }

  @Override
  public void deleteAllByTask(Long id) {
    commentRepository.deleteAllByTask(id);
  }


}
