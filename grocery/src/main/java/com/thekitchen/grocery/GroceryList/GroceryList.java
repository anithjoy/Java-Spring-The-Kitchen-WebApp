package com.thekitchen.grocery.GroceryList;


import com.thekitchen.grocery.Item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="grocery_list")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private int max_quantity;

    @OneToMany(mappedBy = "groceryList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;
}
