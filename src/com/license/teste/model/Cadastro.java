package com.license.teste.model;

public class Cadastro {

	private String nome;
	private String documento;
	private String tipo;
	private String telefone;
	private String enderecoCompleto;
	
	public Cadastro() {
		
	}
	
	public Cadastro(String nome, String documento, String tipo, String telefone, String enderecoCompleto) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.tipo = tipo;
		this.telefone = telefone;
		this.enderecoCompleto = enderecoCompleto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

}
