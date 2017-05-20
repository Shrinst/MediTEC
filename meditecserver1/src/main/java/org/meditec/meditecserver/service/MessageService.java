package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Message;

public class MessageService {
	
	// Takes the same Map in every request as long as the server don't be restarted
	private Map<Long, Message> messages = DataBaseClass.getMessages();
	
	/**
	 * Constructor
	 */
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "TOBE"));
		messages.put(2L, new Message(2, "Hello Jersey", "Milton"));
	}
	
	/**
	 * Gets all messages
	 * @return a list with all messages messages
	 */
	public List<Message> getAllMessages() {		
		return new ArrayList<Message>(messages.values());		
	}
	
	/**
	 * Obtains all the messages by year
	 * @param year
	 * @return an array with the messages of the selected year
	 */
	public List<Message> getAllMessageForYear(int year) {
		List<Message> messagesForYear =  new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	/**
	 * Obtains all the messages in an array
	 * @param start
	 * @param size
	 * @return the array of messages
	 */
	public List<Message> getAllMessagePaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		
		if ((start + size) > list.size()) {
			return new ArrayList<Message>();
		}
		
		return list.subList(start, start + size);
	}
	
	/**
	 * Gets a message
	 * @param id 
	 * @return the message that was searched
	 */
	public Message getMessage(long id) {
		Message message = messages.get(id);	
		return message;
	}
	
	/**
	 * Adds a new message
	 * @param message
	 * @return the new message
	 */
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	/**
	 * Updates a message
	 * @param message
	 * @return the updated message
	 */
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	/**
	 * Removes a message
	 * @param id
	 * @return the message that was deleted
	 */
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
