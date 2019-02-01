package br.com.algaworks.heranca.persistencia;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.Animal;
import br.com.algaworks.util.JpaUtil;

public class PeristeAnimal {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(2011, 2, 1);
		Animal animal = new Animal();
		animal.setNome("Mimosa");
		animal.setDataNascimento(dataNascimento.getTime());
		animal.setDataUltimaAtualizacao(new Date());
		
		System.out.println("Idade ANTES de persistir: " + animal.getIdade());
		
		manager.persist(animal);
		
		System.out.println("Idade DEPOIS de persistir: " + animal.getIdade());
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
