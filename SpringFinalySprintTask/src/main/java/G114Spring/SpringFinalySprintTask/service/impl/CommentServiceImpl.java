package G114Spring.SpringFinalySprintTask.service.impl;

import G114Spring.SpringFinalySprintTask.models.Comment;
import G114Spring.SpringFinalySprintTask.models.Task;
import G114Spring.SpringFinalySprintTask.repositories.CommentRepository;
import G114Spring.SpringFinalySprintTask.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
  @Autowired
  private CommentRepository commentRepository;
  @Override
  public List<Comment> findAllbyTask(Task task) {
    return commentRepository.findAllByTask(task);
  }

  @Override
  public void addComment(String comment, Task task) {
    Comment newcomment = new Comment();
    newcomment.setComment(comment);
    newcomment.setTask(task);
    commentRepository.save(newcomment);
  }

  @Override
  public Comment findCommentById(Long id) {
    return commentRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteComment(List<Comment> comments) {
    commentRepository.deleteAll(comments);
  }
}
