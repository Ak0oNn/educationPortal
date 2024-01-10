package kz.bitlab.educationPortal.service.impl;

import java.util.List;
import kz.bitlab.educationPortal.model.Post;
import kz.bitlab.educationPortal.repository.PostRepository;
import kz.bitlab.educationPortal.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;
  @Override
  public List<Post> getAllPost() {
    return postRepository.findAll();
  }

  @Override
  public Post getPostById(Long id) {
    return postRepository.findById(id).orElse(null);
  }

  @Override
  public void addPost(Post post) {
    postRepository.save(post);
  }

  @Override
  public void editPost(Long id) {
    Post post = getPostById(id);
    addPost(post);
  }

  @Override
  public void deletePost(Long id) {
    postRepository.deleteById(id);
  }
}
