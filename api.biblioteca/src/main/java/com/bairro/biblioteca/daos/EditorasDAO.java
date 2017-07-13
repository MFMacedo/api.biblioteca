package com.bairro.biblioteca.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import com.bairro.biblioteca.entidades.Editoras;
import com.bairro.biblioteca.entidades.Genero;

@Stateless
public class EditorasDAO {
	
	@PersistenceContext(unitName = "bibliotecaDS")
	private EntityManager manager;
	
	public Editoras salvar(Editoras editora){
		manager.persist(editora);
		return editora;
	}
	
	public Editoras atualizar(Editoras editora){
		manager.merge(editora);
		return editora;
	}
	
	public void deletar(Integer idEditoras){
		Editoras editora = manager.find(Editoras.class, idEditoras);
		if (editora != null) {
			manager.remove(editora);
		}
	}
	
	
	public List<Editoras> buscarTodos() {
		return manager.createQuery("select e from Editoras e", Editoras.class).getResultList();
	}
	
	public Editoras buscarPorId(Integer idEditoras) {
		return manager.find(Editoras.class, idEditoras);
	}
	

}
