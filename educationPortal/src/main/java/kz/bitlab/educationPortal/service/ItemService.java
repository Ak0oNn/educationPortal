package kz.bitlab.educationPortal.service;

import java.util.List;
import kz.bitlab.educationPortal.model.Item;


public interface ItemService {
   List<Item> getAllItemFromGroup(Long id);
   Item getItemById(Long id);

   List<Item> getAllItem();
   void addItem(Item item, Long id);

   List<Item> getItemFromTeacher();

   void updateItem (Item item);

   void  addItemFromTeacher(Long userId, Long itemId);



}
