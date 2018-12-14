package br.com.algaworks.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.ProprietarioTel;
import br.com.algaworks.util.JpaUtil;

public class PersistindoProprietario {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		ProprietarioTel proprietarioTel = new ProprietarioTel();
		
		proprietarioTel.setNome("João das Couves");
		proprietarioTel.setEmail("joao@dascouves.com");
		
		proprietarioTel.getTelefones().add("(11)990901141");
		proprietarioTel.getTelefones().add("(21)790301131");
		proprietarioTel.getTelefones().add("(31)510901121");
		
		manager.persist(proprietarioTel);
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
