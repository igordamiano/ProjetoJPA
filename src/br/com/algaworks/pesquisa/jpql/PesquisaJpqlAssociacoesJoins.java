package br.com.algaworks.pesquisa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.dominio.ProprietarioUmParaMuitos;
import br.com.algaworks.util.JpaUtil;

public class PesquisaJpqlAssociacoesJoins {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		
		// Queremos buscar todos os proprietários que possuem veículos.

		TypedQuery<ProprietarioUmParaMuitos> query = manager.createQuery("select distinct p from ProprietarioUmParaMuitos p inner join p.veiculoUmParaMuitos v", ProprietarioUmParaMuitos.class);
		List<ProprietarioUmParaMuitos> propretarios = query.getResultList();

		// Se um proprietário possuir dois ou mais veículos, ele repetirá no resultado da consulta, por isso, é melhor usarmos o operador distinct.
		
		System.out.println("");
		System.out.println("");
		
		for (ProprietarioUmParaMuitos proprietario : propretarios) {
			System.out.println(proprietario.getNome());
		}

		System.out.println("");
		System.out.println("");


		manager.close();
		JpaUtil.close();

	}

}
