package kz.bitlab.educationPortal.controller;

import kz.bitlab.educationPortal.model.User;
import kz.bitlab.educationPortal.service.GroupService;
import kz.bitlab.educationPortal.service.ItemService;
import kz.bitlab.educationPortal.service.RoleService;
import kz.bitlab.educationPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


  @Autowired
  private GroupService groupService;
  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;
  @Autowired
  private ItemService itemService;


  @PostMapping("addUser")
    public String addNewStudent(User user, @RequestParam String re_password, @RequestParam Long group_id ){
      userService.addNewUser(user, re_password, group_id);
      return "redirect:student";
    }
  @PostMapping("addTeacher")
  public String addNewTeacher(User user, @RequestParam String re_password,
      @RequestParam Long group_id){
    userService.addNewTeacher(user, re_password, group_id);
    return "redirect:teacher";
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping("/user")
  public String AdminUserPanel(Model model){
    model.addAttribute("role", roleService.getAllRole());
    model.addAttribute("group",groupService.getAllGroup());
    model.addAttribute("user",userService.getAllUser());
    return "AdminUser";
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping("/student")
  public String AdminStudentPanel(Model model){
    model.addAttribute("group",groupService.getAllGroup());
    model.addAttribute("user",userService.getUserRoleStudent());
    return "AdminStudent";
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping("/teacher")
  public String AdminTeacherPanel(Model model){
    model.addAttribute("group",groupService.getAllGroup());
    model.addAttribute("user",userService.getUserRoleTeacher());
    model.addAttribute("items", itemService.getAllItem());
    return "AdminTeacher";
  }

  @GetMapping("/userDetails")
  public String userDetails(Model model){
    model.addAttribute("user",userService.getCurrentUser());
    return "UserDetails";
  }

}
