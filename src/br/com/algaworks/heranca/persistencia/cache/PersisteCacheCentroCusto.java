package br.com.algaworks.heranca.persistencia.cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.cachesegundonivel.CentroCusto;
import br.com.algaworks.util.JpaUtil;

public class PersisteCacheCentroCusto {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		CentroCusto centroCusto = new CentroCusto();
		centroCusto.setNome("Tecnologia");
		
		CentroCusto centroCusto1 = new CentroCusto();
		centroCusto1.setNome("Comercial");
		
		manager.persist(centroCusto);
		manager.persist(centroCusto1);

		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
