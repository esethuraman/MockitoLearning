package org.esethuraman.mockito.practise.MockitoWithSpringBoot.service;

import org.esethuraman.mockito.practise.MockitoWithSpringBoot.domain.Item;

public class ItemService {
    public Item getItem() {
        return new Item(1, "itemFromService", 15, 10);
    }
}
