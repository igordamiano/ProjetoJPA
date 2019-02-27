package br.com.algaworks.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.algaworks.dominio.ProprietarioUmParaMuitos;
import br.com.algaworks.dominio.ProprietarioUmParaMuitos_;
import br.com.algaworks.dominio.VeiculoUmParaMuitos;
import br.com.algaworks.dominio.VeiculoUmParaMuitos_;
import br.com.algaworks.util.JpaUtil;

public class Metamodel {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<VeiculoUmParaMuitos> criteriaQuery = builder.createQuery(VeiculoUmParaMuitos.class);
		
		Root<VeiculoUmParaMuitos> veiculo = criteriaQuery.from(VeiculoUmParaMuitos.class);
		Join<VeiculoUmParaMuitos, ProprietarioUmParaMuitos> proprietario = veiculo.join(VeiculoUmParaMuitos_.proprietarioUmParaMuitos);
		
		criteriaQuery.select(veiculo);
		criteriaQuery.where(builder.equal(proprietario.get(ProprietarioUmParaMuitos_.nome), "João"));
		
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
