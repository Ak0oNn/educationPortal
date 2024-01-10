package kz.bitlab.educationPortal.service.impl;

import java.util.List;
import kz.bitlab.educationPortal.model.Group;
import kz.bitlab.educationPortal.model.Item;
import kz.bitlab.educationPortal.model.User;
import kz.bitlab.educationPortal.repository.GroupRepository;
import kz.bitlab.educationPortal.repository.ItemRepository;
import kz.bitlab.educationPortal.service.ItemService;
import kz.bitlab.educationPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
@Autowired
private ItemRepository itemRepository;
@Autowired
private UserService userService;
@Autowired
private GroupRepository groupRepository;
  @Override
  public List<Item> getAllItemFromGroup(Long id) {
    return itemRepository.findByGroup_Id(id);
  }

  public Item getItemById(Long id){
    return itemRepository.findById(id).orElse(null);
  }

  @Override
  public List<Item> getAllItem() {
    return itemRepository.findAll();
  }

  public void addItem(Item item, Long id){
    Item newItem = new Item();
    Group group = groupRepository.findById(id).orElse(null);
    newItem.setItemName(item.getItemName());
    newItem.setGroup(group);
    itemRepository.save(newItem);
  }

  @Override
  public List<Item> getItemFromTeacher() {
    User user = userService.getCurrentUser();
    return itemRepository.findByUsers(user);
  }

  @Override
  public void updateItem(Item item) {
    itemRepository.save(item);
  }

  @Override
  public void addItemFromTeacher(Long userId, Long itemId) {
    User user = userService.getUserById(userId);
    Item item = getItemById(itemId);
    item.setUsers(List.of(user));
    itemRepository.save(item);
  }




}
