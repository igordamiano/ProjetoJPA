package br.com.algaworks.criteria.dinamico;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.enums.TipoCombustivel;
import br.com.algaworks.util.JpaUtil;

public class PesquisarVeiculoDinamico {
	
	// método pesquisarVeiculos que retorna uma lista de veículos, dado o tipo do combustível e o valor máximo
	
	public static List<Veiculo> pesquisarVeiculos(TipoCombustivel tipoCombustivel, BigDecimal maiorValor){
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);

		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		
		criteriaQuery.select(veiculo);
		
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (tipoCombustivel != null) {
			ParameterExpression<TipoCombustivel> paramTipoCombustivel = builder.parameter(TipoCombustivel.class, "tipoCombustivel");
			predicates.add(builder.equal(veiculo.get("tipoCombustivel"), paramTipoCombustivel));
		}
		
		if (maiorValor != null) {
			ParameterExpression<BigDecimal> paramValor = builder.parameter(BigDecimal.class, "maiorValor");
			predicates.add(builder.lessThanOrEqualTo(veiculo.<BigDecimal>get("valor"), paramValor));
		}
		
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);
		
		if (tipoCombustivel != null) {
			query.setParameter("tipoCombustivel", tipoCombustivel);
		}
		
		if (maiorValor != null) {
			query.setParameter("maiorValor", maiorValor);
		}
		
		List<Veiculo> veiculos = query.getResultList();
		
		manager.close();
		JpaUtil.close();
		
		return veiculos;
	}
	
	
	public static void main(String[] args) {
		
		List<Veiculo> veiculos = pesquisarVeiculos(TipoCombustivel.BICOMBUSTIVEL, new BigDecimal(50000));
		
		System.out.println("");
		System.out.println("");
		
		for (Veiculo v : veiculos) {
			System.out.println(v.getModelo() + " " + v.getValor());
		}
		
	}
	
	

}
