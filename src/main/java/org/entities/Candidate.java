package org.entities;

public class Candidate {
	private String firstName, surname;
	private int age, votes;
	private int chest, waist, hips;
	private int height, weight;
	private String _id;
	
	

	 

	public Candidate(String id, String firstName, String surname, int age, int chest,
			int waist, int hips, int height, int weight,
			int votes) {
		this._id=id;
		this.firstName = firstName;
		this.surname = surname;
		this.age = age;
		this.chest = chest;
		this.waist = waist;
		this.hips = hips;
		this.height = height;
		this.weight = weight;
		this.votes = votes;
	}

	
	public Candidate() {
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the chest
	 */
	public double getChest() {
		return chest;
	}

	/**
	 * @param chest the chest to set
	 */
	public void setChest(int chest) {
		this.chest = chest;
	}

	/**
	 * @return the waist
	 */
	public double getWaist() {
		return waist;
	}

	/**
	 * @param waist the waist to set
	 */
	public void setWaist(int waist) {
		this.waist = waist;
	}

	/**
	 * @return the hips
	 */
	public double getHips() {
		return hips;
	}

	/**
	 * @param hips the hips to set
	 */
	public void setHips(int hips) {
		this.hips = hips;
	}

	/**
	 * @return the firstName
	 */
	public synchronized String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public synchronized void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the surname
	 */
	public synchronized String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public synchronized void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the heigth
	 */
	public synchronized double getHeight() {
		return height;
	}

	/**
	 * @param heigth the heigth to set
	 */
	public synchronized void setHeight(int heigth) {
		this.height = heigth;
	}

	/**
	 * @return the weight
	 */
	public synchronized double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public synchronized void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the votes
	 */
	public synchronized double getVotes() {
		return votes;
	}

	/**
	 * @param votes the votes to set
	 */
	public synchronized void setVotes(int votes) {
		this.votes = votes;
	}


	/**
	 * @return the id
	 */
	public synchronized String getId() {
		return _id;
	}


	/**
	 * @param id the id to set
	 */
	public synchronized void setId(String id) {
		this._id = id;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
