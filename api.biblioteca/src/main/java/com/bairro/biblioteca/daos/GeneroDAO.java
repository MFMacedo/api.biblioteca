package com.bairro.biblioteca.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bairro.biblioteca.entidades.Genero;

@Stateless
public class GeneroDAO {

	@PersistenceContext(unitName = "bibliotecaDS")
	private EntityManager manager;

	public Genero salvar(Genero genero) {
		manager.persist(genero);
		return genero;
	}

	public Genero atualizar(Genero genero) {
		manager.merge(genero);
		return genero;
	}

	public List<Genero> buscarTodos() {
		return manager.createQuery("select g from Genero g", Genero.class).getResultList();
	}

	public Genero buscarPorId(Integer idGenero) {
		return manager.find(Genero.class, idGenero);
	}

	public void deletar(Integer idGenero) {
		Genero genero = manager.find(Genero.class, idGenero);
		if (genero != null) {
			manager.remove(genero);
		}
	}
}
