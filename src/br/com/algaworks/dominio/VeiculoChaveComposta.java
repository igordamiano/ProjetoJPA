package br.com.algaworks.dominio;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.algaworks.dominio.chavecomposta.VeiculoId;

@Entity
@Table(name = "TAB_CHAVE_COMP")
public class VeiculoChaveComposta {

	@EmbeddedId
	private VeiculoId id;
	
	private String fabricante;
	
	private String modelo;

	public VeiculoId getId() {
		return id;
	}

	public void setId(VeiculoId id) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculoChaveComposta other = (VeiculoChaveComposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
