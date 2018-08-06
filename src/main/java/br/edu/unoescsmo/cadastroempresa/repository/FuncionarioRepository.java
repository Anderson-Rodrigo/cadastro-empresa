package br.edu.unoescsmo.cadastroempresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoescsmo.cadastroempresa.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	List <Funcionario> findByNomeLike(String nome);
	
	@Query("Select p from Funcionario p where p.cpf = :cpf")
	List <Funcionario> porCpf(@Param("cpf") String cpf);
	
	@Query("select p from Funcionario p left join fetch p.naturalidade")
	List<Funcionario> dadosGrid();
	
}