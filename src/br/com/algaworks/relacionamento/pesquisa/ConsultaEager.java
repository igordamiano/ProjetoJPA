package br.com.algaworks.relacionamento.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.relacionamento.ProdutoEager;
import br.com.algaworks.util.JpaUtil;

public class ConsultaEager {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		ProdutoEager produtoEager = manager.find(ProdutoEager.class, 3L);
		
		System.out.println("Nome: " + produtoEager.getNome());
		
		manager.close();
		JpaUtil.close();

	}

}
/*
	 Note que a query SQL fez um join na tabela categoria, pois um produto possui uma categoria, 
	 mas n�s n�o usamos informa��es dessa entidade em momento algum. 
	 Neste caso, as informa��es da categoria do produto foram carregadas ansiosamente, mas n�o foram usadas.
 */
