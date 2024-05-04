package hunre.chinh.it.landlord.service;

import hunre.chinh.it.landlord.dto.UserDto;
import hunre.chinh.it.landlord.entity.Role;
import hunre.chinh.it.landlord.entity.User;
import hunre.chinh.it.landlord.repositories.RoleRepository;
import hunre.chinh.it.landlord.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository,
                         RoleRepository roleRepository,
                         PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void saveUser(UserDto userDto) {
    User user = new User();
    user.setCccd(userDto.getCccd());
    user.setName(userDto.getName());
    user.setGender(userDto.getGender());
    user.setBirthday(userDto.getBirthday());
    user.setPhone(userDto.getPhone());
    user.setEmail(userDto.getEmail());
    // encrypt the password using spring security
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));

    Role role = roleRepository.findByName("ROLE_USER");
    if (role == null) {
      role = checkRoleExist();
    }
    user.setRoles(Arrays.asList(role));
    userRepository.save(user);
  }

  @Override
  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public List<UserDto> findAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream()
        .map(this::mapToUserDto)
        .collect(Collectors.toList());
  }

  private UserDto mapToUserDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setCccd(user.getCccd());
    userDto.setName(user.getName());
    userDto.setGender(user.getGender());
    userDto.setBirthday(user.getBirthday());
    userDto.setPhone(user.getPhone());
    userDto.setEmail(user.getEmail());
    return userDto;
  }

  private Role checkRoleExist() {
    Role role = new Role();
    role.setName("ROLE_USER");
    return roleRepository.save(role);
  }


//  @Override
//  public List<Houses> getHousesByUser(Long id) {
//    return housesRepository.findByUserId(id);
//  }
}
