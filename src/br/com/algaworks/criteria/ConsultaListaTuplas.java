package br.com.algaworks.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class ConsultaListaTuplas {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = builder.createTupleQuery();
		
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);	
		criteriaQuery.multiselect(veiculo.<String>get("modelo").alias("modeloVeiculo"), veiculo.<String>get("valor").alias("valorVeiculo"));
		
		
		TypedQuery<Tuple> query = manager.createQuery(criteriaQuery);
		List<Tuple> resultado = query.getResultList();

		System.out.println("");
		for (Tuple tupla : resultado) {
			System.out.println(tupla.get("modeloVeiculo") + " " + tupla.get("valorVeiculo"));
		}
		System.out.println("");
		
		manager.close();
		JpaUtil.close();
		

	}

}
