package personmanager.model;
import java.time.LocalDate;
import java.time.Period;

/**
 * Person class
 * 
 * Defines person properties like 
 * id, name, lastname, birthdate, gender
 * 
 * @author dpedwards
 *
 */
public class Person {
			
	
	/**
	 * The <code>Sex</code> enum holds gender. 
	 * M stands for male
	 * F stands for female 
	 * 
	 * @author dpedwards
	 */
	public enum PersonSex {
		M,
		F;
	}

	/**
	 * Attributes 
	 */
	public int id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private PersonSex gender;
    
    /**
     * Constructor
     * 
     * @param name clearly name of a person
     * @param lastName clearly last name of a person
     * @param age clearly age of a person
     * @param birth clearly birth date of a person
     * @param personSex clearly gender of a person M for male or F for female
     */
   public Person(int id, String name, String lastName, LocalDate birthDate, PersonSex personSex) {

	   this.setId(id);
       this.setName(name);
       this.setLastName(lastName);
       this.setBirthDate(birthDate);

       gender = personSex;
   }
   
   /**
    * Getter method to get the id
    * @return id for person
    */
   public Integer getId() {
       return id;
   }
   
   /**
    * Setter method to set the id
    * @param id for person
    */
   public void setId(Integer id) {
       this.id = id;
   }
   
   /**
    * containsName() method 
    * @param name
    * @return true or false if name equals name
    */
   public boolean containsName(String name) {
       if(name.equals(name)) {
           return true;
       }
       return false;
   }
   
   /**
    * Getter method to get the name 
    * @return name for person
    */
   public String getName() {
       return name;
   }
   
   /**
    * Setter method to set the name
    * @param name for person
    */
   public void setName(String name){
       this.name = name;
   }
   
   /**
    * Getter method to get the last name
    * @return lastname for person
    */
   public String getLastName() {
       return lastName;
   }
   
   /**
    * Setter method to set the last name 
    * @param lastname for person 
    */
   public void setLastName(String lastName) {
       this.lastName = lastName;
   }
   
   /**
    * Getter method to get the birthdate 
    * @return birthdate for person 
    */
   public LocalDate getBirthDate() {
       return birthDate;
   }
   
   /**
    * Setter method to set the birthdate 
    * @param birthDate for person
    */
   public void setBirthDate(LocalDate birthDate) {
       this.birthDate = birthDate;
   } 
   
   /**
    * Getter method to get the gender 
    * @return gender for person
    */
   public PersonSex getPersonSex() {
	   return gender;
   }
   
   /**
    * Setter method to set the gender 
    * @param sex for person
    */
   public void setPersonSex(PersonSex sex) {
	   gender = sex;
   }

   /**
    * getAge() method to calculate the age by currentDate and given birth date
    * @return result for calculated age
    */
	public int getAge() {
		int result = 0;
		LocalDate currentDate = java.time.LocalDate.now();
		   
	    if ((birthDate != null)) {
	        result = Period.between(birthDate, currentDate).getYears();
	    }	    
	    return result;
	}
	
	
	@Override
	public String toString() {
	
		return this.getId() + ", " + this.getName() + ", " + this.getLastName() + ", " + this.getBirthDate()+ ", " + this.getPersonSex();
	}
}