package br.com.algaworks.criteria;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class Agregacao {

	public static void main(String[] args) {
		
		// soma dos valores de todos os veículos
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> criteriaQuery = builder.createQuery(BigDecimal.class);
		
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		criteriaQuery.select(builder.sum(veiculo.<BigDecimal>get("valor")));
		
		TypedQuery<BigDecimal> query = manager.createQuery(criteriaQuery);
		BigDecimal total = query.getSingleResult();
		
		
		
		System.out.println("");
		System.out.println("Valor total: " + total);
		System.out.println("");
		
		manager.close();
		JpaUtil.close();
	}

}
