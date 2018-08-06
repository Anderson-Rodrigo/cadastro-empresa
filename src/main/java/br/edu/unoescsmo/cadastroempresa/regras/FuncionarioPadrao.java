package br.edu.unoescsmo.cadastroempresa.regras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoescsmo.cadastroempresa.model.Funcionario;
import br.edu.unoescsmo.cadastroempresa.repository.FuncionarioRepository;

@Service
public class FuncionarioPadrao implements FuncionarioRegra{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public void salvar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	public void delete(Funcionario funcionario) {
		funcionarioRepository.delete(funcionario);
	}
	public List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	
	@Override
	public List<Funcionario> listarPorNome(String nome){
		return funcionarioRepository.findByNomeLike("%" + nome + "%");
	}
	
	@Override
	public List<Funcionario> listarPorCpf(String cpf){
		return funcionarioRepository.porCpf(cpf);
	}

	@Override
	public Funcionario buscarPorCodigo(Long codigo) {
		return funcionarioRepository.findById(codigo).orElse(new Funcionario());//define o que quer voltar quando estiver vazio, seria o mesmo que retornar null
	}
	
	@Override
	public List<Funcionario> dadosGrid(){
		return funcionarioRepository.dadosGrid();
	}
}