package com.revature.OSRS;

public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }


    public String searchByName(String searchQuery){
        for (Item item: itemRepository.getItems()){
            if(item.getItemName().equalsIgnoreCase(searchQuery))
                return item.getItemName();
        }
        return null;
    }
}
