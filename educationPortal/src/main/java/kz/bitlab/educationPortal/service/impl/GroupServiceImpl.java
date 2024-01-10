package kz.bitlab.educationPortal.service.impl;

import java.util.List;
import kz.bitlab.educationPortal.model.Group;
import kz.bitlab.educationPortal.repository.GroupRepository;
import kz.bitlab.educationPortal.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
@Autowired
private GroupRepository groupRepository;
  @Override
  public List<Group> getAllGroup() {
    return groupRepository.findAll();
  }

  public Group findById(Long id){
    return groupRepository.findById(id).orElse(null);
  }
}
