package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.entity.Facilitys;
import hunre.chinh.it.landlord.entity.Houses;
import hunre.chinh.it.landlord.entity.Rooms;
import hunre.chinh.it.landlord.entity.Tenants;
import hunre.chinh.it.landlord.service.HousesService;
import hunre.chinh.it.landlord.service.RoomsService;
import hunre.chinh.it.landlord.service.TenantsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TenantsController {
  private final TenantsService service;
  private final HousesService housesService;

  private final RoomsService roomsService;

  public TenantsController(TenantsService service, HousesService housesService, RoomsService roomsService) {
    this.service = service;
    this.housesService = housesService;
    this.roomsService = roomsService;
  }

  @GetMapping("/tenants_register/{idHouse}")
  public String tenantsRegister(@PathVariable("idHouse") long idHouse, Model model) {
//    List<Rooms> rooms  = roomsService.getAllRooms();
    List<Rooms> rooms = roomsService.getRoomsByIdHouse(idHouse);
    model.addAttribute("rooms", rooms);
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("tenant", new Tenants());
    return "tenantsRegister";
  }

  @GetMapping("/available_tenants/{idHouse}")
  public ModelAndView getAllTenantsByHouseId(@PathVariable("idHouse") long idHouse, Model model) {
    List<Tenants> tenantList = service.getAllTenantsByIdHouse(idHouse);
    //return new ModelAndView("roomsList", "rooms", roomList);
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    ModelAndView modelAndView = new ModelAndView("tenantsList");
    modelAndView.addObject("tenants", tenantList);
    return modelAndView;
  }

  @PostMapping("/save_tenants/{idHouse}")
  public String addTenants(@ModelAttribute Tenants t, @PathVariable("idHouse") long idHouse) {
    Houses houses = housesService.getHousesById(idHouse);
    t.setHouses(houses);
    service.saveTenants(t);
    return "redirect:/available_tenants/" + idHouse;
  }

  @RequestMapping("/editTenants/{idHouse}/{idTenant}")
  public String editTenants(@PathVariable("idHouse") long idHouse, @PathVariable("idTenant") long idTenant, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    Tenants tenants = service.getTenantsById(idTenant);
    List<Rooms> rooms = roomsService.getRoomsByIdHouse(idHouse);
    model.addAttribute("rooms", rooms);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("tenants", tenants);
    return "tenantsEdit";
  }

  @RequestMapping("/deleteTenants/{idHouse}/{idTenant}")
  public String deleteTenants(@PathVariable("idHouse") long idHouse, @PathVariable("idTenant") long idTenant) {
    service.deleteById(idTenant);
    return "redirect:/available_tenants/" + idHouse;
  }

  @GetMapping("/available_tenants/{idHouse}/search_tenants")
  public ModelAndView searchTenants(@PathVariable("idHouse") long idHouse, @RequestParam("searchTerm") String searchTerm) {
    List<Tenants> tenantList = service.searchTenants(searchTerm, idHouse);
    Houses houses = housesService.getHousesById(idHouse);

    ModelAndView modelAndView = new ModelAndView("tenantsList");
    modelAndView.addObject("tenants", tenantList);
    modelAndView.addObject("nameHouse", houses.getNameHouse());
    return modelAndView;
  }
}
