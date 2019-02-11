package br.com.algaworks.pesquisa.jpql.agregacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.util.JpaUtil;

public class ConcultaAgregacao {

	public static void main(String[] args) {

		/*
		 * A sintaxe para funções de agregação em JPQL é similar a SQL. Você pode usar
		 * as funções avg, count, min, max e sum, e agrupar os resultados com a cláusula
		 * group by.
		 * 
		 */

		EntityManager manager = JpaUtil.getEntityManager();

		TypedQuery<TotalCarroPorAno> query = manager.createQuery(
				"select new br.com.algaworks.pesquisa.jpql.agregacao.TotalCarroPorAno(v.anoFabricacao, avg(v.valor), count(v)) from Veiculo v group by v.anoFabricacao",
				TotalCarroPorAno.class);

		List<TotalCarroPorAno> resultado = query.getResultList();

		for (TotalCarroPorAno valores : resultado) {
			System.out.println("Ano: " + valores.getAnoFabricacao() + " - Preço médio: " + valores.getMediaPreco()
					+ " - Quantidade: " + valores.getQuantidadeCarros());
		}
		
		manager.close();
		JpaUtil.close();

	}

}
