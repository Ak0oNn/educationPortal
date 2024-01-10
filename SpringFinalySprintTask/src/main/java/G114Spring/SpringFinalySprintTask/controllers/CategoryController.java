package G114Spring.SpringFinalySprintTask.controllers;

import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.Task;
import G114Spring.SpringFinalySprintTask.models.TaskCategory;
import G114Spring.SpringFinalySprintTask.service.FolderService;
import G114Spring.SpringFinalySprintTask.service.TaskCategoryService;
import G114Spring.SpringFinalySprintTask.service.TaskService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CategoryController {
  @Autowired
  private TaskService taskService;
  @Autowired
  private TaskCategoryService taskCategoryService;

  @PostMapping("/addCategory")
  public String addCategory(TaskCategory taskCategory){
    taskCategoryService.addCategory(taskCategory);
    return "redirect:/categories";
  }

  @PostMapping("/deleteCategory")
  public String deleteAr(@RequestParam (name="category_id") Long categoryId ) {
    taskCategoryService.deleteCategoryById(categoryId);
    return "redirect:/categories";
  }

  @GetMapping("/categories")
  public String allCategories(Model model){
    List<Task> tasks = taskService.findAll();
    List<TaskCategory> taskCategories = taskCategoryService.getAllCategory();
    model.addAttribute("taskCategories", taskCategories);
    model.addAttribute("tasks", tasks);
    return "categories";
  }
}
