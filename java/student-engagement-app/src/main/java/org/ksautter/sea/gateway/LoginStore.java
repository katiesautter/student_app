package org.ksautter.sea.gateway;
import java.util.HashMap;

public class LoginStore {

    private static LoginStore single_instance = null; 
    
    public static LoginStore getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new LoginStore(); 
  
        return single_instance; 
    } 
    
	HashMap<String, Integer> hmap = new HashMap<String, Integer>();

	public void addUser(String token, int id)
	{
		hmap.put(token, id);
	}
	
	public boolean findUser(String token)
	{
		return hmap.containsKey(token);
	}
	
	public int getID(String token)
	{
		int value = hmap.get(token);
		return value;
	}
	
	public void removeUser(String token, int id)
	{
		hmap.remove(token, id);
	}
	
	public void display()
	{
		System.out.println("Initial Mappings are: " + hmap);
	}
}
