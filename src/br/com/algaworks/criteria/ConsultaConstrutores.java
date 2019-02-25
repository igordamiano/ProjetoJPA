package br.com.algaworks.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.algaworks.dominio.PrecoVeiculo;
import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class ConsultaConstrutores {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<PrecoVeiculo> criteriaQuery = builder.createQuery(PrecoVeiculo.class);
		
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);	
		criteriaQuery.select(builder.construct(PrecoVeiculo.class, veiculo.<String>get("modelo"), veiculo.<String>get("valor")));
		
		TypedQuery<PrecoVeiculo> query = manager.createQuery(criteriaQuery);
		List<PrecoVeiculo> resultado = query.getResultList();

		System.out.println("");
		for (PrecoVeiculo tupla : resultado) {
			System.out.println(tupla.getModelo() + " " + tupla.getPreco());
		}
		System.out.println("");
		
		manager.close();
		JpaUtil.close();
		

	}

}
