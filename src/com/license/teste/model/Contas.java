package com.license.teste.model;

public class Contas {

	private int id;
	private int numero;
	private int cliente;
	private double saldo;
	
	public Contas() {
		
	}
	
	public Contas(int numeroConta, double saldo, int cliente) {
		super();
		this.numero = numeroConta;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numeroConta) {
		this.numero = numeroConta;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
		
}

