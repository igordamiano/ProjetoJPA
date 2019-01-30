package br.com.algaworks.dominio.lote;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.util.JpaUtil;

public class PersisteUsuario {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Usuario u1 = new Usuario();
		u1.setEmail("ig@gmail.com");
		u1.setAtivo(true);
		
		Usuario u2 = new Usuario();
		u2.setEmail("joao@hotmail.com");
		u2.setAtivo(true);

		Usuario u3 = new Usuario();
		u3.setEmail("patricia@gmail.com");
		u3.setAtivo(true);
		
		manager.persist(u1);
		manager.persist(u2);
		manager.persist(u3);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
