package application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import application.model.Usuario;
import application.repository.UsuarioRepository;
import application.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/formulario")
	public String mostra(Model model){
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@GetMapping("/login")
	public ModelAndView mostraFormulario(){
		ModelAndView model = new ModelAndView("formulario");
		return model;
	}
	
	@PostMapping("/login")
	public ModelAndView valida(@RequestParam("nomeUsuario") String nomeUsuario, @RequestParam("senhaUsuario") String senhaUsuario, Model model){

		model.addAttribute("nomeUsuario", nomeUsuario);
		model.addAttribute("senhaUsuario", senhaUsuario);
		Usuario usuario = usuarioService.loginUsuario(nomeUsuario, senhaUsuario);
		if(usuario == null){
			return new ModelAndView("login-erro");
		}else{
			return new ModelAndView("redirect:/funcionario/menu");
		}
	}
	
	@GetMapping("/sistema")
	  public String loginSucesso(@ModelAttribute Model model) {
	    return "sistema";
	  }
	
	@GetMapping("/login-erro")
	  public String loginErro() {
	    return "login";
	  }
	
	@PostMapping("/formulario")
	public String registra(@ModelAttribute Usuario usuario){
		usuarioRepository.save(usuario);
		return "sucesso";
	}
	
	
}
