package com.license.teste.model;

public class Relatorio {

	private int credito;
	private int debito;
	private double valor;
	private double saldoatual;
	private int quantidadeContas;
	
	public Relatorio() {
		
	}
	
	public int getCredito() {
		return credito;
	}
	public void setCredito(int credito) {
		this.credito += credito;
	}
	public int getDebito() {
		return debito;
	}
	public void setDebito(int debito) {
		this.debito += debito;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor += valor;
	}

	public double getSaldoatual() {
		return saldoatual;
	}

	public void setSaldoatual(double saldoatual) {
		this.saldoatual += saldoatual;
		setQuantidadeContas(1);
	}

	public int getQuantidadeContas() {
		return quantidadeContas;
	}

	public void setQuantidadeContas(int quantidadeContas) {
		this.quantidadeContas += quantidadeContas;
	}
	
	
}
