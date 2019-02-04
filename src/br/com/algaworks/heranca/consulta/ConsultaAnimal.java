package br.com.algaworks.heranca.consulta;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.Animal;
import br.com.algaworks.util.JpaUtil;

public class ConsultaAnimal {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		List<Animal> animais = manager.createQuery("from Animal", Animal.class).getResultList();
		
		for (Animal animal : animais) {
			
			System.out.println("Id: " + animal.getId());
			System.out.println("Nome: " + animal.getNome());
			System.out.println("Última Atualização: " + animal.getDataUltimaAtualizacao());
			System.out.println("----------");
			
		}
		
		manager.close();
		JpaUtil.close();
		
		
	}

}
