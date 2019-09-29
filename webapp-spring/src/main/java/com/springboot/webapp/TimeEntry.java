package com.springboot.webapp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

   /**
    * Entity class for database model
    * 
    * @author Davain Pablo Edwards
    * @version 1.0
    */
@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TimeEntry {

	@Id
	private String id;
	
	@NonNull
	private LocalDateTime start;
	
	private LocalDate stop;
	
	private String description; 
	
}
