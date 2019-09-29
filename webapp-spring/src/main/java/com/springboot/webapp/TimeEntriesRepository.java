package com.springboot.webapp;

import org.springframework.data.mongodb.repository.MongoRepository;

   /**
    * Interface for MongoDB database connection
    * 
    * @author Davain Pablo Edwards
    * @version 1.0
    */
public interface TimeEntriesRepository extends MongoRepository<TimeEntry, String>{

}
