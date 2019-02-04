package br.com.algaworks.heranca.consulta;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.algaworks.heranca.ClienteHierarquia;
import br.com.algaworks.heranca.PessoaHierarquia;
import br.com.algaworks.util.JpaUtil;

public class ConsultaFuncionarioHierarquia {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		List<PessoaHierarquia> pessoas = manager.createQuery("from PessoaHierarquia", PessoaHierarquia.class).getResultList();
		
		for (PessoaHierarquia pessoa : pessoas) {
			
			System.out.print(pessoa.getNome());
			
			if (pessoa instanceof ClienteHierarquia) {
				
				System.out.println(" - � um cliente");
				
			} else {
				System.out.println(" - � um funcion�rio");
			}
			
			
		}
		manager.close();
		JpaUtil.close();

	}

}
