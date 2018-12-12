package br.com.algaworks.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.Acessorio;
import br.com.algaworks.dominio.VeiculoMuitosParaMuitos;
import br.com.algaworks.util.JpaUtil;

public class BuscandoVeiculoMuitosParaMuitos {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		VeiculoMuitosParaMuitos veiculoMuitosParaMuitos = manager.find(VeiculoMuitosParaMuitos.class, 2L);
		System.out.println("=========> Veículo: " + veiculoMuitosParaMuitos.getModelo()); 
		
		for (Acessorio acessorios : veiculoMuitosParaMuitos.getAcessorios()) {
			System.out.println("***********");
			System.out.println(acessorios.getDescricao());
		}
		System.out.println("");
		
		manager.close();
		JpaUtil.close();

	}

}
