package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Client;

public class ClientService {
	
	private Map<String, Client> clientlist = DataBaseClass.getClientList();
	
	public ClientService() {
		clientlist.put("Daniela", new Client("Daniela", "geh3wgdwwhwd", true));
		clientlist.put("Gabriel", new Client("Gabriel", "gsheheehe", true));
	}
	
	public List<Client> getAllClient() {
		return new ArrayList<Client>(clientlist.values());
	}
	
	public List<Client> getAllClientPerName(String clientName) {
		List<Client> clientList =  new ArrayList<>();
		
		for (Client client : this.clientlist.values()) {			
			if (client.getClientName().equals(clientName)) {
				clientList.add(client);
			}
		}
		
		return clientList;
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
