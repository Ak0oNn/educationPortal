package kz.bitlab.educationPortal.service.impl;

import java.util.List;
import kz.bitlab.educationPortal.model.Role;
import kz.bitlab.educationPortal.repository.RoleRepository;
import kz.bitlab.educationPortal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  private RoleRepository roleRepository;
  @Override
  public List<Role> getAllRole() {
    return roleRepository.findAll();
  }
}
