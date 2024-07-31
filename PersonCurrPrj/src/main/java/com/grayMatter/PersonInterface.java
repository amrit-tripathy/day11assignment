package com.grayMatter;

import java.sql.SQLException;
import java.util.List;

public interface PersonInterface {
	
	List<Person> getAllPersons() throws ClassNotFoundException, SQLException;
	public Person getPersonByid(int id) throws ClassNotFoundException, SQLException;
	public Person addPerson(Person person) throws ClassNotFoundException, SQLException;
	public int updatePerson(int id)throws ClassNotFoundException, SQLException;;
	public int deletePerson(int id)throws ClassNotFoundException, SQLException;

}
