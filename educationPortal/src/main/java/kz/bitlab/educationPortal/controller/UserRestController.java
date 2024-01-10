package kz.bitlab.educationPortal.controller;

import java.util.List;
import kz.bitlab.educationPortal.dto.UserView;
import kz.bitlab.educationPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userRest")
public class UserRestController {
  @Autowired
  public UserService userService;

  @GetMapping
  public List<UserView> getUsers(){
    return userService.getAllUser();
  }
}
