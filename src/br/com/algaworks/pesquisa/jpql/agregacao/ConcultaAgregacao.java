package br.com.algaworks.pesquisa.jpql.agregacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.util.JpaUtil;

public class ConcultaAgregacao {

	public static void main(String[] args) {

		/*
		 * A sintaxe para fun��es de agrega��o em JPQL � similar a SQL. Voc� pode usar
		 * as fun��es avg, count, min, max e sum, e agrupar os resultados com a cl�usula
		 * group by.
		 * 
		 */

		EntityManager manager = JpaUtil.getEntityManager();

		TypedQuery<TotalCarroPorAno> query = manager.createQuery(
				"select new br.com.algaworks.pesquisa.jpql.agregacao.TotalCarroPorAno(v.anoFabricacao, avg(v.valor), count(v)) from Veiculo v group by v.anoFabricacao",
				TotalCarroPorAno.class);

		List<TotalCarroPorAno> resultado = query.getResultList();

		for (TotalCarroPorAno valores : resultado) {
			System.out.println("Ano: " + valores.getAnoFabricacao() + " - Pre�o m�dio: " + valores.getMediaPreco()
					+ " - Quantidade: " + valores.getQuantidadeCarros());
		}
		
		manager.close();
		JpaUtil.close();

	}

}
