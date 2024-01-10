package kz.bitlab.educationPortal.repository;

import java.util.List;
import kz.bitlab.educationPortal.model.Comment;
import kz.bitlab.educationPortal.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
  List<Comment> findAllByTask(Task task);



}
