package br.com.algaworks.pesquisa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class PesquisaJpqlNamedQueryDoArquivoXML {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();

		TypedQuery<Veiculo> query = manager.createNamedQuery("Veiculo.anoFabricacaoMenor", Veiculo.class);
		query.setParameter("ano", 2006);
		List<Veiculo> veiculos = query.getResultList();

		System.out.println("");
		System.out.println("Pesquisa por ano: ");

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " " + veiculo.getProprietario().getNome() + " "
					+ veiculo.getValor() + " " + veiculo.getAnoFabricacao());
		}

		
		// Consulta em arquivo externo veiculo.xml
		TypedQuery<Veiculo> queryAnoModelo = manager.createNamedQuery("Veiculo.anoModeloMenor", Veiculo.class);
		queryAnoModelo.setParameter("anoModelo", 2007);
		List<Veiculo> veiculosAnoModelo = queryAnoModelo.getResultList();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Ano Modelo Menor: ");
		System.out.println("");
		
		for (Veiculo v : veiculosAnoModelo) {
			System.out.println(v.getModelo() + " " + v.getAnoModelo());
		}
		
		System.out.println("");

		manager.close();
		JpaUtil.close();

	}

}
