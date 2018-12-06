package br.com.algaworks.persistencia;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.Foto;
import br.com.algaworks.util.JpaUtil;

public class PersistindoFoto {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		byte[] imagem = null;

		// lê bytes do arquivo da imagem
		Path path = FileSystems.getDefault().getPath("C:\\IGOR\\IGOR\\TEMP\\Livros\\Algaworks - Caelum\\Jpa e Hibernate\\sao-paulo.jpg");
		try {
			imagem = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Foto foto = new Foto();
		foto.setImagem(imagem);
		
		manager.persist(foto);
		tx.commit();
		manager.close();
		JpaUtil.close();
		
		
	}

}
