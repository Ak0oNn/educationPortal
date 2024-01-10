package G114Spring.SpringFinalySprintTask.service;

import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.TaskCategory;
import java.util.List;

public interface TaskCategoryService {
 List<TaskCategory> getAllCategory();
 TaskCategory findById(Long id);
 void addCategory(TaskCategory taskCategory);
 void deleteCategoryById(Long id);
}
