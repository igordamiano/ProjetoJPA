package br.com.algaworks.pesquisa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.util.JpaUtil;

public class ListandoVeiculos {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		Query query = manager.createQuery("from Veiculo");
		
		List<Veiculo> veiculos = query.getResultList();
		
		for (Veiculo veiculo : veiculos) {
			
			System.out.println(veiculo.getId() + " - " + veiculo.getFabricante() + " " + veiculo.getModelo() + ", ano "
					+ veiculo.getAnoFabricacao() + "/" + veiculo.getAnoModelo() + " por " + "R$" + veiculo.getValor());
			
		}
		
	}

}
