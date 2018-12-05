package br.com.algaworks.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.VeiculoChaveComposta;
import br.com.algaworks.dominio.chavecomposta.VeiculoId;
import br.com.algaworks.util.JpaUtil;

public class BuscandoVeiculoChaveComposta {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		VeiculoId id = new VeiculoId("ABC-1234", "São Paulo");
		
		VeiculoChaveComposta veiculo = manager.find(VeiculoChaveComposta.class, id);
		
		System.out.println("Placa: " + veiculo.getId().getPlaca());
		System.out.println("Cidade: " + veiculo.getId().getCidade());
		System.out.println("Fabricante: " + veiculo.getFabricante());
		System.out.println("Modelo: " + veiculo.getModelo());
		
		
		manager.close();
		JpaUtil.close();

	}

}
