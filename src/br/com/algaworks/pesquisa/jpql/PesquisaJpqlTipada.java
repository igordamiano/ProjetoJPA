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
			Usamos a interface TypedQuery, que � um subtipo de Query. A diferen�a � que o
			m�todo getResultList j� retorna uma lista do tipo que especificamos na cria��o
			da query, no segundo par�metro.
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
