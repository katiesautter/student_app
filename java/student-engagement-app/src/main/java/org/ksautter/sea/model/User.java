package org.ksautter.sea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity(name = "users")
@Table(name = "users")
public class User 
{
	private int id;
	private String username; 
	private String password; 


public User() {}
public User(String uname, String pword) {
   this.username = uname;
   this.password = pword;
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
public String getUsername() {
   return username;
}

public void setUsername( String user_name ) {
   this.username = user_name;
}

@Column
public String getPassword() {
   return password;
}

public void setPassword( String pass_word ) {
   this.password = pass_word;
}

public String toJSON() {
	StringBuilder builder = new StringBuilder();

	builder.append("{");
	builder.append("\"id\":");
	builder.append(id);
	builder.append(",");

	builder.append("\"username\":");
	builder.append("\"");
	builder.append(username);
	builder.append("\"");
	builder.append(",");
	
	builder.append("\"password\":");
	builder.append("\"");
	builder.append(password);
	builder.append("\"");
	builder.append("}");


	return builder.toString();
}

public String usernameToJSON()
{
	StringBuilder builder = new StringBuilder();
	
	builder.append("\"username\":");
	builder.append("\"");
	builder.append(username);
	builder.append("\"");
	builder.append(",");
	
	return builder.toString();
}

public void save() {

	// Event event = this;
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(this);
	session.getTransaction().commit();
}
}