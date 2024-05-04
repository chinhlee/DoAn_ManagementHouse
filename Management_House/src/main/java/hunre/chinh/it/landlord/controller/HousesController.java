package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.entity.Facilitys;
import hunre.chinh.it.landlord.entity.Houses;
import hunre.chinh.it.landlord.service.HousesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HousesController {
  private final HousesService service;

  public HousesController(HousesService service) {
    this.service = service;
  }

  @GetMapping("/manageHouses/{idHouse}")
  public String manageHouses(@PathVariable("idHouse") Long idHouse, Model model) {
//    // Truyền ID của nhà trọ vào model để sử dụng trong trang quản lý
//    model.addAttribute("idHouse", idHouse);
//    // Chuyển hướng đến trang quản lý nhà trọ
//    return "home_landlord";
    Houses houses = service.getHousesById(idHouse);
    // Truyền thông tin về nhà trọ vào model để sử dụng trong trang quản lý
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    // Chuyển hướng đến trang quản lý nhà trọ
    return "home_landlord";
  }

  @GetMapping("/houses_register")
  public String housesRegister() {
    return "housesRegister";
  }

  @GetMapping("/houses_create")
    public String housesCreate() {
    return "housesCreate";
  }

  @GetMapping("/available_houses")
  public ModelAndView getAllHouses() {
    List<Houses> list = service.getAllHouses();
    return new ModelAndView("housesList", "houses", list);
  }

  @PostMapping("/save_houses")
  public String addHouses(@ModelAttribute Houses h) {
    service.saveHouses(h);
    return "redirect:/available_houses";
  }

  @RequestMapping("/editHouses/{idHouse}")
  public String editHouses(@PathVariable("idHouse") long idHouse, Model model) {
    Houses h = service.getHousesById(idHouse);
    model.addAttribute("houses", h);
    return "housesEdit";
  }

  @RequestMapping("/deleteHouses/{idHouse}")
  public String deleteHouses(@PathVariable("idHouse") long idHouse) {
    service.deleteById(idHouse);
    return "redirect:/available_houses";
  }

  @GetMapping("/available_houses/search_houses")
  public ModelAndView searchHouses(@RequestParam("nameHouse") String nameHouse) {
    List<Houses> houseList = service.getHousesByNameHouse(nameHouse);
    ModelAndView modelAndView = new ModelAndView("housesList");
    modelAndView.addObject("houses", houseList);
    modelAndView.addObject("nameHouse", nameHouse);
    return modelAndView;
  }
}
