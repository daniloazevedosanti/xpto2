package com.license.teste.model;

public class Movimentacao {

	private int id;
	private String tipo;
	private int idCliente;
	private int contaOrigem;
	private double valor;
	
	public Movimentacao() {
		super();
	}

	public Movimentacao(String tipo, int idCliente, int contaOrigem, double valor) {
		super();
		this.tipo = tipo;
		this.idCliente = idCliente;
		this.contaOrigem = contaOrigem;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(int contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
