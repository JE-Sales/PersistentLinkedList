import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static private LinkedList ll = new LinkedList();

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		/*
		 * The main method of the program. If an error occurs while selecting an
		 * operation or while performing an operation, the user will be brought back at
		 * the main menu to try again.
		 */
		while (true) {
			try {
				System.out.println("\nMENU");
				System.out.println("[1] Add Node");
				System.out.println("[2] Delete Node");
				System.out.println("[3] Display");
				System.out.println("[4] Change Value");
				System.out.println("[5] Node History");
				System.out.println("[6] List History");
				System.out.println("[7] Exit");
				System.out.print("Enter Choice: ");
				int choice = Integer.parseInt(reader.readLine());
				switch (choice) {
				case 1:
					addNode();
					break;
				case 2:
					deleteNode();
					break;
				case 3:
					display();
					break;
				case 4:
					changeValue();
					break;
				case 5:
					nodeHistory();
					break;
				case 6:
					listHistory();
					break;
				case 7:
					System.out.print("\n--Exit--" + "\nProgram will be terminated");
					for (int i = 0; i < 3; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
					System.out.print("\nProgram terminated.");
					System.exit(0);

				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("The only allowed input for CHOICE is an integer. Please try again.");
			}
		}

	}

	private static void addNode() throws NumberFormatException, IOException {
		try {
			System.out.print("Enter an integer number to add: ");
			int number = Integer.parseInt(reader.readLine());
			ll.addNode(number);
			System.out.println("The node was successfully added!");
		} catch (NumberFormatException e) {
			System.out.println("The only allowed input for CHOICE is an integer. Please try again.");
		}
	}

	private static void deleteNode() throws NumberFormatException, IOException {
		try {
			System.out.print("Enter node position to delete: ");
			int number = Integer.parseInt(reader.readLine());
			ll.deleteNode(number);
		} catch (NumberFormatException e) {
			System.out.println("The only allowed input for CHOICE is an integer. Please try again.");
		}
	}

	private static void display() {
		ll.display();
	}

	private static void changeValue() throws NumberFormatException, IOException {
		int position, number;

		try {
			System.out.print("Enter node position: ");
			position = Integer.parseInt(reader.readLine());
			System.out.println("Current value of node " + position + " is " + ll.get(position).getData() + ".\n");
			System.out.print("Enter new value for node " + position + ": ");
			number = Integer.parseInt(reader.readLine());
			ll.changeValue(position, number);
			System.out.println("Node value has been modified successfully!");
		} catch (NumberFormatException e) {
			System.out.println("The only allowed input for CHOICE is an integer. Please try again.");
		}

	}

	private static void nodeHistory() throws NumberFormatException, IOException {
		try {
			System.out.print("Enter node position: ");
			int number = Integer.parseInt(reader.readLine());
			ll.nodeHistory(number);
		} catch (NumberFormatException e) {
			System.out.println("The only allowed input for CHOICE is an integer. Please try again.");
		}

	}

	private static void listHistory() {
		ll.listHistory();
	}

}
