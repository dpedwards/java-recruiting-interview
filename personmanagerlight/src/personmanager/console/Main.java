package personmanager.console;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import personmanager.helper.DateValidator;
import personmanager.helper.PersonFileHandler;
import personmanager.manager.PersonManager;
import personmanager.model.Person;
import java.time.LocalDate;

/**
 * Main class
 * 
 * Manages all user inputs 
 * 
 * @author dpedwards
 *
 */
public class Main {

	// Threadsafe auto iterator 
	static AtomicInteger nextId = new AtomicInteger();

	/**
	 * main() method as entry point for the console app
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		PersonManager pm = new PersonManager();

		//Calls the readCsvFile() method
		PersonFileHandler.readCsvFile(pm);
			
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println( "\n" +
					"+-----------------------------------------------+" + "\n" +
					"|                  NEUE AUSWAHL                 |" + "\n" +
					"+-----------------------------------------------+" + "\n" +
					"Hinzufügen mit [h]" + "\n" + 
					"Löschen mit [l]" + "\n" + 
					"Suchen mit [s]" + "\n" + 
					"Personen nach Geschlecht anzeigen mit [g]" + "\n" + 
					"Personen nach Alter anzeigen mit [o]" + "\n" +
					"Alle Personen anzeigen mit [a]:" + "\n" + 
					"Personenanzahl im System anzeigen mit [c]:" + "\n" + 
					"Durchschnittsalter Personen anzeigen mit [v]:" + "\n" +
					"Personen in Csv Datei anlegen mit [x]:" + "\n" +
					"Programm beenden mit [q]:");

			String action = scanner.next();


			if (action.equalsIgnoreCase("h")) {
				uiAddPerson(scanner, pm);
			}

			else if (action.equalsIgnoreCase("l")) {
				uiRemovePerson(scanner, pm);
			}

			else if (action.equalsIgnoreCase("s")) {
				uiFindPerson(scanner, pm);
			}

			else if (action.equalsIgnoreCase("g")) {
				uiListAllPersonsBySex(scanner, pm);
			}

			else if (action.equalsIgnoreCase("o")) {
				uiListAllPersonsByAge(scanner, pm);
			}

			else if (action.equalsIgnoreCase("a")) {
				uiListAllPersons(scanner, pm);
			}

			else if (action.equalsIgnoreCase("c")) {
				uiCountAllPersons(scanner, pm);
			}

			else if (action.equalsIgnoreCase("v")) {
				uiAvgAgeAllPersons(scanner, pm);
			}
			
			else if (action.equalsIgnoreCase("x")) {
				uiSaveCsvFile(scanner, pm);
			}

			else if (action.equalsIgnoreCase("q")) {
				uiQuitApp(scanner);
			}

			else {
				System.out.println("Eingabe " + action + " wird nicht unterstützt!");
			}

		}
	}

	/**
	 * uiAddPerson() method to add a person to the list
	 * @param scanner holds the text input
	 * @param pm for person manager operations
	 */
	public static void uiAddPerson(Scanner scanner, PersonManager pm)  {

		// Assigns the auto iteration for person id
		int id =  nextId.incrementAndGet();

		System.out.println("Bitte neue Personen hinzufügen:");

		while(true) {
			// Set name 
			System.out.println("Vorname:");   
			String name = scanner.next();

			// Set last name 
			System.out.println("Nachname:");   
			String lastName = scanner.next();

			// Set birthdate
			System.out.println("Geburtsdatum (yyyy-MM-dd):");
			String birthDateInput = scanner.next();
			if (DateValidator.isValidFormat("yyyy-MM-dd", birthDateInput) == true) 
			{

				// Set sex
				System.out.println("Geschlecht männlich (M) oder weiblich (F) eingeben:");
				String sex = scanner.next();
				System.out.println("Mit [y] bestätigen, mit [b] Programm beenden");   
				String control = scanner.next();

				LocalDate bDay = LocalDate.parse(birthDateInput);

				if (control.equalsIgnoreCase("y")) {
					pm.addPerson(new Person(id, name, lastName, bDay, Person.PersonSex.valueOf(sex)));
				}
				break;

			} else  {
				System.out.println("Das Datumsformat entspricht nicht der Validierungsrichtlinie!");
				System.out.println("Mit [f] fortfahren, mit [b] Programm beenden");   
				String loop = scanner.next();

				if (loop.equalsIgnoreCase("f")) {
					break;
				} else if (loop.equalsIgnoreCase("b")) {
					System.out.println("Das Programm wurde beendet.");
					System.exit(0);
				}
			}
		}
	}

