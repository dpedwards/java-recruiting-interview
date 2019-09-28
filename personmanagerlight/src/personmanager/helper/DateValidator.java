package personmanager.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateValidator class 
 * 
 * Validates the right date format and checks if its true or not
 * 
 * @author dpedwards
 *
 */
public class DateValidator {

     /**
      * isValidFormat() method to validate the right date format
      * @param format holds the given date format 
      * @param value holds the birthdate input by user
      * @return right date format
      */
	 public static boolean isValidFormat(String format, String value) {
	        Date date = null;
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat(format);
	            date = sdf.parse(value);
	            if (!value.equals(sdf.format(date))) {
	                date = null;
	            }
	        } catch (ParseException ex) {
	            ex.printStackTrace();
	        }
	        return date != null;
	    }
	
}