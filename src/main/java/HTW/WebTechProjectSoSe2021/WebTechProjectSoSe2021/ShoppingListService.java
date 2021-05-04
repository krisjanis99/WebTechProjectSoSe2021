package HTW.WebTechProjectSoSe2021.WebTechProjectSoSe2021;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListService {

    private static final List<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();

    public ShoppingListService() {
    }

    public static List<ShoppingList> allShoppingLists() {
        return shoppingLists;
    }

    public static void createList(String listName, String author) {

        ShoppingList shoppinglist = new ShoppingList(listName, author);
        shoppingLists.add(shoppinglist);

    }

}
