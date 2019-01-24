package br.com.algaworks.relacionamento.persiste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.relacionamento.CategoriaEager;
import br.com.algaworks.relacionamento.ProdutoEager;
import br.com.algaworks.util.JpaUtil;

public class Cadastro {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		CategoriaEager categoria = new CategoriaEager();
		categoria.setNome("Bebidas");
		
		ProdutoEager produto1 = new ProdutoEager();
		produto1.setNome("Refrigerante");
		produto1.setCategoria(categoria);
		
		ProdutoEager produto2 = new ProdutoEager();
		produto2.setNome("Água");
		produto2.setCategoria(categoria);
		
		ProdutoEager produto3 = new ProdutoEager();
		produto3.setNome("Cerveja");
		produto3.setCategoria(categoria);
		
		manager.persist(categoria);
		manager.persist(produto1);
		manager.persist(produto2);
		manager.persist(produto3);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}

