package com.loggerspage.dao.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="activity")
public class ActivityEntity {

	/*
	 * Date/Time. 
	 * Activity description.
	 * How I feel.
	 * Duration.
	 * Value (high, medium,low, none).
	 */
	@Id
	public String id;
	
	public String title;
	
	public String description;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public Date date;
	
	public int duration;
	
	public Category category;
	
	public Feeling feeling;
	
	public Worth worth;
	
	public boolean status;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public Date start;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public Date stop;
	
	
	
}
