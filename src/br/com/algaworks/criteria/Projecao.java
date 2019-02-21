package br.com.algaworks.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class Projecao {

	public static void main(String[] args) {
		
		// listar apenas os modelos dos veículos
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
		
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		criteriaQuery.select(veiculo.<String>get("modelo"));
		
		TypedQuery<String> query = manager.createQuery(criteriaQuery);
		List<String> modelos = query.getResultList();
		
		System.out.println("");
		for (String v : modelos) {
			System.out.println("Modelo: " + v);
			
		}
		System.out.println("");
		
		manager.close();
		JpaUtil.close();
	}

}
