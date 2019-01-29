package br.com.algaworks.relacionamento.persiste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.relacionamento.CategoriaEager;
import br.com.algaworks.relacionamento.ProdutoEager;
import br.com.algaworks.util.JpaUtil;

public class CadastroOperacaoCascataPg115 {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		//@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
		CategoriaEager categoria = new CategoriaEager();
		categoria.setNome("Carnes");
		
		ProdutoEager produto = new ProdutoEager();
		produto.setNome("Picanha");
		produto.setCategoria(categoria);
		
		categoria.getProdutos().add(produto);
		
		manager.persist(categoria);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}

