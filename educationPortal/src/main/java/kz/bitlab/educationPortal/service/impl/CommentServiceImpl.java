package kz.bitlab.educationPortal.service.impl;

import java.time.LocalDate;
import java.util.List;
import kz.bitlab.educationPortal.model.Comment;
import kz.bitlab.educationPortal.model.Task;
import kz.bitlab.educationPortal.model.User;
import kz.bitlab.educationPortal.repository.CommentRepository;
import kz.bitlab.educationPortal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
@Autowired
private CommentRepository commentRepository;
  @Override
  public List<Comment> findAllByTask(Task task) {
    return commentRepository.findAllByTask(task);
  }

  @Override
  public void addComment(String comment, Task task, User user) {
    Comment newcomment = new Comment();
    newcomment.setComment(comment);
    newcomment.setUser(user);
    newcomment.setCreateComment(LocalDate.now());
    newcomment.setTask(task);
    commentRepository.save(newcomment);
  }

  @Override
  public Comment findCommentById(Long id) {
    return commentRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteComments(List<Comment> comments) {
    commentRepository.deleteAll(comments);
  }

  public void deleteComment(Comment comment) {
    commentRepository.delete(comment);
  }



}
