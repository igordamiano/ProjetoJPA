package br.com.algaworks.pesquisa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class PesquisaJpqlTipada {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		/*
			Usamos a interface TypedQuery, que é um subtipo de Query. A diferença é que o
			método getResultList já retorna uma lista do tipo que especificamos na criação
			da query, no segundo parâmetro.
		 */
		
		TypedQuery<Veiculo> query = manager.createQuery("from Veiculo", Veiculo.class);
		
		List<Veiculo> veiculos = query.getResultList();
		
		System.out.println("");
		System.out.println("");
		
		for (Veiculo veiculo : veiculos) {
			
			System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante() + " " + veiculo.getAnoFabricacao());
			
		}
		
		manager.close();
		JpaUtil.close();
		

	}

}
