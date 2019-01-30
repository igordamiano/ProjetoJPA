package br.com.algaworks.relacionamento.remove;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.relacionamento.CategoriaEager;
import br.com.algaworks.relacionamento.ProdutoEager;
import br.com.algaworks.util.JpaUtil;

public class ExcluirObjetosOrfaos {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		CategoriaEager categoriaEager = manager.find(CategoriaEager.class, 6L);
		ProdutoEager produtoEager = manager.find(ProdutoEager.class, 12L);

		categoriaEager.getProdutos().remove(produtoEager);
		manager.remove(categoriaEager);
		
		tx.commit();
		
		manager.close();
		JpaUtil.close();
	}
/*
No exemplo acima, consideramos que temos uma categoria de identificador 6 e um produto com identificador 12, 
e que ambos estão relacionados. Ao remover o produto da coleção de produtos de uma categoria, nada acontece!
Deixamos o produto órfão de um pai (categoria), por isso, o produto poderia ser excluído automaticamente.	
 */
}
