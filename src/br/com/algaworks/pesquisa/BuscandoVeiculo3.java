package br.com.algaworks.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class BuscandoVeiculo3 {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
		System.out.println("Buscou veículo. Será que já executou o SELECT?");
		
		System.out.println("Veículo de código " + veiculo.getId() + " é um " + veiculo.getModelo());
		
		
		manager.close();
		JpaUtil.close();
		

	}

}
