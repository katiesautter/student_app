package org.ksautter.sea.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "posts")
@Table(name = "posts")

public class Post 
{
	private int id;
	private String message; 
	private int fk_user; 
	private int fk_events; 

	@ManyToOne
	@JoinColumn(name ="fk_events_id")
	private Event event;
	/*public Event getEvents()
	{
		return event; 
	}
	
	public void setEvents(Event event) {
	    this.event = event;
	}	*/

	

	public Post() {}
	public Post(String msg, int fkuser, int fkevents) {
		this.message = msg;
		this.fk_user = fkuser;
		this.fk_events = fkevents;
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

	@Column(name = "message")
	public String getMsg() {
		return message;
	}

	public void setMsg( String msg ) {
		this.message = msg;
	}

	@Column(name = "fk_user_id")
	public int getFkuser() {
		return fk_user;
	}

	public void setFkuser( int fkuser ) {
		this.fk_user = fkuser;
	}

	@Column(name = "fk_events_id")
	public int getFkevents() {
		return fk_events;
	}

	public void setFkevents( int fkevents ) {
		this.fk_events = fkevents;
	}

	public String toString()
	{
		return "Post:" + message;
		
	
	}
	public String toJSON()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("{");
		builder.append("\"id\":");
		builder.append(id);
		builder.append(",");
		
		builder.append("\"message\":");
		builder.append("\"");
		builder.append(message);
		builder.append("\"");
		builder.append(",");
	
		builder.append("\"user_id\":");
		builder.append(fk_user);
		builder.append(",");
		
		builder.append("\"event_id\":");
		builder.append(fk_events);
		builder.append("}"); 
		
		return builder.toString();
	}

}


