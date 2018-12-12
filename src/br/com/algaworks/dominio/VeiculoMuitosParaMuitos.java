package br.com.algaworks.dominio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.algaworks.enums.TipoCombustivel;

// Um veículo poderá possuir vários acessórios
@Entity
@Table(name = "TAB_VEICULO_MUITOS_PARA_MUITOS")
public class VeiculoMuitosParaMuitos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 60, nullable = false)
	private String fabricante;
	
	@Column(length = 60, nullable = false)
	private String modelo;
	
	@Column(name = "ANO_FABRICACAO", nullable = false)
	private Integer anoFabricacao;
	
	@Column(name = "ANO_MODELO", nullable = false)
	private Integer anoModelo;
	
	@Column(precision = 10, scale = 2, nullable = true)
	private BigDecimal valor;
	
	@Column(name = "tipo_combustivel", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCombustivel tipoCombustivel;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	@Lob
	private String especificacoes;
	
	// Um veículo poderá possuir apenas um proprietário
	@ManyToOne
	@JoinColumn(name = "cod_proprietario")
	ProprietarioMuitosParaUm proprietarioMuitosParaUm;
	
	// Um veículo poderá possuir muitos acessórios, mas não pode ter acessório repetido.
	@ManyToMany
	@JoinTable(name = "veiculoMuitosParaMuitos_acessorio", 
			   joinColumns = @JoinColumn(name = "id_veiculoMuitosParaMuitos"),
			   inverseJoinColumns = @JoinColumn (name = "cod_acessorio"))
	private Set<Acessorio> acessorios = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	public ProprietarioMuitosParaUm getProprietarioMuitosParaUm() {
		return proprietarioMuitosParaUm;
	}

	public void setProprietarioMuitosParaUm(ProprietarioMuitosParaUm proprietarioMuitosParaUm) {
		this.proprietarioMuitosParaUm = proprietarioMuitosParaUm;
	}

	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Set<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
}
