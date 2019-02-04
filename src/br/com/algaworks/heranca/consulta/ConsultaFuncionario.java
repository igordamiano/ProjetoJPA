package br.com.algaworks.heranca.consulta;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.algaworks.heranca.Cliente;
import br.com.algaworks.heranca.Pessoa;
import br.com.algaworks.util.JpaUtil;

public class ConsultaFuncionario {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		List<Pessoa> pessoas = manager.createQuery("from Pessoa", Pessoa.class).getResultList();
		
		for (Pessoa pessoa : pessoas) {
			
			System.out.print(pessoa.getNome());
			
			if (pessoa instanceof Cliente) {
				
				System.out.println(" - � um cliente");
				
			} else {
				System.out.println(" - � um funcion�rio");
			}
			
			
		}
		manager.close();
		JpaUtil.close();

	}

}
