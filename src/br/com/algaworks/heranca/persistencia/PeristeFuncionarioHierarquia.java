package br.com.algaworks.heranca.persistencia;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.heranca.ClienteHierarquia;
import br.com.algaworks.heranca.FuncionarioHierarquia;
import br.com.algaworks.util.JpaUtil;

public class PeristeFuncionarioHierarquia {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		FuncionarioHierarquia func = new FuncionarioHierarquia();
		func.setNome("João 2");
		func.setCargo("Gerente 3");
		func.setSalario(new BigDecimal(12000.99));
		
		ClienteHierarquia cli = new ClienteHierarquia();
		cli.setNome("Maria 3");
		cli.setRendaMensal(new BigDecimal(100.01));
		cli.setLimiteCredito(new BigDecimal(200.87));
		cli.setBloqueado(false);
		
		manager.persist(func);
		manager.persist(cli);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
