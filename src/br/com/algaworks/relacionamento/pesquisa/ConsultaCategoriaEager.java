package br.com.algaworks.relacionamento.pesquisa;

import javax.persistence.EntityManager;

import br.com.algaworks.relacionamento.CategoriaEager;
import br.com.algaworks.relacionamento.ProdutoEager;
import br.com.algaworks.util.JpaUtil;

public class ConsultaCategoriaEager {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CategoriaEager categoriaEager = manager.find(CategoriaEager.class, 1L); 
		
		System.out.println("Categoria: " + categoriaEager.getNome());
		
		for (ProdutoEager prod : categoriaEager.getProdutos()) {
			System.out.println("Produto: " + prod.getNome());
		}
		
		manager.close();
		JpaUtil.close();

	}

}