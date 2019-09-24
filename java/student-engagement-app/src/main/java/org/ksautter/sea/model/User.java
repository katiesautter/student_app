package org.ksautter.sea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}