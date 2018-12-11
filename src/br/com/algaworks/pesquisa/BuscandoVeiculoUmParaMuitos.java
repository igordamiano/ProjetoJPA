package br.com.algaworks.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.ProprietarioUmParaMuitos;
import br.com.algaworks.dominio.VeiculoUmParaMuitos;
import br.com.algaworks.util.JpaUtil;

public class BuscandoVeiculoUmParaMuitos {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		ProprietarioUmParaMuitos proprietarioUmParaMuitos = manager.find(ProprietarioUmParaMuitos.class, 1L);
		
		for (VeiculoUmParaMuitos veiculoUmParaUm : proprietarioUmParaMuitos.getVeiculoUmParaMuitos()) {
			System.out.println("***********");
			System.out.println("");
			System.out.println(veiculoUmParaUm.getModelo());
			
			System.out.println("");
			System.out.println("***********");
			
			
		}
		
		manager.close();
		JpaUtil.close();

	}

}
