import controller.TicketViewerController;
import model.TicketRepository;
import view.TicketViewerInterface;

public class Main {
	/*
	 * This is the main driver class which will run the CLI Ticket Viewer application
	 */
	public static void main(String[] args) {
		TicketRepository model = new TicketRepository(); // maybe NOT?
		TicketViewerInterface screen = new TicketViewerInterface();
		TicketViewerController controller = new TicketViewerController(model, screen);

		controller.startApplicaton();
	}

}
