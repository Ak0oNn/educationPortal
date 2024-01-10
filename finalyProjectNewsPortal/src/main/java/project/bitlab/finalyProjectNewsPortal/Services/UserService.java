package project.bitlab.finalyProjectNewsPortal.Services;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.bitlab.finalyProjectNewsPortal.models.Role;
import project.bitlab.finalyProjectNewsPortal.models.User;
import project.bitlab.finalyProjectNewsPortal.repositories.RoleRepository;
import project.bitlab.finalyProjectNewsPortal.repositories.UserRepository;

public class UserService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private RoleRepository roleRepository;
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email);
    if(user == null){
      throw new UsernameNotFoundException("user not found");
    }
    return user;
  }

  public User getCurrentUser(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication instanceof AnonymousAuthenticationToken){
      return null;
    }
    return (User)authentication.getPrincipal();
  }

  public User addUser(User newUser, String rePassword){
    User checkUser =userRepository.findByEmail(newUser.getEmail());
    if(checkUser != null){
      return null;
    }
    if (!newUser.getPassword().equals(rePassword)){
      return null;
    }
    newUser.setPassword(passwordEncoder.encode(rePassword));
    Role userRole = roleRepository.findRoleUser();
    newUser.setRoles(Set.of(userRole));
    return userRepository.save(newUser);
  }

}
