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
		dataNascimento.set(2013, 2, 1);
		Animal animal = new Animal();
		animal.setNome("bbbbb");
		animal.setDataNascimento(dataNascimento.getTime());
		
		// Não precisa mais, tem a classe AnimalAuditor
		//animal.setDataUltimaAtualizacao(new Date());
		
		System.out.println("Idade ANTES de persistir: " + animal.getIdade());
		System.out.println("Data: " + new Date());
		
		manager.persist(animal);
		
		System.out.println("Idade DEPOIS de persistir: " + animal.getIdade());
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
