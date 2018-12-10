package br.com.algaworks.persistencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.dominio.Proprietario;
import br.com.algaworks.dominio.Veiculo;
import br.com.algaworks.enums.TipoCombustivel;
import br.com.algaworks.util.JpaUtil;

public class PersistindoVeiculo {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Proprietario proprietario = new Proprietario();
		
		proprietario.setNome("João das Couves");
		proprietario.setEmail("joao@dascouves.com");
		proprietario.setTelefone("(11)990901111");
		
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");		
		
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Honda - Especificações");
		veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2005);
		veiculo.setAnoModelo(2006);
		veiculo.setValor(new BigDecimal(79900));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo.setDataCadastro(new Date());
		veiculo.setEspecificacoes(especificacoes.toString());
		veiculo.setProprietario(proprietario);
		
		
		manager.persist(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
