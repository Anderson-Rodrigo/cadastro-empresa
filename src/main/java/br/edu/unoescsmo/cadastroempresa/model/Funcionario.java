package br.edu.unoescsmo.cadastroempresa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@Column(length=150, nullable=false)
	@NotEmpty(message="nome deve ser preenchido")
	private String nome;
	@Size(max=11, message="tamanho não pode ultrapassar de 11")
	@Column(length=11)
	private String cpf;
	
	//@JoinColumn(name="") qual o nome da coluna da tabela que vou me relacionar no banco de dados
	//@ManyToOne(fetch=FetchType=LAZY) - o LAZY executa quando eu mandar buscar a informacao, sem ele carregou pessoa carrega junto
	
	@ManyToOne(fetch=FetchType.LAZY)  //muitas pessoas para uma cidade / se fose OneToMany, na Empresa deveria retornar uma lista
	private Empresa naturalidade;
	
	public Funcionario() {
		
	}
	
	public Funcionario(Long codigo) {
		this.codigo = codigo;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + "]";
	}

	public Empresa getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(Empresa naturalidade) {
		this.naturalidade = naturalidade;
	}
}