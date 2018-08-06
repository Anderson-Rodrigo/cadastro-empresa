package br.edu.unoescsmo.cadastroempresa.regras;

import java.util.List;

import br.edu.unoescsmo.cadastroempresa.model.Funcionario;

public interface FuncionarioRegra {

	void salvar(Funcionario funcionario);
	
	void delete(Funcionario funcionario);
	
	List<Funcionario> listar();
	
	List<Funcionario> listarPorNome(String nome);
	
	List<Funcionario> listarPorCpf(String cpf);
	
	Funcionario buscarPorCodigo(Long codigo);
	
	List<Funcionario> dadosGrid();
}
