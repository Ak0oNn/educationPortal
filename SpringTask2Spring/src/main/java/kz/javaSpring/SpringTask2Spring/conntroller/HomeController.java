package kz.javaSpring.SpringTask2Spring.conntroller;


import kz.javaSpring.SpringTask2Spring.Models.ApplicationRequest;
import kz.javaSpring.SpringTask2Spring.enums.CoursesEnum;
import kz.javaSpring.SpringTask2Spring.service.ArService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


  @Autowired
  private ArService arService;


  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("zayavki", arService.getAllAps());
    return "home";
  }


  @GetMapping("/add")
  public String addPage(Model model) {
    model.addAttribute("courses", CoursesEnum.values());
    return "add";
  }


  @PostMapping("/addAr")
  public String addAr(ApplicationRequest applicationRequest) {
    arService.creatNewAr(applicationRequest);
    return "redirect:/";
  }


  @GetMapping("/details/{id}")
  public String detailsPage(@PathVariable Long id, Model model) {
    ApplicationRequest applicationRequest = arService.getArById(id);
    if (applicationRequest != null) {
      model.addAttribute("ar", arService.getArById(id));
      return "details";
    }
    return "home";
  }


  @PostMapping("/delete")
  public String deleteAr(@RequestParam Long id) {
    arService.deleteArById(id);
    return "redirect:/";
  }


  @PostMapping("/sethandle")
  public String setHandle(@RequestParam Long id, Model model) {
    arService.setArHandled(id);
    model.addAttribute("ar", arService.getArById(id));
    return "details";
  }


  @GetMapping("/NewAr")
  public String newAr(Model model) {
    model.addAttribute("ar", arService.getAllNewAr());
    return "OnlyNewAr";
  }


  @GetMapping("/OldAr")
  public String oldAr(Model model) {
    model.addAttribute("old", arService.getAllOldAr());
    return "OnlyOldAr";
  }
}

