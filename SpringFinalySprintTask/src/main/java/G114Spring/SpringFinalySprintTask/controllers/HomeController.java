package G114Spring.SpringFinalySprintTask.controllers;

import G114Spring.SpringFinalySprintTask.models.Folder;
import G114Spring.SpringFinalySprintTask.service.FolderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  @Autowired
  private FolderService folderService;

  @GetMapping("/")
  public String homePage(Model model){
    List<Folder> folders = folderService.getAllFolders();
    model.addAttribute("folders", folders);
  return "home";
  }

  @PostMapping("/addFolder")
  public String addFolder(Folder folder){
    folderService.addFolder(folder);
    return "redirect:/";
  }

}
