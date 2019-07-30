package org.ksautter.sea;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
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

@Column
public int getId() {
   return id;
}

public void setId( int id ) {
   this.id = id;
}

@Column
public int getFkuser() {
   return fkuser;
}

public void setFkuser( int fkuser ) {
   this.fkuser = fkuser;
}

@Column
public int getFkevent() {
   return fkevent;
}

public void setFkevent( int fkevent ) {
   this.fkevent = fkevent;
}

}

