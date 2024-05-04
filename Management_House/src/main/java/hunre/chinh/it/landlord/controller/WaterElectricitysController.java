package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.entity.Facilitys;
import hunre.chinh.it.landlord.entity.Houses;
import hunre.chinh.it.landlord.entity.WaterElectricitys;
import hunre.chinh.it.landlord.service.HousesService;
import hunre.chinh.it.landlord.service.WaterElectricitysService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WaterElectricitysController {
  private final WaterElectricitysService service;
  private final HousesService housesService;

  public WaterElectricitysController(WaterElectricitysService service, HousesService housesService) {
    this.service = service;
    this.housesService = housesService;
  }

  @GetMapping("/waterElectricitys_register/{idHouse}")
  public String waterElectricitysRegister(@PathVariable("idHouse") long idHouse, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("waterElectricity", new WaterElectricitys());
    return "waterElectricitysRegister";
  }

  @GetMapping("/available_waterElectricitys/{idHouse}")
  public ModelAndView getAllWaterElectricitysByHouseId(@PathVariable("idHouse") long idHouse, Model model) {
    List<WaterElectricitys> waterElectricityList = service.getAllWaterElectricitysByIdHouse(idHouse);
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    ModelAndView modelAndView = new ModelAndView("waterElectricitysList");
    modelAndView.addObject("waterElectricitys", waterElectricityList);
    return modelAndView;
  }

  @PostMapping("/save_waterElectricitys/{idHouse}")
  public String addWaterElectricitys(@ModelAttribute WaterElectricitys w, @PathVariable("idHouse") long idHouse) {
    Houses houses = housesService.getHousesById(idHouse);
    w.setHouses(houses);
    service.saveWaterElectricitys(w);
    return "redirect:/available_waterElectricitys/" + idHouse;
  }

  @RequestMapping("/editWaterElectricitys/{idHouse}/{idWaterElectricity}")
  public String editWaterElectricitys(@PathVariable("idHouse") long idHouse, @PathVariable("idWaterElectricity") long idWaterElectricity, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    WaterElectricitys waterElectricitys = service.getWaterElectricitysById(idWaterElectricity);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("waterElectricitys", waterElectricitys);
    return "waterElectricitysEdit";
  }

  @RequestMapping("/deleteWaterElectricitys/{idHouse}/{idWaterElectricity}")
  public String deleteWaterElectricitys(@PathVariable("idHouse") long idHouse, @PathVariable("idWaterElectricity") long idWaterElectricity) {
    service.deleteById(idWaterElectricity);
    return "redirect:/available_waterElectricitys/" + idHouse;
  }

  @GetMapping("/available_waterElectricitys/{idHouse}/search_waterElectricitys")
  public ModelAndView searchWaterElectricitys(@PathVariable("idHouse") long idHouse, @RequestParam("idWaterElectricity") long idWaterElectricity) {
    List<WaterElectricitys> waterElectricityList = service.getWaterElectricitysByIdWaterElectricity(idWaterElectricity,idHouse );
    Houses houses = housesService.getHousesById(idHouse);

    ModelAndView modelAndView = new ModelAndView("waterElectricitysList");
    modelAndView.addObject("waterElectricitys", waterElectricityList);
    modelAndView.addObject("nameHouse", houses.getNameHouse());
    modelAndView.addObject("idWaterElectricity", idWaterElectricity);
    return modelAndView;
  }
}
