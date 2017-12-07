package br.com.fiap.eduardo.entity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PEDIDOS")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 6160445732959655389L;

	@Id
	@SequenceGenerator(name = "SEQ_PEDIDOS", sequenceName = "SEQ_PEDIDOS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PEDIDOS")
	@Column(name = "IDPEDIDO")
	private Integer idPedido;

	 
	@Column(name="DATAPEDIDO")
	private LocalDateTime dataPedido;
		
	@Column(name = "DESCRICAO", length = 45)
	private String descricao;

	@Column(name = "VALOR")
	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
	private Cliente cliente;

	public Pedido() {
	}

	public Pedido(Cliente cliente, LocalDateTime data, String descricao, Double valor) {
		this.cliente = cliente;
		this.dataPedido = dataPedido;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Pedido(Integer idPedido, Cliente cliente, LocalDateTime data, String descricao, Double valor) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.dataPedido = dataPedido;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDateTime getData() {
		return null;
	}

	public void setData(LocalDateTime data) {
		this.dataPedido = dataPedido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", datapedido=" + dataPedido + ", descricao=" + descricao + ", valor=" + valor
				+ "]";
	}

}