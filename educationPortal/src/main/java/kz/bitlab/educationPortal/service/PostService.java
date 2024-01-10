package kz.bitlab.educationPortal.service;

import java.util.List;
import kz.bitlab.educationPortal.model.Post;

public interface PostService {
  List<Post> getAllPost();

  Post getPostById(Long id);

  void addPost(Post post);

  void editPost(Long id);

  void deletePost(Long id);

}
