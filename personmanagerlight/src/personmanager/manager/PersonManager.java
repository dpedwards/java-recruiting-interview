
package personmanager.manager;

import java.util.ArrayList;
import java.util.List;

import personmanager.model.Person;

/**
 * Person manager class
 * 
 * Person manager with operations to add, remove and list a person by id and age
 * 
 * @author dpedwards
 *
 */
public class PersonManager {

	// Initialize new persons list
	private List<Person> persons = new ArrayList<Person>();

	/**
	 * Constructor 
	 */
	public PersonManager () {
		
	}

	/**
	 * getPersons() method to get a full list of persons
	 * @return amount of persons 
	 */
	public List<Person> personList() {
		System.out.println("Aktuell " + getPersonCount() +  " Person(en) im System:");
		return persons;
	}

	/**
	 * addPerson() method to add a person to list
	 * @param person for person properties
	 */
	public void addPerson(Person person) {
		persons.add(person);
		System.out.println("Person " + person.getName() + " hinzugefügt!");
	}

	/**
	 * removePerson() method to remove a person from list
	 * @param person for person properties
	 */
	public void removePerson(Integer id) {
		Person personToRemove = null;

		for (Person person : persons) {
			if(person.getId().equals(id)) {
				personToRemove = person;
				break;
			}
		}

		if(personToRemove != null) {
			persons.remove(personToRemove);
			System.out.println("Person " + personToRemove.getName() + " entfernt!");
		}
	}

	/**
	 * idList() method to return a person by id
	 * @param id holds searched person numeric identification
	 * @return idList with searched person id
	 */
	public List<Person> idList(Integer id) {
		List<Person> idList = new ArrayList<Person>();
		for(Person person : persons) {
			if(person.getId().equals(id)) {
				idList.add(person);
			}   
		}
		return idList;
	}

	/**
	 * nameList() method to return person name
	 * @param name holds searched person name
	 * @return nameList returns a list with person names
	 */
	public List<Person> nameList(String name) {
		List<Person> nameList = new ArrayList<Person>();
		for(Person person : persons) {
			if(person.getName().equals(name)) {
				nameList.add(person);
			}   
		}
		return nameList;
	}

	/**
	 * lastNameList() method to return person last name
	 * @param lastName holds searched person last name
	 * @return lastNameList returns a list with person last names
	 */
	public List<Person> lastNameList(String lastName) {
		List<Person> lastNameList = new ArrayList<Person>();
		for(Person person : persons) {
			if(person.getLastName().equals(lastName)) {
				lastNameList.add(person);
			}         
		}
		return lastNameList;  
	}

	/**
	 * sex() method to return person gender
	 * @param sex holds searched person gender
	 * @return sexList returns a list 
	 */
	public List<Person> sexList(String sex) {
		List<Person> sexList = new ArrayList<Person>();
		for(Person person : persons) {
			if(person.getPersonSex().toString().equals(sex)) {
				sexList.add(person);
			}  
		}
		return sexList;
	}

	/**
	 * calculateAge() method to calculate the current age 
	 * @param person for person properties
	 * @return calculated person age
	 */
	public static int calculateAge(Person person) {
		return person.getAge();
	}

    /**
     * calculateAvgAge() method to calculate 
     * average age 
     * @return average age by person list
     */
	public double calculateAvgAge() {
		double result = 0.0;

		for (Person person : persons) {
			result += person.getAge();
		}

		return result / getPersonCount();
	}

	/**
	 * getPersonCount() method to determine 
	 * persons amount in list
	 * @return counted person amount in list
	 */
	public Integer getPersonCount() {
		return persons.size();
	}

	/**
	 * personByAge() method to list persons by age 
	 * @param age holds searched person age 
	 * @return result all persons if <= age  
	 */
	public List<Person> personByAge(Integer age) {
		List<Person> result = new ArrayList<>();

		for(Person person : persons) { 
			if(person.getAge() <= age) {
				result.add(person);
			} 
		}
		return result;
	}

}
