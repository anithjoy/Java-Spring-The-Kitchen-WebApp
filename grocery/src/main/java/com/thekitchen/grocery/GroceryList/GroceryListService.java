package com.thekitchen.grocery.GroceryList;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryListService {

    private final GroceryListRepository groceryListRepository;

    public GroceryListService(GroceryListRepository groceryListRepository){
        this.groceryListRepository = groceryListRepository;
    }

//    CRUD OPERATIONS

    /* Create Grocery List  */
    public GroceryList createGroceryList (GroceryList groceryList) {
        return groceryListRepository.save(groceryList);
    }

//    Read
    /* GetGroceryListByID and getAllGroceryList */
    public GroceryList getGroceryListById (Long Id){
        return groceryListRepository.findById(Id).orElse(null);
    }

    public List<GroceryList> getAllGroceryList () {
        return groceryListRepository.findAll();
    }

//    Update
    /*  Grocery List --> Name, description, Max Quantity(Optional), Delete Item from GroceryList */
    public GroceryList updateGroceryListById (Long Id, GroceryList groceryList){
        GroceryList existingGroceryList = getGroceryListById(Id);
        existingGroceryList.setName(groceryList.getName());
        existingGroceryList.setDescription(groceryList.getDescription());
        existingGroceryList.setMax_quantity(groceryList.getMax_quantity());
        existingGroceryList.setItems(groceryList.getItems());
        return groceryListRepository.save(existingGroceryList);
    }

//    Delete
    /* Delete Grocery List*/
    public void deleteGroceryList (Long Id) {
        groceryListRepository.deleteById(Id);
    }

}
