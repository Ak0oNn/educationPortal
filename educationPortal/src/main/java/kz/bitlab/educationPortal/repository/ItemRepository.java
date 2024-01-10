package kz.bitlab.educationPortal.repository;

import java.util.List;
import kz.bitlab.educationPortal.model.Group;
import kz.bitlab.educationPortal.model.Item;
import kz.bitlab.educationPortal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
  List<Item> findByUsers(User user);
  List<Item> findByGroup_Id(Long id);

  List<Item> findAllByGroup(Group group);
  }
