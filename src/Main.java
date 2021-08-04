import model.TicketRepository;
import view.TicketViewerInterface;
import controller.TicketViewerController;

public class Main {
	/*
	 * This is the main driver class which will run the CLI Ticket Viewer application
	 */
	public static void main(String[] args) {
		TicketRepository model = new TicketRepository();
		TicketViewerInterface screen = new TicketViewerInterface();
		TicketViewerController controller = new TicketViewerController(model, screen);

		controller.startApplicaton();
	}

}
