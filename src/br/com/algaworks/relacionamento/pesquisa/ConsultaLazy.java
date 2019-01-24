package br.com.algaworks.relacionamento.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.relacionamento.ProdutoLazy;
import br.com.algaworks.util.JpaUtil;

public class ConsultaLazy {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		ProdutoLazy produtoLazy = manager.find(ProdutoLazy.class, 3L);
		
		System.out.println("Nome: " + produtoLazy.getNome());
		System.out.println("Categoria: " + produtoLazy.getCategoria().getNome());
		
		manager.close();
		JpaUtil.close();

	}

}
/*
	O provedor JPA n�o buscou as informa��es de categoria, pois o carregamento passou a ser tardia
 */
