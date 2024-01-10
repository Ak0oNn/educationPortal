package kz.bitlab.educationPortal.service.impl;

import java.util.List;
import kz.bitlab.educationPortal.dto.UserView;
import kz.bitlab.educationPortal.mappers.UserMapper;
import kz.bitlab.educationPortal.model.Group;
import kz.bitlab.educationPortal.model.Role;
import kz.bitlab.educationPortal.model.User;
import kz.bitlab.educationPortal.repository.GroupRepository;
import kz.bitlab.educationPortal.repository.RoleRepository;
import kz.bitlab.educationPortal.repository.UserRepository;
import kz.bitlab.educationPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private GroupRepository groupRepository;
  public User getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication instanceof AnonymousAuthenticationToken) {
      return null;
    }
    return (User) authentication.getPrincipal();
  }

  @Override
  public List<User> getUserRoleTeacher() {
    Role roleTeacher = roleRepository.findRoleTeacher();
    return userRepository.findByRoles(roleTeacher);
  }

  @Override
  public User addNewUser(User user, String re_password, Long id) {
    User checkUser = userRepository.findByEmail(user.getEmail());
    if (checkUser != null) {
      return null;
    }
    if (!user.getPassword().equals(re_password)) {
      return null;
    }
    user.setPassword(passwordEncoder.encode(re_password));
    Role userRole = roleRepository.findRoleUser();
    user.setRoles(List.of(userRole));
    Group userGroup = groupRepository.findById(id).orElse(null);
    user.setGroup(userGroup);
    user.setBanned(false);
    return userRepository.save(user);
  }

  @Override
  public User addNewTeacher(User user, String re_password, Long groupId) {
    User checkUser = userRepository.findByEmail(user.getEmail());
    if (checkUser != null) {
      return null;
    }
    if (!user.getPassword().equals(re_password)) {
      return null;
    }
    user.setPassword(passwordEncoder.encode(re_password));
    Role teacherRole = roleRepository.findRoleTeacher();
    user.setRoles(List.of(teacherRole));
    Group teacherGroup = groupRepository.findById(groupId).orElse(null);
    user.setGroup(teacherGroup);
    user.setBanned(false);
    return userRepository.save(user);
  }

  @Override
  public List<UserView> getAllUser() {
    List<User> users = userRepository.findAll();
    return UserMapper.INSTANCE.toViewList(users);
  }

  @Override
  public List<User> getUserRoleStudent() {
    Role roleStudent = roleRepository.findRoleUser();
    return userRepository.findByRoles(roleStudent);
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }
}