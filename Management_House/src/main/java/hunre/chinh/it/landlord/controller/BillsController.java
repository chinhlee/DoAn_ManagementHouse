package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.entity.*;
import hunre.chinh.it.landlord.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BillsController {
//  private final BillsService service;
//  private final HousesService housesService;
//  private final RoomsService roomsService;
//  private final FacilitysService facilitysService;
//  private final WaterElectricitysService waterElectricitysService;
//
//  public BillsController(BillsService service, HousesService housesService, RoomsService roomsService, FacilitysService facilitysService , WaterElectricitysService waterElectricitysService) {
//    this.service = service;
//    this.housesService = housesService;
//    this.roomsService = roomsService;
//    this.facilitysService = facilitysService;
//    this.waterElectricitysService = waterElectricitysService;
//  }

//  @GetMapping("/bills_register/{idHouse}")
//  public String billsRegister(@PathVariable("idHouse") long idHouse, Model model) {
////    List<Rooms> rooms  = roomsService.getAllRooms();
//    List<Rooms> rooms = roomsService.getRoomsByIdHouse(idHouse);
//    model.addAttribute("rooms", rooms);
//
//    Houses houses = housesService.getHousesById(idHouse);
//    model.addAttribute("nameHouse", houses.getNameHouse());
//    model.addAttribute("houses", houses);
//    model.addAttribute("bill", new Bills());
//    return "billsRegister";
//  }
//
//  @GetMapping("/available_bills/{idHouse}")
//  public ModelAndView getAllBillsByHouseId(@PathVariable("idHouse") long idHouse, Model model) {
//    List<Bills> billList = service.getAllBillsByIdHouse(idHouse);
//    //return new ModelAndView("roomsList", "rooms", roomList);
//    Houses houses = housesService.getHousesById(idHouse);
//    model.addAttribute("nameHouse", houses.getNameHouse());
//    ModelAndView modelAndView = new ModelAndView("billsList");
//    modelAndView.addObject("bills", billList);
//    return modelAndView;
//  }
//
//  @PostMapping("/save_bills/{idHouse}")
//  public String addBills(@ModelAttribute Bills b, @PathVariable("idHouse") long idHouse) {
//    Houses houses = housesService.getHousesById(idHouse);
//    b.setHouses(houses);
//    service.saveBills(b);
//    return "redirect:/available_bills/" + idHouse;
//  }
//
//  @RequestMapping("/editBills/{idHouse}/{idBill}")
//  public String editBills(@PathVariable("idHouse") long idHouse, @PathVariable("idBill") long idBill, Model model) {
//    Houses houses = housesService.getHousesById(idHouse);
//    Bills bills = service.getBillsById(idBill);
//
//    List<Rooms> rooms = roomsService.getRoomsByIdHouse(idHouse);
//    model.addAttribute("rooms", rooms);
//
//    model.addAttribute("nameHouse", houses.getNameHouse());
//    model.addAttribute("houses", houses);
//    model.addAttribute("bills", bills);
//    return "billlsEdit";
//  }
//
//  @RequestMapping("/deleteBills/{idHouse}/{idBill}")
//  public String deleteBills(@PathVariable("idHouse") long idHouse, @PathVariable("idBill") long idBill) {
//    service.deleteById(idBill);
//    return "redirect:/available_bills/" + idHouse;
//  }
}
