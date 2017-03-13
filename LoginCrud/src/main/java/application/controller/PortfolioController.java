package application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import application.model.Portfolio;
import application.repository.PortfolioRepository;

@Controller
@RequestMapping("portfolio")
public class PortfolioController {

	@Autowired
	PortfolioRepository portfolioRep;
	
	@GetMapping("menu")
	public String mostraMenu(Model model){
		model.addAttribute("portfolio", new Portfolio());
		
		return "sistema";
	}
	
	@GetMapping("menu/removeProjeto")
	public String mostraRemocao(){
		
		return "remove";
	}
	
	
	@PostMapping("menu/removeProjeto")
	public String removeProjeto(Model model, @RequestParam(value="remover") String nomeProjeto){
		portfolioRep.removeByNomeProjeto(nomeProjeto);
		List<Portfolio> listaProjetos = new ArrayList<Portfolio>();
		listaProjetos = (List<Portfolio>) portfolioRep.findAll();
		model.addAttribute("listaProjetos", listaProjetos);
		return "editarprojetos";
	}
	
	@PostMapping("menu")
	public String mostraProjetos(Model model, @ModelAttribute Portfolio portfolio){
		portfolioRep.save(portfolio);
		List<Portfolio> listaProjetos = new ArrayList<Portfolio>();
		listaProjetos = (List<Portfolio>) portfolioRep.findAll();
		model.addAttribute("listaProjetos", listaProjetos);
		return "editarprojetos";
	}
	

	
}
