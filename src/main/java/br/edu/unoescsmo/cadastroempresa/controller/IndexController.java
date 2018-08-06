package br.edu.unoescsmo.cadastroempresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@GetMapping("/teste/{nome}")
	public String teste(@PathVariable("nome")String nome, Model model) {
		model.addAttribute("valor", nome.toUpperCase());
		return "index";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("valor","teste controller");
		return "index";
	}
	
	@GetMapping("/parametros")
	public String parametros(
			@RequestParam("nome")String nome, 
			@RequestParam("sobrenome")String sobrenome, 
			Model model) {
		model.addAttribute("valor", nome+ " " +sobrenome);
		model.addAttribute("nome", nome);
		model.addAttribute("sobrenome", sobrenome);
		return "index";
	}
	
	@PostMapping("/enviar")
	public String enviar(
			@RequestParam("nome")String nome, 
			@RequestParam("sobrenome")String sobrenome, 
			Model model) {
		model.addAttribute("valor", nome+ " " +sobrenome);
		return "index";
	}
}