package org.ksautter.sea.gateway;
import java.util.HashMap;

public class LoginStore {

	HashMap<String, Integer> hmap = new HashMap<String, Integer>();

	public void addUser(String token, int id)
	{
		hmap.put(token, id);
	}
	
	public boolean findUser(String token)
	{
		if (hmap.containsKey(token) == true)
		{
			return true;
		}
		else return false;
		
	}
	
	public void removeUser(String token, int id)
	{
		hmap.remove(token, id);
	}
	
	public void display()
	{
		System.out.println("Initial Mappings are: " + hmap);
	}
	/*LoginStore()
	{
		  HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		 
	} */
}
