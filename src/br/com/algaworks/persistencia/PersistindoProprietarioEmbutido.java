package br.com.algaworks.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.ProprietarioTelEmbutido;
import br.com.algaworks.dominio.Telefone;
import br.com.algaworks.util.JpaUtil;

public class PersistindoProprietarioEmbutido {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		ProprietarioTelEmbutido proprietarioTelEmbutido = new ProprietarioTelEmbutido();
		
		proprietarioTelEmbutido.setNome("João das Couves");
		proprietarioTelEmbutido.setEmail("joao@dascouves.com");
		
		proprietarioTelEmbutido.getTelefones().add(new Telefone("11", "990901141", "121"));
		proprietarioTelEmbutido.getTelefones().add(new Telefone("31", "292901141", "121"));
		proprietarioTelEmbutido.getTelefones().add(new Telefone("41", "990901141", "121"));
		
		manager.persist(proprietarioTelEmbutido);
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
