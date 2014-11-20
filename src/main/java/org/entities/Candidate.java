package org.entities;

public class Candidate {
	private String firstName, surname;
	private int age, votes;
	private double chest, waist, hips;
	private double heigth, weight;
	
	

	 

	public Candidate(String firstName, String surname, int age, double chest,
			double waist, double hips, double heigth, double weight,
			int votes) {
		this.firstName = firstName;
		this.surname = surname;
		this.age = age;
		this.chest = chest;
		this.waist = waist;
		this.hips = hips;
		this.heigth = heigth;
		this.weight = weight;
		this.votes = votes;
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
	public void setChest(double chest) {
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
	public void setWaist(double waist) {
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
	public void setHips(double hips) {
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
	public synchronized double getHeigth() {
		return heigth;
	}

	/**
	 * @param heigth the heigth to set
	 */
	public synchronized void setHeigth(double heigth) {
		this.heigth = heigth;
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
	public synchronized void setWeight(double weight) {
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
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
