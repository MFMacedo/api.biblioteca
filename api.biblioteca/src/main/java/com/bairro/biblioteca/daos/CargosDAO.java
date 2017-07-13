package com.bairro.biblioteca.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bairro.biblioteca.entidades.Cargos;
@Stateless
public class CargosDAO {
	
	@PersistenceContext(unitName = "bibliotecaDS")
	private EntityManager manager;
	
	public Cargos salvar(Cargos cargo){
		manager.persist(cargo);
		return cargo;
	}
	
	public Cargos atualizar(Cargos cargo){
		manager.merge(cargo);
		return cargo;
	}
	
	public void deletar(Integer idCargos){
		Cargos cargo = manager.find(Cargos.class, idCargos);
		if (cargo != null) {
			manager.remove(cargo);
		}
	}
	
	
	public List<Cargos> buscarTodos() {
		return manager.createQuery("select e from Cargos e", Cargos.class).getResultList();
	}
	
	public Cargos buscarPorId(Integer idCargos) {
		return manager.find(Cargos.class, idCargos);
	}
	

}
