package br.com.algaworks.relacionamento.remove;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.relacionamento.CategoriaEager;
import br.com.algaworks.util.JpaUtil;

public class ExcluirCascata {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		CategoriaEager categoriaEager = manager.find(CategoriaEager.class, 1L);
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		manager.remove(categoriaEager);
		tx.commit();
		
		manager.close();
		JpaUtil.close();
	}

}
