package personmanager.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

import static org.hamcrest.CoreMatchers.is;

import personmanager.console.Main;
import personmanager.model.Person;
import personmanager.model.Person.PersonSex;

public class PersonManagerTest {


	 @Test
	    public void testCalculateAge_Success() {
	        // GIVEN
	        LocalDate birthDate = LocalDate.of(1987, 7, 30);
	        Person person = new Person(1, null, null, birthDate, null);
	        
	        int testAge = 32;
	       
	        // WHEN
	        int actual = PersonManager.calculateAge(person);
	        
	        // THEN
	        Assert.assertEquals(actual, testAge);
	    }

	   @Test
	   public void testEnum(){

		   // WHEN
	       PersonSex personSex = PersonSex.M;

	       // THEN 
	       assertEquals(PersonSex.valueOf("M"), personSex);
	   }
	   
	   @Test
	   public void testAddPerson() {
		   // GIVEN 
		   PersonManager pm = new PersonManager();
		   LocalDate birthDate = LocalDate.of(1987, 7, 30);
		   PersonSex personSex = PersonSex.M;
		   
		   // WHEN
		   Person person = new Person(1, "Name", "LastName", birthDate, personSex.M);
           pm.addPerson(person);
		   
           // THEN
           assertFalse(pm.personList().isEmpty());
	   }
	   
	   @Test 
		 public void testPersonListIsEmpty() {
			  // GIVEN 
	          PersonManager pm = new PersonManager();
	       
	          // WHEN

		      // THEN
	          assertTrue(pm.personList().isEmpty());
		 }
	   
	   @Test
	    public void testPersonList() {
		    // GIVEN 
		    PersonManager pm = new PersonManager();
		    LocalDate birthDate = LocalDate.of(1987, 7, 30);
		    PersonSex personSex = PersonSex.M;
		   
		    // WHEN
		    Person person = new Person(0, null, null, null, null);
	 		pm.addPerson(new Person(1, "Name", "LastName", birthDate, personSex.M));
	 		pm.addPerson(new Person(2, "Name", "LastName", birthDate, personSex.M));
	 		pm.addPerson(new Person(3, "Name", "LastName", birthDate, personSex.M));
	 
	 		// WHEN
	 		List<Person> actual = pm.personList();
	 		 
		    // THEN
		    assertThat(actual.size(), is(3));
	    }

	   @Test
	   public void testRemovePerson() {
		   PersonManager pm = new PersonManager();
		   LocalDate birthDate = LocalDate.of(1987, 7, 30);
		   PersonSex personSex = PersonSex.M;
		   int id = 1;
		   
		   // WHEN
		   Person person = new Person(1, "Name", "LastName", birthDate, personSex.M);
           pm.addPerson(person);
           pm.removePerson(id);
          
	       // THEN
           assertTrue(pm.personList().isEmpty());
	   }
	   
	  @Test
	   public void testPersonExists() {	   
		   // GIVEN 
		  

		   // WHEN
		   Person person1 = new Person(1, "Test", null, null, null);

		   // THEN
		   assertTrue(person1.getId() > 0);
	   } 

}
