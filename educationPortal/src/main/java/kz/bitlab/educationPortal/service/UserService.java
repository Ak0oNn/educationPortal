package kz.bitlab.educationPortal.service;

import java.util.List;
import kz.bitlab.educationPortal.dto.UserView;
import kz.bitlab.educationPortal.model.User;

public interface UserService {
   User getCurrentUser();

   List<User> getUserRoleTeacher();

   User addNewUser(User user, String re_password, Long id);
   User addNewTeacher( User user, String re_password, Long groupId);

   List<UserView> getAllUser();

   List<User> getUserRoleStudent();

   User getUserById(Long id);
}
