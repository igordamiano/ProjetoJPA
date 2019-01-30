package br.com.algaworks.dominio.lote;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.algaworks.util.JpaUtil;

public class AtualizaUsuarioLote {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Query query = manager.createQuery("update Usuario set ativo = false where email like :email");
		query.setParameter("email", "%@gmail.com");
		
		int linhasAfetadas = query.executeUpdate();
		System.out.println(linhasAfetadas + " registros atualizados");

		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
