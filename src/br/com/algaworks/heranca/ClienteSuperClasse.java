package br.com.algaworks.heranca;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_super_classe")
public class ClienteSuperClasse extends PessoaSuperClasse {
	
	@Column(name = "limite_credito", nullable = true)
	private BigDecimal limiteCredito;
	
	@Column(name = "renda_mensal", nullable = true)
	private BigDecimal rendaMensal;
	
	@Column(nullable = true)
	private boolean bloqueado;

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
}
