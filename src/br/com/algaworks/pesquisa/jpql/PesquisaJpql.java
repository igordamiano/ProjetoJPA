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
			O m�todo createQuery retorna um objeto do tipo Query, que pode ser consultado
			atrav�s de getResultList. Este m�todo retorna um List n�o tipado, por isso
			fizemos um cast na itera��o dos objetos.
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
