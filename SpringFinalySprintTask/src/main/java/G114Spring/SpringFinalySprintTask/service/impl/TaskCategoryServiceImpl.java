package G114Spring.SpringFinalySprintTask.service.impl;
import G114Spring.SpringFinalySprintTask.models.TaskCategory;
import G114Spring.SpringFinalySprintTask.repositories.TaskCategoryRepository;
import G114Spring.SpringFinalySprintTask.service.TaskCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskCategoryServiceImpl implements TaskCategoryService {

  @Autowired
  private TaskCategoryRepository taskCategoryRepository;
  @Override
  public List<TaskCategory> getAllCategory() {
    return taskCategoryRepository.findAll();
  }

  @Override
  public TaskCategory findById(Long id) {
    return taskCategoryRepository.findById(id).orElse(null);
  }

  @Override
  public void addCategory(TaskCategory taskCategory) {
    taskCategoryRepository.save(taskCategory);
  }

  @Override
  public void deleteCategoryById(Long id) {
    taskCategoryRepository.deleteById(id);
  }
}
