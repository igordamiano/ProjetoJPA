package br.com.algaworks.heranca.consulta.cache;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.cachesegundonivel.CentroCusto;
import br.com.algaworks.util.JpaUtil;

public class ConsultaCacheCentroCusto {

	public static void main(String[] args) {

		EntityManager manager1 = JpaUtil.getEntityManager();
		CentroCusto centroCusto1 = manager1.find(CentroCusto.class, 2L);
		System.out.println("Centro custo: " + centroCusto1.getNome());
		manager1.close();
		
		System.out.println("-----------------------");

		EntityManager manager2 = JpaUtil.getEntityManager();
		CentroCusto centroCusto2 = manager2.find(CentroCusto.class, 2L);
		System.out.println("Centro custo: " + centroCusto2.getNome());
		
		// Apenas uma consulta SQL foi gerada, graças ao cache de segundo nível.
		
		manager2.close();
		JpaUtil.close();

	}

}
