package br.com.algaworks.pesquisa;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.algaworks.dominio.Foto;
import br.com.algaworks.util.JpaUtil;

public class ExibirImagem {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Foto foto = manager.find(Foto.class, 1L);
		
		if (foto != null && foto.getImagem() != null) {
			
			BufferedImage img = null;
			try {
				img = ImageIO.read(new ByteArrayInputStream(foto.getImagem()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));			
			
		} else {
			System.out.println("Não possui foto");
		}
		
		manager.close();
		JpaUtil.close();

	}

}
