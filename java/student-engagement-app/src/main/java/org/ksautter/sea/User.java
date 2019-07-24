package org.ksautter.sea;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
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

@Column
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