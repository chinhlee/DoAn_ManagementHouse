package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.entity.Houses;
import hunre.chinh.it.landlord.entity.Rooms;
import hunre.chinh.it.landlord.entity.Tenants;
import hunre.chinh.it.landlord.service.HousesService;
import hunre.chinh.it.landlord.service.RoomsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoomsController {
  private final RoomsService service;
  private final HousesService housesService;

  public RoomsController(RoomsService service, HousesService housesService) {
    this.service = service;
    this.housesService = housesService;
  }

//  @GetMapping("/rooms_register")
//  public String roomsRegister(Model model) {
//    // Lấy danh sách các danh mục từ cơ sở dữ liệu
//    List<Houses> houses = housesService.getAllHouses();
//    // Đưa danh sách danh mục vào model để sử dụng trong trang booksRegister
//    model.addAttribute("houses", houses);
//    // Truyền danh sách mã danh mục vào form thêm sách
//    model.addAttribute("room", new Rooms());
//    return "roomsRegister";
//  }
//
//  @GetMapping("/available_rooms")
//  public ModelAndView getAllRooms() {
//    List<Rooms> list = service.getAllRooms();
//    return new ModelAndView("roomsList", "rooms", list);
//  }
//
//  @PostMapping("/save_rooms")
//  public String addRooms(@ModelAttribute Rooms r) {
//    service.saveRooms(r);
//    return "redirect:/available_rooms";
//  }
//
//  @RequestMapping("/editRooms/{idRoom}")
//  public String editRooms(@PathVariable("idRoom") long idRoom, Model model) {
//    Rooms r = service.getRoomsById(idRoom);
//    // Lấy danh sách các danh mục từ cơ sở dữ liệu
//    List<Houses> houses = housesService.getAllHouses();
//    // Đưa danh sách danh mục vào model để sử dụng trong trang booksRegister
//    model.addAttribute("houses", houses);
//    model.addAttribute("rooms", r);
//    return "roomsEdit";
//  }
//
//  @RequestMapping("/deleteRooms/{idRoom}")
//  public String deleteRooms(@PathVariable("idRoom") long idRoom) {
//    service.deleteById(idRoom);
//    return "redirect:/available_rooms";
//  }



  @GetMapping("/rooms_register/{idHouse}")
  public String roomsRegister(@PathVariable("idHouse") long idHouse, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("room", new Rooms());
    return "roomsRegister";
  }

  @GetMapping("/available_rooms/{idHouse}")
  public ModelAndView getAllRoomsByHouseId(@PathVariable("idHouse") long idHouse, Model model) {
    List<Rooms> roomList = service.getAllRoomsByIdHouse(idHouse);
    //return new ModelAndView("roomsList", "rooms", roomList);
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    ModelAndView modelAndView = new ModelAndView("roomsList");
    modelAndView.addObject("rooms", roomList);
    return modelAndView;
  }

  @PostMapping("/save_rooms/{idHouse}")
  public String addRooms(@ModelAttribute Rooms r, @PathVariable("idHouse") long idHouse) {
    Houses houses = housesService.getHousesById(idHouse);
    r.setHouses(houses);
    service.saveRooms(r);
    return "redirect:/available_rooms/" + idHouse;
  }

  @RequestMapping("/editRooms/{idHouse}/{idRoom}")
  public String editRooms(@PathVariable("idHouse") long idHouse, @PathVariable("idRoom") long idRoom, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    Rooms rooms = service.getRoomsById(idRoom);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("rooms", rooms);
    return "roomsEdit";
  }

  @RequestMapping("/deleteRooms/{idHouse}/{idRoom}")
  public String deleteRooms(@PathVariable("idHouse") long idHouse, @PathVariable("idRoom") long idRoom) {
    service.deleteById(idRoom);
    return "redirect:/available_rooms/" + idHouse;
  }

  @GetMapping("/available_rooms/{idHouse}/search_rooms")
  public ModelAndView searchRooms(@PathVariable("idHouse") long idHouse, @RequestParam("searchTerm") String searchTerm) {
    List<Rooms> roomList = service.searchRooms(searchTerm, idHouse);
    Houses houses = housesService.getHousesById(idHouse);

    ModelAndView modelAndView = new ModelAndView("roomsList");
    modelAndView.addObject("rooms", roomList);
    modelAndView.addObject("nameHouse", houses.getNameHouse());
    return modelAndView;
  }

}
