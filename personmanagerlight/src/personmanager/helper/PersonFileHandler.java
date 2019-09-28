package personmanager.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import personmanager.manager.PersonManager;
import personmanager.model.Person;

/**
 * Person file handler class
 * 
 * Handels CSV file writing and reading
 * 
 * @author dpedwards
 *
 */
public class PersonFileHandler {

	 //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ", ";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_PATH = "Person.csv";

    //Person attributes index
    private static final int PERSON_ID_IDX = 0;
    private static final int PERSON_FNAME_IDX = 1;
    private static final int PERSON_LNAME_IDX = 2;
    private static final int PERSON_BIRTHDATE_IDX = 3;
    private static final int PERSON_GENDER_IDX = 4; 
    
    //CSV file header
    private static final String FILE_HEADER = "Id, Name, Lastname, Birthdate , Gender";
 
    /**
     * writeCsvFile() method to write a person list in CSV file
     * @param pm for person manager operations
     */
    public static void writeCsvFile(PersonManager pm) {
         

        List<Person> all = pm.personList();

        FileWriter fileWriter = null;
                 
        try {
            String fileName = FILE_PATH;
			fileWriter = new FileWriter(fileName);
 
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
             
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
             
            //Write a new person object list to the CSV file
            for (Person p : all) {
            	fileWriter.append(String.valueOf(p.getId()));
            	fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(p.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(p.getLastName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(p.getBirthDate()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(p.getPersonSex()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
 
            System.out.println("CSV Date wurde erfolgreich angelegt.");
             
        } catch (Exception e) {
            System.out.println("Fehler im CsvFileWriter!");
            e.printStackTrace();
        } finally {
             
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Fehler beim Schlieﬂen des fileWriter!");
                e.printStackTrace();
            }
        }
    }
      
    /**
     * readCsvFile() method to read a CSV file by its cells and
     * load the data into a person list 
     * @param pm for person manager operations
     */
	public static void readCsvFile(PersonManager pm) {
 
    	  BufferedReader fileReader = null;

    	 try
         {
    		//Create a new list of person to be filled by CSV file data 
    		 List<Person> persons = pm.personList();
              
             String line = "";
              
             //Create the file reader
             fileReader = new BufferedReader(new FileReader(FILE_PATH));
              
             //Read the CSV file header to skip it
             fileReader.readLine();

             //Read the file line by line starting from the second line
             while ((line = fileReader.readLine()) != null) {
                 //Get all tokens available in line
                 String[] ticks = line.split(COMMA_DELIMITER);
                 if (ticks.length == 5) {
                     //Create a new person object and fill his  data
					Person person = new Person(Integer.parseInt(ticks[PERSON_ID_IDX]), ticks[PERSON_FNAME_IDX], ticks[PERSON_LNAME_IDX], LocalDate.parse(ticks[PERSON_BIRTHDATE_IDX]), Person.PersonSex.valueOf(ticks[PERSON_GENDER_IDX]));
                     persons.add(person);
                 }
             }
              
             //Print the new person list
             for (Object person : persons) {
                 System.out.println(person.toString());
             }
        } 
        catch (Exception e) {
            System.out.println("Fehler im CsvFileReader!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Fehler beim Schlieﬂen des fileReader!");
                e.printStackTrace();
            }
        }
 
    }
}
