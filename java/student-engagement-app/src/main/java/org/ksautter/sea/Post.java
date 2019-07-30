package org.ksautter.sea;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post 
{
	private int id;
	private String message; 
	private int fk_user; 
	private int fk_events; 
	

public Post() {}
public Post(String msg, int fkuser, int fkevents) {
   this.message = msg;
   this.fk_user = fkuser;
   this.fk_events = fkevents;
}	

@Column
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
}


