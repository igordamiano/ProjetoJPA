package br.com.algaworks.projecao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.util.JpaUtil;

public class ConsultaProjecao {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<String> query = manager.createQuery("select modelo from Veiculo", String.class);
		
		List<String> modelos = query.getResultList();
		
		System.out.println("");
		System.out.println("");
		
		for (String modelo : modelos) {
			System.out.println("Modelo: " + modelo);
		}
		
		manager.close();
		JpaUtil.close();
		

	}

}
