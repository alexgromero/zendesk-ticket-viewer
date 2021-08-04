package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Ticket;
import model.TicketRepository;
import view.TicketViewerInterface;

/*
 * this class is used to control the user's view, handle input, and interact with the ticket data
 */
public class TicketViewerController {
	// scanner for handling user input
	private Scanner input = new Scanner(System.in);
	// used to update the model
	private TicketRepository repo;
	// used to update the view
	private TicketViewerInterface screen;
	// used to connect to API
	private static HttpURLConnection connection;
	
	
	public TicketViewerController(TicketRepository repo, TicketViewerInterface screen) {
		this.repo = repo;
		this.screen = screen;
	}
	
	public void startApplicaton() {
		// display welcome message
		screen.displayWelcomeMessage();
		// display main menu options
		screen.displayMainMenu();
		// setup connection while user reads main menu
		connectToAPI();
		// prompt user to pick a menu option
		chooseMainMenuOption();
		
	}
	
	// establishes connection with the Zendesk API
	public void connectToAPI() {
		try {
			// URL from where to grab tickets
			URL url = new URL("https://zccromeroale.zendesk.com/api/v2/tickets.json/");
			// open  connection
			connection = (HttpURLConnection) url.openConnection();
			// TODO - figure out how to hide credentials
			// provide credentials
			String auth = "";
			// encode credentials
			String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
			// set request headers
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
			
			if (connection.getResponseCode() != connection.HTTP_OK) {
				// if failed to connect to API or cannot be authenticated
				screen.displayconnectionError();
			} else {
				// create reader for incoming stream from HTTP connection
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String responseBody = reader.readLine();
				// pass response to parse method
				parse(responseBody);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// display exit message on screen and quit the application
	public void quitApplication() {
		screen.displayExitMessage();
	}
	
	// handle input for menu options
	public void chooseMainMenuOption() {
		char option = input.next().charAt(0);
		boolean quit = false;
		do {
			
			switch (option) {
			case 'a':
				screen.displayAllTicketsHeader();
				ArrayList<Integer> ids = repo.keySet();
				for (int i = 0; i < repo.size(); i++) {
					screen.displayAllTicketsInfo(ids.get(i), repo.allTicketInfo(ids.get(i)));
				}
				screen.displayNavigationMenu();
				option = input.next().charAt(0);
				break;
			case 'i':
				boolean validId = false;
				do {
					screen.requestTicketId();
					int id = getTicketId();
					if (repo.isTicketInRepo(id)) {
						validId = true;
						screen.displayIndividualTicket(id, repo.singleTicketInfo(id));
					} else {
						screen.ticketDoesNotExist();
						continue;
					}
				} while (!validId);
				screen.displayMainMenu();
				option = input.next().charAt(0);
				break;
			case 'q':
				quitApplication();
				quit = true;
				break;
			default:
				screen.invalidInput();
				option = input.next().charAt(0);
				break;
			}
			
		} while (!quit);
	}
	
	public void chooseNavigationOption() {
		char option = input.next().charAt(0);
		switch (option) {
		case 'b':
			
			break;
		case 'n':
			break;
		case 'i':
			boolean validId = false;
			do {
				screen.requestTicketId();
				int id = getTicketId();
				if (repo.isTicketInRepo(id)) {
					validId = true;
					screen.displayIndividualTicket(id, repo.singleTicketInfo(id));
					screen.displayNavigationMenu();
				} else {
					screen.ticketDoesNotExist();
					continue;
				}
			} while (!validId);
			break;
		case 'q':
			quitApplication();
			break;
		default:
			screen.invalidInput();
			option = input.next().charAt(0);
			break;
		}
	}
	
	// get ticket ID to display requested ticket
	public int getTicketId() {
		int id = input.nextInt();
		return id;
	}
	
	
	// parse tickets from JSON object and store them in repository
	public void parse(String response) {
		// create a JSON object from the content received by the API
		JSONObject obj = new JSONObject(response);
		
		// get the array of tickets from the JSON object
	    JSONArray arrayOfTickets = obj.getJSONArray("tickets");
	    
	    for (int i = 0; i < arrayOfTickets.length(); i++) {
	    	
	    	// create a Ticket object
	    	Ticket ticket = new Ticket();
	  
	        // set Ticket object attributes
	        ticket.setId(arrayOfTickets.getJSONObject(i).getLong("id"));
	        ticket.setSubject(arrayOfTickets.getJSONObject(i).getString("subject"));
	        ticket.setDescription(arrayOfTickets.getJSONObject(i).getString("description"));
	        ticket.setRequesterId(arrayOfTickets.getJSONObject(i).getLong("requester_id"));
	        ticket.setCreatedAt(arrayOfTickets.getJSONObject(i).getString("created_at"));
	        ticket.setUpdatedAt(arrayOfTickets.getJSONObject(i).getString("updated_at"));
	        ticket.setStatus(arrayOfTickets.getJSONObject(i).getString("status"));
	    	
	        // get the ticket id for the repository key
	        Integer id = (int) ticket.getId();
	        
	        // add the ticket to the ticket repository
	        repo.addTicket(id, ticket);
	    }
	    
	}
	
}
