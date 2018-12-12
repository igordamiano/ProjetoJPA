package br.com.algaworks.persistencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.Acessorio;
import br.com.algaworks.dominio.ProprietarioMuitosParaUm;
import br.com.algaworks.dominio.VeiculoMuitosParaMuitos;
import br.com.algaworks.enums.TipoCombustivel;
import br.com.algaworks.util.JpaUtil;

public class PersistindoVeiculoMuitosParaMuitos {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		// Persiste proprietário
		ProprietarioMuitosParaUm proprietarioMuitosParaUm = new ProprietarioMuitosParaUm();
		
		proprietarioMuitosParaUm.setNome("João das Couves");
		proprietarioMuitosParaUm.setEmail("joao@dascouves.com");
		proprietarioMuitosParaUm.setTelefone("(11)990901111");
		
		manager.persist(proprietarioMuitosParaUm);
		// Fim - Persiste proprietário
		
		// Persiste acessórios
		Acessorio alarme = new Acessorio();
		alarme.setDescricao("Alarme");
		
		Acessorio arCondicionado = new Acessorio();
		arCondicionado.setDescricao("Ar Condicionado");
		
		Acessorio bancosCouro = new Acessorio();
		bancosCouro.setDescricao("Bancos de Couro");
		
		Acessorio direcaoHidraulica = new Acessorio();
		direcaoHidraulica.setDescricao("Direção hidráulica");
		
		manager.persist(alarme);
		manager.persist(arCondicionado);
		manager.persist(bancosCouro);
		manager.persist(direcaoHidraulica);
		// Fim - Persiste acessórios
		
		// Persiste Veiculo
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");		
		
		
		VeiculoMuitosParaMuitos veiculoMuitosParaMuitos = new VeiculoMuitosParaMuitos();
		veiculoMuitosParaMuitos.setFabricante("Honda - Especificações");
		veiculoMuitosParaMuitos.setModelo("Civic");
		veiculoMuitosParaMuitos.setAnoFabricacao(2005);
		veiculoMuitosParaMuitos.setAnoModelo(2006);
		veiculoMuitosParaMuitos.setValor(new BigDecimal(79900));
		veiculoMuitosParaMuitos.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculoMuitosParaMuitos.setDataCadastro(new Date());
		veiculoMuitosParaMuitos.setEspecificacoes(especificacoes.toString());
		veiculoMuitosParaMuitos.setProprietarioMuitosParaUm(proprietarioMuitosParaUm);
		veiculoMuitosParaMuitos.getAcessorios().add(alarme);
		veiculoMuitosParaMuitos.getAcessorios().add(arCondicionado);
		
		manager.persist(veiculoMuitosParaMuitos);
		

		// Persiste segundo Veiculo
		VeiculoMuitosParaMuitos veiculoMuitosParaMuitos2 = new VeiculoMuitosParaMuitos();
		veiculoMuitosParaMuitos2.setFabricante("Honda - Especificações");
		veiculoMuitosParaMuitos2.setModelo("Civic");
		veiculoMuitosParaMuitos2.setAnoFabricacao(2005);
		veiculoMuitosParaMuitos2.setAnoModelo(2006);
		veiculoMuitosParaMuitos2.setValor(new BigDecimal(79900));
		veiculoMuitosParaMuitos2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculoMuitosParaMuitos2.setDataCadastro(new Date());
		veiculoMuitosParaMuitos2.setEspecificacoes(especificacoes.toString());
		veiculoMuitosParaMuitos2.setProprietarioMuitosParaUm(proprietarioMuitosParaUm);
		veiculoMuitosParaMuitos2.getAcessorios().add(alarme);
		veiculoMuitosParaMuitos2.getAcessorios().add(arCondicionado);
		veiculoMuitosParaMuitos2.getAcessorios().add(bancosCouro);
		veiculoMuitosParaMuitos2.getAcessorios().add(direcaoHidraulica);
		veiculoMuitosParaMuitos2.getAcessorios().add(direcaoHidraulica);
		
		manager.persist(veiculoMuitosParaMuitos2);
		
		// Fim - Persiste Veiculo
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
