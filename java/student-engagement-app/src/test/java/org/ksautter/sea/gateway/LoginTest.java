package org.ksautter.sea.gateway;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import javax.ws.rs.core.Response;

import org.ksautter.sea.model.User;
import org.ksautter.sea.server.ServerLocations;
import org.ksautter.sea.gateway.GatewayUsers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class LoginTest {

	@Test
	void test() throws JSONException, ParseException {
		LoginStore store = LoginStore.getInstance();
		store.addUser("123345567", 6);
		store.addUser("1237", 2);
		store.addUser("890437", 3);
		store.addUser("84949495", 3);
		store.addUser("08098029", 4);
		store.display();
		boolean response = store.findUser("1237");
		assertTrue(response);
		store.removeUser("1237", 2);
		store.addUser("8695000404040404", 7);
		store.display();
		
		String userJson = "{\"username\":\"jamata\",\"password\": \"lilHoze\"}\n"
				+ "";
		GatewayUsers getUser = new GatewayUsers();
		Response login = getUser.login(userJson);
		System.out.println(login);
		assertTrue(login != null);
		store.display();
		
	}

}
