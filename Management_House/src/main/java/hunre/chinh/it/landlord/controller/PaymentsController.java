package hunre.chinh.it.landlord.controller;

import hunre.chinh.it.landlord.entity.Houses;
import hunre.chinh.it.landlord.entity.Payments;
import hunre.chinh.it.landlord.entity.Receipts;
import hunre.chinh.it.landlord.service.HousesService;
import hunre.chinh.it.landlord.service.PaymentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PaymentsController {
  private final PaymentsService service;
  private final HousesService housesService;

  public PaymentsController(PaymentsService service, HousesService housesService) {
    this.service = service;
    this.housesService = housesService;
  }

  @GetMapping("/payments_register/{idHouse}")
  public String paymentsRegister(@PathVariable("idHouse") long idHouse, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("payment", new Payments());
    return "paymentsRegister";
  }

  @GetMapping("/available_payments/{idHouse}")
  public ModelAndView getAllPaymentsByHouseId(@PathVariable("idHouse") long idHouse, Model model) {
    List<Payments> paymentList = service.getAllPaymentsByIdHouse(idHouse);
    Houses houses = housesService.getHousesById(idHouse);
    model.addAttribute("nameHouse", houses.getNameHouse());
    ModelAndView modelAndView = new ModelAndView("paymentsList");
    modelAndView.addObject("payments", paymentList);
    return modelAndView;
  }

  @PostMapping("/save_payments/{idHouse}")
  public String addPayments(@ModelAttribute Payments p, @PathVariable("idHouse") long idHouse) {
    Houses houses = housesService.getHousesById(idHouse);
    p.setHouses(houses);
    service.savePayments(p);
    return "redirect:/available_payments/" + idHouse;
  }

  @RequestMapping("/editPayments/{idHouse}/{idPayment}")
  public String editPayments(@PathVariable("idHouse") long idHouse, @PathVariable("idPayment") long idPayment, Model model) {
    Houses houses = housesService.getHousesById(idHouse);
    Payments payments = service.getPaymentsById(idPayment);
    model.addAttribute("nameHouse", houses.getNameHouse());
    model.addAttribute("houses", houses);
    model.addAttribute("payments", payments);
    return "paymentsEdit";
  }

  @RequestMapping("/deletePayments/{idHouse}/{idPayment}")
  public String deletePayments(@PathVariable("idHouse") long idHouse, @PathVariable("idPayment") long idPayment) {
    service.deleteById(idPayment);
    return "redirect:/available_payments/" + idHouse;
  }

  @GetMapping("/available_payments/{idHouse}/search_payments")
  public ModelAndView searchPayments(@PathVariable("idHouse") long idHouse, @RequestParam("searchTerm") String searchTerm) {
    List<Payments> paymentList = service.searchPayments(searchTerm,idHouse);
    Houses houses = housesService.getHousesById(idHouse);

    ModelAndView modelAndView = new ModelAndView("paymentsList");
    modelAndView.addObject("payments", paymentList);
    modelAndView.addObject("nameHouse", houses.getNameHouse());
    return modelAndView;
  }
}
