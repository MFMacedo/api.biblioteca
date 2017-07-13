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

import com.bairro.biblioteca.daos.CargosDAO;
import com.bairro.biblioteca.entidades.Cargos;

@Path("/cargos")
public class CargosResource {

	@Inject
	private CargosDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cargos> buscarTodos() {
		return dao.buscarTodos();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Cargos buscarPorId(@PathParam("id") Integer id) {
		return dao.buscarPorId(id);
	}

	@DELETE
	@Path("/{id}")
	public Response deletar(@PathParam("id") Integer id) {
		if (id == null){
			return Response.ok(id+" não foi encontrado").status(404).build();	
		}else{			
			dao.deletar(id);
			return Response.ok(id+" foi deletado com sucesso").build();	
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Cargos atualizar(Cargos cargo) {
		return dao.atualizar(cargo);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Cargos adicionar(Cargos cargo) {
		return dao.salvar(cargo);
	}
}
