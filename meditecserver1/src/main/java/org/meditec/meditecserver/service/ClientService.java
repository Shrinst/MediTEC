package org.meditec.meditecserver.service;

/**
 * 
 * @author Emmanuelle
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Client;

public class ClientService {
	
	private Map<String, Client> clientlist = DataBaseClass.getClientList();
	
	public ClientService() {
		clientlist.put("Daniela", new Client("Daniela", 3245422, "Cartago", "geh3wgdwwhwd", true));
		clientlist.put("Gabriel", new Client("Gabriel", 3420242, "Cartago", "gsheheehe", true));
	}
	/**
	 * Constructor
	 * 
	 */
	
	public List<Client> getAllClient() {
		return new ArrayList<Client>(clientlist.values());
	}
	/**
	 * Get all the client list
	 * @return client list
	 */
	public List<Client> getAllClientPerName(String clientName) {
		List<Client> clientList =  new ArrayList<>();
		
		for (Client client : this.clientlist.values()) {			
			if (client.getClientName().equals(clientName)) {
				clientList.add(client);
			}
		}
		
		return clientList;
	}
	/**
	 * Get all clients per name
	 * @param clientName
	 * @return clientlist
	 */
	public Client getClient(String clientName) {
		return clientlist.get(clientName);
	}
	/**
	 * Get a specific client per name
	 * @param clientName
	 * @return clientlist.get(clientName)
	 */
	
	public Client addClient(Client client) {		
		clientlist.put(client.getClientName(), client);
		return client;
	}
	/**
	 * Add a client 
	 * @param client
	 * @return client
	 */
	
	public Client updateClient(Client client) {
		if (client.getClientName().isEmpty()) {
			return null;
		}
		clientlist.put(client.getClientName(), client);
		return client;
	}
	/**
	 * Refresh the client list
	 * @param client
	 * @return client
	 */
	
	public Client removeClient(String client) {
		return clientlist.remove(client);
	}
	/**
	 * Remove a specific client  
	 * @param client
	 * @return clientlist.remove(client)
	 */
}
