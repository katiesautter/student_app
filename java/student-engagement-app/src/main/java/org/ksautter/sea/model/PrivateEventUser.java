package org.ksautter.sea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "private_events_users")
@Table(name = "private_events_users")
public class PrivateEventUser 
{
	private int id;
	private int fkuser; 
	private int fkevent;


public PrivateEventUser () {}
public PrivateEventUser (int fkuser, int fkevent) {
   this.fkuser = fkuser;
   this.fkevent = fkevent;
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

@Column(name = "fk_user_id")
public int getFkuser() {
   return fkuser;
}

public void setFkuser( int fkuser ) {
   this.fkuser = fkuser;
}

@Column(name = "fk_events_id")
public int getFkevent() {
   return fkevent;
}

public void setFkevent( int fkevent ) {
   this.fkevent = fkevent;
}

}

