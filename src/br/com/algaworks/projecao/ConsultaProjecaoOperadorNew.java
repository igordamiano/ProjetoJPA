package br.com.algaworks.projecao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.dominio.PrecoVeiculo;
import br.com.algaworks.util.JpaUtil;

public class ConsultaProjecaoOperadorNew {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<PrecoVeiculo> query = manager.createQuery("select new br.com.algaworks.dominio.PrecoVeiculo(modelo, valor) from Veiculo", PrecoVeiculo.class);
		
		List<PrecoVeiculo> precos = query.getResultList();
		
		System.out.println("***************************************************************");
		System.out.println("");
		
		for (PrecoVeiculo preco : precos) {
			System.out.println(preco.getModelo() + " - " + preco.getPreco());
		}
		
		System.out.println("");
		System.out.println("***************************************************************");
		
		
		manager.close();
		JpaUtil.close();

	}

}
