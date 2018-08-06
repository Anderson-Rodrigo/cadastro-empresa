package br.edu.unoescsmo.cadastroempresa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoescsmo.cadastroempresa.model.Funcionario;
import br.edu.unoescsmo.cadastroempresa.regras.FuncionarioRegra;
import br.edu.unoescsmo.cadastroempresa.repository.EmpresaRepository;
import br.edu.unoescsmo.cadastroempresa.repository.SetorRepository;

@Controller
@RequestMapping("/funcionario") //dessa forma ele define nos metodos para sempre dizer que sempre quando for funcionario vai se referir ao metodos dela
public class FuncionarioController {

	@Autowired
	private FuncionarioRegra funcionarioRegra;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private SetorRepository setorRepository;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult errors) {
		if(errors.hasErrors()) {
				return "funcionario/novo";
		}
		funcionarioRegra.salvar(funcionario);
		return "redirect:/funcionario/listar";
	}
	
	@PostMapping("/alterar")
	public String alterar(@Valid Funcionario funcionario, BindingResult errors) {
		if(errors.hasErrors()) {
				return "funcionario/novo";
		}
		funcionarioRegra.salvar(funcionario);
		return "redirect:/funcionario/listar";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("funcionarios", funcionarioRegra.dadosGrid());//torna a lista de funcionario acessivel no JSP
		return "funcionario/lista";	//caminho+nome do jsp que sera renderizado para a tela
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("empresa", empresaRepository.findAll());//para dar um novo nas cidades
		model.addAttribute("setor", setorRepository.findAll());
		return "funcionario/novo";
	}
	
	@GetMapping("/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Long codigo) {
		funcionarioRegra.delete(new Funcionario(codigo));
		return "redirect:/funcionario/listar"; 
	}
	
	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable("codigo")Long codigo, Model model) {
		model.addAttribute("funcionario", funcionarioRegra.buscarPorCodigo(codigo));
		model.addAttribute("empresa", empresaRepository.findAll());//para visualizar as cidade
		model.addAttribute("setor", setorRepository.findAll());
		return "funcionario/visualizar";
	}
	
	@GetMapping("/funcionario/cpf/{cpf}")
	@ResponseBody
	public List<Funcionario> listarCpf(@PathVariable("cpf")String cpf){
		return funcionarioRegra.listarPorCpf(cpf);		
	}
	
	@GetMapping("/funcionario/nome/{nome}")
	@ResponseBody
	public List<Funcionario> listarNome(@PathVariable("nome")String nome){
		return funcionarioRegra.listarPorNome(nome);		
	}
	
}
