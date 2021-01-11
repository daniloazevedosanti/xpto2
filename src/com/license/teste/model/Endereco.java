package com.license.teste.model;

public class Endereco {

	private int id;
	private String enderecoCompleto;
	private int codCliente;

	public Endereco() {

	}

	public Endereco(String enderecoCompleto, int idCliente) {
		super();
		this.enderecoCompleto = enderecoCompleto;
		this.codCliente = idCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int idCliente) {
		this.codCliente = idCliente;
	}

}