	/**
	 * uiRemovePerson() method to remove a single person in list by its id
	 * @param scanner holds the text input
	 * @param pm for person manager operations
	 */
	public static void uiRemovePerson(Scanner scanner, PersonManager pm) {
		System.out.println("Bitte zu löschende Id der Person angeben:");

		while(true) {
			System.out.println("Id:");
			Integer id = Integer.parseInt(scanner.next());
			System.out.println("Mit [y] bestätigen");   
			String control = scanner.next();

			if (control.equalsIgnoreCase("y")) {
				pm.removePerson(id);
			}
		}
	}

	/**
	 * uiFindPerson() method to find a single person in person list by its id
	 * @param scanner holds the text input
	 * @param pm for person manager operations
	 */
	public static void uiFindPerson(Scanner scanner, PersonManager pm) {
		System.out.println("Suche nach Nachname und ID:");
		String search = scanner.next();
		Scanner inputTest = new Scanner(search);

		if (inputTest.hasNextInt())
		{
			List<Person> result = pm.idList(Integer.parseInt(search));						
			printPerson(result);
		}
	}

	/**
	 * printPersons() method to print full data of persons in a list 
	 * @param result person data
	 */
	private static void printPerson(List<Person> result) {
		for(Person person : result) { 
			System.out.println("Vollständige Daten: " + person.toString());
		}
	}

	/**
	 * uiListAllPersons() method to list all persons from a list with whole information
	 * @param scanner holds the text input
	 * @param pm for person manager operations
	 */
	public static void uiListAllPersons(Scanner scanner, PersonManager pm) {
		List<Person> all = pm.personList();

		System.out.println("Liste aller Personen [Id, Name, Nachname, Geburtsdatum, Geschlecht]:");   
		printPerson(all);
	}

	/**
	 * uiCountAllPersons() method to count all persons in a list and shows numeric amount
	 * @param scanner holds the text input
	 * @param pm for person manager operations
	 */
	public static void uiCountAllPersons(Scanner scanner, PersonManager pm) {
		System.out.println("Anzahl aller Personen im System:");   
		System.out.println(pm.getPersonCount());   
	}

	/**
	 * uiListAllPersonsBySex() method to list persons by gender male or female
	 * @param scanner holds the text input
	 * @param pm for person manager operations
	 */
	public static void uiListAllPersonsBySex(Scanner scanner, PersonManager pm) {
		System.out.println("Alle Personen nach Geschlecht männlich (M) oder weiblich (W) auswählen: ");   
		String sexSelection = scanner.next();

		List<Person> searchBySex = pm.sexList(sexSelection);
		printPerson(searchBySex);
	}

	/**
	 * uiListAllPersonsByAge() method to list all persons by max set age using scanner tex input
	 * @param scanner holds the text input
	 * @param pm for person manager operations
	 */
	public static void uiListAllPersonsByAge(Scanner scanner, PersonManager pm) {

		System.out.println("Filter Personen nach Alter (Jahre) <= Eingabe:");
		String search = scanner.next();
		Scanner inputTest = new Scanner(search);

		if (inputTest.hasNextInt())
		{
			List<Person> personsByAge = pm.personByAge(Integer.parseInt(search));
			printPerson(personsByAge);
		} 
	}

	/**
	 * uiAvgAgeAllPersons() method to calculate the average age 
	 * of all users in person list
	 * @param scanner holds the text input
	 * @param pm for person manager operations
	 */
	public static void uiAvgAgeAllPersons(Scanner scanner, PersonManager pm) {
		double averageAge = pm.calculateAvgAge();
		System.out.println("Das Durchschnittsalter aller Personen im System beträgt:");   
		System.out.println(averageAge + " Jahre");
	}

	/**
	 * uiSaveCsvFile() method 
	 * @param scanner holds the text input
	 * @param pm for person manager operations
	 */
    public static void uiSaveCsvFile(Scanner scanner, PersonManager pm) {
    	PersonFileHandler.writeCsvFile(pm);
    }

	/**
	 * uiQuitApp() method to exit the console application
	 * @param scanner holds the text input
	 * @throws FileNotFoundException 
	 */
	public static void uiQuitApp(Scanner scanner) {	
		System.exit(0);
	}

}
