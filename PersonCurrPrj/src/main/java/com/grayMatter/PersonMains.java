package com.grayMatter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PersonMains {
	List<Person>persons = new ArrayList<Person>();
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PersonApi api = new PersonApi();
//		api.addPerson(new Person(1,"amrit",22,"9999999999","amr@gmail.com"));
//		System.out.println(api.getAllPersons());
//		api.updatePerson(1);
//		api.deletePerson(1);
		Person p = api.getPersonByid(1);
		System.out.println(p.getId());
		
	}




}
