package br.com.algaworks.paginacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class ConsultaPaginacaoNavegar {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Registros por página: ");
		int registrosPorPagina = scanner.nextInt();
		int numeroDaPagina = 0;

		TypedQuery<Veiculo> query = manager.createQuery("from Veiculo", Veiculo.class);

		do {
			System.out.print("Número da página: ");
			numeroDaPagina = scanner.nextInt();

			if (numeroDaPagina != 0) {
				int primeiroRegistro = (numeroDaPagina - 1) * registrosPorPagina;
				System.out.println("*** -->>> Primeiro registro: " + primeiroRegistro);

				query.setFirstResult(primeiroRegistro);
				query.setMaxResults(registrosPorPagina);

				List<Veiculo> veiculos = query.getResultList();
				
				for (Veiculo veiculo : veiculos) {
					System.out.println(veiculo.getId() + ": " + veiculo.getModelo() + " " + veiculo.getFabricante()
							+ " " + veiculo.getAnoFabricacao());
				}

			}

		} while (numeroDaPagina != 0);

		System.out.println("");
		System.out.println("");

		scanner.close();
		manager.close();
		JpaUtil.close();

	}

}
