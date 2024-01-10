package kz.bitlab.educationPortal.controller;

import java.util.List;
import kz.bitlab.educationPortal.model.Comment;
import kz.bitlab.educationPortal.model.Group;
import kz.bitlab.educationPortal.model.Task;
import kz.bitlab.educationPortal.model.User;
import kz.bitlab.educationPortal.service.CommentService;
import kz.bitlab.educationPortal.service.GroupService;
import kz.bitlab.educationPortal.service.TaskService;
import kz.bitlab.educationPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TaskController {

  @Autowired
  private TaskService taskService;
  @Autowired
  private CommentService commentService;
  @Autowired
  private UserService userService;
  @Autowired
  private GroupService groupService;


  @GetMapping("/taskDetails/{id}")
  public String taskDetails(@PathVariable Long id, Model model) {
    Task task = taskService.getTaskById(id);
    User user = userService.getCurrentUser();
    List<Group> group = groupService.getAllGroup();
    List<Comment> comments = commentService.findAllByTask(task);
    model.addAttribute("comments", comments);
    model.addAttribute("task", task);
    model.addAttribute("user", user);
    model.addAttribute("groups", group);
    return "taskDetails";
  }

  @PostMapping("/upload")
  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {
    try {
      taskService.uploadFile(uploadfile);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/download")
  public ResponseEntity<Resource> downloadFile(@RequestParam("filename") String filename) {

    Resource resource = null;
    try {
      resource = taskService.downloadFile(filename);
      String contentType = "application/octet-stream";

      return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
          .header(
              HttpHeaders.CONTENT_DISPOSITION,
              "attachment; filename=\"" + resource.getFilename() + "\"")
          .body(resource);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("addComment")
  public String addComment(@RequestParam Long id, String comment) {
    User author = userService.getCurrentUser();
    Task task = taskService.getTaskById(id);
    commentService.addComment(comment, task, author);
    return "redirect:/taskDetails/" + id;
  }

  @PostMapping("deleteComment")
  public String deleteComment(@RequestParam Long id) {
    Comment comment = commentService.findCommentById(id);
    Long TaskId = comment.getTask().getId();
    commentService.deleteComment(comment);
    return "redirect:/taskDetails/" + TaskId;
  }

  @PostMapping("editTask")
  public String editTask(@RequestParam(name = "task_id") Long taskId,
      @RequestParam(name = "item_id") Long itemId,
      @RequestParam(name = "group_id") Long groupId) {
    taskService.editTask(taskId, itemId, groupId);
    return "redirect:/taskDetails/" + taskId;
  }

  @PostMapping("/addTask")
  public String addTask(@RequestParam(name = "item_id") Long itemId, Task task,
      @RequestParam(name = "group_id") Long groupID) {
    taskService.addNewTask(itemId, task, groupID);
    return "redirect:itemDetails/" + itemId;
  }

  @PostMapping("deleteTask")
  public String deleteTask(@RequestParam(name = "task_id") Long taskId,
      @RequestParam(name = "item_id") Long itemId) {
    taskService.deleteTask(taskId);
    return "redirect:/itemDetails/" + itemId;
  }
}
