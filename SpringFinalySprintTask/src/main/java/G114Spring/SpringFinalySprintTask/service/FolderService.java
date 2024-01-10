package G114Spring.SpringFinalySprintTask.service;

import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.TaskCategory;
import java.util.List;

public interface FolderService {
  List<Folder> getAllFolders();
  void addFolder(Folder folder);
  Folder findById(Long id);
  void updateFolder(Folder folder);
  void deleteFolder(Long folderId);
  void deleteAllByFolderId(Long id);

  void deleteAllByTask(Long id);


}
