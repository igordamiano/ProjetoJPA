package br.com.algaworks.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.VeiculoChaveComposta;
import br.com.algaworks.dominio.chavecomposta.VeiculoId;
import br.com.algaworks.util.JpaUtil;

public class PersistindoVeiculoChaveComposta {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		VeiculoChaveComposta veiculo = new VeiculoChaveComposta();
		veiculo.setId(new VeiculoId("ABC-1234", "São Paulo"));
		veiculo.setFabricante("Honda");
		veiculo.setModelo("City");
		
		manager.persist(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
