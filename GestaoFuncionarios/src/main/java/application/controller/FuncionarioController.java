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

import application.model.Funcionario;
import application.repository.FuncionarioRepository;

@Controller
@RequestMapping("funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository portfolioRep;
	
	@GetMapping("menu")
	public String mostraMenu(Model model){
		model.addAttribute("funcionario", new Funcionario());
		
		return "sistema";
	}
	
	@GetMapping("menu/removeFuncionario")
	public String mostraRemocao(){
		
		return "remove";
	}
	
	
	@PostMapping("menu/removeFuncionario")
	public String removeProjeto(Model model, @RequestParam(value="remover") String nomeFuncionario){
		portfolioRep.removeByNomeFuncionario(nomeFuncionario);
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		listaFuncionario = (List<Funcionario>) portfolioRep.findAll();
		model.addAttribute("listaFuncionarios", listaFuncionario);
		return "editarfuncionarios";
	}
	
	@PostMapping("menu")
	public String mostraProjetos(Model model, @ModelAttribute Funcionario funcionario){
		portfolioRep.save(funcionario);
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		listaFuncionario = (List<Funcionario>) portfolioRep.findAll();
		model.addAttribute("listaFuncionarios", listaFuncionario);
		return "editarfuncionarios";
	}
	

	
}
