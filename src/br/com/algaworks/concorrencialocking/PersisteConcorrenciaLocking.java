package br.com.algaworks.concorrencialocking;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;

import br.com.algaworks.dominio.lote.Usuario;
import br.com.algaworks.util.JpaUtil;

public class PersisteConcorrenciaLocking {

	public static void main(String[] args) {

		// obtém primeiro EntityManager e inicia transação
		EntityManager manager1 = JpaUtil.getEntityManager();
		EntityTransaction tx1 = manager1.getTransaction();
		tx1.begin();
		
		// obtém segundo EntityManager e inicia transação
		EntityManager manager2 = JpaUtil.getEntityManager();
		EntityTransaction tx2 = manager2.getTransaction();
		tx2.begin();

		// altera objeto associado à primeira transação
		Usuario u1 = manager1.find(Usuario.class, 2L, LockModeType.PESSIMISTIC_WRITE);
		u1.setEmail("joaquina123@gmail.com");
		
		// altera objeto associado à segunda transação
		Usuario u2 = manager2.find(Usuario.class, 2L);
		u2.setEmail("fernanda123@gmail.com");

		// faz commit na primeira transação
		tx1.commit();
		manager1.close();
		
		// faz commit na segunda transação
		tx2.commit();
		manager2.close();
		
		
		JpaUtil.close();
		
	}

}
