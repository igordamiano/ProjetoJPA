package br.com.algaworks.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class BuscandoVeiculo2 {

	public static void main(String[] args) {
		
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		// Utilizando getReference ao inv�s do find
		Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
		
		System.out.println("Ve�culo de c�digo " + veiculo.getId() + " � um " + veiculo.getModelo());
		
		
		manager.close();
		JpaUtil.close();
		

	}

}
