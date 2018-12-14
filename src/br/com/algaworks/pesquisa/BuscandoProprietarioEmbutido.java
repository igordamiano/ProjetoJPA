package br.com.algaworks.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.dominio.ProprietarioTelEmbutido;
import br.com.algaworks.dominio.Telefone;
import br.com.algaworks.util.JpaUtil;

public class BuscandoProprietarioEmbutido {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		ProprietarioTelEmbutido proprietarioTelEmbutido = manager.find(ProprietarioTelEmbutido.class, 1L);
		
		System.out.println("Proprietário: " + proprietarioTelEmbutido.getNome());
		
		for (Telefone telefone : proprietarioTelEmbutido.getTelefones()) {
			System.out.println("Telefone: (" + telefone.getPrefixo() + ") "
					+ telefone.getNumero()
					+ (telefone.getRamal() != null ? " x" + telefone.getRamal() : ""));
		}
		
		System.out.println("-------");
		
		
		manager.close();
		JpaUtil.close();

	}

}
