package HTW.WebTechProjectSoSe2021.WebTechProjectSoSe2021.Controller;

import HTW.WebTechProjectSoSe2021.WebTechProjectSoSe2021.Entity.ShoppingListEntity;
import HTW.WebTechProjectSoSe2021.WebTechProjectSoSe2021.Service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ControllerForTemplates {

    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping("/alllists")
    public String listsTable(Model model) {
        List<ShoppingListEntity> slists = shoppingListService.findAll();
        model.addAttribute("slists", slists);
        return "listtable";
    }
    @GetMapping("/createlist")
    public String createShoppingListForm(Model model) {
        model.addAttribute("shoppingList", new ShoppingListEntity());
        return "listcreation";
    }

    //create a shopping list through a userform
    @PostMapping("/createlist")
    public String createShoppingList(@ModelAttribute ShoppingListEntity shoppingList, Model model) {
        shoppingListService.saveList(shoppingList);
        model.addAttribute("shoppingList", shoppingList);
        return "listresult";
    }

}

