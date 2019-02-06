package br.com.algaworks.pesquisa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class PesquisaJpql {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		/*
			O método createQuery retorna um objeto do tipo Query, que pode ser consultado
			através de getResultList. Este método retorna um List não tipado, por isso
			fizemos um cast na iteração dos objetos.
		 */
		
		Query query = manager.createQuery("select v from Veiculo v where anoFabricacao = 2005");	
			
		List veiculos = query.getResultList();
		
		System.out.println("");
		System.out.println("");
		
		for (Object obj : veiculos) {
			Veiculo veiculo = (Veiculo) obj;
			
			System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante() + " " + veiculo.getAnoFabricacao());
			
		}
		
		manager.close();
		JpaUtil.close();
		

	}

}
