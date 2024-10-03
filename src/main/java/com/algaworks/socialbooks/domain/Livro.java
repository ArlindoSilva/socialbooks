package com.algaworks.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
public class Livro {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "O atributo nome é de preenchimento obrigatório.")
	private String nome;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "O atributo data de publicação é de preenchimento obrigatório.")
	private Date publicacao;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@NotNull(message = "O atributo editora é de preenchimento obrigatório.")
	private String editora;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@NotEmpty(message = "O atributo resumo deve ser preenchido.")
	@Size(max = 1000, message = "O resumo não pode conter mais de 1000 caracteres")
	private String resumo;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
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