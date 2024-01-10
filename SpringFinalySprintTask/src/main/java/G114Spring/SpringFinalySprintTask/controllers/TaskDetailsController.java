package G114Spring.SpringFinalySprintTask.controllers;

import G114Spring.SpringFinalySprintTask.models.Comment;
import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.models.Task;
import G114Spring.SpringFinalySprintTask.service.CommentService;
import G114Spring.SpringFinalySprintTask.service.FolderService;
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
public class TaskDetailsController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private FolderService folderService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/taskDetails/{id}")
    public String taskDetails(@PathVariable Long id, Model model) {
      Task task = taskService.findById(id);
      List<Comment> comments = commentService.findAllbyTask(task);
      model.addAttribute("task", task);
      model.addAttribute("comments", comments);
      return "taskDetails";
    }

    @PostMapping("editTask")
    public String editTask(@RequestParam(name = "folder_id") Long folderId, Task task) {
      Folder folder = folderService.findById(folderId);
      taskService.editTask(task, folder);
      return "redirect:/folderDetails/" + folder.getId();
    }

    @PostMapping("deleteTask")
    public String deleteTask(@RequestParam Long id,
        @RequestParam(name = "folder_id") Long folderId) {
      Task task = taskService.findById(id);
      List<Comment> comments = commentService.findAllbyTask(task);
      commentService.deleteComment(comments);
      taskService.deleteTask(task);
      return "redirect:/folderDetails/" + folderId;
    }

    @PostMapping("addComment")
    public String addComment(@RequestParam Long id, String comment) {
      Task task = taskService.findById(id);
      commentService.addComment(comment, task);
      return "redirect:/taskDetails/" + id;
    }
  }

