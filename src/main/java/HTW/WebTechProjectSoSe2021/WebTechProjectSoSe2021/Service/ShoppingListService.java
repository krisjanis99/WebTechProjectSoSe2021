package HTW.WebTechProjectSoSe2021.WebTechProjectSoSe2021.Service;

import HTW.WebTechProjectSoSe2021.WebTechProjectSoSe2021.Entity.ShoppingListEntity;
import HTW.WebTechProjectSoSe2021.WebTechProjectSoSe2021.Repo.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {

    @Autowired
    private final ShoppingListRepository shopRepository;
    private final ItemService itemService;
    private RestTemplate restTemplate;

    public ShoppingListService(ShoppingListRepository repository, ItemService itemService) {
        this.shopRepository = repository;
        this.itemService = itemService;
    }

    //saves list to DB
    public ShoppingListEntity saveList(ShoppingListEntity shoppinglist) {

        return shopRepository.save(shoppinglist);

    }

    //find one shopping list by its id
    public Optional<ShoppingListEntity> findById(Long shoppingListId) {
        return shopRepository.findById(shoppingListId);
    }

    //find all shopping lists
    public List<ShoppingListEntity> findAll(String user) {

        var it = shopRepository.findAll();

        var sList = new ArrayList<ShoppingListEntity>();
        for (ShoppingListEntity s : it){
            if(s.getAuthor()!=null && s.getAuthor().equals(user)) sList.add(s);
        }
        return sList;
    }

    //determine the total number of shopping lists available
    public Long count() {
        return shopRepository.count();
    }

    //remove or delete shopping list by its id
    public void deleteById(Long shopId) {
        shopRepository.deleteById(shopId);
    }
}