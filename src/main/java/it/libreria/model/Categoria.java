package it.libreria.model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@Column(name="ID_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome_categoria")
	private String nomeCategoria;
	
	@JsonIgnore
	@OneToMany
	(
		cascade = CascadeType.REFRESH,
		fetch = FetchType.EAGER,
		mappedBy = "categoria",
		orphanRemoval = true
	)
	private List<Libro> libri = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	
	public List<Libro> getLibri(){
		return libri;
	}
	
	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
	
	
}
