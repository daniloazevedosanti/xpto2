package com.license.teste.model;

import java.util.List;

public class Cliente {

	private int id;
	private String nome;
	private String documento;
	private String tipo;
	private String telefone;
	private int codEndereco;
	private List<Contas> contas;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String documento, String tipo, String telefone) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.tipo = tipo;
		this.telefone = telefone;
		//this.codEndereco = endereco;
		//this.contas = contas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(int endereco) {
		this.codEndereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Contas> getContas() {
		return contas;
	}

	public void setContas(List<Contas> contas) {
		this.contas = contas;
	}
}