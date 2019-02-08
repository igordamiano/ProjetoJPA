package br.com.algaworks.dominio;

import java.math.BigDecimal;

public class PrecoVeiculo {
	
	private String modelo;
	private BigDecimal preco;
	
	public PrecoVeiculo(String modelo, BigDecimal preco) {
		super();
		this.modelo = modelo;
		this.preco = preco;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
