package br.com.algaworks.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.ProprietarioTel;
import br.com.algaworks.util.JpaUtil;

public class BuscandoProprietario {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		ProprietarioTel proprietarioTel = manager.find(ProprietarioTel.class, 1L);
		
		System.out.println("Proprietário: " + proprietarioTel.getNome());
		
		for (String telefone : proprietarioTel.getTelefones()) {
			System.out.println("Telefone: " + telefone);
		}
		
		System.out.println("-------");
		
		
		manager.close();
		JpaUtil.close();

	}

}
