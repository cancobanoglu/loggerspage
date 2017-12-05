package com.loggerspage.model;

import java.util.Date;

import com.loggerspage.dao.domain.Category;
import com.loggerspage.dao.domain.Feeling;
import com.loggerspage.dao.domain.Worth;


public class Activity{

	public String id;
	
	public String title;
	
	public String description;
	
	public Date date;
	
	public int duration;
	
	public Category category;
	
	public Feeling feeling;
	
	public Worth worth;
	
	public boolean status;

}
