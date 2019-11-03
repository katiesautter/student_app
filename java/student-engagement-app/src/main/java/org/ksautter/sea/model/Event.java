package org.ksautter.sea.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "events")
@Table(name = "events")
public class Event 
{
	private int id;
	private String title; 
	private String status; 
	private Date date_time; 
	private int fk_loc_id;
	
	
	private List<Post> posts;
	
	@OneToMany
	@JoinColumn(name ="fk_events_id")
	public List<Post> getPosts()
	{
		return posts; 
	}
	
	public void setPosts(List<Post> posts) {
	    this.posts = posts;
	}	

public Event() {}
public Event(String title, String stat, Date date , int fkloc) {
   this.title = title;
   this.status = stat;
   this.date_time = date;
   this.fk_loc_id = fkloc;
	}	

@Id
@Column
@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	public String toString()
	{
		return "Title:" + title;
		
	
	}
	/*
	private List<Event> events;
	public List<Event> getEvents()
	{
		return events; 
	}
	
	public void setEvents(List<Event> events) {
	    this.events = events;
	}	*/

	
	public String toJSON()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("{");
		builder.append("\"title\":");
		builder.append(title);
		builder.append("}");
		
	/*	builder.append("\"title\":");
		builder.append("\"");
		builder.append(title);
		builder.append("\"");
		builder.append(",");
	
		builder.append("\"status\":");
		builder.append("\"");
		builder.append(status);
		builder.append("\"");
		builder.append(",");
		
		builder.append("\"datetime\":");
		builder.append(date_time);
		builder.append(",");
		
		builder.append("\"fk_location\":");
		builder.append(fk_loc_id);
		builder.append("}"); */
		
		return builder.toString();
	}
	
	}
