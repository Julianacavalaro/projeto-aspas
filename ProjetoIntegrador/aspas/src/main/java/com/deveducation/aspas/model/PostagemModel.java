package com.deveducation.aspas.model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class PostagemModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPostagem;
	
	@Column
	@NotNull
	private String titulo;
	
	@Column
	@NotNull
	private String descricao;
	
	@Column
	private String imagem;
	
	@Column
	private String video;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dataPostagem;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;

	@ManyToOne
	@JsonIgnoreProperties({"postagem","comentario"})
	private UsuarioModel usuario;
	
	@OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"usuario", "comentario"})
		private List<ComentarioModel> comentario;

	public Long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public List<ComentarioModel> getComentario() {
		return comentario;
	}

	public void setComentario(List<ComentarioModel> comentario) {
		this.comentario = comentario;
	}

	//Getter e Setter
	
	
		
}
