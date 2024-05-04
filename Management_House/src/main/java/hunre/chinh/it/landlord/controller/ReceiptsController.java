package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.entity.Houses;
import hunre.chinh.it.landlord.entity.Receipts;
import hunre.chinh.it.landlord.service.HousesService;
import hunre.chinh.it.landlord.service.ReceiptsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReceiptsController {
  private final ReceiptsService service;
  private final HousesService housesService;

  public ReceiptsController(ReceiptsService service, HousesService housesService) {
    this.service = service;
    this.housesService = housesService;
  }

  @GetMapping("/receipts_register/{idHouse}")
  public String receiptsRegister(@PathVariable("idHouse") long idHouse, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("receipt", new Receipts());
    return "receiptsRegister";
  }

  @GetMapping("/available_receipts/{idHouse}")
  public ModelAndView getAllReceiptsByHouseId(@PathVariable("idHouse") long idHouse, Model model) {
    List<Receipts> receiptList = service.getAllReceiptsByIdHouse(idHouse);
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    ModelAndView modelAndView = new ModelAndView("receiptsList");
    modelAndView.addObject("receipts", receiptList);
    return modelAndView;
  }

  @PostMapping("/save_receipts/{idHouse}")
  public String addReceipts(@ModelAttribute Receipts re, @PathVariable("idHouse") long idHouse) {
    Houses houses = housesService.getHousesById(idHouse);
    re.setHouses(houses);
    service.saveReceipts(re);
    return "redirect:/available_receipts/" + idHouse;
  }

  @RequestMapping("/editReceipts/{idHouse}/{idReceipt}")
  public String editReceipts(@PathVariable("idHouse") long idHouse, @PathVariable("idReceipt") long idReceipt, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    Receipts receipts = service.getReceiptsById(idReceipt);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("receipts", receipts);
    return "receiptsEdit";
  }

  @RequestMapping("/deleteReceipts/{idHouse}/{idReceipt}")
  public String deleteReceipts(@PathVariable("idHouse") long idHouse, @PathVariable("idReceipt") long idReceipt) {
    service.deleteById(idReceipt);
    return "redirect:/available_receipts/" + idHouse;
  }

  @GetMapping("/available_receipts/{idHouse}/search_receipts")
  public ModelAndView searchReceipts(@PathVariable("idHouse") long idHouse, @RequestParam("searchTerm") String searchTerm) {
    List<Receipts> receiptList = service.searchReceipts(searchTerm,idHouse);
    Houses houses = housesService.getHousesById(idHouse);

    ModelAndView modelAndView = new ModelAndView("receiptsList");
    modelAndView.addObject("receipts", receiptList);
    modelAndView.addObject("nameHouse", houses.getNameHouse());
    return modelAndView;
  }
}
