package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * This class will store the ticket objects in a HashMap for access
 * Key: the ticket ID which is an integer
 * Value: the ticket object 
 */
public class TicketRepository {
	private final int ATTRIBUTES = 7;
	
	public HashMap<Integer, Ticket> ticketRepo;
	
	public TicketRepository() {
		ticketRepo = new HashMap<Integer, Ticket>();
	}
	
	public void addTicket(Integer id, Ticket ticket) {
		ticketRepo.put(id, ticket);
	}
	
	public int size() {
		return ticketRepo.size();
	}
	
	public ArrayList<Integer> keySet() {
		ArrayList<Integer> keys = new ArrayList<Integer>(ticketRepo.keySet());
		return keys;
	}
	public boolean isTicketInRepo(int id) {
		if (ticketRepo.containsKey(id)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<String> allTicketInfo(int id) {
		ArrayList<String> allInfo = new ArrayList<>();

		allInfo.add(String.valueOf(ticketRepo.get(id).getId()));
		allInfo.add(ticketRepo.get(id).getStatus());
		allInfo.add(ticketRepo.get(id).getSubject());
		
		return allInfo;
	}
	
	public ArrayList<String> singleTicketInfo(int id) {
		ArrayList<String> info = new ArrayList<>();
		
		info.add(String.valueOf(ticketRepo.get(id).getRequesterId()));
		info.add(ticketRepo.get(id).getStatus());
		info.add(ticketRepo.get(id).getCreatedAt());
		info.add(ticketRepo.get(id).getUpdatedAt());
		info.add(ticketRepo.get(id).getSubject());
		info.add(ticketRepo.get(id).getDescription());
		
		return info;
	}
	
	public void printTicketInfo(int id) {
		System.out.println(Arrays.asList(singleTicketInfo(id)));
	}
	
	// TODO - REMOVE THIS METHOD
	public void print() {
		System.out.println(ticketRepo.entrySet());
	}
	
}
