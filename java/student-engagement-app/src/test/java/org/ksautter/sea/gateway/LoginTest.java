package org.ksautter.sea.gateway;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginTest {

	@Test
	void test() {
		LoginStore store = new LoginStore();
		store.addUser("123345567", 6);
		store.addUser("1237", 2);
		store.addUser("890437", 3);
		store.addUser("08098029", 4);
		store.display();
		boolean response = store.findUser("1237");
		assertTrue(response);
		store.removeUser("1237", 2);
		store.addUser("8695000404040404", 7);
		store.display();
		
	}

}
