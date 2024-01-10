package kz.bitlab.educationPortal.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import kz.bitlab.educationPortal.model.Comment;
import kz.bitlab.educationPortal.model.Group;
import kz.bitlab.educationPortal.model.Item;
import kz.bitlab.educationPortal.model.Task;
import kz.bitlab.educationPortal.model.User;
import kz.bitlab.educationPortal.model.enums.statusTask;
import kz.bitlab.educationPortal.repository.TaskRepository;
import kz.bitlab.educationPortal.service.CommentService;
import kz.bitlab.educationPortal.service.GroupService;
import kz.bitlab.educationPortal.service.ItemService;
import kz.bitlab.educationPortal.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TaskServiceImpl implements TaskService {
  @Autowired
  private TaskRepository taskRepository;
  @Autowired
  private ItemService itemService;
  @Autowired
  private ResourceLoader resourceLoader;
  @Autowired
  private GroupService groupService;
  @Autowired
  private CommentService commentService;

  @Override
  public List<Task> getAllTaskFromItem(Long id) {
    Item item = itemService.getItemById(id);
    return taskRepository.findByItem(item);
  }


  @Override
  public Task getTaskById(Long id) {
    return taskRepository.findById(id).orElse(null);
  }


  public void uploadFile(MultipartFile file) throws IOException {

    File file1 = new File(
        resourceLoader.getResource("classpath:store/").getFile() + "/" + file.getOriginalFilename());
    if (file1.createNewFile()) {
      System.out.println("File is created!" + file1.getAbsolutePath());

    } else {
      System.out.println("File already exists.");
    }

    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file1));
    stream.write(file.getBytes());
    stream.close();
  }

  public Resource downloadFile(String fileName) throws Exception {

    final Resource fileResource = resourceLoader.getResource("classpath:store/" + fileName);
    return fileResource;
  }

  @Override
  public void addNewTask(Long itemId, Task task, Long groupId ) {
    Group group = groupService.findById(groupId);
    Item item = itemService.getItemById(itemId);
    task.setItem(item);
    task.setGroup(group);
    task.setStatus(statusTask.Назначено);
    taskRepository.save(task);
    itemService.updateItem(item);
  }

  @Override

  public void deleteTask(Long taskId) {
    Task task = getTaskById(taskId);
    List<Comment> comments = commentService.findAllByTask(task);
    commentService.deleteComments(comments);
    taskRepository.delete(task);
  }

  @Override
  public void editTask(Long taskId, Long itemId, Long groupId) {
    Task task = getTaskById(taskId);
    Group group = groupService.findById(groupId);
    Item item = itemService.getItemById(itemId);
    task.setGroup(group);
    task.setItem(item);
    taskRepository.save(task);
    itemService.updateItem(item);

  }
}
