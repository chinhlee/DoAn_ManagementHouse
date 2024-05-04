package hunre.chinh.it.landlord.service;


import hunre.chinh.it.landlord.dto.UserDto;
import hunre.chinh.it.landlord.entity.User;

import java.util.List;

public interface UserService {
  void saveUser(UserDto userDto);

  User findUserByEmail(String email);

  List<UserDto> findAllUsers();

//  List<Houses> getHousesByUser(Long id);

}
