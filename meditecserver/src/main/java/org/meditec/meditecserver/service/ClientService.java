package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Client;

public class ClientService {
	
	private Map<String, Client> clientlist = DataBaseClass.getClientList();
	
	public ClientService() {
		clientlist.put("Daniela", new Client("Daniela", 3245422, "Cartago"));
		clientlist.put("Gabriel", new Client("Gabriel", 3420242, "Cartago"));
	}
	
	public List<Client> getAllClient() {
		return new ArrayList<Client>(clientlist.values());
	}
	
	public Client getClient(String clientName) {
		return clientlist.get(clientName);
	}
	
	public Client addClient(Client client) {		
		clientlist.put(client.getClientName(), client);
		return client;
	}
	
	public Client updateClient(Client client) {
		if (client.getClientName().isEmpty()) {
			return null;
		}
		clientlist.put(client.getClientName(), client);
		return client;
	}
	
	public Client removeClient(String client) {
		return clientlist.remove(client);
	}
}
