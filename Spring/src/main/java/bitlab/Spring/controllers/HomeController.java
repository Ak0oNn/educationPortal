package bitlab.Spring.controllers;

import bitlab.Spring.Model.Item;
import bitlab.Spring.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("items", DBManager.getItems());
        return "home";
    }

    @PostMapping("/add-item")
    public String addItem(Item item){
        DBManager.addItem(item);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String itemDetails(@PathVariable Long id, Model model){
        Item item = DBManager.getItemById(id);
        model.addAttribute("zat", item);
        return "details";
    }

    @PostMapping("/edit-item/{id}")
    public String editItem(@PathVariable long id,
                           @RequestParam(name = "item_name")String name,
                           @RequestParam(name = "item_description")String description,
                           @RequestParam(name = "item_price")double price) {
        Item item = DBManager.getItemById(id);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        return "redirect:/details/"+id;
    }
    @PostMapping("/delete-item/{id}")
    public String deleteItem(@PathVariable Long id) {
        DBManager.deleteItemById(id);
        return "redirect:/";
    }
}
