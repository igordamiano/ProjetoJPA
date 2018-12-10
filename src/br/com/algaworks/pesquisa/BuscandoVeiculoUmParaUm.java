package br.com.algaworks.pesquisa;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.VeiculoUmParaUm;
import br.com.algaworks.util.JpaUtil;

public class BuscandoVeiculoUmParaUm {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		List<VeiculoUmParaUm> veiculos = manager.createQuery("from VeiculoUmParaUm", VeiculoUmParaUm.class).getResultList();
		
		for (VeiculoUmParaUm veiculoUmParaUm : veiculos) {
			System.out.println("***********");
			System.out.println("");
			System.out.println(veiculoUmParaUm.getModelo() + " - "
					+ veiculoUmParaUm.getProprietarioUmParaUm().getNome());
			
			System.out.println("");
			System.out.println("***********");
			
			
		}
		
		manager.close();
		JpaUtil.close();

	}

}
