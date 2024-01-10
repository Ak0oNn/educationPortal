package kz.bitlab.educationPortal.controller;

import java.util.List;
import kz.bitlab.educationPortal.model.Item;
import kz.bitlab.educationPortal.model.User;
import kz.bitlab.educationPortal.service.GroupService;
import kz.bitlab.educationPortal.service.ItemService;
import kz.bitlab.educationPortal.service.TaskService;
import kz.bitlab.educationPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {
  @Autowired
  private TaskService taskService;
  @Autowired
  private ItemService itemService;
  @Autowired
  private GroupService groupService;
  @Autowired
  private UserService userService;

  @GetMapping("/itemDetails/{id}")
  public String itemDetails(@PathVariable Long id, Model model){
  Item item = itemService.getItemById(id);
  model.addAttribute("tasks",taskService.getAllTaskFromItem(id));
  model.addAttribute("items", item);
  model.addAttribute("group", groupService.getAllGroup());
  return "task";
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @PostMapping("addItem")
  public String addItem(Item item, @RequestParam(name = "group_id") Long groupId){
    itemService.addItem(item, groupId);
    return"redirect:/item";
  }



  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping("/item")
  public String AdminItemPanel(Model model){
    model.addAttribute("group",groupService.getAllGroup());
    model.addAttribute("item",itemService.getAllItem());
    return "AdminItem";
  }

  @PreAuthorize("hasAnyRole('ROLE_TEACHER')")
  @GetMapping("/ItemTeacher")
  public String TeacherItem(Model model){
    model.addAttribute("items", itemService.getItemFromTeacher());
    return "TeacherItem";
  }

  @GetMapping("StudentItem")
  public String ItemPage(Model module){
    User user = userService.getCurrentUser();
    Long groupId = user.getGroup().getId();
    List<Item> items = itemService.getAllItemFromGroup(groupId);
    module.addAttribute("items",items);
    return "StudentItem";
  }

  @PostMapping("addItemFromTeacher")
  public String addItemFromTeacher(@RequestParam (name = "teacher_id") Long teacherId,
      @RequestParam(name = "item_id") Long itemId){
    System.out.println(itemId+"aaaaaaaa"+teacherId);
    itemService.addItemFromTeacher(teacherId,itemId);
    return "redirect:/ItemTeacher";
  }

}
