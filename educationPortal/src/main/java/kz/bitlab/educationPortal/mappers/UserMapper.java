package kz.bitlab.educationPortal.mappers;

import java.util.List;
import kz.bitlab.educationPortal.dto.UserView;
import kz.bitlab.educationPortal.model.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))

public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
  UserView toView(User user);

  List<UserView> toViewList(List<User> entities);
}
