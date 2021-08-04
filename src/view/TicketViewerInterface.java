package view;

import java.util.ArrayList;

public class TicketViewerInterface {
	/*
	 * This class creates the user's view for the Ticket Viewer application
	 * It displays the tickets and other application messages
	 */
	public TicketViewerInterface() {
		
	}
	
	public void displayWelcomeMessage() {
		System.out.println("Welcome to Zendesk's Ticket Viewer!\n");
	}

	public void displayMainMenu() {
		System.out.println("===========================================");
		System.out.println("---------------- Main Menu ----------------");
		System.out.println("===========================================");
		System.out.println("\nChoose from the following options:");
		System.out.println("* Enter 'a' to view all tickets");
		System.out.println("* Enter 'i' to view an individual ticket");
		System.out.println("* Enter 'q' to quit");
	}
	
	public void displayNavigationMenu() {
		System.out.println(String.format("%s", "-------------------------------------------------------------------------------"));
		
		// TODO: figure out pagination & update 'page x of x' placeholder
		System.out.println("<<< Back [b]" + "\t\t\tPage x of x\t\t\t" + "[n] Next >>>\n");
		
		System.out.println("* [i] - View an individual ticket");
		System.out.println("* [q] - Quit the application");
		System.out.println(String.format("%s", "-------------------------------------------------------------------------------"));
	}
	
	public void displayAllTicketsHeader() {
		System.out.println(String.format("%s", "==============================================================================="));
		System.out.println(String.format("%s", "----------------------------------- TICKETS -----------------------------------"));
		System.out.println(String.format("%s", "==============================================================================="));
		System.out.println(String.format("%5s %3s %8s %3s %20s", "ID", "|", "Status", "|", "Subject"));
	    System.out.println(String.format("%s", "-------------------------------------------------------------------------------"));
	}
	
	public void displayAllTicketsInfo(int id, ArrayList<String> infoToDisplay) {
		String currId = infoToDisplay.get(0);
		String status = infoToDisplay.get(1);
		String subject = infoToDisplay.get(2);
		
		// for each ticket, display id, status, and subject
		System.out.println(String.format("%5s %3s %7s %4s %-25s", currId, "|", status, "|", subject));
		System.out.println(String.format("%s", "-------------------------------------------------------------------------------"));
	}
	
	public void displayIndividualTicket(int id, ArrayList<String> infoToDisplay) {
		System.out.println("\n-------------------------------------------------------------------------------");
		System.out.println("--------------------------------- Ticket #" + id + ": ---------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Requested by: " + infoToDisplay.get(0) + "\t\tStatus: " + infoToDisplay.get(1));
		System.out.println("Created on: " + infoToDisplay.get(2) + "\tUpdated on: " + infoToDisplay.get(3));
		System.out.println("\nSubject: " + infoToDisplay.get(4) + "\n");
		System.out.println("Description: " + infoToDisplay.get(5));
	}
	
	public void requestTicketId() {
		System.out.print("Please enter the ticket ID: ");
	}
	
	public void ticketDoesNotExist() {
		System.out.println("Sorry! The ticket you are trying to view does not exist. Try a different ticket ID.");
	}
	
	public void displayExitMessage() {
		System.out.println("Goodbye! Thank you for using the Zendesk Ticket Viewer.");
	}
	
	public void displayPageNumber() {
		System.out.println("Page: ");
	}
	
	public void invalidInput() {
		System.out.println("Please enter a valid option.");
	}
	
	public void displayconnectionError() {
		System.out.println("Connection or Authentication has Failed. Please try again.");
	}
}
