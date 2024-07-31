package com.grayMatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class PersonApi implements PersonInterface{

	
	Scanner sc = new Scanner(System.in);
	@Override
	public List<Person> getAllPersons() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Person> plist = new ArrayList<Person>();
		
		Dbconnection dc = new Dbconnection();
		String query ="select * from person";
		Connection con = dc.getConnection();  //con
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			plist.add(new Person(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
		}
		return plist;
	}

	@Override
	public Person getPersonByid(int id) throws ClassNotFoundException, SQLException {
		Dbconnection dc = new Dbconnection();
		Connection con = dc.getConnection();
		String query ="select * from person where id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Person p=null;
		if(rs.next()) {
			p = new Person(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
		}
		return p;
	}

	@Override
	public Person addPerson(Person person) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Dbconnection dc = new Dbconnection();
		Connection con = dc.getConnection();
		String query ="insert into person values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, person.getId());
		ps.setString(2, person.getName());
		ps.setInt(3, person.getAge());
		ps.setString(4, person.getMobile());
		ps.setString(5, person.getEmail());
		ps.executeUpdate();
		String query1 ="select * from person where id=?";
		PreparedStatement ps1 = con.prepareStatement(query1);
		ps1.setInt(1, person.getId());
		ResultSet rs=ps1.executeQuery();
		Person p=null;
		if(rs.next()) {
			p = new Person(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
		}
		return p;
	}

	@Override
	public int updatePerson(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Dbconnection dc = new Dbconnection();
		Connection con = dc.getConnection();
		System.out.println("what do you want to update");
		String x = sc.next();
		PreparedStatement ps=null;
		if(x.equals("name")) {
			System.out.println("enter name");
			String name = sc.next();
			String query ="update person set name=? where id=?";
			ps = con.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2, id);
		}
		if(x.equals("email")) {
			System.out.println("enter email");
			String email = sc.next();
			String query ="update person set email=? where id=?";
			 ps = con.prepareStatement(query);
			ps.setString(1,email);
			ps.setInt(2, id);
		}
		if(x.equals("mobile")) {
			System.out.println("enter mobile");
			String mobile = sc.next();
			String query ="update person set mobile=? where id=?";
		    ps = con.prepareStatement(query);
			ps.setString(1,mobile);
			ps.setInt(2, id);
		}
		int y = ps.executeUpdate();
		return y;
		
	}

	@Override
	public int deletePerson(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Dbconnection dc = new Dbconnection();
		Connection con = dc.getConnection();
		String query ="delete from person where id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		int x=ps.executeUpdate();
		return x;
	}

}
