package br.com.algaworks.pesquisa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class PesquisaJpqlProblemaNMais1 {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<Veiculo> query = manager.createQuery("from Veiculo v inner join fetch v.proprietario", Veiculo.class);
		
		List<Veiculo> veiculos = query.getResultList();

		
		System.out.println("");
		System.out.println("");
		
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " " + veiculo.getProprietario().getNome());
		}

		System.out.println("");
		System.out.println("");


		manager.close();
		JpaUtil.close();

	}

}
