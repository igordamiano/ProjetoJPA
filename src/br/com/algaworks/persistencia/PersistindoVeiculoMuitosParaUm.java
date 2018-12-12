package br.com.algaworks.persistencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.ProprietarioMuitosParaUm;
import br.com.algaworks.dominio.VeiculoMuitosParaMuitos;
import br.com.algaworks.enums.TipoCombustivel;
import br.com.algaworks.util.JpaUtil;

public class PersistindoVeiculoMuitosParaUm {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		ProprietarioMuitosParaUm proprietarioMuitosParaUm = new ProprietarioMuitosParaUm();
		
		proprietarioMuitosParaUm.setNome("João das Couves");
		proprietarioMuitosParaUm.setEmail("joao@dascouves.com");
		proprietarioMuitosParaUm.setTelefone("(11)990901111");
		
		manager.persist(proprietarioMuitosParaUm);
		
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");		
		
		
		VeiculoMuitosParaMuitos veiculoMuitosParaUm = new VeiculoMuitosParaMuitos();
		veiculoMuitosParaUm.setFabricante("Honda - Especificações");
		veiculoMuitosParaUm.setModelo("Civic");
		veiculoMuitosParaUm.setAnoFabricacao(2005);
		veiculoMuitosParaUm.setAnoModelo(2006);
		veiculoMuitosParaUm.setValor(new BigDecimal(79900));
		veiculoMuitosParaUm.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculoMuitosParaUm.setDataCadastro(new Date());
		veiculoMuitosParaUm.setEspecificacoes(especificacoes.toString());
		veiculoMuitosParaUm.setProprietarioMuitosParaUm(proprietarioMuitosParaUm);
		
		manager.persist(veiculoMuitosParaUm);
		

		VeiculoMuitosParaMuitos veiculoMuitosParaUm2 = new VeiculoMuitosParaMuitos();
		veiculoMuitosParaUm2.setFabricante("Honda - mesmo dono");
		veiculoMuitosParaUm2.setModelo("City");
		veiculoMuitosParaUm2.setAnoFabricacao(2010);
		veiculoMuitosParaUm2.setAnoModelo(2011);
		veiculoMuitosParaUm2.setValor(new BigDecimal(89200));
		veiculoMuitosParaUm2.setTipoCombustivel(TipoCombustivel.ALCOOL);
		veiculoMuitosParaUm2.setDataCadastro(new Date());
		veiculoMuitosParaUm2.setEspecificacoes(especificacoes.toString());
		veiculoMuitosParaUm2.setProprietarioMuitosParaUm(proprietarioMuitosParaUm);
		
		manager.persist(veiculoMuitosParaUm2);		
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
