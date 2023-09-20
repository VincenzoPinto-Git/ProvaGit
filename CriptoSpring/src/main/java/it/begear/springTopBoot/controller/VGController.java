package it.begear.springTopBoot.controller;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import it.begear.springTopBoot.entities.Registrato;
import it.begear.springTopBoot.service.VGService;
import it.begear.springTopBoot.service.VGServiceConvertitore;

@Controller
public class VGController {
	
	@Autowired
    VGService vgService;
    VGServiceConvertitore vgConvertitore;

	@RequestMapping("/convertBitcoin")
	public String conversioneBitcoin(@RequestParam double quantitàEuro,Model model) {
    double quantitàBitcoin = vgConvertitore.conversioneEuroBitcoin(quantitàEuro);
	model.addAttribute("quantitàEuro", quantitàEuro);
    model.addAttribute("quantitàBitcoin",quantitàBitcoin);
	return "Risultato";
	}
	
	@RequestMapping("/convertEur")
	public String conversioneEur(@RequestParam double quantitàBitcoin,Model model) {
	double quantitàEuro = vgConvertitore.conversioneBitcoinEuro(quantitàBitcoin);
    model.addAttribute("quantitàBitcoin", quantitàBitcoin);
    model.addAttribute("quantitàEuro", quantitàEuro);
	return "Risutlato";
    }
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Registrato> listaVG = vgService.listAll();
	    model.addAttribute("listaVG", listaVG);
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Registrato vg = new Registrato();
	    model.addAttribute("vg", vg);
	    return "add-vg";
	}
    
    @RequestMapping("/addVG")
    public String saveProduct(@ModelAttribute("vg") Registrato vg) {
        vgService.save(vg);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")									
    public ModelAndView showEditVG(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit-vg");
        Registrato vg = vgService.get(id);
        mav.addObject("vg", vg);
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        vgService.delete(id);
        return "redirect:/";       
    }
    
    @RequestMapping("/search")
    public String findByAcquisto(@RequestParam("acquisto") String acquisto, Model model) {
    	List<Registrato> listaVG = vgService.findByAcquisto(acquisto);
        model.addAttribute("listaVG", listaVG);
        return "index";
    }

}