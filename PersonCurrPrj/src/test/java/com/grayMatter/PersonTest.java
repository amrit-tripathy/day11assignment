package com.grayMatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

public class PersonTest {
	
	PersonApi papi = new PersonApi();
//	@Test
//	public void testaddPerson() throws ClassNotFoundException, SQLException {
//		Person p = new Person(2,"ammmmrit",22,"99999","abc@gmail.com");
//		Person newP = papi.addPerson(p);
//		
//		assertEquals(p.getName(), newP.getName());
//	}
//	@Test
//	public void testgetPerson() throws ClassNotFoundException, SQLException {
//		int id =1;
//		Person p = papi.getPersonByid(id);
//		int x = p.getId();
//		assertEquals(id, x);
//	}
	@Test
	public void testupdate() throws ClassNotFoundException, SQLException {
		int x = papi.updatePerson(1);
		assertNotNull(x);
	}

}
