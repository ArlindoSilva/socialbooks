package com.algaworks.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Optional;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "O comentário deve ser preenchido")
	@Size(max = 1000, message = "O comentário não pode conter mais de 1000 caracteres.")
	//@JsonProperty("comentario") // Essa anotação permite mudar o nome do atributo para o cliente, na chamada do Json.
	private String texto;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String usuario;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIVRO_ID")
	@JsonIgnore //MUITO IMPORTANTE COLOCAR ESSA ANOTAÇÃO PARA NÃO ENTRAR EM UM LOOPING INFINITO.
	private Livro livro;

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}