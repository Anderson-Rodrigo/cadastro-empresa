package br.edu.unoescsmo.cadastroempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoescsmo.cadastroempresa.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
