package com.yerbamateprimer.model;

import java.util.List;

/**
 * This class models a group of
 * people that usually drink 
 * mate together.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public class Group {
	private String name;
	private List<Person> members;
	/**
	 * @param name
	 * @param members
	 */
	public Group(String name, List<Person> members) {
		this.name = name;
		this.members = members;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the members
	 */
	public List<Person> getMembers() {
		return members;
	}

	/**
	 * @param members The members to add.
	 */
	public void addMembers(List<Person> members) {
		this.members.addAll(members);
	}
	
	public void addMember(Person member) {
		this.members.add(member);
	}
}