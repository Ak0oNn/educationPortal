package kz.bitlab.educationPortal.service;

import java.io.IOException;
import java.util.List;
import kz.bitlab.educationPortal.model.Task;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface TaskService {

  List<Task> getAllTaskFromItem(Long id);

  Task getTaskById(Long id);


  void uploadFile(MultipartFile file) throws IOException;

  Resource downloadFile(String fileName) throws Exception;
  void addNewTask(Long itemID, Task task , Long groupId);

  void deleteTask(Long taskId );

  void editTask(Long taskId, Long itemId, Long groupId);

}
