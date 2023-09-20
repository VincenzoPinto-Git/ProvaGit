package it.begear.springTopBoot.entities;


import javax.persistence.*;

@Entity  
@Table(name="registrati") 
public class Registrato {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name = "id") 
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "acquisto")
	private String acquisto;
	
	public Registrato() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAcquisto() {
		return acquisto;
	}

	public void setAcquisto(String acquisto) {
		this.acquisto = acquisto;
	}
	
}