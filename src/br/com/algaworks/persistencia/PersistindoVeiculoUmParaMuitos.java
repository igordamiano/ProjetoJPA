package br.com.algaworks.persistencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.ProprietarioUmParaMuitos;
import br.com.algaworks.dominio.VeiculoUmParaMuitos;
import br.com.algaworks.enums.TipoCombustivel;
import br.com.algaworks.util.JpaUtil;

public class PersistindoVeiculoUmParaMuitos {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		ProprietarioUmParaMuitos proprietarioUmParaMuitos = new ProprietarioUmParaMuitos();
		
		proprietarioUmParaMuitos.setNome("Mateus");
		proprietarioUmParaMuitos.setEmail("Mateus@dascouves.com");
		proprietarioUmParaMuitos.setTelefone("(11)990901111");
		
		manager.persist(proprietarioUmParaMuitos);
		
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");		
		
		
		VeiculoUmParaMuitos veiculoUmParaMuitos = new VeiculoUmParaMuitos();
		veiculoUmParaMuitos.setFabricante("Honda - Especificações");
		veiculoUmParaMuitos.setModelo("Civic");
		veiculoUmParaMuitos.setAnoFabricacao(2005);
		veiculoUmParaMuitos.setAnoModelo(2006);
		veiculoUmParaMuitos.setValor(new BigDecimal(79900));
		veiculoUmParaMuitos.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculoUmParaMuitos.setDataCadastro(new Date());
		veiculoUmParaMuitos.setEspecificacoes(especificacoes.toString());
		veiculoUmParaMuitos.setProprietarioUmParaMuitos(proprietarioUmParaMuitos);
		
		manager.persist(veiculoUmParaMuitos);
		

		VeiculoUmParaMuitos veiculoUmParaMuitos2 = new VeiculoUmParaMuitos();
		veiculoUmParaMuitos2.setFabricante("Honda - mais de um proprietario");
		veiculoUmParaMuitos2.setModelo("City");
		veiculoUmParaMuitos2.setAnoFabricacao(2015);
		veiculoUmParaMuitos2.setAnoModelo(2016);
		veiculoUmParaMuitos2.setValor(new BigDecimal(89900));
		veiculoUmParaMuitos2.setTipoCombustivel(TipoCombustivel.ALCOOL);
		veiculoUmParaMuitos2.setDataCadastro(new Date());
		veiculoUmParaMuitos2.setEspecificacoes(especificacoes.toString());
		veiculoUmParaMuitos2.setProprietarioUmParaMuitos(proprietarioUmParaMuitos);
		
		manager.persist(veiculoUmParaMuitos2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
