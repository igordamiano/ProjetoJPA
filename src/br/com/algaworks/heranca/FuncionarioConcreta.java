package br.com.algaworks.heranca;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "funcionario_concreta")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class FuncionarioConcreta extends PessoaConcreta {

	@Column(nullable = true)
	private BigDecimal salario;
	
	@Column(length = 60, nullable = true)
	private String cargo;

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
