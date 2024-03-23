package it.libreria.model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="autore")
public class Autore {
	
	@Id
	@Column(name="ID_AUTORE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome_autore")
	private String nome;
	
	@Column(name="cognome_autore")
	private String cognome;
	
	@JsonIgnore
	@OneToMany
	(
		cascade = CascadeType.REFRESH,
		fetch = FetchType.EAGER,
		mappedBy = "autore",
		orphanRemoval = true
	)
	private List<Libro> libri = new ArrayList<>();
	
	
	
	public int getId() {
		return id;
	}
		
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
		
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public List<Libro> getLibri(){
		return libri;
	}
	
	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

}
