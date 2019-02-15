package br.com.algaworks.pesquisa.jpql;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class PesquisaJpqlNamedQuery {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<Veiculo> query = manager.createNamedQuery("Veiculo.comProprietarioPorValor", Veiculo.class);
		query.setParameter("valor", new BigDecimal(59900));
		List<Veiculo> veiculos = query.getResultList();
		
		TypedQuery<Veiculo> queryPorModelo = manager.createNamedQuery("Veiculo.porModelo", Veiculo.class);
		queryPorModelo.setParameter("modelo", "Fiat");
		List<Veiculo> veiculosPorModelos = queryPorModelo.getResultList();
		
		System.out.println("");
		System.out.println("Pesquisa por valor");
		
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " " + veiculo.getProprietario().getNome() + " " + veiculo.getValor());
		}

		System.out.println("");

		System.out.println("");
		System.out.println("Pesquisa por modelo");
		
		for (Veiculo veiculosPorModelo : veiculosPorModelos) {
			System.out.println(veiculosPorModelo.getModelo() + " " + veiculosPorModelo.getProprietario().getNome());
		}

		System.out.println("");
		System.out.println("");		
		
		

		manager.close();
		JpaUtil.close();

	}

}
