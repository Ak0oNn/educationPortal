package kz.bitlab.educationPortal.service;

import java.util.List;
import kz.bitlab.educationPortal.model.Comment;
import kz.bitlab.educationPortal.model.Task;
import kz.bitlab.educationPortal.model.User;

public interface CommentService {

  List<Comment> findAllByTask(Task task);

  void addComment(String comment, Task task, User user);

  Comment findCommentById(Long id);

  void deleteComments(List<Comment> comments);
  void deleteComment(Comment comment);



}
