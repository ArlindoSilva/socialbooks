package com.algaworks.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Livro {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date publicacao;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String editora;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String resumo;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;

	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Autor autor;
	
	public Livro() {}
	
	public Livro(String nome) {
		this.nome = nome;
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

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}