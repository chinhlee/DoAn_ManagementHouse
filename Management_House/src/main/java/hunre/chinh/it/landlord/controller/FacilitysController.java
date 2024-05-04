package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.entity.Facilitys;
import hunre.chinh.it.landlord.entity.Houses;
import hunre.chinh.it.landlord.entity.Rooms;
import hunre.chinh.it.landlord.service.FacilitysService;
import hunre.chinh.it.landlord.service.HousesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FacilitysController {
  private final FacilitysService service;
  private final HousesService housesService;

  public FacilitysController(FacilitysService service, HousesService housesService) {
    this.service = service;
    this.housesService = housesService;
  }

  @GetMapping("/facilitys_register/{idHouse}")
  public String facilitysRegister(@PathVariable("idHouse") long idHouse, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("facility", new Facilitys());
    return "facilitysRegister";
  }

  @GetMapping("/available_facilitys/{idHouse}")
  public ModelAndView getAllFacilitysByHouseId(@PathVariable("idHouse") long idHouse, Model model) {
    List<Facilitys> facilityList = service.getAllFacilitysByIdHouse(idHouse);
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    ModelAndView modelAndView = new ModelAndView("facilitysList");
    modelAndView.addObject("facilitys", facilityList);
    return modelAndView;
  }

  @PostMapping("/save_facilitys/{idHouse}")
  public String addFacilitys(@ModelAttribute Facilitys f, @PathVariable("idHouse") long idHouse) {
    Houses houses = housesService.getHousesById(idHouse);
    f.setHouses(houses);
    service.saveFacilitys(f);
    return "redirect:/available_facilitys/" + idHouse;
  }

  @RequestMapping("/editFacilitys/{idHouse}/{idFacility}")
  public String editFacilitys(@PathVariable("idHouse") long idHouse, @PathVariable("idFacility") long idFacility, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    Facilitys facilitys = service.getFacilitysById(idFacility);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("facilitys", facilitys);
    return "facilitysEdit";
  }

  @RequestMapping("/deleteFacilitys/{idHouse}/{idFacility}")
  public String deleteFacilitys(@PathVariable("idHouse") long idHouse, @PathVariable("idFacility") long idFacility) {
    service.deleteById(idFacility);
    return "redirect:/available_facilitys/" + idHouse;
  }

  @GetMapping("/available_facilitys/{idHouse}/search_facilitys")
  public ModelAndView searchFacilitys(@PathVariable("idHouse") long idHouse, @RequestParam("nameFacility") String nameFacility) {
    List<Facilitys> facilityList = service.getFacilitysByNameFacility(nameFacility,idHouse);
    Houses houses = housesService.getHousesById(idHouse);

    ModelAndView modelAndView = new ModelAndView("facilitysList");
    modelAndView.addObject("facilitys", facilityList);
    modelAndView.addObject("nameHouse", houses.getNameHouse());
    modelAndView.addObject("nameFacility", nameFacility);
    return modelAndView;
  }
}

