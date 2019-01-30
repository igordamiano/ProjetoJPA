package br.com.algaworks.dominio.lote;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.algaworks.util.JpaUtil;

public class DeleteUsuarioLote {

	public static void main(String[] args) {
		
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Query query = manager.createQuery("delete Usuario where ativo = false");
		
		int linhasExcluidas = query.executeUpdate();
		System.out.println(linhasExcluidas + " registros removidos");

		tx.commit();
		manager.close();
		JpaUtil.close();		
		
		

	}

}
