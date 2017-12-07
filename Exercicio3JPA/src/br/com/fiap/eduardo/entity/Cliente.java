package br.com.fiap.eduardo.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 5232613218129160644L;

	@Id
	@SequenceGenerator(name = "SEQ_CLIENTES", sequenceName = "SEQ_CLIENTES")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTES")
	@Column(name = "IDCLIENTE")
	private Integer idCliente;

	@Column(name = "NOME", length = 45)
	private String nome;

	@Column(name = "EMAIL", length = 45)
	private String email;

	public Cliente() {
	}

	public Cliente(Integer idCliente, String nome, String email) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
	}

	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + "]";
	}

}