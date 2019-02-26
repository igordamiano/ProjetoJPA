package br.com.algaworks.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class FuncaoConcat {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
		
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);	
		
		Expression<String> expression = builder.concat(builder.concat(veiculo.<String>get("fabricante"), " - "), veiculo.<String>get("modelo"));
		
		criteriaQuery.select(expression);
		
		TypedQuery<String> query = manager.createQuery(criteriaQuery);
		List<String> veiculos = query.getResultList();

		System.out.println("");
		for (String v : veiculos) {
			System.out.println(v);
		}
		System.out.println("");
		
		manager.close();
		JpaUtil.close();
		

	}

}
