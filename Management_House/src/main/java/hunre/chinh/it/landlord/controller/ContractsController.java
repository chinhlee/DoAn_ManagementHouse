package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.entity.Contracts;
import hunre.chinh.it.landlord.entity.Houses;
import hunre.chinh.it.landlord.entity.Rooms;
import hunre.chinh.it.landlord.entity.Tenants;
import hunre.chinh.it.landlord.service.ContractsService;
import hunre.chinh.it.landlord.service.HousesService;
import hunre.chinh.it.landlord.service.RoomsService;
import hunre.chinh.it.landlord.service.TenantsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ContractsController {
  private final ContractsService service;
  private final HousesService housesService;
  private final RoomsService roomsService;
  private final TenantsService tenantsService;

  public ContractsController(ContractsService service, HousesService housesService, RoomsService roomsService, TenantsService tenantsService) {
    this.service = service;
    this.housesService = housesService;
    this.roomsService = roomsService;
    this.tenantsService = tenantsService;
  }

  @GetMapping("/contracts_register/{idHouse}")
  public String contractsRegister(@PathVariable("idHouse") long idHouse, Model model) {
//    List<Rooms> rooms  = roomsService.getAllRooms();
    List<Rooms> rooms = roomsService.getRoomsByIdHouse(idHouse);
    model.addAttribute("rooms", rooms);

    List<Tenants> tenants  = tenantsService.getTenantsByIdHouse(idHouse);
    model.addAttribute("tenants", tenants);

    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("contract", new Contracts());
    return "contractsRegister";
  }

  @GetMapping("/available_contracts/{idHouse}")
  public ModelAndView getAllContractsByHouseId(@PathVariable("idHouse") long idHouse, Model model) {
    List<Contracts> contractList = service.getAllContractsByIdHouse(idHouse);
    //return new ModelAndView("roomsList", "rooms", roomList);
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    ModelAndView modelAndView = new ModelAndView("contractsList");
    modelAndView.addObject("contracts", contractList);
    return modelAndView;
  }

  @PostMapping("/save_contracts/{idHouse}")
  public String addContracts(@ModelAttribute Contracts c, @PathVariable("idHouse") long idHouse) {
    Houses houses = housesService.getHousesById(idHouse);
    c.setHouses(houses);
    service.saveContracts(c);
    return "redirect:/available_contracts/" + idHouse;
  }

  @RequestMapping("/editContracts/{idHouse}/{idContract}")
  public String editContracts(@PathVariable("idHouse") long idHouse, @PathVariable("idContract") long idContract, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    Contracts contracts = service.getContractsById(idContract);

    List<Tenants> tenants  = tenantsService.getAllTenants();
    model.addAttribute("tenants", tenants);

    List<Rooms> rooms = roomsService.getRoomsByIdHouse(idHouse);
    model.addAttribute("rooms", rooms);

    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("contracts", contracts);
    return "contractsEdit";
  }

  @RequestMapping("/deleteContracts/{idHouse}/{idContract}")
  public String deleteContracts(@PathVariable("idHouse") long idHouse, @PathVariable("idContract") long idContract) {
    service.deleteById(idContract);
    return "redirect:/available_contracts/" + idHouse;
  }

  @GetMapping("/available_contracts/{idHouse}/search_contracts")
  public ModelAndView searchContracts(@PathVariable("idHouse") long idHouse, @RequestParam("searchTerm") String searchTerm) {
    List<Contracts> contractList = service.searchContracts(searchTerm, idHouse);
    Houses houses = housesService.getHousesById(idHouse);

    ModelAndView modelAndView = new ModelAndView("contractsList");
    modelAndView.addObject("contracts", contractList);
    modelAndView.addObject("nameHouse", houses.getNameHouse());
    return modelAndView;
  }
}
