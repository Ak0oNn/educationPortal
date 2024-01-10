package G114Spring.SpringFinalySprintTask.service;

import G114Spring.SpringFinalySprintTask.models.Comment;
import G114Spring.SpringFinalySprintTask.models.Task;
import java.util.List;

public interface CommentService {
  List<Comment> findAllbyTask(Task task);

  void addComment(String comment, Task task);

  Comment findCommentById(Long id);

  void deleteComment(List<Comment> comments);
}
