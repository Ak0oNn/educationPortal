package G114Spring.SpringFinalySprintTask.controllers;

import G114Spring.SpringFinalySprintTask.models.Comment;
import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.Task;
import G114Spring.SpringFinalySprintTask.models.TaskCategory;
import G114Spring.SpringFinalySprintTask.service.CommentService;
import G114Spring.SpringFinalySprintTask.service.FolderService;
import G114Spring.SpringFinalySprintTask.service.TaskCategoryService;
import G114Spring.SpringFinalySprintTask.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FolderController {
  @Autowired
  private FolderService folderService;

  @Autowired
  private TaskService taskService;

  @Autowired
  private TaskCategoryService taskCategoryService;
  @Autowired
  private CommentService commentService;

  @GetMapping("/folderDetails/{id}")
  public String folderDetails(@PathVariable Long id, Model model){
    Folder folder = folderService.findById(id);
    List<Task> tasks = taskService.findByFolder(folder);
    List<TaskCategory> taskCategories = taskCategoryService.getAllCategory();
    model.addAttribute("folder", folder);
    model.addAttribute("tasks",tasks);
    model.addAttribute("categories", taskCategories);
    return "folderDetails";
  }

  @PostMapping("/addTaskCategory")
  public String addTaskCategory(@RequestParam(name = "category_id")Long categoryId,
                                @RequestParam(name = "folder_id")Long folderId){
  Folder folder = folderService.findById(folderId);
  TaskCategory taskCategory = taskCategoryService.findById(categoryId);
  List<TaskCategory> taskCategories= folder.getCategories();
  if (!taskCategories.contains(taskCategory)){
    taskCategories.add(taskCategory);
  }
  folderService.updateFolder(folder);
  return "redirect:/folderDetails/"+folderId;
  }

  @PostMapping("/deleteTaskCategory")
  public String deleteCategory(@RequestParam(name = "category_id") Long categoryId,
      @RequestParam(name = "folder_id") Long folderId) {
    Folder folder = folderService.findById(folderId);
    TaskCategory taskCategory = taskCategoryService.findById(categoryId);
    List<TaskCategory> taskCategories = folder.getCategories();
    taskCategories.remove(taskCategory);
    folderService.updateFolder(folder);
    return "redirect:/folderDetails/" + folderId;
  }

  @PostMapping("/addTask")
  public String addTask(@RequestParam(name = "folder_id") Long folderId, Task task){
    Folder folder = folderService.findById(folderId);
    taskService.addNewTask(task, folder);
    folderService.updateFolder(folder);
    return "redirect:folderDetails/"+ folderId;
  }
  @PostMapping("/editFolder")
  public String editFolder(Folder folder){
    folderService.updateFolder(folder);
    return "redirect:/folderDetails/"+folder.getId();
  }



  @PostMapping("/deleteFolder")
  public  String deleteFolder(@RequestParam(name = "folder_id") Long folderId){
    folderService.deleteFolder(folderId);
    return "redirect:/home";
  }



}
