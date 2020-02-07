package org.ksautter.sea.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "locations")
@Table(name = "locations")
public class Location 
{
	private int id;
	private String name; 

	private List<Event> events;

	

public Location() {}
public Location(String name) {
   this.name = name;
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
public String getName() {
   return name;
}

public void setName( String name ) {
   this.name = name;
}

public String toJSON() {
	StringBuilder builder = new StringBuilder();

	builder.append("{");
	builder.append("\"id\":");
	builder.append(id);
	builder.append(",");

	builder.append("\"name\":");
	builder.append("\"");
	builder.append(name);
	builder.append("\"");
	builder.append("}");

	return builder.toString();
}

public String locationNameToJSON() {
	StringBuilder builder = new StringBuilder();

	builder.append("\"locationName\":");
	builder.append("\"");
	builder.append(name);
	builder.append("\"");
	builder.append("}");

	return builder.toString();
}

}
