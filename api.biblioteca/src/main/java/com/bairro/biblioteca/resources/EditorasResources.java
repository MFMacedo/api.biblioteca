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

import com.bairro.biblioteca.daos.EditorasDAO;
import com.bairro.biblioteca.entidades.Editoras;

@Path("/editora")
public class EditorasResources {

	@Inject
	private EditorasDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Editoras> buscarTodos(){
		return dao.buscarTodos();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Editoras buscarPorId(@PathParam("id") Integer id){
		return dao.buscarPorId(id);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Editoras salvar(Editoras editora){
		return dao.salvar(editora);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deletar(@PathParam("id") Integer idEditoras){
		if (idEditoras != null) {
			dao.deletar(idEditoras);
			return Response.ok("Genero de id " +idEditoras+" removido com sucesso!").build();
		}else{
			return Response.ok("Genero de id " +idEditoras+" não foi encontrado!").status(404).build();	
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Editoras atualizar(Editoras editora){
		return dao.atualizar(editora);
	}
}
