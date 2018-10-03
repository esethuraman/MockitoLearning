package org.esethuraman.mockito.practise.MockitoWithSpringBoot.controller;

import org.esethuraman.mockito.practise.MockitoWithSpringBoot.domain.Item;
import org.esethuraman.mockito.practise.MockitoWithSpringBoot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    public Item item(){
        return new Item(1, "item1", 15, 10);
    }

    @GetMapping("/itemFromService")
    public Item itemFromService(){
        return itemService.getItem();
    }
}
