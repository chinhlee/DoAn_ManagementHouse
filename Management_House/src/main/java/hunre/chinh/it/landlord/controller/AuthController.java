package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.dto.UserDto;
import hunre.chinh.it.landlord.entity.User;
import hunre.chinh.it.landlord.service.HousesService;
import hunre.chinh.it.landlord.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {
  private UserService userService;
  private HousesService housesService;

  public AuthController(UserService userService, HousesService housesService) {
    this.userService = userService;
    this.housesService = housesService;
  }


  @GetMapping("/index")
  public String home() {
    return "index";
  }

  @GetMapping("/login")
  public String login(){
    return "login";
  }

  @GetMapping("/loginSuccess")
  public String loginSuccess(Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      String username = authentication.getName();
      User user = userService.findUserByEmail(username);
      if (user != null) {
        Long id = user.getId();
        return "redirect:/houses/manageHouses/" + id;
      }
//      if (user != null && user.isHasHouse()) {
//        // Nếu người dùng đã có nhà trọ, chuyển hướng đến trang danh sách nhà trọ của họ
//        return "redirect:/available_houses"; // Định tuyến đến trang hiển thị danh sách nhà trọ
//      } else {
//        // Nếu người dùng chưa có nhà trọ, chuyển hướng đến trang yêu cầu tạo nhà trọ
//        return "redirect:/houses_create"; // Định tuyến đến trang tạo nhà trọ
//      }
    }
    return "login";
  }

//  @GetMapping("/home_landlord")
//  public String homelandlord(){
//    return "home_landlord";
//  }

  @GetMapping("/register")
  public String showRegistrationForm(Model model) {
    // create model object to store form data
    UserDto user = new UserDto();
    model.addAttribute("user", user);
    return "register";
  }
  @PostMapping("/register/save")
  public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                             BindingResult result,
                             Model model){
    User existingUser = userService.findUserByEmail(userDto.getEmail());

    if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
      result.rejectValue("email", null,
          "There is already an account registered with the same email");
    }

    if(result.hasErrors()){
      model.addAttribute("user", userDto);
      return "/register";
    }

    userService.saveUser(userDto);
    return "redirect:/register?success";
  }

  @GetMapping("/available_users")
  public String users(Model model){
    List<UserDto> users = userService.findAllUsers();
    model.addAttribute("users", users);
    return "users";
  }

//  @GetMapping("/available_users")
//  public String users(Model model) {
//    List<UserDto> users = userService.findAllUsers();
//    model.addAttribute("users", users);
//    return "users"; // hiển th danh sách người dùng đã đăng ký
//  }
}
