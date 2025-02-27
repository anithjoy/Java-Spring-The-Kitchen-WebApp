package com.thekitchen.grocery.GroceryList;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/grocery")
public class GroceryListController {

    /*
    "api/grocery"-> get all grocery list, Post create grocery list

"api/grocery/id" -> get grocery list by id, Update grocery list by id, Delete Grocery list By id
     */

    private final GroceryListService groceryListService;

    public GroceryListController (GroceryListService groceryListService){
        this.groceryListService = groceryListService;
    }

    @GetMapping
    public List<GroceryList> getAllGroceryList() {
        return groceryListService.getAllGroceryList();
    }

    @PostMapping
    public GroceryList createGroceryList (@RequestBody GroceryList groceryList) {
        return groceryListService.createGroceryList(groceryList);
    }

    @GetMapping("/{id}")
    public GroceryList getGroceryListById(@PathVariable Long id) {
        return groceryListService.getGroceryListById(id);
    }

    @PutMapping("/{id}")
    public GroceryList updateGroceryListById (@PathVariable Long id, @RequestBody GroceryList groceryList){
        return groceryListService.updateGroceryListById( id, groceryList);
    }

    @DeleteMapping("/{id}")
    public void deleteGroceryList (@PathVariable Long id){
        groceryListService.deleteGroceryList(id);
    }
}
