package br.edu.unoescsmo.cadastroempresa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa {	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	@Column(length=70, nullable=false)
	private String Nome;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
}
