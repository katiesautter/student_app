package org.ksautter.sea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location 
{
	private int id;
	private String name; 


public Location() {}
public Location(String name) {
   this.name = name;
}

@Column
public int getId() {
   return id;
}

public void setId( int id ) {
   this.id = id;
}

@Column
public String getName() {
   return name;
}

public void setName( String name ) {
   this.name = name;
}

}
