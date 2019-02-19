package br.com.algaworks.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.enums.TipoCombustivel;
import br.com.algaworks.util.JpaUtil;

public class ConsultaFiltroWhere {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);
		
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		
		// consultamos todos os veículos que o tipo de combustível não seja díesel.
		
		Predicate predicate = builder.not(builder.equal(veiculo.get("tipoCombustivel"), TipoCombustivel.DIESEL));
		//Predicate predicate = builder.equal(veiculo.get("tipoCombustivel"), TipoCombustivel.DIESEL);
		
		criteriaQuery.select(veiculo);
		criteriaQuery.where(predicate);
		
		TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);
		List<Veiculo> veiculos = query.getResultList();
		
		System.out.println("");
		for (Veiculo v : veiculos) {
			System.out.println("Modelo: " + v.getModelo());
		}
		System.out.println("");
		
		manager.close();
		JpaUtil.close();
		
	}

}
