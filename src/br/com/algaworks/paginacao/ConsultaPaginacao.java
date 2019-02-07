package br.com.algaworks.paginacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class ConsultaPaginacao {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<Veiculo> query = manager.createQuery("from Veiculo", Veiculo.class);
		query.setFirstResult(0);
		query.setMaxResults(10);
		
		List<Veiculo> veiculos = query.getResultList();
		
		System.out.println("");
		System.out.println("");
		
		for (Veiculo veiculo : veiculos) {
			
			System.out.println(veiculo.getId() +": "+ veiculo.getModelo() + " " + veiculo.getFabricante() + " " + veiculo.getAnoFabricacao());
			
		}
		
		manager.close();
		JpaUtil.close();
		

	}

}
