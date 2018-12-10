package br.com.algaworks.persistencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.ProprietarioUmParaUm;
import br.com.algaworks.dominio.VeiculoUmParaUm;
import br.com.algaworks.enums.TipoCombustivel;
import br.com.algaworks.util.JpaUtil;

public class PersistindoVeiculoUmParaUm {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		ProprietarioUmParaUm proprietarioUmParaUm = new ProprietarioUmParaUm();
		
		proprietarioUmParaUm.setNome("João das Couves");
		proprietarioUmParaUm.setEmail("joao@dascouves.com");
		proprietarioUmParaUm.setTelefone("(11)990901111");
		
		manager.persist(proprietarioUmParaUm);
		
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");		
		
		
		VeiculoUmParaUm veiculoUmParaUm = new VeiculoUmParaUm();
		veiculoUmParaUm.setFabricante("Honda - Especificações");
		veiculoUmParaUm.setModelo("Civic");
		veiculoUmParaUm.setAnoFabricacao(2005);
		veiculoUmParaUm.setAnoModelo(2006);
		veiculoUmParaUm.setValor(new BigDecimal(79900));
		veiculoUmParaUm.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculoUmParaUm.setDataCadastro(new Date());
		veiculoUmParaUm.setEspecificacoes(especificacoes.toString());
		veiculoUmParaUm.setProprietarioUmParaUm(proprietarioUmParaUm);
		
		
		manager.persist(veiculoUmParaUm);
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
