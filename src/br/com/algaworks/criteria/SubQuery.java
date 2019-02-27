package br.com.algaworks.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.com.algaworks.dominio.VeiculoUmParaMuitos;
import br.com.algaworks.util.JpaUtil;

public class SubQuery {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<VeiculoUmParaMuitos> criteriaQuery = builder.createQuery(VeiculoUmParaMuitos.class);
		
		Subquery<Double> subquery = criteriaQuery.subquery(Double.class);
		
		Root<VeiculoUmParaMuitos> veiculoUmParaMuitosA = criteriaQuery.from(VeiculoUmParaMuitos.class);
		Root<VeiculoUmParaMuitos> veiculoUmParaMuitosB = subquery.from(VeiculoUmParaMuitos.class);
		
		subquery.select(builder.avg(veiculoUmParaMuitosB.<Double>get("valor")));
		
		criteriaQuery.select(veiculoUmParaMuitosA);
		criteriaQuery.where(builder.greaterThanOrEqualTo(veiculoUmParaMuitosA.<Double>get("valor"), subquery));
		
		TypedQuery<VeiculoUmParaMuitos> query = manager.createQuery(criteriaQuery);
		List<VeiculoUmParaMuitos> veiculos = query.getResultList();

		System.out.println("");
		for (VeiculoUmParaMuitos v : veiculos) {
			System.out.println(v.getModelo() + " - " + v.getProprietarioUmParaMuitos().getNome());
		}
		System.out.println("");
		
		manager.close();
		JpaUtil.close();
		

	}

}
