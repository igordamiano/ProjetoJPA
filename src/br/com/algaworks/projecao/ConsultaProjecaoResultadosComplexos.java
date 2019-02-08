package br.com.algaworks.projecao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.util.JpaUtil;

public class ConsultaProjecaoResultadosComplexos {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<Object[]> query = manager.createQuery("select modelo, valor from Veiculo", Object[].class);
		
		List<Object[]> resultado = query.getResultList();
		
		System.out.println("");
		System.out.println("");
		
		for (Object[] valores : resultado) {
			String modelo = (String) valores[0];
			BigDecimal valor = (BigDecimal) valores[1];
			System.out.println(modelo + " - " + valor);
		}
		
		manager.close();
		JpaUtil.close();
		

	}

}
