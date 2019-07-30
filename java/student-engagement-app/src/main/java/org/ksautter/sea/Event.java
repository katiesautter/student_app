package org.ksautter.sea;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Event 
{
	private int id;
	private String title; 
	private String status; 
	private Date date_time; 
	private int fk_loc_id;
		

public Event() {}
public Event(String title, String stat, Date date , int fkloc) {
   this.title = title;
   this.status = stat;
   this.date_time = date;
   this.fk_loc_id = fkloc;
	}	

@Column
public int getId() {
	   return id;
	}

	public void setId( int id ) {
	   this.id = id;
	}

	@Column
	public String getTitle() {
	   return title;
	}

	public void setTitle( String title ) {
	   this.title = title;
	}

	@Column
	public String getStatus() {
	   return status;
	}

	public void setStatus( String stat ) {
	   this.status = stat;
	}

	@Column(name = "date_time")
	public Date getDate() {
	   return date_time;
	}

	public void setDate( Date date) {
	   this.date_time = date;
	}
	
	@Column(name = "fk_location_id")
	public int getFkloc() {
	   return fk_loc_id;
	}

	public void setFkloc (int fkloc ) {
	   this.fk_loc_id = fkloc;
	}
}
