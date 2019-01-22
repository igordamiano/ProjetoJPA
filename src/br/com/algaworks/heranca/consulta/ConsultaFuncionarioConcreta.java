package br.com.algaworks.heranca.consulta;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.algaworks.heranca.ClienteConcreta;
import br.com.algaworks.heranca.PessoaConcreta;
import br.com.algaworks.util.JpaUtil;

public class ConsultaFuncionarioConcreta {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		List<PessoaConcreta> pessoas = manager.createQuery("from PessoaConcreta", PessoaConcreta.class).getResultList();
		
		for (PessoaConcreta pessoa : pessoas) {
			
			System.out.print(pessoa.getNome());
			
			if (pessoa instanceof ClienteConcreta) {
				
				System.out.println(" - é um cliente");
				
			} else {
				System.out.println(" - é um funcionário");
			}
			
			
		}
		

	}

}
