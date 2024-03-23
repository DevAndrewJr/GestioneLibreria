package it.libreria.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;


@Entity
@Table(name = "libro")
@Transactional
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIBRO")
    private int id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "costo")
    private Double costo;

    @Column(name = "codice_ISBN")
    private String codiceIsbn;

    
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_autore", referencedColumnName = "ID_AUTORE")
    private Autore autore;

    
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_categoria", referencedColumnName = "ID_CATEGORIA")
    private Categoria categoria;

    
    public int getId() {
        return id;
    }
    
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    
    public String getCodiceIsbn() {
        return codiceIsbn;
    }

    public void setCodiceIsbn(String codiceIsbn) {
        this.codiceIsbn = codiceIsbn;
    }
    
    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
