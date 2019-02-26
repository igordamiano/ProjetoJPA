package br.com.algaworks.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class FuncaoOrdenacaoResultado {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);
		
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		
		// desc ordenação decrescente(maior para o menor)
		Order order = builder.desc(veiculo.<String>get("anoFabricacao"));
		// asc ordenação crescente(menor para o maior)
		//Order order = builder.asc(veiculo.<String>get("anoFabricacao"));
		
		
		criteriaQuery.select(veiculo);
		criteriaQuery.orderBy(order);
		
		TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);
		List<Veiculo> veiculos = query.getResultList();

		System.out.println("");
		for (Veiculo v : veiculos) {
			System.out.println(v.getModelo() + " - " + v.getAnoFabricacao());
		}
		System.out.println("");
		
		manager.close();
		JpaUtil.close();
	}

}
