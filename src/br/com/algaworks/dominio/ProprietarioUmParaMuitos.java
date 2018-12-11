package br.com.algaworks.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Um proprietário poderá possuir muitos veículos 
@Entity
@Table(name = "TAB_PROP_UM_PARA_MUITOS")
public class ProprietarioUmParaMuitos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_proprietario")
	private Long codigo;
	
	private String nome;
	private String email;
	private String telefone;
	
	@OneToMany(mappedBy = "proprietarioUmParaMuitos")
	private List<VeiculoUmParaMuitos> veiculoUmParaMuitos;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<VeiculoUmParaMuitos> getVeiculoUmParaMuitos() {
		return veiculoUmParaMuitos;
	}
	public void setVeiculoUmParaMuitos(List<VeiculoUmParaMuitos> veiculoUmParaMuitos) {
		this.veiculoUmParaMuitos = veiculoUmParaMuitos;
	}

}
