package br.com.algaworks.persistencia;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class PersistindoVeiculo {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Honda");
		veiculo.setModelo("City");
		veiculo.setAnoFabricacao(2018);
		veiculo.setAnoModelo(2019);
		veiculo.setValor(new BigDecimal(99300));
		
		manager.persist(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
