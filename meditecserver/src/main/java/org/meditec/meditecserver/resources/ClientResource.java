package org.meditec.meditecserver.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.meditec.meditecserver.model.Client;
import org.meditec.meditecserver.service.ClientService;

@Path("clientlist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
	
	private ClientService clientService = new ClientService();
	
	@GET
	public List<Client> getClients() {
		return clientService.getAllClient();
	}
	
	@POST
	public Client addClient(Client client) {
		return clientService.addClient(client);
	}
	
	@PUT
	@Path("{clientName}")
	public Client updateProfile(@PathParam("clientName") String clientName, Client client) {
		client.setClientName(clientName);
		return clientService.updateClient(client);
	}
	
	@DELETE
	@Path("{clientName}")
	public void deleteProfile(@PathParam("clientName") String clientName) {
		clientService.removeClient(clientName);
	}
	
	
	@GET
	@Path("{clientName}")
	public Client getProfile(@PathParam("clientName") String clientName) {
		return clientService.getClient(clientName);
	}
}
