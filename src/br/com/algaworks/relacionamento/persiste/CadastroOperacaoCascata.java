package br.com.algaworks.relacionamento.persiste;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.OneToMany;

import br.com.algaworks.relacionamento.CategoriaEager;
import br.com.algaworks.relacionamento.ProdutoEager;
import br.com.algaworks.util.JpaUtil;

public class CadastroOperacaoCascata {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		//@OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST)
		CategoriaEager categoria = new CategoriaEager();
		categoria.setNome("Bancos");
		
		ProdutoEager produto = new ProdutoEager();
		produto.setNome("Banco Inter");
		produto.setCategoria(categoria);
		
		
		manager.persist(produto);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}

