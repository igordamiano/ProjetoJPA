package br.com.algaworks.auditorentidade;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.algaworks.dominio.Animal;

public class AnimalAuditor {
	
	@PreUpdate
	@PrePersist
	public void alterarDataUltimaAtualizacao(Animal animal) {
		
		animal.setDataUltimaAtualizacao(new Date());
	}

}
