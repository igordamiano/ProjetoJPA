package br.com.algaworks.pesquisa.jpql.sqlnativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class PesquisaSqlNativo {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();

		Query query = manager.createNativeQuery("select * from tab_veiculo", Veiculo.class);
		List<Veiculo> veiculos = query.getResultList();

		System.out.println("");
		System.out.println("");

		for (Veiculo veiculo : veiculos) {
			
			System.out.println(veiculo.getModelo() + " - " + veiculo.getProprietario().getNome());
		}
		
		System.out.println("");
		System.out.println("");

		manager.close();
		JpaUtil.close();
		
		
		
		
		

	}

}
