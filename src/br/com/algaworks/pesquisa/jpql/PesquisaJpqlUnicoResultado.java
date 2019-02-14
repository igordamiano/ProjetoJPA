package br.com.algaworks.pesquisa.jpql;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.util.JpaUtil;

public class PesquisaJpqlUnicoResultado {

	public static void main(String[] args) {

		/*
		 * As interfaces Query e TypedQuery fornecem o método getSingleResult, que deve
		 * ser usado quando estamos esperando que a consulta retorne apenas um
		 * resultado.
		 */

		EntityManager manager = JpaUtil.getEntityManager();

		TypedQuery<Long> query = manager.createQuery("select count(v) from Veiculo v", Long.class);
		Long quantidadeVeiculos = query.getSingleResult();

		System.out.println("");
		System.out.println("");

		System.out.println("Quantidade de veículos: " + quantidadeVeiculos);

		manager.close();
		JpaUtil.close();

	}

}
