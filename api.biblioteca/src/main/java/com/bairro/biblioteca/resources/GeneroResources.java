package com.bairro.biblioteca.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bairro.biblioteca.daos.GeneroDAO;
import com.bairro.biblioteca.entidades.Genero;

@Path("/genero")
public class GeneroResources {
	
	@Inject
	private GeneroDAO dao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Genero> buscarTodos(){
		return dao.buscarTodos();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Genero buscarPorId(@PathParam("id") Integer idGenero) {
		return dao.buscarPorId(idGenero);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Genero atualizar(Genero genero) {
		return dao.atualizar(genero);
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response deletar(@PathParam("id") Integer idGenero) {
		if (idGenero != null) {
			dao.deletar(idGenero);
			return Response.ok("Genero de id " +idGenero+" removido com sucesso!").build();
		}else{
			return Response.ok("Genero de id " +idGenero+" não foi encontrado!").status(404).build();	
		}
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Genero salvar(Genero genero) {
		return dao.salvar(genero);
	}

}
