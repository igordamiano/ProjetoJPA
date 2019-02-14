package br.com.algaworks.pesquisa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.util.JpaUtil;

public class PesquisaJpqlLeftJoin {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		// Mostra todos proprietários, mesmo os que não possuem veículo
		
		TypedQuery<Object[]> query = manager.createQuery("select p.nome, count(v) from ProprietarioUmParaMuitos p left join p.veiculoUmParaMuitos v group by p.nome", Object[].class);
		
		List<Object[]> resultado = query.getResultList();

		
		System.out.println("");
		System.out.println("");
		
		for (Object[] valores : resultado) {
			System.out.println(valores[0] + " " + valores[1]);
		}

		System.out.println("");
		System.out.println("");


		manager.close();
		JpaUtil.close();

	}

}
