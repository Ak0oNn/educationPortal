package kz.bitlab.educationPortal.controller;


import java.util.List;
import kz.bitlab.educationPortal.model.Post;
import kz.bitlab.educationPortal.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  @Autowired
  private PostService postService;

  @GetMapping("home")
  public String homePage(Model module){
    List<Post> posts = postService.getAllPost();
    module.addAttribute("posts", posts);
    return "home";
  }

  @GetMapping("/postDetails/{id}")
  public String detailsPost(@PathVariable Long id, Model model){
    model.addAttribute("post", postService.getPostById(id));
    return "postDetails";
  }

  @PostMapping("editPost")
  public String editPost(Long id){
    postService.editPost(id);
    return "redirect:/taskDetails/{id}"+ id;
  }

  @PostMapping("deletePost")
  public String deletePost(Long id){
    postService.deletePost(id);
    return "home";
  }

  @PostMapping("addPost")
  public String addPost(Post post){
    postService.addPost(post);
    return "redirect:/home";
  }

  @GetMapping("sign-in")
  public String signInPage(){
    return "sign-in";
  }


}
